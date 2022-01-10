package grddl;


import org.xml.sax.SAXException;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

/**
 *
 * Primer demonstrira ekstrakciju RDFa metapodataka iz
 * XML dokumenta primenom GRDDL (Gleaning Resource Descriptions
 * from Dialects of Languages) transformacije.
 *
 */
public class MetadataExtractor {

    private TransformerFactory transformerFactory;

    private static final String XSLT_FILE = "data/xsl/grddl.xsl";

    public MetadataExtractor() throws SAXException, IOException {

        // Setup the XSLT transformer factory
        transformerFactory = new TransformerFactory() {
            @Override
            public Transformer newTransformer(Source source) throws TransformerConfigurationException {
                return null;
            }

            @Override
            public Transformer newTransformer() throws TransformerConfigurationException {
                return null;
            }

            @Override
            public Templates newTemplates(Source source) throws TransformerConfigurationException {
                return null;
            }

            @Override
            public Source getAssociatedStylesheet(Source source, String media, String title, String charset) throws TransformerConfigurationException {
                return null;
            }

            @Override
            public void setURIResolver(URIResolver resolver) {

            }

            @Override
            public URIResolver getURIResolver() {
                return null;
            }

            @Override
            public void setFeature(String name, boolean value) throws TransformerConfigurationException {

            }

            @Override
            public boolean getFeature(String name) {
                return false;
            }

            @Override
            public void setAttribute(String name, Object value) {

            }

            @Override
            public Object getAttribute(String name) {
                return null;
            }

            @Override
            public void setErrorListener(ErrorListener listener) {

            }

            @Override
            public ErrorListener getErrorListener() {
                return null;
            }
        };
    }

    /**
     * Generates RDF/XML based on RDFa metadata from an XML containing
     * input stream by applying GRDDL XSL transformation.
     *
     * @param in XML containing input stream
     * @param out RDF/XML output stream
     */
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


    public void test() throws Exception {

        System.out.println("[INFO] " + MetadataExtractor.class.getSimpleName());

        String filePath = "gen/grddl_metadata.rdf";

        InputStream in = new FileInputStream(new File("data/rdfa/contacts.xml"));

        OutputStream out = new FileOutputStream(filePath);

        extractMetadata(in, out);

        System.out.println("[INFO] File \"" + filePath + "\" generated successfully.");

        System.out.println("[INFO] End.");

    }

    public static void main(String[] args) throws Exception {
        new MetadataExtractor().test();
    }

}
