package com.vacc.dao;

import com.vacc.config.DBConfig;
import model.interesovanje.Interesovanje;
import model.zahtev.ZahtevZaSertifikat;
import org.springframework.stereotype.Component;
import org.xmldb.api.base.XMLDBException;

import java.util.ArrayList;
import java.util.List;

@Component
public class ZahtevDAO extends DataAccessLayer{

    private final String folderPath="/db/zahtev";
    private final DBConfig dbConfig;
    public ZahtevDAO(DBConfig dbConfig) {
        super(dbConfig);
        this.dbConfig = dbConfig;
    }

    public Integer getCountDateRange(String start, String end){
        String xPath = "//zahtev_za_sertifikat[datum_zahtev >'" + start + "' and datum_zahtev <'" + end + "']";
        List<ZahtevZaSertifikat> zahtevi = new ArrayList<>();
        try{
            zahtevi = this.xPathResult(this.dbConfig.getUrl()+folderPath, xPath,"http://ftn.uns.ac.rs/vakcina/zahtev",ZahtevZaSertifikat.class);
        }
        catch(XMLDBException xe){
            xe.printStackTrace();
        }

        return zahtevi.size();

    }

}