//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.01.05 at 01:47:54 PM CET 
//


<<<<<<< Updated upstream:Spring-JAX-RS/src/main/java/com/spring/rest/model/types/TipVakcine.java
package com.spring.rest.model.types;
=======
<<<<<<< Updated upstream:Spring-JAX-RS/src/main/java/com/spring/rest/model/potvrda/TipVakcine.java
package com.spring.rest.model.potvrda;
=======
package model.types;
>>>>>>> Stashed changes:Spring-JAX-RS/src/main/java/model/types/TipVakcine.java
>>>>>>> Stashed changes:Spring-JAX-RS/src/main/java/com/spring/rest/model/potvrda/TipVakcine.java

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tip_vakcine.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tip_vakcine">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Pfizer-BioNTech"/>
 *     &lt;enumeration value="Sputnik V (Gamaleya \u0438\u0441\u0442\u0440\u0430\u0436\u0438\u0432\u0430\u0447\u043a\u0438 \u0446\u0435\u043d\u0442\u0430\u0440)"/>
 *     &lt;enumeration value="Sinopharm"/>
 *     &lt;enumeration value="AstraZeneca"/>
 *     &lt;enumeration value="Moderna"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tip_vakcine", namespace = "http://www.ftn-vakcine.rs/types")
@XmlEnum
public enum TipVakcine {

    @XmlEnumValue("Pfizer-BioNTech")
    PFIZER_BIO_N_TECH("Pfizer-BioNTech"),
    @XmlEnumValue("Sputnik V (Gamaleya \u0438\u0441\u0442\u0440\u0430\u0436\u0438\u0432\u0430\u0447\u043a\u0438 \u0446\u0435\u043d\u0442\u0430\u0440)")
    SPUTNIK_V_GAMALEYA_\u0418\u0421\u0422\u0420\u0410\u0416\u0418\u0412\u0410\u0427\u041a\u0418_\u0426\u0415\u041d\u0422\u0410\u0420("Sputnik V (Gamaleya \u0438\u0441\u0442\u0440\u0430\u0436\u0438\u0432\u0430\u0447\u043a\u0438 \u0446\u0435\u043d\u0442\u0430\u0440)"),
    @XmlEnumValue("Sinopharm")
    SINOPHARM("Sinopharm"),
    @XmlEnumValue("AstraZeneca")
    ASTRA_ZENECA("AstraZeneca"),
    @XmlEnumValue("Moderna")
    MODERNA("Moderna");
    private final String value;

    TipVakcine(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipVakcine fromValue(String v) {
        for (TipVakcine c: TipVakcine.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
