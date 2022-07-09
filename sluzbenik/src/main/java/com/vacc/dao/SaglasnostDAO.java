package com.vacc.dao;

import com.vacc.config.DBConfig;
import model.interesovanje.Interesovanje;
import model.saglasnost.SaglasnostZaImunizaciju;
import org.springframework.stereotype.Component;
import org.xmldb.api.base.XMLDBException;

import java.util.ArrayList;
import java.util.List;

@Component
public class SaglasnostDAO extends DataAccessLayer{
    private final String folderPath = "/db/saglasnost";
    private final DBConfig dbConfig;

    public SaglasnostDAO(DBConfig dbConfig) {
        super(dbConfig);
        this.dbConfig = dbConfig;
    }

    public List<SaglasnostZaImunizaciju> getByJmbgOrPassportNumber(String jmbg){

        String xPath = "//saglasnost_za_imunizaciju/licni_podaci/drzavljanstvo/srpsko[JMBG ='" + jmbg + "']";
        List<SaglasnostZaImunizaciju> saglasnostZaImunizaciju = new ArrayList<>();
        try{
            saglasnostZaImunizaciju = this.xPathResult(this.dbConfig.getUrl()+folderPath, xPath,"http://ftn.uns.ac.rs/vakcina/saglasnost",SaglasnostZaImunizaciju.class);
        }
        catch(XMLDBException xe){
            xe.printStackTrace();
        }
        return saglasnostZaImunizaciju;
    }
}


