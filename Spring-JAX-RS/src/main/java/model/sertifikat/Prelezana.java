//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.01.12 at 07:36:17 PM CET 
//


package model.sertifikat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
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
 *         &lt;element name="datum_pozitivnog" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="laboratorija" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "datumPozitivnog",
    "laboratorija"
})
@XmlRootElement(name = "prelezana")
public class Prelezana {

    @XmlElement(name = "datum_pozitivnog", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumPozitivnog;
    @XmlElement(required = true)
    protected String laboratorija;

    /**
     * Gets the value of the datumPozitivnog property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumPozitivnog() {
        return datumPozitivnog;
    }

    /**
     * Sets the value of the datumPozitivnog property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumPozitivnog(XMLGregorianCalendar value) {
        this.datumPozitivnog = value;
    }

    /**
     * Gets the value of the laboratorija property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLaboratorija() {
        return laboratorija;
    }

    /**
     * Sets the value of the laboratorija property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLaboratorija(String value) {
        this.laboratorija = value;
    }

}
