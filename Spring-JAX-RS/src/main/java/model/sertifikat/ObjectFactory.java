//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.01.12 at 07:36:17 PM CET 
//


package model.sertifikat;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the rs.ac.uns.ftn.vakcina.sertifikat package. 
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

    private final static QName _Test_QNAME = new QName("http://ftn.uns.ac.rs/vakcina/sertifikat", "test");
    private final static QName _LicniPodaci_QNAME = new QName("http://ftn.uns.ac.rs/vakcina/sertifikat", "licni_podaci");
    private final static QName _Vakcinacija_QNAME = new QName("http://ftn.uns.ac.rs/vakcina/sertifikat", "vakcinacija");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: rs.ac.uns.ftn.vakcina.sertifikat
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ZeleniSertifikat }
     * 
     */
    public ZeleniSertifikat createZeleniSertifikat() {
        return new ZeleniSertifikat();
    }

    /**
     * Create an instance of {@link TTest }
     * 
     */
    public TTest createTTest() {
        return new TTest();
    }

    /**
     * Create an instance of {@link TVakcinacija }
     * 
     */
    public TVakcinacija createTVakcinacija() {
        return new TVakcinacija();
    }

    /**
     * Create an instance of {@link TLicniPodaci }
     * 
     */
    public TLicniPodaci createTLicniPodaci() {
        return new TLicniPodaci();
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
     * Create an instance of {@link ZeleniSertifikat.DatumIzdavanja }
     * 
     */
    public ZeleniSertifikat.DatumIzdavanja createZeleniSertifikatDatumIzdavanja() {
        return new ZeleniSertifikat.DatumIzdavanja();
    }

    /**
     * Create an instance of {@link ZeleniSertifikat.IzdavacSertifikata }
     * 
     */
    public ZeleniSertifikat.IzdavacSertifikata createZeleniSertifikatIzdavacSertifikata() {
        return new ZeleniSertifikat.IzdavacSertifikata();
    }

    /**
     * Create an instance of {@link Vakcinacije }
     * 
     */
    public Vakcinacije createVakcinacije() {
        return new Vakcinacije();
    }

    /**
     * Create an instance of {@link TTest.Naziv }
     * 
     */
    public TTest.Naziv createTTestNaziv() {
        return new TTest.Naziv();
    }

    /**
     * Create an instance of {@link TVakcinacija.Proizvodjac }
     * 
     */
    public TVakcinacija.Proizvodjac createTVakcinacijaProizvodjac() {
        return new TVakcinacija.Proizvodjac();
    }

    /**
     * Create an instance of {@link TLicniPodaci.JMBG }
     * 
     */
    public TLicniPodaci.JMBG createTLicniPodaciJMBG() {
        return new TLicniPodaci.JMBG();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TTest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ftn.uns.ac.rs/vakcina/sertifikat", name = "test")
    public JAXBElement<TTest> createTest(TTest value) {
        return new JAXBElement<TTest>(_Test_QNAME, TTest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TLicniPodaci }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ftn.uns.ac.rs/vakcina/sertifikat", name = "licni_podaci")
    public JAXBElement<TLicniPodaci> createLicniPodaci(TLicniPodaci value) {
        return new JAXBElement<TLicniPodaci>(_LicniPodaci_QNAME, TLicniPodaci.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TVakcinacija }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ftn.uns.ac.rs/vakcina/sertifikat", name = "vakcinacija")
    public JAXBElement<TVakcinacija> createVakcinacija(TVakcinacija value) {
        return new JAXBElement<TVakcinacija>(_Vakcinacija_QNAME, TVakcinacija.class, null, value);
    }

}
