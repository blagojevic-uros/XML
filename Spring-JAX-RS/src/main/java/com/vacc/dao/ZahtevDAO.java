package com.vacc.dao;

import com.vacc.config.DBConfig;
import org.springframework.stereotype.Component;

@Component
public class ZahtevDAO extends DataAccessLayer{

    private final String folderPath="/db/zahtev";
    private final DBConfig dbConfig;
    public ZahtevDAO(DBConfig dbConfig) {
        super(dbConfig);
        this.dbConfig = dbConfig;
    }

}
