//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.02.07 at 03:15:04 PM CET 
//


package model.interesovanje;

import model.tipovi.ImePrezime;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the test package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: test
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Interesovanje }
     * 
     */
    public Interesovanje createInteresovanje() {
        return new Interesovanje();
    }

    /**
     * Create an instance of {@link Interesovanje.LicniPodaci }
     * 
     */
    public Interesovanje.LicniPodaci createInteresovanjeLicniPodaci() {
        return new Interesovanje.LicniPodaci();
    }

    /**
     * Create an instance of {@link Interesovanje.LokacijaVakcinisanja }
     * 
     */
    public Interesovanje.LokacijaVakcinisanja createInteresovanjeLokacijaVakcinisanja() {
        return new Interesovanje.LokacijaVakcinisanja();
    }

    /**
     * Create an instance of {@link Interesovanje.TipVakcine }
     * 
     */
    public Interesovanje.TipVakcine createInteresovanjeTipVakcine() {
        return new Interesovanje.TipVakcine();
    }

    /**
     * Create an instance of {@link Interesovanje.Datum }
     * 
     */
    public Interesovanje.Datum createInteresovanjeDatum() {
        return new Interesovanje.Datum();
    }

    /**
     * Create an instance of {@link ImePrezime }
     * 
     */
    public ImePrezime createImePrezime() {
        return new ImePrezime();
    }

    /**
     * Create an instance of {@link Interesovanje.LicniPodaci.Drzavljanstvo }
     * 
     */
    public Interesovanje.LicniPodaci.Drzavljanstvo createInteresovanjeLicniPodaciDrzavljanstvo() {
        return new Interesovanje.LicniPodaci.Drzavljanstvo();
    }

    /**
     * Create an instance of {@link Interesovanje.LicniPodaci.JMBG }
     * 
     */
    public Interesovanje.LicniPodaci.JMBG createInteresovanjeLicniPodaciJMBG() {
        return new Interesovanje.LicniPodaci.JMBG();
    }

}
