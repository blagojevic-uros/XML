//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.01.12 at 07:41:55 PM CET 
//


package model.saglasnost;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element ref="{http://ftn.uns.ac.rs/vakcina/saglasnost}srpsko"/>
 *         &lt;element ref="{http://ftn.uns.ac.rs/vakcina/saglasnost}strano"/>
 *       &lt;/choice>
 *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="datatype" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "srpsko",
    "strano"
})
@XmlRootElement(name = "drzavljanstvo")
public class Drzavljanstvo {

    protected Srpsko srpsko;
    protected Strano strano;
    @XmlAttribute(name = "property")
    @XmlSchemaType(name = "anySimpleType")
    protected String property;
    @XmlAttribute(name = "datatype")
    @XmlSchemaType(name = "anySimpleType")
    protected String datatype;

    /**
     * Gets the value of the srpsko property.
     * 
     * @return
     *     possible object is
     *     {@link Srpsko }
     *     
     */
    public Srpsko getSrpsko() {
        return srpsko;
    }

    /**
     * Sets the value of the srpsko property.
     * 
     * @param value
     *     allowed object is
     *     {@link Srpsko }
     *     
     */
    public void setSrpsko(Srpsko value) {
        this.srpsko = value;
    }

    /**
     * Gets the value of the strano property.
     * 
     * @return
     *     possible object is
     *     {@link Strano }
     *     
     */
    public Strano getStrano() {
        return strano;
    }

    /**
     * Sets the value of the strano property.
     * 
     * @param value
     *     allowed object is
     *     {@link Strano }
     *     
     */
    public void setStrano(Strano value) {
        this.strano = value;
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