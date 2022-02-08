package rdf;

import grddl.MetadataExtractor;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.xml.sax.SAXException;
import util.RDFAuthenticationUtilities;
import util.SparqlUtil;

import javax.xml.transform.TransformerException;
import java.io.IOException;

public class InteresovanjeRdf {


    private static final String SPARQL_NAMED_GRAPH_URI = "/example/sparql/metadata";
    private static RDFAuthenticationUtilities conn;
    public static void main(String[] args) throws Exception {

        run(conn.loadProperties(),
                "src/main/resources/podaci/xml/interesovanje.xml","src/main/resources/podaci/gen/interesovanje.rdf");
        run(RDFAuthenticationUtilities.loadProperties(),
                "src/main/resources/podaci/xml/saglasnost_za_imunizaciju.xml","src/main/resources/podaci/gen/saglasnost_za_imunizaciju.rdf");
        run(RDFAuthenticationUtilities.loadProperties(),
                "src/main/resources/podaci/xml/potvrda_o_vakcinisanju.xml","src/main/resources/podaci/gen/potvrda_o_vakcinisanju.rdf");
        run(RDFAuthenticationUtilities.loadProperties(),
                "src/main/resources/podaci/xml/zahtev_za_sertifikat.xml","src/main/resources/podaci/gen/zahtev_za_sertifikat.rdf");
        run(RDFAuthenticationUtilities.loadProperties(),
                "src/main/resources/podaci/xml/zeleni_sertifikat.xml","src/main/resources/podaci/gen/zeleni_sertifikat.rdf");
        run(RDFAuthenticationUtilities.loadProperties(),
                "src/main/resources/podaci/xml/izvestaj.xml","src/main/resources/podaci/gen/izvestaj.rdf");
        printAll(RDFAuthenticationUtilities.loadProperties());
    }

    public static void run(RDFAuthenticationUtilities.ConnectionProperties conn,String xmlFilePath,String rdfFilePath) throws IOException, SAXException, TransformerException {

        // Referencing XML file with RDF data in attributes
//        String xmlFilePath = "src/main/resources/podaci/xml/interesovanje.xml";
//
//        String rdfFilePath = "src/main/resources/podaci/gen/interesovanje.rdf";

        // Automatic extraction of RDF triples from XML file
        MetadataExtractor metadataExtractor = new MetadataExtractor(conn);
        System.out.println(conn);
        metadataExtractor.extractAndSave(xmlFilePath,rdfFilePath);
    }

    public static void printAll(RDFAuthenticationUtilities.ConnectionProperties conn){

        // Read the triples from the named graph
        System.out.println();
        System.out.println("[INFO] Retrieving triples from RDF store.");
        System.out.println("[INFO] Using \"" + SPARQL_NAMED_GRAPH_URI + "\" named graph.");

        System.out.println("[INFO] Selecting the triples from the named graph \"" + SPARQL_NAMED_GRAPH_URI + "\".");
        String sparqlQuery = SparqlUtil.selectData(conn.dataEndpoint + SPARQL_NAMED_GRAPH_URI, "?s ?p ?o");

        // Create a QueryExecution that will access a SPARQL service over HTTP
        QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint, sparqlQuery);


        // Query the collection, dump output response as XML
        ResultSet results = query.execSelect();

        ResultSetFormatter.out(System.out, results);

        query.close() ;

        System.out.println("[INFO] End.");
    }
}
