package rdf;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.RDFNode;
import util.RDFAuthenticationUtilities;
import util.RDFAuthenticationUtilities.ConnectionProperties;
import util.SparqlUtil;

import java.io.IOException;
import java.util.Iterator;


/**
 *
 * [PRIMER 2]
 *
 * Primer demonstrira rad sa Apache Jena programskim API-em za izvrsavanje CRUD
 * operacija nad semantickim grafovima skladistenim u Apache Jena Fuseki RDF storu.
 *
 * - Preuzimanje tripleta iz imenovanog grafa
 * - Hendlanje rezultata kao SPARQL response XML
 * - Iteriranje po result setu
 *
 */
public class FusekiReaderExample2 {

    private static final String PERSON_NAMED_GRAPH_URI = "/example/person/metadata";

    private static final String TEST_NAMED_GRAPH_URI = "/example/test/metadata";

    public static void main(String[] args) throws Exception {
        run(RDFAuthenticationUtilities.loadProperties());
    }

    public static void run(ConnectionProperties conn) throws IOException {

        // Querying the first named graph with a simple SPARQL query
        System.out.println("[INFO] Selecting the triples from the named graph \"" + TEST_NAMED_GRAPH_URI + "\".");
        String sparqlQuery = SparqlUtil.selectData(conn.dataEndpoint + TEST_NAMED_GRAPH_URI, "?s ?p ?o");

        // Create a QueryExecution that will access a SPARQL service over HTTP
        QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint, sparqlQuery);

        // Query the SPARQL endpoint, iterate over the result set...
        ResultSet results = query.execSelect();

        String varName;
        RDFNode varValue;

        while(results.hasNext()) {

            // A single answer from a SELECT query
            QuerySolution querySolution = results.next() ;
            Iterator<String> variableBindings = querySolution.varNames();

            // Retrieve variable bindings
            while (variableBindings.hasNext()) {

                varName = variableBindings.next();
                varValue = querySolution.get(varName);

                System.out.println(varName + ": " + varValue);
            }
            System.out.println();
        }

        // Querying the other named graph
        System.out.println("[INFO] Selecting the triples from the named graph \"" + PERSON_NAMED_GRAPH_URI + "\".");
        sparqlQuery = SparqlUtil.selectData(conn.dataEndpoint + PERSON_NAMED_GRAPH_URI, "?s ?p ?o");

        // Create a QueryExecution that will access a SPARQL service over HTTP
        query = QueryExecutionFactory.sparqlService(conn.queryEndpoint, sparqlQuery);


        // Query the collection, dump output response as XML
        results = query.execSelect();

        ResultSetFormatter.outputAsXML(System.out, results);

        query.close() ;

        System.out.println("[INFO] End.");
    }

}
