package com.vacc.dao;

import com.vacc.config.DBConfig;

public class IzvestajDAO extends DataAccessLayer{
    private final String folderPath = "/db/izvestaj";
    private final DBConfig dbConfig;

    public IzvestajDAO(DBConfig dbConfig) {
        super(dbConfig);
        this.dbConfig = dbConfig;
    }


}
