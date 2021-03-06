//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.02.07 at 03:15:04 PM CET 
//


package model.interesovanje;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TDrzavljanstvo.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TDrzavljanstvo">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Drzavljanin_RS"/>
 *     &lt;enumeration value="Strani_bez_boravka"/>
 *     &lt;enumeration value="Strani_sa_boravkom"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TDrzavljanstvo", namespace = "http://ftn.uns.ac.rs/vakcina/interesovanje")
@XmlEnum
public enum TDrzavljanstvo {

    @XmlEnumValue("Drzavljanin_RS")
    DRZAVLJANIN_RS("Drzavljanin_RS"),
    @XmlEnumValue("Strani_bez_boravka")
    STRANI_BEZ_BORAVKA("Strani_bez_boravka"),
    @XmlEnumValue("Strani_sa_boravkom")
    STRANI_SA_BORAVKOM("Strani_sa_boravkom");
    private final String value;

    TDrzavljanstvo(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TDrzavljanstvo fromValue(String v) {
        for (TDrzavljanstvo c: TDrzavljanstvo.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
