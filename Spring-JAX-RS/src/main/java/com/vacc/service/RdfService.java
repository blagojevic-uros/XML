package com.vacc.service;

import com.vacc.config.RdfConfig;
import grddl.MetadataExtractor;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import util.SparqlUtil;

import javax.xml.transform.TransformerException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class RdfService {

    private final RdfConfig rdfConfig;

    public RdfService(RdfConfig rdfConfig) {
        this.rdfConfig = rdfConfig;
    }

    public void save(String xml, String fileName, String namedGraphUri) throws IOException, TransformerException, SAXException {
        File directory = new File("data/rdf");
        if (!directory.exists()){
            directory.mkdir();
        }
        String rdfPath = "data/rdf/" + fileName + ".rdf";

        PrintWriter printWritter = new PrintWriter(Files.newOutputStream(Paths.get(rdfPath)));
        printWritter.println(xml);
        printWritter.close();

        MetadataExtractor metadataExtractor = new MetadataExtractor();
        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();

        System.out.println("[INFO] Extracting metadata from RDFa attributes...");
        metadataExtractor.extractMetadata(
                Files.newInputStream(new File(rdfPath).toPath()),
                byteArrayOut);
        FileOutputStream outputStream = new FileOutputStream(new File(rdfPath));
        outputStream.write(byteArrayOut.toByteArray());

        Model model = ModelFactory.createDefaultModel();
        FileInputStream inputStream = new FileInputStream(new File(rdfPath));
        model.read(inputStream, "");

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        model.write(out, SparqlUtil.NTRIPLES);

        System.out.println("[INFO] Extracted metadata as RDF/XML...");
        model.write(System.out, SparqlUtil.RDF_XML);

        // Writing the named graph
        System.out.println("[INFO] Populating named graph \"" + namedGraphUri + "\" with extracted metadata.");
        String sparqlUpdate = SparqlUtil.insertData(rdfConfig.getData() + namedGraphUri, out.toString());
        System.out.println(sparqlUpdate);

        // UpdateRequest represents a unit of execution
        UpdateRequest update = UpdateFactory.create(sparqlUpdate);

        UpdateProcessor processor = UpdateExecutionFactory.createRemote(update, rdfConfig.getUpdate());
        processor.execute();
    }
//
//    public ByteArrayInputStream getMetadataJSON(String sparkql, String fileName, String namedGraphUri) throws IOException {
//        RDFDBAuthenticationUtilities.ConnectionProperties conn = RDFDBAuthenticationUtilities.loadProperties();
//        // Querying the first named graph with a simple SPARQL query
//        System.out.println("[INFO] Selecting the triples from the named graph \"" + namedGraphUri + "\".");
//        String sparqlQuery = SparqlUtil.selectData(conn.dataEndpoint + namedGraphUri, sparkql);
//
//        // Create a QueryExecution that will access a SPARQL service over HTTP
//        QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint, sparqlQuery);
//
//        // Query the SPARQL endpoint, iterate over the result set...
//        ResultSet results = query.execSelect();
//
//        String varName;
//        RDFNode varValue;
//
//        while(results.hasNext()) {
//
//            // A single answer from a SELECT query
//            QuerySolution querySolution = results.next() ;
//            Iterator<String> variableBindings = querySolution.varNames();
//
//            // Retrieve variable bindings
//            while (variableBindings.hasNext()) {
//
//                varName = variableBindings.next();
//                varValue = querySolution.get(varName);
//
//                System.out.println(varName + ": " + varValue);
//            }
//            System.out.println();
//        }
//
//        // Querying the other named graph
//        System.out.println("[INFO] Selecting the triples from the named graph \"" + namedGraphUri + "\".");
//        sparqlQuery = SparqlUtil.selectData(conn.dataEndpoint + namedGraphUri, sparkql);
//
//        // Create a QueryExecution that will access a SPARQL service over HTTP
//        query = QueryExecutionFactory.sparqlService(conn.queryEndpoint, sparqlQuery);
//
//
//        // Query the collection, dump output response as XML
//        results = query.execSelect();
//
//        File directory = new File("output_metadata_json");
//        if (!directory.exists()){
//            directory.mkdir();
//        }
//        String xmlFile = "output_metadata_json/" + fileName + ".json";
//
//        ResultSetFormatter.outputAsJSON(Files.newOutputStream(Paths.get(xmlFile)), results);
//
//        System.out.println("[INFO] End.");
//
//        query.close();
//
//        File readJsonFile = new File(xmlFile);
//        byte[] bytes = FileUtils.readFileToByteArray(readJsonFile);
//        return new ByteArrayInputStream(bytes);
//    }
}
