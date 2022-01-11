//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.01.04 at 09:58:14 PM CET 
//


package com.spring.rest.model.sertifikat;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sertifikat package. 
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

    private final static QName _Test_QNAME = new QName("http://www.ftn-vakcine.rs/sertifikat", "test");
    private final static QName _Vakcinacija_QNAME = new QName("http://www.ftn-vakcine.rs/sertifikat", "vakcinacija");
    private final static QName _LicniPodaci_QNAME = new QName("http://www.ftn-vakcine.rs/sertifikat", "licni_podaci");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sertifikat
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TLicniPodaci }
     * 
     */
    public TLicniPodaci createTLicniPodaci() {
        return new TLicniPodaci();
    }

    /**
     * Create an instance of {@link TVakcinacija }
     * 
     */
    public TVakcinacija createTVakcinacija() {
        return new TVakcinacija();
    }

    /**
     * Create an instance of {@link TTest }
     * 
     */
    public TTest createTTest() {
        return new TTest();
    }

    /**
     * Create an instance of {@link Testovi }
     * 
     */
    public Testovi createTestovi() {
        return new Testovi();
    }

    /**
     * Create an instance of {@link Prelezana }
     * 
     */
    public Prelezana createPrelezana() {
        return new Prelezana();
    }

    /**
     * Create an instance of {@link ZeleniSertifikat }
     * 
     */
    public ZeleniSertifikat createZeleniSertifikat() {
        return new ZeleniSertifikat();
    }

    /**
     * Create an instance of {@link Vakcinacije }
     * 
     */
    public Vakcinacije createVakcinacije() {
        return new Vakcinacije();
    }

    /**
     * Create an instance of {@link ImePrezime }
     * 
     */
    public ImePrezime createImePrezime() {
        return new ImePrezime();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TTest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn-vakcine.rs/sertifikat", name = "test")
    public JAXBElement<TTest> createTest(TTest value) {
        return new JAXBElement<TTest>(_Test_QNAME, TTest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TVakcinacija }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn-vakcine.rs/sertifikat", name = "vakcinacija")
    public JAXBElement<TVakcinacija> createVakcinacija(TVakcinacija value) {
        return new JAXBElement<TVakcinacija>(_Vakcinacija_QNAME, TVakcinacija.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TLicniPodaci }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn-vakcine.rs/sertifikat", name = "licni_podaci")
    public JAXBElement<TLicniPodaci> createLicniPodaci(TLicniPodaci value) {
        return new JAXBElement<TLicniPodaci>(_LicniPodaci_QNAME, TLicniPodaci.class, null, value);
    }

}