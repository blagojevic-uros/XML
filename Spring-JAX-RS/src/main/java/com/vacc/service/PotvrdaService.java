package com.vacc.service;

import com.vacc.dao.PotvrdaDAO;
import com.vacc.dao.ZahtevDAO;
import model.potvrda.PotvrdaOVakcinaciji;
import model.zahtev.ZahtevZaSertifikat;
import org.springframework.stereotype.Service;
import util.ObjectParser;

import java.util.UUID;

@Service
public class PotvrdaService {

    private final ObjectParser objectParser;
    private final PotvrdaDAO potvrdaDAO;
    private final String folderPath="/db/potvrda";

    public PotvrdaService(ObjectParser objectParser, PotvrdaDAO potvrdaDAO){
        this.objectParser = objectParser;
        this.potvrdaDAO = potvrdaDAO;
    }

    public String save(PotvrdaOVakcinaciji potvrdaOVakcinaciji) throws Exception{
        String uniqueID = UUID.randomUUID().toString();
        potvrdaOVakcinaciji.setId(uniqueID);
        //potvrdaOVakcinaciji.setAbout("http://www.ftn.uns.ac.rs/rdf/potvrda/" + uniqueID);
        //potvrdaOVakcinaciji.setRel("pred:saglasnostOd");
        String documentId = "potvrda-" + uniqueID + ".xml";
        try{
            this.potvrdaDAO.save(folderPath,documentId,potvrdaOVakcinaciji,PotvrdaOVakcinaciji.class);
            return uniqueID;
        }
        catch (Exception e){
            throw new Exception();
        }

    }

}
