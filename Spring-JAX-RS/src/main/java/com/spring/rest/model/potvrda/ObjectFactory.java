//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.01.04 at 09:55:55 PM CET 
//


package com.spring.rest.model.potvrda;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the potvrda package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _InformacijeODozi_QNAME = new QName("http://www.ftn-vakcine.rs/potvrda", "informacije_o_dozi");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: potvrda
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PotvrdaOVakcinaciji }
     * 
     */
    public PotvrdaOVakcinaciji createPotvrdaOVakcinaciji() {
        return new PotvrdaOVakcinaciji();
    }

    /**
     * Create an instance of {@link LicniPodaci }
     * 
     */
    public LicniPodaci createLicniPodaci() {
        return new LicniPodaci();
    }

    /**
     * Create an instance of {@link InformacijeVakcinacija }
     * 
     */
    public InformacijeVakcinacija createInformacijeVakcinacija() {
        return new InformacijeVakcinacija();
    }

    /**
     * Create an instance of {@link TInfomacijeODozi }
     * 
     */
    public TInfomacijeODozi createTInfomacijeODozi() {
        return new TInfomacijeODozi();
    }

    /**
     * Create an instance of {@link ImePrezime }
     * 
     */
    public ImePrezime createImePrezime() {
        return new ImePrezime();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TInfomacijeODozi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn-vakcine.rs/potvrda", name = "informacije_o_dozi")
    public JAXBElement<TInfomacijeODozi> createInformacijeODozi(TInfomacijeODozi value) {
        return new JAXBElement<TInfomacijeODozi>(_InformacijeODozi_QNAME, TInfomacijeODozi.class, null, value);
    }

}
