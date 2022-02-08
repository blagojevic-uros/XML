package com.vacc.dao;

import com.vacc.config.DBConfig;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.CollectionManagementService;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.OutputKeys;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DataAccessLayer {


    private final DBConfig dbConfig;


    public DataAccessLayer(DBConfig dbConfig) {
        this.dbConfig = dbConfig;
        try {
            Class<?> cl = Class.forName(dbConfig.getDriver());
            Database database = (Database) cl.newInstance();
            database.setProperty("create-database", "true");
            DatabaseManager.registerDatabase(database);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void save(String folderId, String documentId, model.interesovanje.Interesovanje object, Class<?> classOfObject){
        try {
            Class<?> cl = Class.forName(this.dbConfig.getDriver());
            Database database = (Database) cl.newInstance();
            database.setProperty("create-database", "true");
            DatabaseManager.registerDatabase(database);
            Collection col = getCollection(folderId, 0);
            col.setProperty(OutputKeys.INDENT, "yes");
            XMLResource res = (XMLResource) col.createResource(documentId, XMLResource.RESOURCE_TYPE);
            OutputStream os = new ByteArrayOutputStream();
            JAXBContext context = JAXBContext.newInstance(classOfObject);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(object, os);
            res.setContent(os);
            col.storeResource(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Collection getCollection(String collectionUri, int pathSegmentOffset) throws XMLDBException {
        Collection col = DatabaseManager.getCollection(this.dbConfig.getUrl() + collectionUri, this.dbConfig.getUsername(), this.dbConfig.getPassword());

        // create the collection if it does not exist
        if(col == null) {

            if(collectionUri.startsWith("/")) {
                collectionUri = collectionUri.substring(1);
            }

            String pathSegments[] = collectionUri.split("/");

            if(pathSegments.length > 0) {
                StringBuilder path = new StringBuilder();

                for(int i = 0; i <= pathSegmentOffset; i++) {
                    path.append("/" + pathSegments[i]);
                }

                Collection startCol = DatabaseManager.getCollection(this.dbConfig.getUrl() + collectionUri, this.dbConfig.getUsername(), this.dbConfig.getPassword());

                if (startCol == null) {

                    // child collection does not exist

                    String parentPath = path.substring(0, path.lastIndexOf("/"));
                    Collection parentCol = DatabaseManager.getCollection(this.dbConfig.getUrl() + collectionUri, this.dbConfig.getUsername(), this.dbConfig.getPassword());

                    CollectionManagementService mgt = (CollectionManagementService) parentCol.getService("CollectionManagementService", "1.0");

                    System.out.println("[INFO] Creating the collection: " + pathSegments[pathSegmentOffset]);
                    col = mgt.createCollection(pathSegments[pathSegmentOffset]);

                    col.close();
                    parentCol.close();

                } else {
                    startCol.close();
                }
            }
            return getCollection(collectionUri, ++pathSegmentOffset);
        } else {
            return col;
        }
    }

    public XMLResource getById(String documentId, String collectionId) throws XMLDBException {
        Collection col = null;
        XMLResource res;
        try {
            // get the collection
            System.out.println("[INFO] Retrieving the collection: " + this.dbConfig.getUrl() + collectionId);
            col = DatabaseManager.getCollection(this.dbConfig.getUrl() + collectionId);
            col.setProperty(OutputKeys.INDENT, "yes");
            System.out.println(col.getResourceCount());
            System.out.println("[INFO] Retrieving the document: " + documentId);
            res = (XMLResource)col.getResource(documentId);
            System.out.println("RES" + res.getContent());

        } finally {
            if (col != null) {
                try {
                    col.close();
                } catch (XMLDBException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return res;
    }

    public List<String> getAllDocumentNames(String collectionId) throws XMLDBException {
        Collection col = null;
        List<String> values = new ArrayList<>();
//        String xPath = "//interesovanje/licni_podaci[JMBG ='1231231231123']";
        try {
            System.out.println("[INFO] Retrieving the collection: " + this.dbConfig.getUrl() + collectionId);
            col = DatabaseManager.getCollection(this.dbConfig.getUrl() + collectionId);

            values = Arrays.asList(col.listResources());
//            Resource res = null;
//            while(i.hasMoreResources()) {
//                res = i.nextResource();
//                System.out.println(res.getContent());
//            }
        }
        catch(XMLDBException xe){
            xe.printStackTrace();
        }
        return values;
    }

    public <T> List<T> xPathResult(ResourceSet result,Class<T> clazz) throws XMLDBException {
        ResourceIterator i = result.getIterator();
        List<T> results = new ArrayList<>();
        Resource res = null;
        while(i.hasMoreResources()) {
            try {
                res = i.nextResource();
                System.out.println(res.getContent());
                results.add((T) res.getContent());

            } catch(XMLDBException xe) {
                xe.printStackTrace();
            }

        }


        return results;
    }

}
