package com.vacc.service;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.transform.TransformerFactory;
@Service
public class XHTMLTransformerService {
    private static TransformerFactory transformerFactory;

    private static DocumentBuilderFactory documentFactory;

    public static final String HTML_FILE = "Spring-JAX-RS/data/temp/temp.html";

    static {
        /* Inicijalizacija DOM fabrike */
        documentFactory = DocumentBuilderFactory.newInstance();
        documentFactory.setNamespaceAware(true);
        documentFactory.setIgnoringComments(true);
        documentFactory.setIgnoringElementContentWhitespace(true);

        /* Inicijalizacija Transformer fabrike */
        transformerFactory = TransformerFactory.newInstance();

    }

    public ByteArrayInputStream generateHTML(String xmlFile, String xslPath) throws IOException {

        try {

            // Initialize Transformer instance
            StreamSource transformSource = new StreamSource(xslPath);
            Transformer transformer = transformerFactory.newTransformer(transformSource);
            transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            // Generate XHTML
            transformer.setOutputProperty(OutputKeys.METHOD, "xhtml");

            // Transform DOM to HTML
            DOMSource source = new DOMSource(buildDocument(xmlFile));
            File file = new File(HTML_FILE);
            StreamResult result = new StreamResult(new FileOutputStream(file));
            transformer.transform(source, result);
            return new ByteArrayInputStream(FileUtils.readFileToByteArray(file));

        } catch (TransformerFactoryConfigurationError | TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Document buildDocument(String xmlFile) {

        Document document = null;
        try {

            DocumentBuilder builder = documentFactory.newDocumentBuilder();
            document = builder.parse(new ByteArrayInputStream(xmlFile.getBytes()));

            if (document != null)
                System.out.println("[INFO] File parsed with no errors.");
            else
                System.out.println("[WARN] Document is null.");

        } catch (Exception e) {
            return null;

        }

        return document;
    }
}
