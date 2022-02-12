package com.vacc.dao;

import com.vacc.config.DBConfig;

public class KorisnikDAO extends DataAccessLayer{
    private final DBConfig dbConfig;
    public KorisnikDAO(DBConfig dbConfig) {
        super(dbConfig);
        this.dbConfig = dbConfig;
    }

}
