package com.vacc.service;

import com.vacc.dao.VakcineDAO;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;

import java.util.List;

@Service
public class VakcineService {


    private final VakcineDAO vakcineDAO;


    public VakcineService(VakcineDAO vakcineDAO) {
        this.vakcineDAO = vakcineDAO;
    }

    public List<String> getAll() throws XMLDBException {
        return vakcineDAO.getAllVakcine();
    }
}
