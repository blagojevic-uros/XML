package com.vacc.dao;

import com.vacc.config.DBConfig;
import org.springframework.stereotype.Component;

@Component
public class RoleDAO extends DataAccessLayer{
    public RoleDAO(DBConfig dbConfig) {
        super(dbConfig);
    }
}
