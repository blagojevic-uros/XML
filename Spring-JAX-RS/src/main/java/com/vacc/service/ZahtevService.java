package com.vacc.service;

import com.vacc.dao.ZahtevDAO;
import model.interesovanje.Interesovanje;
import model.zahtev.ZahtevZaSertifikat;
import org.springframework.stereotype.Service;
import util.ObjectParser;

import java.util.Date;
import java.util.UUID;

@Service
public class ZahtevService {

    private final ObjectParser objectParser;
    private final ZahtevDAO zahtevDAO;
    private final String folderPath="/db/zahtev";


    public ZahtevService(ObjectParser objectParser, ZahtevDAO zahtevDAO) {
        this.objectParser = objectParser;
        this.zahtevDAO = zahtevDAO;
    }

    public String save(ZahtevZaSertifikat zahtevZaSertifikat) throws Exception{
        String uniqueID = UUID.randomUUID().toString();
        zahtevZaSertifikat.setId(uniqueID);
       //zahtevZaSertifikat.setAbout("http://www.ftn.uns.ac.rs/rdf/interesovanje/" + uniqueID);
        //zahtevZaSertifikat.setRel("pred:saglasnostOd");
        String documentId = "zahtev-" + uniqueID + ".xml";
        try{
            this.zahtevDAO.save(folderPath,documentId,zahtevZaSertifikat,ZahtevZaSertifikat.class);
            return uniqueID;
        }
        catch (Exception e){
            throw new Exception();
        }

    }
}
