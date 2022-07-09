package com.vacc.service;

import com.vacc.Exception.NotFoundException;
import com.vacc.dao.SaglasnostDAO;
import model.saglasnost.EvidencijaOVakcinaciji;
import model.saglasnost.SaglasnostZaImunizaciju;
import org.springframework.stereotype.Service;
import org.xmldb.api.modules.XMLResource;
import util.ObjectParser;

import java.util.List;

@Service
public class SaglasnostService {

    private final ObjectParser objectParser;
    private final SaglasnostDAO saglasnostDAO;
    private final String folderPath="/db/saglasnost";

    private final InteresovanjeService interesovanjeService;
    public SaglasnostService(ObjectParser objectParser, SaglasnostDAO saglasnostDAO, InteresovanjeService interesovanjeService) {
        this.objectParser = objectParser;
        this.saglasnostDAO = saglasnostDAO;

        this.interesovanjeService = interesovanjeService;
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
            return "good";
        }
        catch (Exception e){
            throw new Exception();
        }
    }

    public void updateSaglasnost(EvidencijaOVakcinaciji evidencijaOVakcinaciji,String jmbg) throws Exception {
        SaglasnostZaImunizaciju saglasnostZaImunizaciju = getByIdObject(jmbg);
        saglasnostZaImunizaciju.setEvidencijaOVakcinaciji(evidencijaOVakcinaciji);
        save(saglasnostZaImunizaciju,jmbg);
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
}
