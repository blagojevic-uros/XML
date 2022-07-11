package com.vacc.service;

import com.vacc.dao.PotvrdaDAO;
import com.vacc.dao.ZahtevDAO;
import model.potvrda.PotvrdaOVakcinaciji;
import model.zahtev.ZahtevZaSertifikat;
import org.springframework.stereotype.Service;
import util.ObjectParser;
import util.XSLFOPaths;
import util.XSLPaths;

import javax.mail.util.ByteArrayDataSource;
import java.io.ByteArrayInputStream;
import java.util.UUID;

@Service
public class PotvrdaService {

    private final ObjectParser objectParser;
    private final PotvrdaDAO potvrdaDAO;
    private final String folderPath="/db/potvrda";
    private final EmailService emailService;
    private final XHTMLTransformerService xhtmlTransformerService;
    private final PDFTransformerService pdfTransformerService;

    public PotvrdaService(ObjectParser objectParser, PotvrdaDAO potvrdaDAO, EmailService emailService, XHTMLTransformerService xhtmlTransformerService, PDFTransformerService pdfTransformerService){
        this.objectParser = objectParser;
        this.potvrdaDAO = potvrdaDAO;
        this.emailService = emailService;
        this.xhtmlTransformerService = xhtmlTransformerService;
        this.pdfTransformerService = pdfTransformerService;
    }

    public String save(PotvrdaOVakcinaciji potvrdaOVakcinaciji) throws Exception{
        String uniqueID = UUID.randomUUID().toString();
        potvrdaOVakcinaciji.setId(uniqueID);
        //potvrdaOVakcinaciji.setAbout("http://www.ftn.uns.ac.rs/rdf/potvrda/" + uniqueID);
        //potvrdaOVakcinaciji.setRel("pred:saglasnostOd");
        String documentId = "potvrda-" + uniqueID + ".xml";
        try{
            this.potvrdaDAO.save(folderPath,documentId,potvrdaOVakcinaciji,PotvrdaOVakcinaciji.class);
            ByteArrayDataSource pdf = new ByteArrayDataSource(generisiPdf(uniqueID), "application/pdf");
            ByteArrayDataSource xhtml = new ByteArrayDataSource(generisiXHTML(uniqueID), "text/html");
            return uniqueID;
        }
        catch (Exception e){
            throw new Exception();
        }

    }

    public ByteArrayInputStream generisiPdf(String uniqueID) throws Exception {
        String potvrda = getById(uniqueID);
        if (potvrda == null) {
            throw new Exception();
        }
        return pdfTransformerService.generatePDF(potvrda, XSLFOPaths.POTVRDA_XSL_FO);
    }

    public ByteArrayInputStream generisiXHTML(String uniqueID) throws Exception {
        String potvrda = getById(uniqueID);
        if (potvrda == null) {
            throw new Exception();
        }
        return xhtmlTransformerService.generateHTML(potvrda, XSLPaths.POTVRDA_XSL);
    }

    public String getById(String id) throws Exception {
        try{
            String documentId = "potvrda-" + id + ".xml";
            return (String) this.potvrdaDAO.getById(documentId,folderPath).getContent();
        }
        catch (Exception e){
            throw new Exception();
        }
    }
}
