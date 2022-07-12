package com.vacc.service;

import com.vacc.Exception.NotFoundException;
import com.vacc.dao.SaglasnostDAO;
import model.saglasnost.EvidencijaOVakcinaciji;
import model.saglasnost.SaglasnostZaImunizaciju;
import model.saglasnost.TVakcinisanje;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.modules.XMLResource;
import util.ObjectParser;
import util.XSLFOPaths;
import util.XSLPaths;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SaglasnostService {

    private final ObjectParser objectParser;
    private final SaglasnostDAO saglasnostDAO;
    private final String folderPath="/db/saglasnost";
    private final XHTMLTransformerService xhtmlTransformerService;
    private final PDFTransformerService pdfTransformerService;
    private final InteresovanjeService interesovanjeService;


    private final EmailService emailService;
    private final VakcineService vakcineService;
    public SaglasnostService(ObjectParser objectParser, SaglasnostDAO saglasnostDAO, InteresovanjeService interesovanjeService, XHTMLTransformerService xhtmlTransformerService, PDFTransformerService pdfTransformerService, EmailService emailService, VakcineService vakcineService) {
        this.objectParser = objectParser;
        this.saglasnostDAO = saglasnostDAO;

        this.interesovanjeService = interesovanjeService;
        this.xhtmlTransformerService = xhtmlTransformerService;
        this.pdfTransformerService = pdfTransformerService;
        this.emailService = emailService;
        this.vakcineService = vakcineService;
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

        saglasnost.setId(jmbg);
        if(interesovanjeService.getAllJMBG(jmbg).isEmpty()){
            throw new NotFoundException("Niste popunili interesovanje");
        }
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
            return content.toString();
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
        SaglasnostZaImunizaciju saglasnostZaImunizaciju = getByIdObject(jmbg);
        if (saglasnostZaImunizaciju.getEvidencijaOVakcinaciji() != null){
            throw new Exception();
        }
        evidencijaOVakcinaciji.setTabelaVakcinisanja(new EvidencijaOVakcinaciji.TabelaVakcinisanja());
        saglasnostZaImunizaciju.setEvidencijaOVakcinaciji(evidencijaOVakcinaciji);
        save(saglasnostZaImunizaciju,jmbg);
    }

    public void updateSaglasnostVakcina(TVakcinisanje vakcinisanje, String jmbg) throws Exception {

        SaglasnostZaImunizaciju saglasnostZaImunizaciju = getByIdObject(jmbg);
        if(saglasnostZaImunizaciju.getEvidencijaOVakcinaciji() == null){
            throw new Exception();
        }
        saglasnostZaImunizaciju.getEvidencijaOVakcinaciji().getTabelaVakcinisanja().getVakcinisanje().add(vakcinisanje);

        vakcineService.subtractVakcina(vakcinisanje.getNazivVakcine().getValue().value(),1);


        save(saglasnostZaImunizaciju,jmbg);
        emailService.sendEmail(saglasnostZaImunizaciju.getLicniPodaci().getEmail(),"Sledeca doza","Sledece doza je za 6 meseci");
    }

    public List<String>  getVakcineInRange(String start,String end) throws SAXException {
        List<String> vakcinisanja = this.saglasnostDAO.getVakcineInDateRange(start,end);
        Map<String, Integer> mapaVakcina = new HashMap<>();
        mapaVakcina.put("AstraZeneca",0);
        mapaVakcina.put("Moderna",0);
        mapaVakcina.put("Pfizer-BioNTech",0);
        mapaVakcina.put("Sinopharm",0);
        mapaVakcina.put("Sputnik_V",0);
        Integer count = 0;
//        for(TVakcinisanje vakcina: vakcinisanja){
//            System.out.println(vakcina.getProizvodjac());
////            String key = vakcina.getProizvodjac().value();
////            mapaVakcina.put(key, mapaVakcina.get(key) + 1);
//        }
        return vakcinisanja;
    }
}
