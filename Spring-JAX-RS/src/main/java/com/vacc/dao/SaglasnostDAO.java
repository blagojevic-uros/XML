package com.vacc.dao;

import com.vacc.config.DBConfig;
import model.interesovanje.Interesovanje;
import model.saglasnost.SaglasnostZaImunizaciju;
import model.saglasnost.TVakcinisanje;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import util.ObjectParser;

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

    public String getFolderPath() {
        return folderPath;
    }

    public List<SaglasnostZaImunizaciju> getByJmbgOrPassportNumber(String jmbg){

        String xPath = "//saglasnost_za_imunizaciju[licni_podaci/drzavljanstvo/srpsko/JMBG ='" + jmbg + "']";
        List<SaglasnostZaImunizaciju> saglasnostZaImunizaciju = new ArrayList<>();
        try{
            saglasnostZaImunizaciju = this.xPathResult(this.dbConfig.getUrl()+folderPath, xPath,"http://ftn.uns.ac.rs/vakcina/saglasnost",SaglasnostZaImunizaciju.class);
        }
        catch(XMLDBException xe){
            xe.printStackTrace();
        }
        return saglasnostZaImunizaciju;
    }


    public List<String> getVakcineInDateRange(String start, String end) throws SAXException {
        String xPath = "//saglasnost_za_imunizaciju//vakcinisanje[datum_davanja >'" + start + "' and datum_davanja <'" + end + "']";
        List<String> vakcine = new ArrayList<>();
        try{
            vakcine = this.xPathResult2(this.dbConfig.getUrl()+folderPath, xPath,"",TVakcinisanje.class);
        }
        catch(XMLDBException xe){
            xe.printStackTrace();
        }
        return vakcine;
    }

}


