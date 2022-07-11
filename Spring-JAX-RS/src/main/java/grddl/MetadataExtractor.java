package grddl;


//import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;

import com.vacc.config.RdfConfig;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.xml.sax.SAXException;
import util.RDFAuthenticationUtilities.ConnectionProperties;
import util.SparqlUtil;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.xalan.xsltc.trax.TransformerFactoryImpl;
/**
 *
 * Primer demonstrira ekstrakciju RDFa metapodataka iz
 * XML dokumenta primenom GRDDL (Gleaning Resource Descriptions
 * from Dialects of Languages) transformacije.
 *
 */
public class MetadataExtractor {

    private TransformerFactory transformerFactory;
    private static final String XSLT_FILE = "Spring-JAX-RS/src/main/resources/podaci/rdf/xsl/grddl.xsl";

    public MetadataExtractor() throws SAXException, IOException {

        // Setup the XSLT transformer factory
        this.transformerFactory = new TransformerFactoryImpl();
    }

//    public void extractAndSave(String xmlFilePath, String path) throws IOException, TransformerException {
//        extractMetadata(Files.newInputStream(Paths.get(xmlFilePath)), Files.newOutputStream(Paths.get(path)));
//        saveRdf(path);
//    }
    public void extractMetadata(InputStream in, OutputStream out) throws FileNotFoundException, TransformerException {

        // Create transformation source
        StreamSource transformSource = new StreamSource(new File(XSLT_FILE));

        // Initialize GRDDL transformer object
        Transformer grddlTransformer = transformerFactory.newTransformer(transformSource);

        // Set the indentation properties
        grddlTransformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
        grddlTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

        // Initialize transformation subject
        StreamSource source = new StreamSource(in);

        // Initialize result stream
        StreamResult result = new StreamResult(out);

        // Trigger the transformation
        grddlTransformer.transform(source, result);

    }
//    private void saveRdf(String path,String N){
//        Model model = ModelFactory.createDefaultModel();
//        model.read(path);
//
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        model.write(out, SparqlUtil.NTRIPLES);
//
//        String sparqlUpdate = SparqlUtil.insertData(rdfConfig.getEndpoint() + SPARQL_NAMED_GRAPH_URI, out.toString());
//        System.out.println(sparqlUpdate);
//        UpdateRequest update = UpdateFactory.create(sparqlUpdate);
//        System.out.println("[INFO] Selecting the triples from the named graph \"" + SPARQL_NAMED_GRAPH_URI + "\".");
//        UpdateProcessor processor = UpdateExecutionFactory.createRemote(update, conn.updateEndpoint);
//        processor.execute();
//
//    }


//    public static void main(String[] args) throws Exception {
//        new MetadataExtractor().test();
//    }

}
