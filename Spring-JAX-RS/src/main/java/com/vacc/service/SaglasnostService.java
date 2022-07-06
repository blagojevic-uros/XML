package com.vacc.service;

import com.vacc.dao.InteresovanjeDAO;
import com.vacc.dao.SaglasnostDAO;
import model.interesovanje.Interesovanje;
import model.saglasnost.LicniPodaci;
import model.saglasnost.SaglasnostZaImunizaciju;
import org.springframework.stereotype.Service;
import util.ObjectParser;

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
    public String save(LicniPodaci saglasnost) throws Exception{
        String uniqueID = UUID.randomUUID().toString();
        String documentId = "saglasnost-" + uniqueID + ".xml";
        //emailService.sendMailForSaglasnost(interesovanje.getLicniPodaci().getEmail(),new Date());
        try{
            //this.saglasnostDAO.save(folderPath,documentId,interesovanje,Interesovanje.class);
            return "good";
        }
        catch (Exception e){
            throw new Exception();
        }

    }
}
