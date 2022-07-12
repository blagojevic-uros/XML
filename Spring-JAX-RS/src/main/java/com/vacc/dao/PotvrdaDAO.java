package com.vacc.dao;

import com.vacc.config.DBConfig;
import model.interesovanje.Interesovanje;
import model.potvrda.PotvrdaOVakcinaciji;
import org.springframework.stereotype.Component;
import org.xmldb.api.base.XMLDBException;

import java.util.ArrayList;
import java.util.List;

@Component
public class PotvrdaDAO extends DataAccessLayer{

    private final String folderPath="/db/potvrda";
    private final DBConfig dbConfig;

    public PotvrdaDAO(DBConfig dbConfig) {
        super(dbConfig);
        this.dbConfig = dbConfig;
    }

    public List<PotvrdaOVakcinaciji> getByJmbg(String jmbg){
        String xPath = "//potvrda_o_vakcinaciji[licni_podaci/JMBG ='" + jmbg + "']";
        List<PotvrdaOVakcinaciji> potvrda = new ArrayList<>();
        try{
            potvrda = this.xPathResult(this.dbConfig.getUrl()+folderPath, xPath,"http://ftn.uns.ac.rs/vakcina/potvrda",PotvrdaOVakcinaciji.class);
        }
        catch(XMLDBException xe){
            xe.printStackTrace();
        }
        System.out.println(potvrda);
        return potvrda;
    }

}
