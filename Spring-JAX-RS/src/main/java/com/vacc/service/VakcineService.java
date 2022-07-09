package com.vacc.service;

import com.vacc.dao.VakcineDAO;
import model.vakcine.Vakcina;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;

import javax.xml.bind.JAXBException;
import java.util.List;

@Service
public class VakcineService {


    private final VakcineDAO vakcineDAO;


    public VakcineService(VakcineDAO vakcineDAO) {
        this.vakcineDAO = vakcineDAO;
    }

    public List<Vakcina> getAll() throws XMLDBException, JAXBException {
        return vakcineDAO.getAllVakcineObject();
    }


}
