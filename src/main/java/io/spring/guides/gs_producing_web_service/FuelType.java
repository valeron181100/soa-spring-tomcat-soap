//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.04.07 at 08:35:48 PM MSK 
//


package io.spring.guides.gs_producing_web_service;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FuelType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FuelType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="SOLID"/&gt;
 *     &lt;enumeration value="LIQUID"/&gt;
 *     &lt;enumeration value="GAS"/&gt;
 *     &lt;enumeration value="DIESEL"/&gt;
 *     &lt;enumeration value="KEROSENE"/&gt;
 *     &lt;enumeration value="MANPOWER"/&gt;
 *     &lt;enumeration value="NUCLEAR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "FuelType")
@XmlEnum
public enum FuelType {

    SOLID,
    LIQUID,
    GAS,
    DIESEL,
    KEROSENE,
    MANPOWER,
    NUCLEAR;

    public String value() {
        return name();
    }

    public static FuelType fromValue(String v) {
        return valueOf(v);
    }

}
