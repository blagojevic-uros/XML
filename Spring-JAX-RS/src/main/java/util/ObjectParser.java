package util;

import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;


public class ObjectParser {

    public static Object parseToObject(XMLResource resource, Class<?> classOfObject) throws JAXBException, XMLDBException {

        JAXBContext context = JAXBContext.newInstance(classOfObject);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        return unmarshaller.unmarshal(resource.getContentAsDOM());
    }
    public static OutputStream parseToXml(Object object, Class<?> classOfObject) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(classOfObject);

        OutputStream os = new ByteArrayOutputStream();

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // marshal the contents to an output stream
        marshaller.marshal(object, os);

        return os;
    }
    public static Object parseFromString(String xml, Class<?> classOfObject) throws SAXException {
        try {
            JAXBContext context = JAXBContext.newInstance(classOfObject);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return unmarshaller.unmarshal(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
