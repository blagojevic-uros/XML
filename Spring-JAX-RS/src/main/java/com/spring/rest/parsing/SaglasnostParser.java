package com.spring.rest.parsing;

import model.saglasnost.SaglasnostZaImunizaciju;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.CollectionManagementService;
import org.xmldb.api.modules.XMLResource;
import util.AuthenticationUtilities;
import util.AuthenticationUtilities.ConnectionProperties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class SaglasnostParser {

    private static ConnectionProperties conn;

    public static void main(String[] args) throws Exception {
        int id = 12345;
        List<String> list = SaglasnostParser.make(id);
        SaglasnostParser.save(conn = AuthenticationUtilities.loadProperties(), list.get(0), list.get(1), list.get(2));
    }

    public static ArrayList<String> make(int id) throws Exception {

        System.out.println("[INFO] Using defaults with ID.");
        String collectionId = null;
        String documentId = null;
        String filePath = null;

        collectionId = "/db/saglasnost";
        documentId = "saglasnost_za_imunizaciju-" + id + ".xml";
        filePath = "podaci/xml/saglasnost_za_imunizaciju.xml";

        System.out.println("\t- collection ID: " + collectionId);
        System.out.println("\t- document ID: " + documentId);
        System.out.println("\t- file path: " + filePath + "\n");

        ArrayList<String> ret = new ArrayList<String>();
        ret.add(collectionId);
        ret.add(documentId);
        ret.add(filePath);
        return ret;
    }

    public static void save(ConnectionProperties conn, String collectionId, String documentId, String filepath) throws Exception{
        System.out.println("[INFO] Loading driver class: " + conn.driver);
        Class<?> cl = Class.forName(conn.driver);

        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");

        DatabaseManager.registerDatabase(database);

        Collection col = null;
        XMLResource res = null;
        OutputStream os = new ByteArrayOutputStream();

        System.out.println("[INFO] Retrieving the collection: " + collectionId);
        col = getOrCreateCollection(collectionId);

        System.out.println("[INFO] Inserting the document: " + documentId);
        res = (XMLResource) col.createResource(documentId, XMLResource.RESOURCE_TYPE);

        JAXBContext context = unmarshall_1();
        SaglasnostZaImunizaciju saglasnostZaImunizaciju = unmarshall_2(context);
        marshall(res, context, saglasnostZaImunizaciju, os, col);
    }

    public static JAXBContext unmarshall_1() throws Exception{

        System.out.println("[INFO] Unmarshalling XML document to an JAXB instance: ");
        JAXBContext context = JAXBContext.newInstance("com.spring.rest.model.saglasnost");

        Unmarshaller unmarshaller = context.createUnmarshaller();

        return context;
    }

    public static SaglasnostZaImunizaciju unmarshall_2(JAXBContext context) throws Exception{

        Unmarshaller unmarshaller = context.createUnmarshaller();

        SaglasnostZaImunizaciju saglasnostZaImunizaciju = (SaglasnostZaImunizaciju) unmarshaller.unmarshal(new File("src/main/resources/podaci/xml/saglasnost_za_imunizaciju.xml"));
        saglasnostZaImunizaciju.setInteresovanje("Random"); // Random name update for test
        System.out.println(saglasnostZaImunizaciju);

        return saglasnostZaImunizaciju;
    }

    public static void marshall(XMLResource res, JAXBContext context, SaglasnostZaImunizaciju saglasnostZaImunizaciju, OutputStream os, Collection col) throws Exception{
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // marshal the contents to an output stream
        marshaller.marshal(saglasnostZaImunizaciju, os);

        // link the stream to the XML resource
        res.setContent(os);
        System.out.println("[INFO] Storing the document: " + res.getId());

        col.storeResource(res);
        System.out.println("[INFO] Done.");
    }


    private static Collection getOrCreateCollection(String collectionUri) throws XMLDBException {
        return getOrCreateCollection(collectionUri, 0);
    }

    private static Collection getOrCreateCollection(String collectionUri, int pathSegmentOffset) throws XMLDBException {

        Collection col = DatabaseManager.getCollection(conn.uri + collectionUri, conn.user, conn.password);

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

                Collection startCol = DatabaseManager.getCollection(conn.uri + path, conn.user, conn.password);

                if (startCol == null) {

                    // child collection does not exist

                    String parentPath = path.substring(0, path.lastIndexOf("/"));
                    Collection parentCol = DatabaseManager.getCollection(conn.uri + parentPath, conn.user, conn.password);

                    CollectionManagementService mgt = (CollectionManagementService) parentCol.getService("CollectionManagementService", "1.0");

                    System.out.println("[INFO] Creating the collection: " + pathSegments[pathSegmentOffset]);
                    col = mgt.createCollection(pathSegments[pathSegmentOffset]);

                    col.close();
                    parentCol.close();

                } else {
                    startCol.close();
                }
            }
            return getOrCreateCollection(collectionUri, ++pathSegmentOffset);
        } else {
            return col;
        }
    }
}