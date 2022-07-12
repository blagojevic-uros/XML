package com.vacc.service;

import com.vacc.dao.SertifikatDAO;
import model.sertifikat.ZeleniSertifikat;
import org.springframework.stereotype.Service;
import util.ObjectParser;
import util.QrCodeUtil;
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

    public String save(ZeleniSertifikat sertifikat) throws Exception {
        String uniqueID = UUID.randomUUID().toString();
        uniqueID = uniqueID + "-22";
        sertifikat.setId(uniqueID);
        sertifikat.setBrojSertifikata(uniqueID);
        String documentId = "sertifikat-" + uniqueID + ".xml";
        sertifikat.setQRCode(QrCodeUtil.generisiQRCode( "http://localhost:9090/api/sertifikat/"+uniqueID));
        sertifikatDAO.save(sertifikatDAO.getFolderPath(), documentId,sertifikat,ZeleniSertifikat.class);
//        ByteArrayDataSource pdf = new ByteArrayDataSource(generisiPdf(uniqueID), "application/pdf");
//        ByteArrayDataSource xhtml = new ByteArrayDataSource(generisiXHTML(uniqueID), "text/html");
        return uniqueID;
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

    public ZeleniSertifikat getByIdObject(String id) throws Exception {
        try{
            String documentId = "sertifikat-" + id + ".xml";
            return (ZeleniSertifikat) ObjectParser.parseToObject(this.sertifikatDAO.getById(documentId,folderPath),ZeleniSertifikat.class);
        }
        catch (Exception e){
            throw new Exception();
        }
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
