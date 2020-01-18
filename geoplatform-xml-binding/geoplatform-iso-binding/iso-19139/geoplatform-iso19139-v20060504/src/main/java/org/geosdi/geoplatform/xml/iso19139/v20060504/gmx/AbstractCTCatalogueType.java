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
// Generated on: 2015.06.17 at 04:41:23 PM CEST 
//


package org.geosdi.geoplatform.xml.iso19139.v20060504.gmx;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.geosdi.geoplatform.xml.iso19139.v20060504.gco.AbstractObjectType;
import org.geosdi.geoplatform.xml.iso19139.v20060504.gco.CharacterStringPropertyType;
import org.geosdi.geoplatform.xml.iso19139.v20060504.gco.DatePropertyType;
import org.geosdi.geoplatform.xml.iso19139.v20060504.gmd.MDCharacterSetCodePropertyType;
import org.geosdi.geoplatform.xml.iso19139.v20060504.gmd.PTLocalePropertyType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for AbstractCT_Catalogue_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractCT_Catalogue_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.isotc211.org/2005/gco}AbstractObject_Type">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType"/>
 *         &lt;element name="scope" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType" maxOccurs="unbounded"/>
 *         &lt;element name="fieldOfApplication" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="versionNumber" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType"/>
 *         &lt;element name="versionDate" type="{http://www.isotc211.org/2005/gco}Date_PropertyType"/>
 *         &lt;element name="language" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType" minOccurs="0"/>
 *         &lt;element name="characterSet" type="{http://www.isotc211.org/2005/gmd}MD_CharacterSetCode_PropertyType" minOccurs="0"/>
 *         &lt;element name="locale" type="{http://www.isotc211.org/2005/gmd}PT_Locale_PropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="subCatalogue" type="{http://www.isotc211.org/2005/gmx}CT_Catalogue_PropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractCT_Catalogue_Type", propOrder = {
    "name",
    "scope",
    "fieldOfApplication",
    "versionNumber",
    "versionDate",
    "language",
    "characterSet",
    "locale",
    "subCatalogue"
})
@XmlSeeAlso({
    CTCodelistCatalogueType.class,
    CTCrsCatalogueType.class,
    CTUomCatalogueType.class
})
public abstract class AbstractCTCatalogueType
    extends AbstractObjectType
    implements ToString
{

    @XmlElement(required = true)
    protected CharacterStringPropertyType name;
    @XmlElement(required = true)
    protected List<CharacterStringPropertyType> scope;
    protected List<CharacterStringPropertyType> fieldOfApplication;
    @XmlElement(required = true)
    protected CharacterStringPropertyType versionNumber;
    @XmlElement(required = true)
    protected DatePropertyType versionDate;
    protected CharacterStringPropertyType language;
    protected MDCharacterSetCodePropertyType characterSet;
    protected List<PTLocalePropertyType> locale;
    protected List<CTCataloguePropertyType> subCatalogue;

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
     * Gets the value of the scope property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the scope property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScope().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CharacterStringPropertyType }
     * 
     * 
     */
    public List<CharacterStringPropertyType> getScope() {
        if (scope == null) {
            scope = new ArrayList<CharacterStringPropertyType>();
        }
        return this.scope;
    }

    public boolean isSetScope() {
        return ((this.scope!= null)&&(!this.scope.isEmpty()));
    }

    public void unsetScope() {
        this.scope = null;
    }

    /**
     * Gets the value of the fieldOfApplication property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fieldOfApplication property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFieldOfApplication().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CharacterStringPropertyType }
     * 
     * 
     */
    public List<CharacterStringPropertyType> getFieldOfApplication() {
        if (fieldOfApplication == null) {
            fieldOfApplication = new ArrayList<CharacterStringPropertyType>();
        }
        return this.fieldOfApplication;
    }

    public boolean isSetFieldOfApplication() {
        return ((this.fieldOfApplication!= null)&&(!this.fieldOfApplication.isEmpty()));
    }

    public void unsetFieldOfApplication() {
        this.fieldOfApplication = null;
    }

    /**
     * Gets the value of the versionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public CharacterStringPropertyType getVersionNumber() {
        return versionNumber;
    }

    /**
     * Sets the value of the versionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public void setVersionNumber(CharacterStringPropertyType value) {
        this.versionNumber = value;
    }

    public boolean isSetVersionNumber() {
        return (this.versionNumber!= null);
    }

    /**
     * Gets the value of the versionDate property.
     * 
     * @return
     *     possible object is
     *     {@link DatePropertyType }
     *     
     */
    public DatePropertyType getVersionDate() {
        return versionDate;
    }

    /**
     * Sets the value of the versionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatePropertyType }
     *     
     */
    public void setVersionDate(DatePropertyType value) {
        this.versionDate = value;
    }

    public boolean isSetVersionDate() {
        return (this.versionDate!= null);
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public CharacterStringPropertyType getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public void setLanguage(CharacterStringPropertyType value) {
        this.language = value;
    }

    public boolean isSetLanguage() {
        return (this.language!= null);
    }

    /**
     * Gets the value of the characterSet property.
     * 
     * @return
     *     possible object is
     *     {@link MDCharacterSetCodePropertyType }
     *     
     */
    public MDCharacterSetCodePropertyType getCharacterSet() {
        return characterSet;
    }

    /**
     * Sets the value of the characterSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link MDCharacterSetCodePropertyType }
     *     
     */
    public void setCharacterSet(MDCharacterSetCodePropertyType value) {
        this.characterSet = value;
    }

    public boolean isSetCharacterSet() {
        return (this.characterSet!= null);
    }

    /**
     * Gets the value of the locale property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the locale property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocale().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PTLocalePropertyType }
     * 
     * 
     */
    public List<PTLocalePropertyType> getLocale() {
        if (locale == null) {
            locale = new ArrayList<PTLocalePropertyType>();
        }
        return this.locale;
    }

    public boolean isSetLocale() {
        return ((this.locale!= null)&&(!this.locale.isEmpty()));
    }

    public void unsetLocale() {
        this.locale = null;
    }

    /**
     * Gets the value of the subCatalogue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subCatalogue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubCatalogue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CTCataloguePropertyType }
     * 
     * 
     */
    public List<CTCataloguePropertyType> getSubCatalogue() {
        if (subCatalogue == null) {
            subCatalogue = new ArrayList<CTCataloguePropertyType>();
        }
        return this.subCatalogue;
    }

    public boolean isSetSubCatalogue() {
        return ((this.subCatalogue!= null)&&(!this.subCatalogue.isEmpty()));
    }

    public void unsetSubCatalogue() {
        this.subCatalogue = null;
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
            CharacterStringPropertyType theName;
            theName = this.getName();
            strategy.appendField(locator, this, "name", buffer, theName);
        }
        {
            List<CharacterStringPropertyType> theScope;
            theScope = (this.isSetScope()?this.getScope():null);
            strategy.appendField(locator, this, "scope", buffer, theScope);
        }
        {
            List<CharacterStringPropertyType> theFieldOfApplication;
            theFieldOfApplication = (this.isSetFieldOfApplication()?this.getFieldOfApplication():null);
            strategy.appendField(locator, this, "fieldOfApplication", buffer, theFieldOfApplication);
        }
        {
            CharacterStringPropertyType theVersionNumber;
            theVersionNumber = this.getVersionNumber();
            strategy.appendField(locator, this, "versionNumber", buffer, theVersionNumber);
        }
        {
            DatePropertyType theVersionDate;
            theVersionDate = this.getVersionDate();
            strategy.appendField(locator, this, "versionDate", buffer, theVersionDate);
        }
        {
            CharacterStringPropertyType theLanguage;
            theLanguage = this.getLanguage();
            strategy.appendField(locator, this, "language", buffer, theLanguage);
        }
        {
            MDCharacterSetCodePropertyType theCharacterSet;
            theCharacterSet = this.getCharacterSet();
            strategy.appendField(locator, this, "characterSet", buffer, theCharacterSet);
        }
        {
            List<PTLocalePropertyType> theLocale;
            theLocale = (this.isSetLocale()?this.getLocale():null);
            strategy.appendField(locator, this, "locale", buffer, theLocale);
        }
        {
            List<CTCataloguePropertyType> theSubCatalogue;
            theSubCatalogue = (this.isSetSubCatalogue()?this.getSubCatalogue():null);
            strategy.appendField(locator, this, "subCatalogue", buffer, theSubCatalogue);
        }
        return buffer;
    }

    public void setScope(List<CharacterStringPropertyType> value) {
        this.scope = null;
        List<CharacterStringPropertyType> draftl = this.getScope();
        draftl.addAll(value);
    }

    public void setFieldOfApplication(List<CharacterStringPropertyType> value) {
        this.fieldOfApplication = null;
        List<CharacterStringPropertyType> draftl = this.getFieldOfApplication();
        draftl.addAll(value);
    }

    public void setLocale(List<PTLocalePropertyType> value) {
        this.locale = null;
        List<PTLocalePropertyType> draftl = this.getLocale();
        draftl.addAll(value);
    }

    public void setSubCatalogue(List<CTCataloguePropertyType> value) {
        this.subCatalogue = null;
        List<CTCataloguePropertyType> draftl = this.getSubCatalogue();
        draftl.addAll(value);
    }

}
