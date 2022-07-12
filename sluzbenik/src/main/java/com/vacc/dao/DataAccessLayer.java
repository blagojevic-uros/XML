package com.vacc.dao;

import com.vacc.config.DBConfig;
import org.springframework.stereotype.Component;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.CollectionManagementService;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XPathQueryService;
import org.xmldb.api.modules.XQueryService;
import util.ObjectParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.OutputKeys;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
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
    public void saveList(String folderId,List<String> documentIds,List<?> objects,Class<?> classOfObject){
        for (int i = 0; i < documentIds.size(); i++) {
            save(folderId,documentIds.get(i),objects.get(i),classOfObject);
        }
    }

    public void save(String folderId, String documentId, Object object, Class<?> classOfObject){
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

            String[] pathSegments = collectionUri.split("/");

            if(pathSegments.length > 0) {
                StringBuilder path = new StringBuilder();

                for(int i = 0; i <= pathSegmentOffset; i++) {
                    path.append("/").append(pathSegments[i]);
                }

                Collection startCol = DatabaseManager.getCollection(this.dbConfig.getUrl() + collectionUri, this.dbConfig.getUsername(), this.dbConfig.getPassword());

                if (startCol == null) {

                    // child collection does not exist

                    String parentPath = path.substring(0, path.lastIndexOf("/"));
                    System.out.println(parentPath);
                    Collection parentCol = DatabaseManager.getCollection(this.dbConfig.getUrl() + parentPath, this.dbConfig.getUsername(), this.dbConfig.getPassword());
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

    public List<String> getAllDocumentNames(String collectionId){
        Collection col;
        List<String> values = new ArrayList<>();
        try {
            System.out.println("[INFO] Retrieving the collection: " + this.dbConfig.getUrl() + collectionId);
            col = DatabaseManager.getCollection(this.dbConfig.getUrl() + collectionId);

            values = Arrays.asList(col.listResources());
        }
        catch(XMLDBException xe){
            xe.printStackTrace();
        }
        return values;
    }
    @SuppressWarnings("unchecked")
    public <T> List<T> xPathResult(String collectionPath, String xPath, String namespace, Class<T> clazz) throws XMLDBException {
        Collection col;
        col = DatabaseManager.getCollection(collectionPath);
        XPathQueryService xpathService = (XPathQueryService) col.getService("XPathQueryService", "1.0");
        xpathService.setProperty("indent", "yes");
        xpathService.setNamespace("", namespace);
        ResourceSet result =  xpathService.query(xPath);
        ResourceIterator i = result.getIterator();

        List<T> results = new ArrayList<>();
        Resource res;
        while(i.hasMoreResources()) {
            try {
                res = i.nextResource();
                results.add((T) ObjectParser.parseToObject((XMLResource) res,clazz));
//                results.add((T) res.getContent());

            } catch(XMLDBException xe) {
                xe.printStackTrace();
            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }

        }


        return results;
    }
//    @SuppressWarnings("unchecked")
//    public <T> List<T> xQueryResult(String collectionPath, String xQuery, String namespace, Class<T> clazz) throws XMLDBException {
//        Collection col;
//        col = DatabaseManager.getCollection(collectionPath);
//        XQueryService xqueryService = (XQueryService) col.getService("XQueryService", "1.0");
//        xqueryService.setProperty("indent", "yes");
//        xqueryService.setNamespace("", namespace);
//        CompiledExpression compiledXquery = xqueryService.compile(xQuery);
//        ResourceSet result = xqueryService.execute(compiledXquery);
//        ResourceIterator i = result.getIterator();
//
//        List<T> results = new ArrayList<>();
//        Resource res;
//        while(i.hasMoreResources()) {
//            try {
//                res = i.nextResource();
//                results.add((T) res.getContent());
//
//            } catch(XMLDBException xe) {
//                xe.printStackTrace();
//            }
//
//        }
//
//
//        return results;
//    }

}
