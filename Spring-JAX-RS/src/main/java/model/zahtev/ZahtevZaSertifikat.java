//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.01.12 at 07:36:09 PM CET 
//


package model.zahtev;


import model.tipovi.ImePrezime;
import model.tipovi.Pol;

import javax.xml.bind.annotation.*;
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
 *         &lt;element name="licni_podaci">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ime_prezime" type="{http://ftn.uns.ac.rs/vakcina/tipovi}Ime_prezime"/>
 *                   &lt;element name="datum_rodjenja" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="pol" type="{http://ftn.uns.ac.rs/vakcina/tipovi}pol"/>
 *                   &lt;element name="JMBG">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://ftn.uns.ac.rs/vakcina/tipovi>JMBG">
 *                           &lt;attribute name="prop" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                           &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="broj_pasosa">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://ftn.uns.ac.rs/vakcina/tipovi}broj_pasosa">
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="razlog_za_zahtev" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mesto">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="prop" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                 &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="datum_zahteva">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>date">
 *                 &lt;attribute name="prop" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                 &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="potpis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="sertifikat" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
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
    "razlogZaZahtev",
    "mesto",
    "datumZahteva",
    "potpis",
    "status",
    "zahtevId"
})
@XmlRootElement(name = "zahtev_za_sertifikat")
public class ZahtevZaSertifikat {

    @XmlElement(name = "licni_podaci", required = true)
    protected LicniPodaci licniPodaci;
    @XmlElement(name = "razlog_za_zahtev", required = true)
    protected String razlogZaZahtev;
    @XmlElement(required = true)
    protected Mesto mesto;
    @XmlElement(name = "datum_zahteva", required = true)
    protected DatumZahteva datumZahteva;
    @XmlElement(required = true)
    protected String potpis;
    @XmlElement(required = true)
    protected String status;

    @XmlElement(required = true)
    protected String zahtevId;
    @XmlAttribute(name = "sertifikat")
    @XmlSchemaType(name = "anySimpleType")
    protected String sertifikat;
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
     * Gets the value of the razlogZaZahtev property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRazlogZaZahtev() {
        return razlogZaZahtev;
    }

    /**
     * Sets the value of the razlogZaZahtev property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRazlogZaZahtev(String value) {
        this.razlogZaZahtev = value;
    }

    /**
     * Gets the value of the mesto property.
     * 
     * @return
     *     possible object is
     *     {@link Mesto }
     *     
     */
    public Mesto getMesto() {
        return mesto;
    }

    /**
     * Sets the value of the mesto property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mesto }
     *     
     */
    public void setMesto(Mesto value) {
        this.mesto = value;
    }

    /**
     * Gets the value of the datumZahteva property.
     * 
     * @return
     *     possible object is
     *     {@link DatumZahteva }
     *     
     */
    public DatumZahteva getDatumZahteva() {
        return datumZahteva;
    }

