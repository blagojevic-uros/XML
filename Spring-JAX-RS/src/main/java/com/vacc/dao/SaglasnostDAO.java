package com.vacc.dao;

import com.vacc.config.DBConfig;
import org.springframework.stereotype.Component;

@Component
public class SaglasnostDAO extends DataAccessLayer{
    private final String folderPath = "/db/saglasnost";
    private final DBConfig dbConfig;

    public SaglasnostDAO(DBConfig dbConfig) {
        super(dbConfig);
        this.dbConfig = dbConfig;
    }
}


