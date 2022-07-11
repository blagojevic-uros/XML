package com.vacc.service;

import com.vacc.dao.SertifikatDAO;
import model.sertifikat.ZeleniSertifikat;
import org.springframework.stereotype.Service;
import util.XSLFOPaths;
import util.XSLPaths;

import javax.mail.util.ByteArrayDataSource;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.UUID;

@Service
public class SertifikatService {


    private final SertifikatDAO sertifikatDAO;
    private final XHTMLTransformerService xhtmlTransformerService;
    private final PDFTransformerService pdfTransformerService;
    private final String folderPath="/db/sertifikat";

    public SertifikatService(SertifikatDAO sertifikatDAO, XHTMLTransformerService xhtmlTransformerService, PDFTransformerService pdfTransformerService) {
        this.sertifikatDAO = sertifikatDAO;
        this.xhtmlTransformerService = xhtmlTransformerService;
        this.pdfTransformerService = pdfTransformerService;
    }

    public void save(ZeleniSertifikat sertifikat) throws Exception {
        String uniqueID = UUID.randomUUID().toString();
        sertifikat.setId(uniqueID);
        String documentId = "sertifikat-" + uniqueID + "-22.xml";
        sertifikatDAO.save(sertifikatDAO.getFolderPath(), documentId,sertifikat,ZeleniSertifikat.class);
//        ByteArrayDataSource pdf = new ByteArrayDataSource(generisiPdf(uniqueID), "application/pdf");
//        ByteArrayDataSource xhtml = new ByteArrayDataSource(generisiXHTML(uniqueID), "text/html");

    }

    public List<ZeleniSertifikat> getAllJmbg(String jmbg){
        return sertifikatDAO.getAll(jmbg);
    }

    public ByteArrayInputStream generisiPdf(String uniqueID) throws Exception {
        String sertifikat = getById(uniqueID);
        if (sertifikat == null) {
            throw new Exception();
        }
        return pdfTransformerService.generatePDF(sertifikat, XSLFOPaths.SERTIFIKAT_XSL_FO);
    }

    public ByteArrayInputStream generisiXHTML(String uniqueID) throws Exception {
        String sertifikat = getById(uniqueID);
        if (sertifikat == null) {
            throw new Exception();
        }
        return xhtmlTransformerService.generateHTML(sertifikat, XSLPaths.SERTIFIKAT_XSL);
    }

    public String getById(String id) throws Exception {
        try{
            String documentId = "sertifikat-" + id + ".xml";
            return (String) this.sertifikatDAO.getById(documentId,folderPath).getContent();
        }
        catch (Exception e){
            throw new Exception();
        }
    }
}
