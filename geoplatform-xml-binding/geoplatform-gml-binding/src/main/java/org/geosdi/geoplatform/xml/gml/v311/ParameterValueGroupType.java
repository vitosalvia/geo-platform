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
 * A group of related parameter values. The same group can be repeated more than once in a Conversion, Transformation, or higher level parameterValueGroup, if those instances contain different values of one or more parameterValues which suitably distinquish among those groups. This concrete complexType can be used for operation methods without using an Application Schema that defines operation-method-specialized element names and contents, especially for methods with only one instance. This complexType can be used, extended, or restricted for well-known operation methods, especially for methods with many instances. 
 * 
 * <p>Java class for ParameterValueGroupType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ParameterValueGroupType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractGeneralParameterValueType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/gml}includesValue" maxOccurs="unbounded" minOccurs="2"/>
 *         &lt;element ref="{http://www.opengis.net/gml}valuesOfGroup"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParameterValueGroupType", propOrder = {
    "includesValue",
    "valuesOfGroup"
})
public class ParameterValueGroupType extends AbstractGeneralParameterValueType {

    @XmlElement(required = true)
    private List<AbstractGeneralParameterValueType> includesValue;
    @XmlElement(required = true)
    protected OperationParameterGroupRefType valuesOfGroup;

    public ParameterValueGroupType() {
    }

    /**
     * @param includesValue the includesValue to set
     */
    public void setIncludesValue(List<AbstractGeneralParameterValueType> includesValue) {
        this.includesValue = includesValue;
    }

    /**
     * Unordered set of composition associations to the parameter values and groups of values included in this group. Gets the value of the includesValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the includesValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncludesValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractGeneralParameterValueType }
     * 
     * 
     */
    public List<AbstractGeneralParameterValueType> getIncludesValue() {
        if (includesValue == null) {
            this.includesValue = new ArrayList<AbstractGeneralParameterValueType>();
        }
        return this.includesValue;
    }

    /**
     * Gets the value of the valuesOfGroup property.
     * 
     * @return
     *     possible object is
     *     {@link OperationParameterGroupRefType }
     *     
     */
    public OperationParameterGroupRefType getValuesOfGroup() {
        return valuesOfGroup;
    }

    /**
     * Sets the value of the valuesOfGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationParameterGroupRefType }
     *     
     */
    public void setValuesOfGroup(OperationParameterGroupRefType value) {
        this.valuesOfGroup = value;
    }

    @Override
    public String toString() {
        return "ParameterValueGroupType{ " + "includesValue = "
                + includesValue + ", valuesOfGroup = " + valuesOfGroup + '}';
    }
}
