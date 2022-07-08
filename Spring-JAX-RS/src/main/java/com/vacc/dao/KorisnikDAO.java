package com.vacc.dao;

import com.vacc.config.DBConfig;
import lombok.Getter;
import model.korisnik.Korisnik;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.xmldb.api.base.XMLDBException;
import util.ObjectParser;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class KorisnikDAO extends DataAccessLayer{
    private final String folderPath="/db/korisnik/";
    private final DBConfig dbConfig;
    public KorisnikDAO(DBConfig dbConfig) {
        super(dbConfig);
        this.dbConfig = dbConfig;
    }
    public UserDetails getByUsername(String username) throws XMLDBException, JAXBException {
        Korisnik korisnik = (Korisnik) ObjectParser.parseToObject(getById(username + ".xml", folderPath), Korisnik.class);
        return korisnik;
    }

    //TODO: proveriti zasto ne radi
    public UserDetails getByUsername1(String username){
        String xPath = "//korisnik[username ='" + username + "']";
        List<Korisnik> korisnici = new ArrayList<>();
        try{
            korisnici = this.xPathResult(this.dbConfig.getUrl()+folderPath, xPath,"",Korisnik.class);
        }
        catch(XMLDBException xe){
            xe.printStackTrace();
        }
        return korisnici.get(0);
    }


}
