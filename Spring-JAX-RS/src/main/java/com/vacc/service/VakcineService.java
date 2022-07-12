package com.vacc.service;

import com.vacc.dao.VakcineDAO;
import model.vakcine.Vakcina;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;
import util.ObjectParser;

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

    public Vakcina getByName(String name) throws XMLDBException, JAXBException {
        return (Vakcina) ObjectParser.parseToObject(vakcineDAO.getById(name + ".xml",vakcineDAO.getFolderPath()),Vakcina.class);
    }

    public void subtractVakcina(String name,Integer amount) throws Exception {
        Vakcina v = getByName(name);
        if(v.getKolicina() == 0){
            throw new Exception();
        }
        v.setKolicina(v.getKolicina() - amount);
        vakcineDAO.save(vakcineDAO.getFolderPath(),name + ".xml",v,Vakcina.class);
    }

    public void setKolicina(String name,Integer amount) throws XMLDBException, JAXBException {
        Vakcina v = getByName(name);
        v.setKolicina(amount);
        vakcineDAO.save(vakcineDAO.getFolderPath(),name + ".xml",v,Vakcina.class);
    }


}
