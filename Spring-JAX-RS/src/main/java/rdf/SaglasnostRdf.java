package rdf;

<<<<<<< Updated upstream
import grddl.MetadataExtractor;
=======
import util.grddl.MetadataExtractor;
>>>>>>> Stashed changes
import org.xml.sax.SAXException;
import util.RDFAuthenticationUtilities;

import javax.xml.transform.TransformerException;
import java.io.IOException;

public class SaglasnostRdf {

    public static void main(String[] args) throws Exception {
        run(RDFAuthenticationUtilities.loadProperties());
    }

    public static void run(RDFAuthenticationUtilities.ConnectionProperties conn) throws IOException, SAXException, TransformerException {

        System.out.println("[INFO] " + InteresovanjeRdf.class.getSimpleName());

        // Referencing XML file with RDF data in attributes
        String xmlFilePath = "src/main/resources/podaci/xml/saglasnost_za_imunizaciju.xml";

        String rdfFilePath = "src/main/resources/podaci/gen/saglasnost_za_imunizaciju.rdf";

        // Automatic extraction of RDF triples from XML file
        MetadataExtractor metadataExtractor = new MetadataExtractor(conn);
        metadataExtractor.extractAndSave(xmlFilePath,rdfFilePath);
    }
}
