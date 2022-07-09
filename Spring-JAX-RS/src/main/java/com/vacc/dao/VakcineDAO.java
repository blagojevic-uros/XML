package com.vacc.dao;

import com.vacc.config.DBConfig;
import org.springframework.stereotype.Component;
import org.xmldb.api.base.XMLDBException;

import java.util.ArrayList;
import java.util.List;


@Component
public class VakcineDAO extends DataAccessLayer{
    private final String folderPath = "/db/vakcine";
    private final DBConfig dbConfig;
    public VakcineDAO(DBConfig dbConfig) {
        super(dbConfig);
        this.dbConfig = dbConfig;
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
