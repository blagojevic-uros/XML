package com.vacc.dao;

import com.vacc.config.DBConfig;
import lombok.Getter;
import model.vakcine.Vakcina;
import org.springframework.stereotype.Component;
import org.xmldb.api.base.XMLDBException;
import util.ObjectParser;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;


@Component
@Getter
public class VakcineDAO extends DataAccessLayer{
    private final String folderPath = "/db/vakcine";
    private final DBConfig dbConfig;
    public VakcineDAO(DBConfig dbConfig) {
        super(dbConfig);
        this.dbConfig = dbConfig;
    }
    public List<Vakcina> getAllVakcineObject() throws XMLDBException, JAXBException {
        List<String> names = getAllDocumentNames(folderPath);
        System.out.println(names);
        List<Vakcina> vakcine = new ArrayList<>();

        for(String name: names){
            Vakcina v = (Vakcina) ObjectParser.parseToObject(getById(name,folderPath),Vakcina.class);
            vakcine.add(v);
        }
        return vakcine;
    }
    public List<String> getAllVakcine() throws XMLDBException {
        List<String> names = getAllDocumentNames(folderPath);
        System.out.println(names);
        List<String> vakcine = new ArrayList<>();
        for(String name: names){
            vakcine.add((String) getById(name,folderPath).getContent());
        }
        return vakcine;
    }
}