    /**
     * Sets the value of the datumZahteva property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatumZahteva }
     *     
     */
    public void setDatumZahteva(DatumZahteva value) {
        this.datumZahteva = value;
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


    public void setStatus(String value) {this.status = value;}

    public String getStatus() {return status;}

    public void setZahtevId(String value) {this.zahtevId = value;}

    public String getZahtevId() {return zahtevId;}

    /**
     * Gets the value of the sertifikat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSertifikat() {
        return sertifikat;
    }

    /**
     * Sets the value of the sertifikat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSertifikat(String value) {
        this.sertifikat = value;
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
        return "ZahtevZaSertifikat{" +
                "licniPodaci=" + licniPodaci +
                ", razlogZaZahtev='" + razlogZaZahtev + '\'' +
                ", mesto=" + mesto +
                ", datumZahteva=" + datumZahteva +
                ", potpis='" + potpis + '\'' +
                ", sertifikat='" + sertifikat + '\'' +
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
     *       &lt;attribute name="prop" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
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
    public static class DatumZahteva {

        @XmlValue
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar value;
        @XmlAttribute(name = "prop")
        @XmlSchemaType(name = "anySimpleType")
        protected String prop;
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
         * Gets the value of the prop property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getProp() {
            return prop;
        }

        /**
         * Sets the value of the prop property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setProp(String value) {
            this.prop = value;
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
     *         &lt;element name="ime_prezime" type="{http://ftn.uns.ac.rs/vakcina/tipovi}Ime_prezime"/>
     *         &lt;element name="datum_rodjenja" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="pol" type="{http://ftn.uns.ac.rs/vakcina/tipovi}pol"/>
     *         &lt;element name="JMBG">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://ftn.uns.ac.rs/vakcina/tipovi>JMBG">
     *                 &lt;attribute name="prop" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *                 &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="broj_pasosa">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://ftn.uns.ac.rs/vakcina/tipovi}broj_pasosa">
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
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
        "imePrezime",
        "datumRodjenja",
        "pol",
        "jmbg",
        "brojPasosa"
    })
    public static class LicniPodaci {

        @XmlElement(name = "ime_prezime", required = true)
        protected ImePrezime imePrezime;
        @XmlElement(name = "datum_rodjenja", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar datumRodjenja;
        @XmlElement(required = true)
        @XmlSchemaType(name = "string")
        protected Pol pol;
        @XmlElement(name = "JMBG", required = true)
        protected JMBG jmbg;
        @XmlElement(name = "broj_pasosa", required = true)
        protected String brojPasosa;

        /**
         * Gets the value of the imePrezime property.
         * 
         * @return
         *     possible object is
         *     {@link ImePrezime }
         *     
         */
        public ImePrezime getImePrezime() {
            return imePrezime;
        }

        /**
         * Sets the value of the imePrezime property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImePrezime }
         *     
         */
        public void setImePrezime(ImePrezime value) {
            this.imePrezime = value;
        }

        /**
         * Gets the value of the datumRodjenja property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDatumRodjenja() {
            return datumRodjenja;
        }

        /**
         * Sets the value of the datumRodjenja property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDatumRodjenja(XMLGregorianCalendar value) {
            this.datumRodjenja = value;
        }

        /**
         * Gets the value of the pol property.
         * 
         * @return
         *     possible object is
         *     {@link Pol }
         *     
         */
        public Pol getPol() {
            return pol;
        }

        /**
         * Sets the value of the pol property.
         * 
         * @param value
         *     allowed object is
         *     {@link Pol }
         *     
         */
        public void setPol(Pol value) {
            this.pol = value;
        }

        /**
         * Gets the value of the jmbg property.
         * 
         * @return
         *     possible object is
         *     {@link JMBG }
         *     
         */
        public JMBG getJMBG() {
            return jmbg;
        }

        /**
         * Sets the value of the jmbg property.
         * 
         * @param value
         *     allowed object is
         *     {@link JMBG }
         *     
         */
        public void setJMBG(JMBG value) {
            this.jmbg = value;
        }

        /**
         * Gets the value of the brojPasosa property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBrojPasosa() {
            return brojPasosa;
        }

        /**
         * Sets the value of the brojPasosa property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBrojPasosa(String value) {
            this.brojPasosa = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://ftn.uns.ac.rs/vakcina/tipovi>JMBG">
         *       &lt;attribute name="prop" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
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
        public static class JMBG {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "prop")
            @XmlSchemaType(name = "anySimpleType")
            protected String prop;
            @XmlAttribute(name = "datatype")
            @XmlSchemaType(name = "anySimpleType")
            protected String datatype;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the prop property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProp() {
                return prop;
            }

            /**
             * Sets the value of the prop property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProp(String value) {
                this.prop = value;
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

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="prop" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
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
    public static class Mesto {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "prop")
        @XmlSchemaType(name = "anySimpleType")
        protected String prop;
        @XmlAttribute(name = "datatype")
        @XmlSchemaType(name = "anySimpleType")
        protected String datatype;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the prop property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getProp() {
            return prop;
        }

        /**
         * Sets the value of the prop property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setProp(String value) {
            this.prop = value;
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

}
