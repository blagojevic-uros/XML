package com.vacc.dao;

import com.vacc.config.DBConfig;
import com.vacc.config.DataConfig;
import lombok.Getter;
import org.springframework.stereotype.Component;
@Getter
@Component
public class PorudzbinaDAO extends  DataAccessLayer{
    private final String folderPath = "/db/porudzbina";
    private final DBConfig dbConfig;
    public PorudzbinaDAO(DBConfig dbConfig) {
        super(dbConfig);
        this.dbConfig = dbConfig;
    }
}
