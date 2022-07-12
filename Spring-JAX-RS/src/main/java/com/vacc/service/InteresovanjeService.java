package com.vacc.service;

import com.vacc.dao.InteresovanjeDAO;
import model.interesovanje.Interesovanje;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import util.ObjectParser;
import util.XSLFOPaths;
import util.XSLPaths;

import javax.mail.util.ByteArrayDataSource;
import java.io.ByteArrayInputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class InteresovanjeService {

    private final ObjectParser objectParser;
    private final InteresovanjeDAO interesovanjeDAO;
    private final EmailService emailService;

    private final XHTMLTransformerService xhtmlTransformerService;
    private final PDFTransformerService pdfTransformerService;
    private final String folderPath="/db/interesovanje";
    public InteresovanjeService(ObjectParser objectParser, InteresovanjeDAO interesovanjeDAO, EmailService emailService, XHTMLTransformerService xhtmlTransformerService, PDFTransformerService pdfTransformerService) {
        this.objectParser = objectParser;
        this.interesovanjeDAO = interesovanjeDAO;
        this.emailService = emailService;
        this.xhtmlTransformerService = xhtmlTransformerService;
        this.pdfTransformerService = pdfTransformerService;
    }

    public String save(Interesovanje interesovanje) throws Exception{
        String uniqueID = UUID.randomUUID().toString();
        interesovanje.setId(uniqueID);
        interesovanje.setAbout("http://www.ftn.uns.ac.rs/rdf/interesovanje/" + uniqueID);
        interesovanje.setRel("pred:saglasnostOd");
        String documentId = "interesovanje-" + uniqueID + ".xml";

        if(!this.interesovanjeDAO.getAll(interesovanje.getLicniPodaci().getJMBG().getValue()).isEmpty()){
            throw new Exception();
        };
        try{
            this.interesovanjeDAO.save(folderPath,documentId,interesovanje,Interesovanje.class);
            ByteArrayDataSource pdf = new ByteArrayDataSource(generisiPdf(uniqueID), "application/pdf");
            ByteArrayDataSource xhtml = new ByteArrayDataSource(generisiXHTML(uniqueID), "text/html");
            emailService.sendMail(interesovanje.getLicniPodaci().getEmail(),"Interesovanje ","Vase interesovanje. Popunite saglasnost!!",pdf,xhtml);
            return uniqueID;
        }
        catch (Exception e){
            throw new Exception();
        }

    }

    public ByteArrayInputStream generisiPdf(String uniqueID) throws Exception {
        String interesovanje = getById(uniqueID);
        if (interesovanje == null) {
            throw new Exception();
        }
        return pdfTransformerService.generatePDF(interesovanje, XSLFOPaths.INTERESOVANJE_XSL_FO);
    }

    public ByteArrayInputStream generisiXHTML(String uniqueID) throws Exception {
        String interesovanje = getById(uniqueID);
        if (interesovanje == null) {
            throw new Exception();
        }
        return xhtmlTransformerService.generateHTML(interesovanje, XSLPaths.INTERESOVANJE_XSL);
    }
    public String getById(String id) throws Exception {
        try{
            String documentId = "interesovanje-" + id + ".xml";
            return (String) this.interesovanjeDAO.getById(documentId,folderPath).getContent();
        }
        catch (Exception e){
            throw new Exception();
        }
    }
    public Interesovanje getByIdObject(String id) throws Exception {
        try{
            String documentId = "interesovanje-" + id + ".xml";
            XMLResource content = this.interesovanjeDAO.getById(documentId,folderPath);
            return (Interesovanje) ObjectParser.parseToObject(content,Interesovanje.class);
        }
        catch (Exception e){
            throw new Exception();
        }
    }
    public List<String> getAll() throws Exception{
        return this.interesovanjeDAO.getAll();
    }
    public List<Interesovanje> getAllJMBG(String jmbg) throws XMLDBException {
        return this.interesovanjeDAO.getAll(jmbg);
    }

    public Integer getCountInRange(String start,String end){
        return this.interesovanjeDAO.getCountDateRange(start,end);
    }
}
