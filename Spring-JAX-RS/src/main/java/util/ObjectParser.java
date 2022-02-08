package util;

import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
<<<<<<< Updated upstream

public class ObjectParser {


    public static Object parseToObject(XMLResource resource, String pathToClass) throws JAXBException, XMLDBException {

        JAXBContext context = JAXBContext.newInstance(pathToClass);
=======
public class ObjectParser {

    public static Object parseToObject(XMLResource resource, Class<?> classOfObject) throws JAXBException, XMLDBException {

        JAXBContext context = JAXBContext.newInstance(classOfObject);
>>>>>>> Stashed changes

        Unmarshaller unmarshaller = context.createUnmarshaller();

        return unmarshaller.unmarshal(resource.getContentAsDOM());
    }
<<<<<<< Updated upstream

    public static OutputStream parseToXml(Object object, String pathToClass) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(pathToClass);
=======
    public static OutputStream parseToXml(Object object, Class<?> classOfObject) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(classOfObject);

>>>>>>> Stashed changes
        OutputStream os = new ByteArrayOutputStream();

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // marshal the contents to an output stream
        marshaller.marshal(object, os);

        return os;
    }
}
