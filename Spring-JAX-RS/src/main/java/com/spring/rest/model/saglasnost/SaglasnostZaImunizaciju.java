//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.01.12 at 07:41:55 PM CET 
//


package com.spring.rest.model.saglasnost;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://ftn.uns.ac.rs/vakcina/saglasnost}licni_podaci"/>
 *         &lt;element name="saglanost">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="saglasan_sam" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *                   &lt;element name="naziv_leka" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="potpis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="datum">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>date">
 *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                 &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{http://ftn.uns.ac.rs/vakcina/saglasnost}evidencija_o_vakcinaciji"/>
 *       &lt;/sequence>
 *       &lt;attribute name="potvrda_o_vakcinisanju" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="interesovanje" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="about" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="rel" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "licniPodaci",
    "saglanost",
    "potpis",
    "datum",
    "evidencijaOVakcinaciji"
})
@XmlRootElement(name = "saglasnost_za_imunizaciju")
public class SaglasnostZaImunizaciju {

    @XmlElement(name = "licni_podaci", required = true)
    protected LicniPodaci licniPodaci;
    @XmlElement(required = true)
    protected Saglanost saglanost;
    @XmlElement(required = true)
    protected String potpis;
    @XmlElement(required = true)
    protected Datum datum;
    @XmlElement(name = "evidencija_o_vakcinaciji", required = true)
    protected EvidencijaOVakcinaciji evidencijaOVakcinaciji;
    @XmlAttribute(name = "potvrda_o_vakcinisanju")
    @XmlSchemaType(name = "anySimpleType")
    protected String potvrdaOVakcinisanju;
    @XmlAttribute(name = "interesovanje")
    @XmlSchemaType(name = "anySimpleType")
    protected String interesovanje;
    @XmlAttribute(name = "id")
    @XmlSchemaType(name = "anySimpleType")
    protected String id;
    @XmlAttribute(name = "about")
    @XmlSchemaType(name = "anySimpleType")
    protected String about;
    @XmlAttribute(name = "rel")
    @XmlSchemaType(name = "anySimpleType")
    protected String rel;
    @XmlAttribute(name = "href")
    @XmlSchemaType(name = "anySimpleType")
    protected String href;

    /**
     * Gets the value of the licniPodaci property.
     * 
     * @return
     *     possible object is
     *     {@link LicniPodaci }
     *     
     */
    public LicniPodaci getLicniPodaci() {
        return licniPodaci;
    }

    /**
     * Sets the value of the licniPodaci property.
     * 
     * @param value
     *     allowed object is
     *     {@link LicniPodaci }
     *     
     */
    public void setLicniPodaci(LicniPodaci value) {
        this.licniPodaci = value;
    }

    /**
     * Gets the value of the saglanost property.
     * 
     * @return
     *     possible object is
     *     {@link Saglanost }
     *     
     */
    public Saglanost getSaglanost() {
        return saglanost;
    }

    /**
     * Sets the value of the saglanost property.
     * 
     * @param value
     *     allowed object is
     *     {@link Saglanost }
     *     
     */
    public void setSaglanost(Saglanost value) {
        this.saglanost = value;
    }

    /**
     * Gets the value of the potpis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPotpis() {
        return potpis;
    }

    /**
     * Sets the value of the potpis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPotpis(String value) {
        this.potpis = value;
    }

    /**
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link Datum }
     *     
     */
    public Datum getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Datum }
     *     
     */
    public void setDatum(Datum value) {
        this.datum = value;
    }

    /**
     * Gets the value of the evidencijaOVakcinaciji property.
     * 
     * @return
     *     possible object is
     *     {@link EvidencijaOVakcinaciji }
     *     
     */
    public EvidencijaOVakcinaciji getEvidencijaOVakcinaciji() {
        return evidencijaOVakcinaciji;
    }

    /**
     * Sets the value of the evidencijaOVakcinaciji property.
     * 
     * @param value
     *     allowed object is
     *     {@link EvidencijaOVakcinaciji }
     *     
     */
    public void setEvidencijaOVakcinaciji(EvidencijaOVakcinaciji value) {
        this.evidencijaOVakcinaciji = value;
    }

    /**
     * Gets the value of the potvrdaOVakcinisanju property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPotvrdaOVakcinisanju() {
        return potvrdaOVakcinisanju;
    }

    /**
     * Sets the value of the potvrdaOVakcinisanju property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPotvrdaOVakcinisanju(String value) {
        this.potvrdaOVakcinisanju = value;
    }

    /**
     * Gets the value of the interesovanje property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInteresovanje() {
        return interesovanje;
    }

    /**
     * Sets the value of the interesovanje property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInteresovanje(String value) {
        this.interesovanje = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the about property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbout() {
        return about;
    }

    /**
     * Sets the value of the about property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbout(String value) {
        this.about = value;
    }

    /**
     * Gets the value of the rel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRel() {
        return rel;
    }

    /**
     * Sets the value of the rel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRel(String value) {
        this.rel = value;
    }

    /**
     * Gets the value of the href property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHref() {
        return href;
    }

    /**
     * Sets the value of the href property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHref(String value) {
        this.href = value;
    }

    @Override
    public String toString() {
        return "SaglasnostZaImunizaciju{" +
                "licniPodaci=" + licniPodaci +
                ", saglanost=" + saglanost +
                ", potpis='" + potpis + '\'' +
                ", datum=" + datum +
                ", evidencijaOVakcinaciji=" + evidencijaOVakcinaciji +
                ", potvrdaOVakcinisanju='" + potvrdaOVakcinisanju + '\'' +
                ", interesovanje='" + interesovanje + '\'' +
                ", id='" + id + '\'' +
                ", about='" + about + '\'' +
                ", rel='" + rel + '\'' +
                ", href='" + href + '\'' +
                '}';
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>date">
     *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *       &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Datum {

        @XmlValue
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar value;
        @XmlAttribute(name = "property")
        @XmlSchemaType(name = "anySimpleType")
        protected String property;
        @XmlAttribute(name = "datatype")
        @XmlSchemaType(name = "anySimpleType")
        protected String datatype;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setValue(XMLGregorianCalendar value) {
            this.value = value;
        }

        /**
         * Gets the value of the property property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getProperty() {
            return property;
        }

        /**
         * Sets the value of the property property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setProperty(String value) {
            this.property = value;
        }

        /**
         * Gets the value of the datatype property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDatatype() {
            return datatype;
        }

        /**
         * Sets the value of the datatype property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDatatype(String value) {
            this.datatype = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="saglasan_sam" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *         &lt;element name="naziv_leka" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "saglasanSam",
        "nazivLeka"
    })
    public static class Saglanost {

        @XmlElement(name = "saglasan_sam")
        protected Object saglasanSam;
        @XmlElement(name = "naziv_leka", required = true)
        protected String nazivLeka;

        /**
         * Gets the value of the saglasanSam property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getSaglasanSam() {
            return saglasanSam;
        }

        /**
         * Sets the value of the saglasanSam property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setSaglasanSam(Object value) {
            this.saglasanSam = value;
        }

        /**
         * Gets the value of the nazivLeka property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNazivLeka() {
            return nazivLeka;
        }

        /**
         * Sets the value of the nazivLeka property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNazivLeka(String value) {
            this.nazivLeka = value;
        }

    }

}
