package com.spring.rest.parsing;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

<<<<<<< Updated upstream
import com.spring.rest.model.izvestaj.IzvestajOImunizaciji;
=======
import model.izvestaj.IzvestajOImunizaciji;
>>>>>>> Stashed changes
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
<<<<<<< Updated upstream
import org.xmldb.api.modules.CollectionManagementService;
=======
>>>>>>> Stashed changes
import org.xmldb.api.modules.XMLResource;
import util.AuthenticationUtilities;
import util.AuthenticationUtilities.ConnectionProperties;
import util.XmlDatabaseUtil;

public class IzvestajParser {

    private static ConnectionProperties conn;

    public static void main(String[] args) throws Exception {
        String d1, d2;
        d1 = "2021-08-01";
        d2 = "2021-09-01";
        List<String> list = IzvestajParser.make(d1, d2);
        IzvestajParser.save(conn = AuthenticationUtilities.loadProperties(), list.get(0), list.get(1), list.get(2));
    }

    public static ArrayList<String> make(String date1, String date2) throws Exception {

        System.out.println("[INFO] Using defaults with Date.");
        String collectionId = null;
        String documentId = null;
        String filePath = null;

        collectionId = "/db/izvestaj";
        documentId = "izvestaj-" + date1 + "-" + date2 + ".xml";
        filePath = "podaci/xml/izvestaj.xml";

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
        IzvestajOImunizaciji izvestaj = unmarshall_2(context);
        marshall(res, context, izvestaj, os, col);
    }

    public static JAXBContext unmarshall_1() throws Exception{

        System.out.println("[INFO] Unmarshalling XML document to an JAXB instance: ");
        JAXBContext context = JAXBContext.newInstance("com.spring.rest.model.izvestaj");

        Unmarshaller unmarshaller = context.createUnmarshaller();

        return context;
    }

    public static IzvestajOImunizaciji unmarshall_2(JAXBContext context) throws Exception{

        Unmarshaller unmarshaller = context.createUnmarshaller();

        IzvestajOImunizaciji izvestaj = (IzvestajOImunizaciji) unmarshaller.unmarshal(new File("src/main/resources/podaci/xml/izvestaj.xml"));
        izvestaj.setPotpis("PemeX"); // Random name update for test
        System.out.println(izvestaj);

        return izvestaj;
    }

    public static void marshall(XMLResource res, JAXBContext context, IzvestajOImunizaciji izvestaj, OutputStream os, Collection col) throws Exception{
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // marshal the contents to an output stream
        marshaller.marshal(izvestaj, os);

        // link the stream to the XML resource
        res.setContent(os);
        System.out.println("[INFO] Storing the document: " + res.getId());

        col.storeResource(res);
        System.out.println("[INFO] Done.");
    }


//    private static Collection getOrCreateCollection(String collectionUri) throws XMLDBException {
//        return getOrCreateCollection(collectionUri, 0);
//    }

    private static Collection getOrCreateCollection(String collectionUri) throws XMLDBException {
        return XmlDatabaseUtil.getOrCreateCollection(conn, collectionUri, 0);
    }

}
