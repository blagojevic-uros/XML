package com.vacc.service;

import com.vacc.Exception.NotFoundException;
import com.vacc.dao.SaglasnostDAO;
import model.saglasnost.EvidencijaOVakcinaciji;
import model.saglasnost.SaglasnostZaImunizaciju;
import model.saglasnost.TVakcinisanje;
import org.springframework.stereotype.Service;
import org.xmldb.api.modules.XMLResource;
import util.ObjectParser;
import util.XSLFOPaths;
import util.XSLPaths;

import javax.mail.util.ByteArrayDataSource;
import java.io.ByteArrayInputStream;
import java.util.List;

@Service
public class SaglasnostService {

    private final ObjectParser objectParser;
    private final SaglasnostDAO saglasnostDAO;
    private final String folderPath="/db/saglasnost";
    private final XHTMLTransformerService xhtmlTransformerService;
    private final PDFTransformerService pdfTransformerService;
    private final InteresovanjeService interesovanjeService;
    public SaglasnostService(ObjectParser objectParser, SaglasnostDAO saglasnostDAO, InteresovanjeService interesovanjeService, XHTMLTransformerService xhtmlTransformerService, PDFTransformerService pdfTransformerService) {
        this.objectParser = objectParser;
        this.saglasnostDAO = saglasnostDAO;

        this.interesovanjeService = interesovanjeService;
        this.xhtmlTransformerService = xhtmlTransformerService;
        this.pdfTransformerService = pdfTransformerService;
    }

    public List<SaglasnostZaImunizaciju> getByJmbgOrPassportNumber(String jmbg) throws Exception {
        try{
            List<SaglasnostZaImunizaciju> lista =this.saglasnostDAO.getByJmbgOrPassportNumber(jmbg);

            return lista;
        }
        catch (Exception e){
            throw new Exception();
        }
    }

    public String save(SaglasnostZaImunizaciju saglasnost, String jmbg) throws Exception{
        String documentId = "saglasnost-" + jmbg + ".xml";

        if(interesovanjeService.getAllJMBG(jmbg).isEmpty()){
            throw new NotFoundException("Niste popunili interesovanje");
        }
//        SaglasnostZaImunizaciju saglasnostZaImunizaciju = new SaglasnostZaImunizaciju();
//        saglasnostZaImunizaciju.setLicniPodaci(saglasnost);
//        saglasnostZaImunizaciju.setId(uniqueID);
//        saglasnostZaImunizaciju.setRel("pred:interesovanjeOd");
        try{
            this.saglasnostDAO.save(folderPath,documentId,saglasnost,SaglasnostZaImunizaciju.class);
//            ByteArrayDataSource pdf = new ByteArrayDataSource(generisiPdf(uniqueID), "application/pdf");
//            ByteArrayDataSource xhtml = new ByteArrayDataSource(generisiXHTML(uniqueID), "text/html");
            return "good";
        }
        catch (Exception e){
            throw new Exception();
        }
    }





    public String getById(String jmbg) throws Exception {
        try{
            String documentId = "saglasnost-" + jmbg + ".xml";
            System.out.println(documentId);
            System.out.println("*********************");
            XMLResource content = this.saglasnostDAO.getById(documentId,saglasnostDAO.getFolderPath());
            return (String) ObjectParser.parseToObject(content,SaglasnostZaImunizaciju.class);
        }
        catch (Exception e){
            throw new Exception();
        }
    }
    public SaglasnostZaImunizaciju getByIdObject(String jmbg) throws Exception {
        try{
            String documentId = "saglasnost-" + jmbg + ".xml";
            System.out.println(documentId);
            System.out.println("*********************");
            XMLResource content = this.saglasnostDAO.getById(documentId,saglasnostDAO.getFolderPath());
            return (SaglasnostZaImunizaciju) ObjectParser.parseToObject(content,SaglasnostZaImunizaciju.class);
        }
        catch (Exception e){
            throw new Exception();
        }
    }


    public ByteArrayInputStream generisiPdf(String uniqueID) throws Exception {
        String saglasnost = getById(uniqueID);
        if (saglasnost == null) {
            throw new Exception();
        }
        return pdfTransformerService.generatePDF(saglasnost, XSLFOPaths.SAGLASNOST_XSL_FO);
    }

    public ByteArrayInputStream generisiXHTML(String uniqueID) throws Exception {
        String saglasnost = getById(uniqueID);
        if (saglasnost == null) {
            throw new Exception();
        }
        return xhtmlTransformerService.generateHTML(saglasnost, XSLPaths.SAGLASNOST_XSL);
    }
    public void updateSaglasnost(EvidencijaOVakcinaciji evidencijaOVakcinaciji,String jmbg) throws Exception {
//        evidencijaOVakcinaciji.getTabelaVakcinisanja();
        evidencijaOVakcinaciji.setTabelaVakcinisanja(new EvidencijaOVakcinaciji.TabelaVakcinisanja());
        SaglasnostZaImunizaciju saglasnostZaImunizaciju = getByIdObject(jmbg);
        saglasnostZaImunizaciju.setEvidencijaOVakcinaciji(evidencijaOVakcinaciji);
        save(saglasnostZaImunizaciju,jmbg);
    }

    public void updateSaglasnostVakcina(TVakcinisanje vakcinisanje, String jmbg) throws Exception {

        SaglasnostZaImunizaciju saglasnostZaImunizaciju = getByIdObject(jmbg);
        if(saglasnostZaImunizaciju.getEvidencijaOVakcinaciji() == null){
            throw new Exception();
        }
        //\<O(saglasnostZaImunizaciju.getEvidencijaOVakcinaciji().setTabelaVakcinisanja(new EvidencijaOVakcinaciji.TabelaVakcinisanja());
        saglasnostZaImunizaciju.getEvidencijaOVakcinaciji().getTabelaVakcinisanja().getVakcinisanje().add(vakcinisanje);
        save(saglasnostZaImunizaciju,jmbg);
    }
}
