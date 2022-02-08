package com.vacc.service;

import com.vacc.dao.InteresovanjeDAO;
import model.interesovanje.Interesovanje;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import util.ObjectParser;

import java.util.List;
import java.util.UUID;

@Service
public class InteresovanjeService {

    private final ObjectParser objectParser;
//    private final DataAccessLayer dao;
    private final InteresovanjeDAO interesovanjeDAO;

    private final String folderPath="/db/interesovanje";
    public InteresovanjeService(ObjectParser objectParser,InteresovanjeDAO interesovanjeDAO) {
        this.objectParser = objectParser;
//        this.dao = dao;
        this.interesovanjeDAO = interesovanjeDAO;
    }

//    public Interesovanje getById(String id) {
//        this.dao.getById()
//    }

    public String save(Interesovanje interesovanje) throws Exception{
        String uniqueID = UUID.randomUUID().toString();
        interesovanje.setId(uniqueID);
        interesovanje.setAbout("http://www.ftn.uns.ac.rs/rdf/interesovanje/" + uniqueID);
        interesovanje.setRel("pred:saglasnostOd");
        String documentId = "interesovanje-" + uniqueID + ".xml";
        try{
            this.interesovanjeDAO.save(folderPath,documentId,interesovanje,Interesovanje.class);
            return uniqueID;
        }
        catch (Exception e){
            throw new Exception();
        }

    }

    public String getById(String id) throws Exception {
        try{
            String documentId = "interesovanje-" + id + ".xml";
            return (String) this.interesovanjeDAO.getById(documentId,folderPath).getContent();
        }
        catch (Exception e){
            throw new Exception();
        }
    }
    public Interesovanje getByIdObject(String id) throws Exception {
        try{
            String documentId = "interesovanje-" + id + ".xml";
            XMLResource content = this.interesovanjeDAO.getById(documentId,folderPath);
            return (Interesovanje) ObjectParser.parseToObject(content,Interesovanje.class);
        }
        catch (Exception e){
            throw new Exception();
        }
    }
    public List<String> getAll() throws Exception{
        return this.interesovanjeDAO.getAll();
    }
    public List<Interesovanje> getAllJMBG(String jmbg) throws XMLDBException {
        return this.interesovanjeDAO.getAll(jmbg);
    }
}
