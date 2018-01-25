/**
 *
 *    geo-platform
 *    Rich webgis framework
 *    http://geo-platform.org
 *   ====================================================================
 *
 *   Copyright (C) 2008-2018 geoSDI Group (CNR IMAA - Potenza - ITALY).
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
// Generated on: 2012.04.17 at 10:27:36 PM CEST 
//


package org.geosdi.geoplatform.xml.gml.v311;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * Definition of an algorithm used to perform a coordinate operation. Most operation methods use a number of operation parameters, although some coordinate conversions use none. Each coordinate operation using the method assigns values to these parameters. 
 * 
 * <p>Java class for OperationMethodType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OperationMethodType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}OperationMethodBaseType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/gml}methodID" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.opengis.net/gml}remarks" minOccurs="0"/>
 *         &lt;element ref="{http://www.opengis.net/gml}methodFormula"/>
 *         &lt;element ref="{http://www.opengis.net/gml}sourceDimensions"/>
 *         &lt;element ref="{http://www.opengis.net/gml}targetDimensions"/>
 *         &lt;element ref="{http://www.opengis.net/gml}usesParameter" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OperationMethodType", propOrder = {
    "methodID",
    "remarks",
    "methodFormula",
    "sourceDimensions",
    "targetDimensions",
    "usesParameter"
})
public class OperationMethodType
    extends OperationMethodBaseType
    implements ToString
{

    protected List<IdentifierType> methodID;
    protected StringOrRefType remarks;
    @XmlElement(required = true)
    protected CodeType methodFormula;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger sourceDimensions;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger targetDimensions;
    protected List<AbstractGeneralOperationParameterRefType> usesParameter;

    /**
     * Set of alternative identifications of this operation method. The first methodID, if any, is normally the primary identification code, and any others are aliases. Gets the value of the methodID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the methodID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMethodID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentifierType }
     * 
     * 
     */
    public List<IdentifierType> getMethodID() {
        if (methodID == null) {
            methodID = new ArrayList<IdentifierType>();
        }
        return this.methodID;
    }

    public boolean isSetMethodID() {
        return ((this.methodID!= null)&&(!this.methodID.isEmpty()));
    }

    public void unsetMethodID() {
        this.methodID = null;
    }

    /**
     * Comments on or information about this operation method, including source information.
     * 
     * @return
     *     possible object is
     *     {@link StringOrRefType }
     *     
     */
    public StringOrRefType getRemarks() {
        return remarks;
    }

    /**
     * Sets the value of the remarks property.
     * 
     * @param value
     *     allowed object is
     *     {@link StringOrRefType }
     *     
     */
    public void setRemarks(StringOrRefType value) {
        this.remarks = value;
    }

    public boolean isSetRemarks() {
        return (this.remarks!= null);
    }

    /**
     * Gets the value of the methodFormula property.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getMethodFormula() {
        return methodFormula;
    }

    /**
     * Sets the value of the methodFormula property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setMethodFormula(CodeType value) {
        this.methodFormula = value;
    }

    public boolean isSetMethodFormula() {
        return (this.methodFormula!= null);
    }

    /**
     * Gets the value of the sourceDimensions property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSourceDimensions() {
        return sourceDimensions;
    }

    /**
     * Sets the value of the sourceDimensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSourceDimensions(BigInteger value) {
        this.sourceDimensions = value;
    }

    public boolean isSetSourceDimensions() {
        return (this.sourceDimensions!= null);
    }

    /**
     * Gets the value of the targetDimensions property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTargetDimensions() {
        return targetDimensions;
    }

    /**
     * Sets the value of the targetDimensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTargetDimensions(BigInteger value) {
        this.targetDimensions = value;
    }

    public boolean isSetTargetDimensions() {
        return (this.targetDimensions!= null);
    }

    /**
     * Unordered list of associations to the set of operation parameters and parameter groups used by this operation method. Gets the value of the usesParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usesParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsesParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractGeneralOperationParameterRefType }
     * 
     * 
     */
    public List<AbstractGeneralOperationParameterRefType> getUsesParameter() {
        if (usesParameter == null) {
            usesParameter = new ArrayList<AbstractGeneralOperationParameterRefType>();
        }
        return this.usesParameter;
    }

    public boolean isSetUsesParameter() {
        return ((this.usesParameter!= null)&&(!this.usesParameter.isEmpty()));
    }

    public void unsetUsesParameter() {
        this.usesParameter = null;
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        super.appendFields(locator, buffer, strategy);
        {
            List<IdentifierType> theMethodID;
            theMethodID = (this.isSetMethodID()?this.getMethodID():null);
            strategy.appendField(locator, this, "methodID", buffer, theMethodID);
        }
        {
            StringOrRefType theRemarks;
            theRemarks = this.getRemarks();
            strategy.appendField(locator, this, "remarks", buffer, theRemarks);
        }
        {
            CodeType theMethodFormula;
            theMethodFormula = this.getMethodFormula();
            strategy.appendField(locator, this, "methodFormula", buffer, theMethodFormula);
        }
        {
            BigInteger theSourceDimensions;
            theSourceDimensions = this.getSourceDimensions();
            strategy.appendField(locator, this, "sourceDimensions", buffer, theSourceDimensions);
        }
        {
            BigInteger theTargetDimensions;
            theTargetDimensions = this.getTargetDimensions();
            strategy.appendField(locator, this, "targetDimensions", buffer, theTargetDimensions);
        }
        {
            List<AbstractGeneralOperationParameterRefType> theUsesParameter;
            theUsesParameter = (this.isSetUsesParameter()?this.getUsesParameter():null);
            strategy.appendField(locator, this, "usesParameter", buffer, theUsesParameter);
        }
        return buffer;
    }

    public void setMethodID(List<IdentifierType> value) {
        this.methodID = null;
        List<IdentifierType> draftl = this.getMethodID();
        draftl.addAll(value);
    }

    public void setUsesParameter(List<AbstractGeneralOperationParameterRefType> value) {
        this.usesParameter = null;
        List<AbstractGeneralOperationParameterRefType> draftl = this.getUsesParameter();
        draftl.addAll(value);
    }

}
