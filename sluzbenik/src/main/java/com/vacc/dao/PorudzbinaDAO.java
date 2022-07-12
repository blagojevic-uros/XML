package com.vacc.dao;

import com.vacc.config.DBConfig;
import com.vacc.config.DataConfig;
import lombok.Getter;
import model.interesovanje.Interesovanje;
import model.vakcine.Porudzbina;
import model.vakcine.Vakcina;
import org.springframework.stereotype.Component;
import org.xmldb.api.base.XMLDBException;
import util.ObjectParser;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Component
public class PorudzbinaDAO extends  DataAccessLayer{
    private final String folderPath = "/db/porudzbina";
    private final DBConfig dbConfig;
    public PorudzbinaDAO(DBConfig dbConfig) {
        super(dbConfig);
        this.dbConfig = dbConfig;
    }

    public List<Porudzbina> getAllPorudzbinaObject() throws XMLDBException, JAXBException {
        List<String> names = getAllDocumentNames(folderPath);
        List<Porudzbina> porudzbine = new ArrayList<>();

        for(String name: names){
            Porudzbina p = (Porudzbina) ObjectParser.parseToObject(getById(name,folderPath),Porudzbina.class);
            porudzbine.add(p );
        }
        return porudzbine;
    }
    public List<Porudzbina> getAllPendingPorudzbine() throws XMLDBException, JAXBException {
        String xPath = "//porudzbina[status ='PENDING']";
        List<Porudzbina> porudzbinas = new ArrayList<>();
        try{
            porudzbinas = this.xPathResult(this.dbConfig.getUrl()+folderPath, xPath,"",Porudzbina.class);
        }
        catch(XMLDBException xe){
            xe.printStackTrace();
        }
        System.out.println(porudzbinas);
        return porudzbinas;
    }
    public Porudzbina getById(String id) throws XMLDBException, JAXBException {
        String xPath = "//porudzbina[id ='" +id + "']";
        List<Porudzbina> porudzbinas = new ArrayList<>();
        try{
            porudzbinas = this.xPathResult(this.dbConfig.getUrl()+folderPath, xPath,"",Porudzbina.class);
        }
        catch(XMLDBException xe){
            xe.printStackTrace();
        }
        System.out.println(porudzbinas);
        return porudzbinas.get(0);
    }
}
