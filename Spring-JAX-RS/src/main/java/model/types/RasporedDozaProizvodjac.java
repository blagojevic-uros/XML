//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.01.05 at 01:47:54 PM CET 
//


package model.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for raspored_doza_proizvodjac complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="raspored_doza_proizvodjac">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.ftn-vakcine.rs/izvestaj}info_proizvodjac" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "raspored_doza_proizvodjac", propOrder = {
    "infoProizvodjac"
})
public class RasporedDozaProizvodjac {

    @XmlElement(name = "info_proizvodjac")
    protected List<TProizvodjac> infoProizvodjac;

    /**
     * Gets the value of the infoProizvodjac property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the infoProizvodjac property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfoProizvodjac().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TProizvodjac }
     * 
     * 
     */
    public List<TProizvodjac> getInfoProizvodjac() {
        if (infoProizvodjac == null) {
            infoProizvodjac = new ArrayList<TProizvodjac>();
        }
        return this.infoProizvodjac;
    }

}
