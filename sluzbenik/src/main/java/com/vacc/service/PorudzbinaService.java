package com.vacc.service;

import com.vacc.dao.PorudzbinaDAO;
import model.vakcine.PORUDZBINA_STATUS;
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

    public List<Porudzbina> getAllPending() throws JAXBException, XMLDBException {
        return porudzbinaDAO.getAllPendingPorudzbine();
    }

    public void finishPorudzbina(String id) throws JAXBException, XMLDBException {
        Porudzbina porudzbina = porudzbinaDAO.getById(id);
        porudzbina.setStatus(PORUDZBINA_STATUS.FINISHED);
        porudzbinaDAO.save(porudzbinaDAO.getFolderPath(),"porudzbina-"+ id+ ".xml",porudzbina,Porudzbina.class);

    }
}
