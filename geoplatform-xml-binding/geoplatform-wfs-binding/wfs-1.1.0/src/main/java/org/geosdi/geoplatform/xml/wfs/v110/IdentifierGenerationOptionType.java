/**
 *
 *    geo-platform
 *    Rich webgis framework
 *    http://geo-platform.org
 *   ====================================================================
 *
 *   Copyright (C) 2008-2020 geoSDI Group (CNR IMAA - Potenza - ITALY).
 *
 *   This program is free software: you can redistribute it and/or modify it
 *   under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version. This program is distributed in the
 *   hope that it will be useful, but WITHOUT ANY WARRANTY; without
 *   even the implied warranty of MERCHANTABILITY or FITNESS FOR
 *   A PARTICULAR PURPOSE. See the GNU General Public License
 *   for more details. You should have received a copy of the GNU General
 *   Public License along with this program. If not, see http://www.gnu.org/licenses/
 *
 *   ====================================================================
 *
 *   Linking this library statically or dynamically with other modules is
 *   making a combined work based on this library. Thus, the terms and
 *   conditions of the GNU General Public License cover the whole combination.
 *
 *   As a special exception, the copyright holders of this library give you permission
 *   to link this library with independent modules to produce an executable, regardless
 *   of the license terms of these independent modules, and to copy and distribute
 *   the resulting executable under terms of your choice, provided that you also meet,
 *   for each linked independent module, the terms and conditions of the license of
 *   that module. An independent module is a module which is not derived from or
 *   based on this library. If you modify this library, you may extend this exception
 *   to your version of the library, but you are not obligated to do so. If you do not
 *   wish to do so, delete this exception statement from your version.
 */
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.26 at 03:16:42 PM CEST 
//


package org.geosdi.geoplatform.xml.wfs.v110;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IdentifierGenerationOptionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IdentifierGenerationOptionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UseExisting"/>
 *     &lt;enumeration value="ReplaceDuplicate"/>
 *     &lt;enumeration value="GenerateNew"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IdentifierGenerationOptionType")
@XmlEnum
public enum IdentifierGenerationOptionType {


    /**
     * 
     *                   The UseExsiting value indicates that WFS should not
     *                   generate a new feature identifier for the feature
     *                   being inserted into the repositry.  Instead, the WFS
     *                   should use the identifier encoded if the feature.  
     *                   If a duplicate exists then the WFS10 should raise an
     *                   exception.
     *                
     * 
     */
    @XmlEnumValue("UseExisting")
    USE_EXISTING("UseExisting"),

    /**
     * 
     *                   The ReplaceDuplicate value indicates that WFS10 should
     *                   not generate a new feature identifier for the feature
     *                   being inserted into the repositry.  Instead, the WFS10
     *                   should use the identifier encoded if the feature.  
     *                   If a duplicate exists then the WFS10 should replace the
     *                   existing feature instance with the one encoded in the
     *                   Insert action.
     *                
     * 
     */
    @XmlEnumValue("ReplaceDuplicate")
    REPLACE_DUPLICATE("ReplaceDuplicate"),

    /**
     * 
     *                   The GenerateNew value indicates that WFS10 should
     *                   generate a new unique feature identifier for the
     *                   feature being inserted into the repositry.
     *                
     * 
     */
    @XmlEnumValue("GenerateNew")
    GENERATE_NEW("GenerateNew");
    private final String value;

    IdentifierGenerationOptionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IdentifierGenerationOptionType fromValue(String v) {
        for (IdentifierGenerationOptionType c: IdentifierGenerationOptionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
