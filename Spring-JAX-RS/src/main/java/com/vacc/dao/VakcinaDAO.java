package com.vacc.dao;

import com.vacc.config.DBConfig;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class VakcinaDAO extends  DataAccessLayer{

    private final String folderPath="/db/vakcine";
    private final DBConfig dbConfig;
    public VakcinaDAO(DBConfig dbConfig) {
        super(dbConfig);
        this.dbConfig = dbConfig;
    }
}
