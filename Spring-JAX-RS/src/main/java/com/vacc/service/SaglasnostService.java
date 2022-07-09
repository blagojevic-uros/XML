package com.vacc.service;

import com.vacc.dao.InteresovanjeDAO;
import com.vacc.dao.SaglasnostDAO;
import model.interesovanje.Interesovanje;
import model.saglasnost.LicniPodaci;
import model.saglasnost.SaglasnostZaImunizaciju;
import org.springframework.stereotype.Service;
import org.xmldb.api.modules.XMLResource;
import util.ObjectParser;

import java.util.List;
import java.util.UUID;

@Service
public class SaglasnostService {

    private final ObjectParser objectParser;
    private final SaglasnostDAO saglasnostDAO;
    private final String folderPath="/db/saglasnost";
    public SaglasnostService(ObjectParser objectParser, SaglasnostDAO saglasnostDAO) {
        this.objectParser = objectParser;
        this.saglasnostDAO = saglasnostDAO;

    }

    public SaglasnostZaImunizaciju getByJmbgOrPassportNumber(String jmbg) throws Exception {
        try{
            System.out.println(jmbg);
            List<SaglasnostZaImunizaciju> lista =this.saglasnostDAO.getByJmbgOrPassportNumber(jmbg);
            System.out.println(lista);

            return lista.get(0);
        }
        catch (Exception e){
            throw new Exception();
        }
    }

    public String save(SaglasnostZaImunizaciju saglasnost, String jmbg) throws Exception{
        String documentId = "saglasnost-" + jmbg + ".xml";
        //emailService.sendMailForSaglasnost(interesovanje.getLicniPodaci().getEmail(),new Date());
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


    public SaglasnostZaImunizaciju getByIdObject(String jmbg) throws Exception {
        try{
            String documentId = "saglasnost-" + jmbg + ".xml";
            XMLResource content = this.saglasnostDAO.getById(documentId,saglasnostDAO.getFolderPath());
            return (SaglasnostZaImunizaciju) ObjectParser.parseToObject(content,SaglasnostZaImunizaciju.class);
        }
        catch (Exception e){
            throw new Exception();
        }
    }
}
