package com.vacc.dao;

import com.vacc.config.DBConfig;
import org.springframework.stereotype.Component;

@Component
public class PotvrdaDAO extends DataAccessLayer{

    private final String folderPath="/db/potvrda";
    private final DBConfig dbConfig;

    public PotvrdaDAO(DBConfig dbConfig) {
        super(dbConfig);
        this.dbConfig = dbConfig;
    }
}
