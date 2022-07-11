package com.vacc.service;

import com.vacc.dao.ZahtevDAO;
import model.saglasnost.SaglasnostZaImunizaciju;
import model.zahtev.ZahtevZaSertifikat;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;
import util.ObjectParser;
import util.XSLFOPaths;
import util.XSLPaths;

import javax.mail.util.ByteArrayDataSource;
import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.UUID;

@Service
public class ZahtevService {

    private final ObjectParser objectParser;
    private final ZahtevDAO zahtevDAO;
    private final String folderPath="/db/zahtev";
    private final XHTMLTransformerService xhtmlTransformerService;
    private final PDFTransformerService pdfTransformerService;
    private final EmailService emailService;
    private final SaglasnostService saglasnostService;
    public ZahtevService(ObjectParser objectParser, ZahtevDAO zahtevDAO, EmailService emailService, SaglasnostService saglasnostService, XHTMLTransformerService xhtmlTransformerService, PDFTransformerService pdfTransformerService) {
        this.objectParser = objectParser;
        this.zahtevDAO = zahtevDAO;
        this.emailService = emailService;
        this.saglasnostService = saglasnostService;
        this.xhtmlTransformerService = xhtmlTransformerService;
        this.pdfTransformerService = pdfTransformerService;
    }

    public ZahtevZaSertifikat getById(String id) throws XMLDBException, JAXBException {

        ZahtevZaSertifikat zahtevZaSertifikat = (ZahtevZaSertifikat) ObjectParser.parseToObject(this.zahtevDAO.getById(id,zahtevDAO.getFolderPath()),ZahtevZaSertifikat.class);
        return zahtevZaSertifikat;
    }

    public String getByIdString(String id) throws Exception {
        try{
            String documentId = "zahtev-" + id + ".xml";
            return (String) this.zahtevDAO.getById(documentId,folderPath).getContent();
        }
        catch (Exception e){
            throw new Exception();
        }
    }
    public String save(ZahtevZaSertifikat zahtevZaSertifikat,String jmbg) throws Exception{

        List<SaglasnostZaImunizaciju> saglasnosti = saglasnostService.getByJmbgOrPassportNumber(jmbg);
        
//        if(saglasnosti.isEmpty()){
//            throw new NotFoundException("Ne postoji saglasnost");
//        }
//        if(saglasnosti.get(0).getEvidencijaOVakcinaciji() == null){
//            throw new NotFoundException("Niste se vakcinisali");
//        }
        String uniqueID = UUID.randomUUID().toString();
        zahtevZaSertifikat.setId(uniqueID);
        zahtevZaSertifikat.setAbout("http://www.ftn.uns.ac.rs/rdf/zahtev/" + uniqueID);
        zahtevZaSertifikat.setZahtevId(uniqueID);
        //zahtevZaSertifikat.setRel("pred:saglasnostOd");
        String documentId = "zahtev-" + uniqueID + ".xml";
        try{
            this.zahtevDAO.save(folderPath,documentId,zahtevZaSertifikat,ZahtevZaSertifikat.class);
//            ByteArrayDataSource pdf = new ByteArrayDataSource(generisiPdf(uniqueID), "application/pdf");
//            ByteArrayDataSource xhtml = new ByteArrayDataSource(generisiXHTML(uniqueID), "text/html");
            return uniqueID;
        }
        catch (Exception e){
            throw new Exception();
        }

    }

    public Integer getCountInRange(String start,String end){
        return this.zahtevDAO.getCountDateRange(start,end);
    }

    public ZahtevZaSertifikat updateStatus(String id,String status) throws Exception {
        String document_id = "zahtev-" + id + ".xml";
        ZahtevZaSertifikat zahtevZaSertifikat = getById(document_id);
        zahtevZaSertifikat.setStatus(status);
        zahtevDAO.save(zahtevDAO.getFolderPath(),document_id,zahtevZaSertifikat,ZahtevZaSertifikat.class);
        return zahtevZaSertifikat;
    }

    public void declineZahtev(String id,String status,String reason) throws Exception {

        ZahtevZaSertifikat zahtevZaSertifikat = updateStatus(id,status);
        emailService.sendZahtevDeclineMail(getEmailFromSaglasnost(zahtevZaSertifikat.getLicniPodaci().getJMBG().getValue()),reason);
    }

    public String getEmailFromSaglasnost(String jmbg) throws Exception {
        return saglasnostService.getByIdObject(jmbg).getLicniPodaci().getDrzavljanstvo().getSrpsko().getJMBG().getValue();
    }
    public List<ZahtevZaSertifikat> getAllPendingUserZahtevi(String jmbg){
        List<ZahtevZaSertifikat> zahtevZaSertifikat = zahtevDAO.getAllPendingJmbgZahtevi(jmbg);
        return zahtevZaSertifikat;
    }

    public ByteArrayInputStream generisiPdf(String uniqueID) throws Exception {
        String zahtev = getByIdString(uniqueID);
        if (zahtev == null) {
            throw new Exception();
        }
        return pdfTransformerService.generatePDF(zahtev, XSLFOPaths.ZAHTEV_XSL_FO);
    }

    public ByteArrayInputStream generisiXHTML(String uniqueID) throws Exception {
        String zahtev = getByIdString(uniqueID);
        if (zahtev == null) {
            throw new Exception();
        }
        return xhtmlTransformerService.generateHTML(zahtev, XSLPaths.ZAHTEV_XSL);
    }
}