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
// Generated on: 2012.04.18 at 03:12:11 PM CEST 
//


package org.geosdi.geoplatform.xml.iso19139.v20070417.gmd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.geosdi.geoplatform.xml.iso19139.v20070417.gco.AbstractObjectType;
import org.geosdi.geoplatform.xml.iso19139.v20070417.gco.CharacterStringPropertyType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * Information about online sources from which the dataset, specification, or community profile name and extended metadata elements can be obtained.
 * 
 * <p>Java class for CI_OnlineResource_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CI_OnlineResource_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.isotc211.org/2005/gco}AbstractObject_Type">
 *       &lt;sequence>
 *         &lt;element name="linkage" type="{http://www.isotc211.org/2005/gmd}URL_PropertyType"/>
 *         &lt;element name="protocol" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType" minOccurs="0"/>
 *         &lt;element name="applicationProfile" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType" minOccurs="0"/>
 *         &lt;element name="function" type="{http://www.isotc211.org/2005/gmd}CI_OnLineFunctionCode_PropertyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CI_OnlineResource_Type", propOrder = {
    "linkage",
    "protocol",
    "applicationProfile",
    "name",
    "description",
    "function"
})
public class CIOnlineResourceType
    extends AbstractObjectType
    implements ToString
{

    @XmlElement(required = true)
    protected URLPropertyType linkage;
    protected CharacterStringPropertyType protocol;
    protected CharacterStringPropertyType applicationProfile;
    protected CharacterStringPropertyType name;
    protected CharacterStringPropertyType description;
    protected CIOnLineFunctionCodePropertyType function;

    /**
     * Gets the value of the linkage property.
     * 
     * @return
     *     possible object is
     *     {@link URLPropertyType }
     *     
     */
    public URLPropertyType getLinkage() {
        return linkage;
    }

    /**
     * Sets the value of the linkage property.
     * 
     * @param value
     *     allowed object is
     *     {@link URLPropertyType }
     *     
     */
    public void setLinkage(URLPropertyType value) {
        this.linkage = value;
    }

    public boolean isSetLinkage() {
        return (this.linkage!= null);
    }

    /**
     * Gets the value of the protocol property.
     * 
     * @return
     *     possible object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public CharacterStringPropertyType getProtocol() {
        return protocol;
    }

    /**
     * Sets the value of the protocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public void setProtocol(CharacterStringPropertyType value) {
        this.protocol = value;
    }

    public boolean isSetProtocol() {
        return (this.protocol!= null);
    }

    /**
     * Gets the value of the applicationProfile property.
     * 
     * @return
     *     possible object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public CharacterStringPropertyType getApplicationProfile() {
        return applicationProfile;
    }

    /**
     * Sets the value of the applicationProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public void setApplicationProfile(CharacterStringPropertyType value) {
        this.applicationProfile = value;
    }

    public boolean isSetApplicationProfile() {
        return (this.applicationProfile!= null);
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public CharacterStringPropertyType getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public void setName(CharacterStringPropertyType value) {
        this.name = value;
    }

    public boolean isSetName() {
        return (this.name!= null);
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public CharacterStringPropertyType getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public void setDescription(CharacterStringPropertyType value) {
        this.description = value;
    }

    public boolean isSetDescription() {
        return (this.description!= null);
    }

    /**
     * Gets the value of the function property.
     * 
     * @return
     *     possible object is
     *     {@link CIOnLineFunctionCodePropertyType }
     *     
     */
    public CIOnLineFunctionCodePropertyType getFunction() {
        return function;
    }

    /**
     * Sets the value of the function property.
     * 
     * @param value
     *     allowed object is
     *     {@link CIOnLineFunctionCodePropertyType }
     *     
     */
    public void setFunction(CIOnLineFunctionCodePropertyType value) {
        this.function = value;
    }

    public boolean isSetFunction() {
        return (this.function!= null);
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
            URLPropertyType theLinkage;
            theLinkage = this.getLinkage();
            strategy.appendField(locator, this, "linkage", buffer, theLinkage);
        }
        {
            CharacterStringPropertyType theProtocol;
            theProtocol = this.getProtocol();
            strategy.appendField(locator, this, "protocol", buffer, theProtocol);
        }
        {
            CharacterStringPropertyType theApplicationProfile;
            theApplicationProfile = this.getApplicationProfile();
            strategy.appendField(locator, this, "applicationProfile", buffer, theApplicationProfile);
        }
        {
            CharacterStringPropertyType theName;
            theName = this.getName();
            strategy.appendField(locator, this, "name", buffer, theName);
        }
        {
            CharacterStringPropertyType theDescription;
            theDescription = this.getDescription();
            strategy.appendField(locator, this, "description", buffer, theDescription);
        }
        {
            CIOnLineFunctionCodePropertyType theFunction;
            theFunction = this.getFunction();
            strategy.appendField(locator, this, "function", buffer, theFunction);
        }
        return buffer;
    }

}
