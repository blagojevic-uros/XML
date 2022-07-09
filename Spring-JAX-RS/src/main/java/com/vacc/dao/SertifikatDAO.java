package com.vacc.dao;

import com.vacc.config.DBConfig;
import lombok.Getter;
import model.interesovanje.Interesovanje;
import model.sertifikat.ZeleniSertifikat;
import org.springframework.stereotype.Component;
import org.xmldb.api.base.XMLDBException;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class SertifikatDAO extends DataAccessLayer{

    private final String folderPath ="/db/sertifikat";
    private final DBConfig dbConfig;

    public SertifikatDAO(DBConfig dbConfig) {
        super(dbConfig);
        this.dbConfig = dbConfig;
    }

    public List<ZeleniSertifikat> getAll(String jmbg) {
        String xPath = "//zeleni_sertifikat[licni_podaci/JMBG ='" + jmbg + "']";
        List<ZeleniSertifikat> sertifikati = new ArrayList<>();
        try{
            sertifikati = this.xPathResult(this.dbConfig.getUrl()+folderPath, xPath,"http://ftn.uns.ac.rs/vakcina/sertifikat",ZeleniSertifikat.class);
        }
        catch(XMLDBException xe){
            xe.printStackTrace();
        }
        System.out.println(sertifikati);
        return sertifikati;
    }
}
