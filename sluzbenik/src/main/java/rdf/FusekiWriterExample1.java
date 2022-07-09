package rdf;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import util.RDFAuthenticationUtilities;
import util.RDFAuthenticationUtilities.ConnectionProperties;
import util.SparqlUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;



/**
 *
 * [PRIMER 1]
 *
 * Primer demonstrira rad sa Apache Jena programskim API-em za izvrsavanje CRUD
 * operacija nad semantickim grafovima skladistenim u Apache Jena Fuseki RDF storu.
 *
 * - Kreiranje RDF modela
 * - Učitavanje RDF/XML u model
 * - Kreiranje/brisanje imenovanog grafa
 * - Populisanje grafa tripletima iz RDF modela
 *
 */
public class FusekiWriterExample1 {

    private static final String PERSON_NAMED_GRAPH_URI = "/example/person/metadata";

    private static final String TEST_NAMED_GRAPH_URI = "/example/test/metadata";

    private static final String BOOKS_NAMED_GRAPH_URI = "/example/bookstore/metadata";

    public static void main(String[] args) throws Exception {
        run(RDFAuthenticationUtilities.loadProperties());
    }

    public static void run(ConnectionProperties conn) throws IOException {

        System.out.println("[INFO] Loading triples from an RDF/XML to a model...");

        // RDF triples which are to be loaded into the model
        String rdfFilePath = "src/main/resources/podaci/rdf/rdf/interesovanje-123.rdf";

        // Creates a default model
        Model model = ModelFactory.createDefaultModel();
        model.read(rdfFilePath);

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        model.write(out, SparqlUtil.NTRIPLES);

        System.out.println("[INFO] Rendering model as RDF/XML...");
        model.write(System.out, SparqlUtil.RDF_XML);

        // Delete all of the triples in all of the named graphs
        UpdateRequest request = UpdateFactory.create() ;
        request.add(SparqlUtil.dropAll());

        /*
         * Create UpdateProcessor, an instance of execution of an UpdateRequest.
         * UpdateProcessor sends update request to a remote SPARQL update service.
         */
        UpdateProcessor processor = UpdateExecutionFactory.createRemote(request, conn.updateEndpoint);
        processor.execute();

        // Creating the first named graph and updating it with RDF data
        System.out.println("[INFO] Writing the triples to a named graph \"" + PERSON_NAMED_GRAPH_URI + "\".");
        String sparqlUpdate = SparqlUtil.insertData(conn.dataEndpoint + PERSON_NAMED_GRAPH_URI, new String(out.toByteArray()));
        System.out.println(sparqlUpdate);

        // UpdateRequest represents a unit of execution
        UpdateRequest update = UpdateFactory.create(sparqlUpdate);

        processor = UpdateExecutionFactory.createRemote(update, conn.updateEndpoint);
        processor.execute();

        // Creating the second named graph and updating it with RDF data
        System.out.println("[INFO] Writing the triples to a named graph \"" + TEST_NAMED_GRAPH_URI + "\".");
        sparqlUpdate = SparqlUtil.insertData(conn.dataEndpoint + TEST_NAMED_GRAPH_URI, new String(out.toByteArray()));
        System.out.println(sparqlUpdate);

        update = UpdateFactory.create(sparqlUpdate);

        processor = UpdateExecutionFactory.createRemote(update, conn.updateEndpoint);
        processor.execute();

        // Creating the third named graph and updating it with RDF data
        System.out.println("[INFO] Writing the triples to a named graph \"" + BOOKS_NAMED_GRAPH_URI + "\".");
        sparqlUpdate = SparqlUtil.insertData(conn.dataEndpoint + BOOKS_NAMED_GRAPH_URI, new String(out.toByteArray()));
        System.out.println(sparqlUpdate);

        update = UpdateFactory.create(sparqlUpdate);

        processor = UpdateExecutionFactory.createRemote(update, conn.updateEndpoint);
        processor.execute();

        // Dropping the third graph...
        System.out.println("[INFO] Dropping the named graph \"" + BOOKS_NAMED_GRAPH_URI + "\"...");

//		UpdateRequest dropRequest = UpdateFactory.create() ;
//
//		sparqlUpdate = SparqlUtil.dropGraph(conn.dataEndpoint + BOOKS_NAMED_GRAPH_URI);
//		System.out.println(sparqlUpdate);
//
//	    dropRequest.add(sparqlUpdate);
//
//	    processor = UpdateExecutionFactory.createRemote(dropRequest, conn.updateEndpoint);
//	    processor.execute();

        System.out.println("[INFO] End.");
    }

}
