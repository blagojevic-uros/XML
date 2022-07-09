package com.vacc.service;

import com.vacc.dao.PorudzbinaDAO;
import model.vakcine.Porudzbina;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;

import javax.xml.bind.JAXBException;
import java.util.List;

@Service
public class PorudzbinaService {
    private final PorudzbinaDAO porudzbinaDAO;

    public PorudzbinaService(PorudzbinaDAO porudzbinaDAO) {
        this.porudzbinaDAO = porudzbinaDAO;
    }

    public List<Porudzbina> getAll() throws JAXBException, XMLDBException {
        return porudzbinaDAO.getAllPorudzbinaObject();
    }
}
