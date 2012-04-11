/*
 *  geo-platform
 *  Rich webgis framework
 *  http://geo-platform.org
 * ====================================================================
 *
 * Copyright (C) 2008-2012 geoSDI Group (CNR IMAA - Potenza - ITALY).
 *
 * This program is free software: you can redistribute it and/or modify it 
 * under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or 
 * (at your option) any later version. This program is distributed in the 
 * hope that it will be useful, but WITHOUT ANY WARRANTY; without 
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR 
 * A PARTICULAR PURPOSE. See the GNU General Public License 
 * for more details. You should have received a copy of the GNU General 
 * Public License along with this program. If not, see http://www.gnu.org/licenses/ 
 *
 * ====================================================================
 *
 * Linking this library statically or dynamically with other modules is 
 * making a combined work based on this library. Thus, the terms and 
 * conditions of the GNU General Public License cover the whole combination. 
 * 
 * As a special exception, the copyright holders of this library give you permission 
 * to link this library with independent modules to produce an executable, regardless 
 * of the license terms of these independent modules, and to copy and distribute 
 * the resulting executable under terms of your choice, provided that you also meet, 
 * for each linked independent module, the terms and conditions of the license of 
 * that module. An independent module is a module which is not derived from or 
 * based on this library. If you modify this library, you may extend this exception 
 * to your version of the library, but you are not obligated to do so. If you do not 
 * wish to do so, delete this exception statement from your version. 
 *
 */
package org.geosdi.geoplatform.xml.gml.v311;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * [complexType of] Predefined concrete value of the top-level property. Encapsulates all other styling information.
 * 
 * <p>Java class for StyleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StyleType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractStyleType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/gml}featureStyle" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.opengis.net/gml}graphStyle" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StyleType", propOrder = {
    "featureStyle",
    "graphStyle"
})
public class StyleType extends AbstractStyleType {

    @XmlElement(required = true)
    private List<FeatureStylePropertyType> featureStyle;
    protected GraphStylePropertyType graphStyle;

    /**
     * @param featureStyle the featureStyle to set
     */
    public void setFeatureStyle(List<FeatureStylePropertyType> featureStyle) {
        this.featureStyle = featureStyle;
    }

    /**
     * Gets the value of the featureStyle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the featureStyle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeatureStyle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FeatureStylePropertyType }
     * 
     * 
     */
    public List<FeatureStylePropertyType> getFeatureStyle() {
        if (featureStyle == null) {
            this.featureStyle = new ArrayList<FeatureStylePropertyType>();
        }
        return this.featureStyle;
    }

    /**
     * Gets the value of the graphStyle property.
     * 
     * @return
     *     possible object is
     *     {@link GraphStylePropertyType }
     *     
     */
    public GraphStylePropertyType getGraphStyle() {
        return graphStyle;
    }

    /**
     * Sets the value of the graphStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link GraphStylePropertyType }
     *     
     */
    public void setGraphStyle(GraphStylePropertyType value) {
        this.graphStyle = value;
    }

    @Override
    public String toString() {
        return "StyleType{ " + "featureStyle = " + featureStyle
                + ", graphStyle = " + graphStyle + '}';
    }
}
