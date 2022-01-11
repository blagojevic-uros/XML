package com.spring.rest.parsing;

import com.spring.rest.model.interesovanje.Interesovanje;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import util.AuthenticationUtilities;
import util.AuthenticationUtilities.ConnectionProperties;
import util.ObjectParser;
import util.XmlDatabaseUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class InteresovanjeParser {

    private static ConnectionProperties conn;
    private static XmlDatabaseUtil xmlDatabaseUtil;
    private static ObjectParser objectParser;
    public static void main(String[] args) throws Exception {
        List<String> list = InteresovanjeParser.make(1234);
        InteresovanjeParser.save(conn = AuthenticationUtilities.loadProperties(), list.get(0), list.get(1), list.get(2));
    }

    public static ArrayList<String> make(int id) throws Exception {

        System.out.println("[INFO] Using defaults with ID.");
        String collectionId = null;
        String documentId = null;
        String filePath = null;

        collectionId = "/db/interesovanje"; // /db/interesovanje
        documentId = "interesovanje-" + id + ".xml"; // interesovanje-{id}
        filePath = "podaci/xml/interesovanje.xml";

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
        Interesovanje interesovanje = unmarshall_2(context);
        marshall(res, context, interesovanje, os, col);
    }

    public static JAXBContext unmarshall_1() throws Exception{

        System.out.println("[INFO] Unmarshalling XML document to an JAXB instance: ");
        JAXBContext context = JAXBContext.newInstance("com.spring.rest.model.interesovanje");

        Unmarshaller unmarshaller = context.createUnmarshaller();

        return context;
    }

    public static Interesovanje unmarshall_2(JAXBContext context) throws Exception{

        Unmarshaller unmarshaller = context.createUnmarshaller();

        Interesovanje interesovanje = (Interesovanje) unmarshaller.unmarshal(new File("src/main/resources/podaci/xml/interesovanje.xml"));
        interesovanje.getLicniPodaci().setIme("Mare"); // Random name update for test
        System.out.println(interesovanje);

        return interesovanje;
    }

    public static void marshall(XMLResource res, JAXBContext context, Interesovanje interesovanje, OutputStream os, Collection col) throws Exception{

//        objectParser.parseToXml(interesovanje);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // marshal the contents to an output stream
        marshaller.marshal(interesovanje, os);

        // link the stream to the XML resource
        res.setContent(os);
        System.out.println("[INFO] Storing the document: " + res.getId());

        col.storeResource(res);
        System.out.println("[INFO] Done.");
    }


    private static Collection getOrCreateCollection(String collectionUri) throws XMLDBException {
        return XmlDatabaseUtil.getOrCreateCollection(conn, collectionUri, 0);
    }

}
