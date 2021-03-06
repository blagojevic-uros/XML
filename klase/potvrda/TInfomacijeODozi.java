//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.01.04 at 09:55:55 PM CET 
//


package potvrda;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TInfomacije_o_dozi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TInfomacije_o_dozi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="naziv_vakcine" type="{http://www.ftn-vakcine.rs/types}tip_vakcine"/>
 *         &lt;element name="datum_doze" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="broj_serije" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="broj_doze" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="zdravstena_ustanova" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TInfomacije_o_dozi", propOrder = {
    "nazivVakcine",
    "datumDoze",
    "brojSerije",
    "brojDoze",
    "zdravstenaUstanova"
})
public class TInfomacijeODozi {

    @XmlElement(name = "naziv_vakcine", required = true)
    @XmlSchemaType(name = "string")
    protected TipVakcine nazivVakcine;
    @XmlElement(name = "datum_doze", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumDoze;
    @XmlElement(name = "broj_serije", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger brojSerije;
    @XmlElement(name = "broj_doze", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger brojDoze;
    @XmlElement(name = "zdravstena_ustanova", required = true)
    protected String zdravstenaUstanova;

    /**
     * Gets the value of the nazivVakcine property.
     * 
     * @return
     *     possible object is
     *     {@link TipVakcine }
     *     
     */
    public TipVakcine getNazivVakcine() {
        return nazivVakcine;
    }

    /**
     * Sets the value of the nazivVakcine property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipVakcine }
     *     
     */
    public void setNazivVakcine(TipVakcine value) {
        this.nazivVakcine = value;
    }

    /**
     * Gets the value of the datumDoze property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumDoze() {
        return datumDoze;
    }

    /**
     * Sets the value of the datumDoze property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumDoze(XMLGregorianCalendar value) {
        this.datumDoze = value;
    }

    /**
     * Gets the value of the brojSerije property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBrojSerije() {
        return brojSerije;
    }

    /**
     * Sets the value of the brojSerije property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBrojSerije(BigInteger value) {
        this.brojSerije = value;
    }

    /**
     * Gets the value of the brojDoze property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBrojDoze() {
        return brojDoze;
    }

    /**
     * Sets the value of the brojDoze property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBrojDoze(BigInteger value) {
        this.brojDoze = value;
    }

    /**
     * Gets the value of the zdravstenaUstanova property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZdravstenaUstanova() {
        return zdravstenaUstanova;
    }

    /**
     * Sets the value of the zdravstenaUstanova property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZdravstenaUstanova(String value) {
        this.zdravstenaUstanova = value;
    }

}
