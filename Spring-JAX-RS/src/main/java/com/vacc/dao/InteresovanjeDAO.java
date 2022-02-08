package com.vacc.dao;

import com.vacc.config.DBConfig;
import model.interesovanje.Interesovanje;
import org.springframework.stereotype.Component;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;

import java.util.ArrayList;
import java.util.List;

@Component
public class InteresovanjeDAO extends  DataAccessLayer{

    private final String folderPath="/db/interesovanje";
    private final DBConfig dbConfig;
    public InteresovanjeDAO(DBConfig dbConfig) {
        super(dbConfig);
        this.dbConfig = dbConfig;
    }

    public List<String> getAll() throws XMLDBException {
        return this.getAllDocumentNames(folderPath);
    }

    public List<Interesovanje> getAll(String jmbg) throws XMLDBException {
        Collection col;
        String xPath = "//interesovanje/licni_podaci[JMBG ='" + jmbg + "']";
        List<Interesovanje> interesovanja = new ArrayList<>();
        try{
            col = DatabaseManager.getCollection(this.dbConfig.getUrl() + folderPath);
            XPathQueryService xpathService = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            xpathService.setProperty("indent", "yes");

            xpathService.setNamespace("", "http://ftn.uns.ac.rs/vakcina/interesovanje");

            interesovanja = this.xPathResult(xpathService.query(xPath),Interesovanje.class);
        }
        catch(XMLDBException xe){
            xe.printStackTrace();
        }
        return interesovanja;
    }
    public void getAllObject() throws XMLDBException {

    }

//    XPathQueryService xpathService = (XPathQueryService) col.getService("XPathQueryService", "1.0");
//            xpathService.setProperty("indent", "yes");
//
//            xpathService.setNamespace("", "http://ftn.uns.ac.rs/vakcina/interesovanje");
//
//    ResourceSet result = xpathService.query(xPath);

}
