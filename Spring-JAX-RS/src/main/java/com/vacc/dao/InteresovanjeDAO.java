package com.vacc.dao;

import com.vacc.config.DBConfig;
import model.interesovanje.Interesovanje;
import org.springframework.stereotype.Component;
import org.xmldb.api.base.XMLDBException;

import java.util.ArrayList;
import java.util.List;

@Component
public class InteresovanjeDAO extends  DataAccessLayer{

    private final String folderPath="/db/interesovanje";
    private final DBConfig dbConfig;
    public InteresovanjeDAO(DBConfig dbConfig) {
        super(dbConfig);
        this.dbConfig = dbConfig;
    }

    public List<String> getAll() throws XMLDBException {
        return this.getAllDocumentNames(folderPath);
    }

    public List<Interesovanje> getAll(String jmbg){

//        String xPath = "//interesovanje[licni_podaci/JMBG ='" + jmbg + "']";
        String xPath = "//interesovanje[licni_podaci/JMBG ='" + jmbg + "']";
        List<Interesovanje> interesovanja = new ArrayList<>();
        try{
            interesovanja = this.xPathResult(this.dbConfig.getUrl()+folderPath, xPath,"http://ftn.uns.ac.rs/vakcina/interesovanje",Interesovanje.class);
        }
        catch(XMLDBException xe){
            xe.printStackTrace();
        }
        System.out.println(interesovanja);
        return interesovanja;
    }

}
