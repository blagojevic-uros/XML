package com.vacc.service;

import com.vacc.Exception.NotFoundException;
import com.vacc.dao.ZahtevDAO;
import model.saglasnost.SaglasnostZaImunizaciju;
import model.zahtev.ZahtevZaSertifikat;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;
import util.ObjectParser;

import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.UUID;

@Service
public class ZahtevService {

    private final ObjectParser objectParser;
    private final ZahtevDAO zahtevDAO;
    private final String folderPath="/db/zahtev";

    private final SaglasnostService saglasnostService;
    public ZahtevService(ObjectParser objectParser, ZahtevDAO zahtevDAO, SaglasnostService saglasnostService) {
        this.objectParser = objectParser;
        this.zahtevDAO = zahtevDAO;
        this.saglasnostService = saglasnostService;
    }

    public ZahtevZaSertifikat getById(String id) throws XMLDBException, JAXBException {

        ZahtevZaSertifikat zahtevZaSertifikat = (ZahtevZaSertifikat) ObjectParser.parseToObject(this.zahtevDAO.getById(id,zahtevDAO.getFolderPath()),ZahtevZaSertifikat.class);
        return zahtevZaSertifikat;
    }
    public String save(ZahtevZaSertifikat zahtevZaSertifikat,String jmbg) throws Exception{

        List<SaglasnostZaImunizaciju> saglasnosti = saglasnostService.getByJmbgOrPassportNumber(jmbg);
        
//        if(saglasnosti.isEmpty()){
//            throw new NotFoundException("Ne postoji saglasnost");
//        }
//        if(saglasnosti.get(0).getEvidencijaOVakcinaciji() == null){
//            throw new NotFoundException("Niste se vakcinisali");
//        }
        String uniqueID = UUID.randomUUID().toString();
        zahtevZaSertifikat.setId(uniqueID);
        zahtevZaSertifikat.setAbout("http://www.ftn.uns.ac.rs/rdf/zahtev/" + uniqueID);
        zahtevZaSertifikat.setZahtevId(uniqueID);
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

    public Integer getCountInRange(String start,String end){
        return this.zahtevDAO.getCountDateRange(start,end);
    }

    public void updateStatus(String id,String status) throws JAXBException, XMLDBException {
        String document_id = "zahtev-" + id + ".xml";
        ZahtevZaSertifikat zahtevZaSertifikat = getById(document_id);
        zahtevZaSertifikat.setStatus(status);
        zahtevDAO.save(zahtevDAO.getFolderPath(),document_id,zahtevZaSertifikat,ZahtevZaSertifikat.class);
    }

    public List<ZahtevZaSertifikat> getAllPendingUserZahtevi(String jmbg){
        List<ZahtevZaSertifikat> zahtevZaSertifikat = zahtevDAO.getAllPendingJmbgZahtevi(jmbg);
        return zahtevZaSertifikat;
    }
}