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
// Generated on: 2012.11.02 at 06:49:13 PM CET 
//
package org.geosdi.geoplatform.xml.xsd.v2001;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;

/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained
 * within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.w3.org/2001/XMLSchema}openAttrs">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{http://www.w3.org/2001/XMLSchema}include"/>
 *           &lt;element ref="{http://www.w3.org/2001/XMLSchema}import"/>
 *           &lt;element ref="{http://www.w3.org/2001/XMLSchema}redefine"/>
 *           &lt;element ref="{http://www.w3.org/2001/XMLSchema}annotation"/>
 *         &lt;/choice>
 *         &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *           &lt;group ref="{http://www.w3.org/2001/XMLSchema}schemaTop"/>
 *           &lt;element ref="{http://www.w3.org/2001/XMLSchema}annotation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="targetNamespace" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}token" />
 *       &lt;attribute name="finalDefault" type="{http://www.w3.org/2001/XMLSchema}fullDerivationSet" default="" />
 *       &lt;attribute name="blockDefault" type="{http://www.w3.org/2001/XMLSchema}blockSet" default="" />
 *       &lt;attribute name="attributeFormDefault" type="{http://www.w3.org/2001/XMLSchema}formChoice" default="unqualified" />
 *       &lt;attribute name="elementFormDefault" type="{http://www.w3.org/2001/XMLSchema}formChoice" default="unqualified" />
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/>
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "includeOrImportOrRedefine",
    "simpleTypeOrComplexTypeOrGroup"
})
@XmlRootElement(name = "schema")
public class Schema
        extends OpenAttrs
        implements ToString {

    @XmlElements({
        @XmlElement(name = "include", type = Include.class),
        @XmlElement(name = "import", type = Import.class),
        @XmlElement(name = "redefine", type = Redefine.class),
        @XmlElement(name = "annotation", type = Annotation.class)
    })
    protected List<OpenAttrs> includeOrImportOrRedefine;
    @XmlElements({
        @XmlElement(name = "simpleType", type = TopLevelSimpleType.class),
        @XmlElement(name = "complexType", type = TopLevelComplexType.class),
        @XmlElement(name = "group", type = NamedGroup.class),
        @XmlElement(name = "attributeGroup", type = NamedAttributeGroup.class),
        @XmlElement(name = "element", type = TopLevelElement.class),
        @XmlElement(name = "attribute", type = TopLevelAttribute.class),
        @XmlElement(name = "notation", type = Notation.class),
        @XmlElement(name = "annotation", type = Annotation.class)
    })
    protected List<OpenAttrs> simpleTypeOrComplexTypeOrGroup;
    @XmlAttribute(name = "targetNamespace")
    @XmlSchemaType(name = "anyURI")
    protected String targetNamespace;
    @XmlAttribute(name = "version")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String version;
    @XmlAttribute(name = "finalDefault")
    @XmlSchemaType(name = "fullDerivationSet")
    protected List<String> finalDefault;
    @XmlAttribute(name = "blockDefault")
    @XmlSchemaType(name = "blockSet")
    protected List<String> blockDefault;
    @XmlAttribute(name = "attributeFormDefault")
    protected FormChoice attributeFormDefault;
    @XmlAttribute(name = "elementFormDefault")
    protected FormChoice elementFormDefault;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "lang",
                  namespace = "http://www.w3.org/XML/1998/namespace")
    protected String lang;

    /**
     * Gets the value of the includeOrImportOrRedefine property.
     *
     * <p> This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the includeOrImportOrRedefine property.
     *
     * <p> For example, to add a new item, do as follows:
     * <pre>
     *    getIncludeOrImportOrRedefine().add(newItem);
     * </pre>
     *
     *
     * <p> Objects of the following type(s) are allowed in the list null null
     * null null null null null null null null     {@link Include }
     * {@link Import }
     * {@link Redefine }
     * {@link Annotation }
     *
     *
     */
    public List<OpenAttrs> getIncludeOrImportOrRedefine() {
        if (includeOrImportOrRedefine == null) {
            includeOrImportOrRedefine = new ArrayList<OpenAttrs>();
        }
        return this.includeOrImportOrRedefine;
    }

    public boolean isSetIncludeOrImportOrRedefine() {
        return ((this.includeOrImportOrRedefine != null) && (!this.includeOrImportOrRedefine.isEmpty()));
    }

    public void unsetIncludeOrImportOrRedefine() {
        this.includeOrImportOrRedefine = null;
    }

    /**
     * Gets the value of the simpleTypeOrComplexTypeOrGroup property.
     *
     * <p> This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the simpleTypeOrComplexTypeOrGroup property.
     *
     * <p> For example, to add a new item, do as follows:
     * <pre>
     *    getSimpleTypeOrComplexTypeOrGroup().add(newItem);
     * </pre>
     *
     *
     * <p> Objects of the following type(s) are allowed in the list null null
     * null null null null null null null null     {@link TopLevelSimpleType }
     * {@link TopLevelComplexType }
     * {@link NamedGroup }
     * {@link NamedAttributeGroup }
     * {@link TopLevelElement }
     * {@link TopLevelAttribute }
     * {@link Notation }
     * {@link Annotation }
     *
     *
     */
    public List<OpenAttrs> getSimpleTypeOrComplexTypeOrGroup() {
        if (simpleTypeOrComplexTypeOrGroup == null) {
            simpleTypeOrComplexTypeOrGroup = new ArrayList<OpenAttrs>();
        }
        return this.simpleTypeOrComplexTypeOrGroup;
    }

    public boolean isSetSimpleTypeOrComplexTypeOrGroup() {
        return ((this.simpleTypeOrComplexTypeOrGroup != null) && (!this.simpleTypeOrComplexTypeOrGroup.isEmpty()));
    }

    public void unsetSimpleTypeOrComplexTypeOrGroup() {
        this.simpleTypeOrComplexTypeOrGroup = null;
    }

    /**
     * Gets the value of the targetNamespace property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getTargetNamespace() {
        return targetNamespace;
    }

    /**
     * Sets the value of the targetNamespace property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setTargetNamespace(String value) {
        this.targetNamespace = value;
    }

    public boolean isSetTargetNamespace() {
        return (this.targetNamespace != null);
    }

    /**
     * Gets the value of the version property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setVersion(String value) {
        this.version = value;
    }

    public boolean isSetVersion() {
        return (this.version != null);
    }

    /**
     * Gets the value of the finalDefault property.
     *
     * <p> This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the finalDefault property.
     *
     * <p> For example, to add a new item, do as follows:
     * <pre>
     *    getFinalDefault().add(newItem);
     * </pre>
     *
     *
     * <p> Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     */
    public List<String> getFinalDefault() {
        if (finalDefault == null) {
            finalDefault = new ArrayList<String>();
        }
        return this.finalDefault;
    }

    public boolean isSetFinalDefault() {
        return ((this.finalDefault != null) && (!this.finalDefault.isEmpty()));
    }

    public void unsetFinalDefault() {
        this.finalDefault = null;
    }

    /**
     * Gets the value of the blockDefault property.
     *
     * <p> This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the blockDefault property.
     *
     * <p> For example, to add a new item, do as follows:
     * <pre>
     *    getBlockDefault().add(newItem);
     * </pre>
     *
     *
     * <p> Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     */
    public List<String> getBlockDefault() {
        if (blockDefault == null) {
            blockDefault = new ArrayList<String>();
        }
        return this.blockDefault;
    }

    public boolean isSetBlockDefault() {
        return ((this.blockDefault != null) && (!this.blockDefault.isEmpty()));
    }

    public void unsetBlockDefault() {
        this.blockDefault = null;
    }

    /**
     * Gets the value of the attributeFormDefault property.
     *
     * @return possible object is {@link FormChoice }
     *
     */
    public FormChoice getAttributeFormDefault() {
        if (attributeFormDefault == null) {
            return FormChoice.UNQUALIFIED;
        } else {
            return attributeFormDefault;
        }
    }

    /**
     * Sets the value of the attributeFormDefault property.
     *
     * @param value allowed object is {@link FormChoice }
     *
     */
    public void setAttributeFormDefault(FormChoice value) {
        this.attributeFormDefault = value;
    }

    public boolean isSetAttributeFormDefault() {
        return (this.attributeFormDefault != null);
    }

    /**
     * Gets the value of the elementFormDefault property.
     *
     * @return possible object is {@link FormChoice }
     *
     */
    public FormChoice getElementFormDefault() {
        if (elementFormDefault == null) {
            return FormChoice.UNQUALIFIED;
        } else {
            return elementFormDefault;
        }
    }

    /**
     * Sets the value of the elementFormDefault property.
     *
     * @param value allowed object is {@link FormChoice }
     *
     */
    public void setElementFormDefault(FormChoice value) {
        this.elementFormDefault = value;
    }

    public boolean isSetElementFormDefault() {
        return (this.elementFormDefault != null);
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setId(String value) {
        this.id = value;
    }

    public boolean isSetId() {
        return (this.id != null);
    }

    /**
     * Gets the value of the lang property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setLang(String value) {
        this.lang = value;
    }

    public boolean isSetLang() {
        return (this.lang != null);
    }

    /**
     * Return {@link TopLevelElement} type by {@link String} name.
     *
     * @param name
     *
     * @return {@link TopLevelElement} type
     */
    public TopLevelElement getTopLevelElement(String name) {
        if (name != null) {
            for (OpenAttrs openAttrs : getSimpleTypeOrComplexTypeOrGroup()) {
                if (openAttrs instanceof TopLevelElement) {
                    TopLevelElement element = (TopLevelElement) openAttrs;
                    if (element.getName().equalsIgnoreCase(name)) {
                        return element;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Returns all {@link TopLevelElement} elements.
     *
     * @return {@link List<TopLevelElement>}
     */
    public List<TopLevelElement> getTopLevelElements() {
        List<TopLevelElement> topElements = new ArrayList<TopLevelElement>();
        for (OpenAttrs o : getSimpleTypeOrComplexTypeOrGroup()) {
            if (o instanceof TopLevelElement) {
                topElements.add((TopLevelElement) o);
            }
        }
        return topElements;
    }

    /**
     * Return {@link TopLevelComplexType} type by {@link String} name.
     *
     * @param name
     *
     * @return {@link TopLevelComplexType} type
     */
    public TopLevelComplexType getTopLevelComplexType(String name) {
        if (name != null) {
            for (OpenAttrs openAttrs : getSimpleTypeOrComplexTypeOrGroup()) {
                if (openAttrs instanceof TopLevelComplexType) {
                    TopLevelComplexType complexType = (TopLevelComplexType) openAttrs;
                    if (complexType.getName().equalsIgnoreCase(name)) {
                        return complexType;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Returns all {@link TopLevelComplexType} elements.
     *
     * @return {@link List<TopLevelComplexType>}
     */
    public List<TopLevelComplexType> getTopLevelComplexTypeElements() {
        List<TopLevelComplexType> elements = new ArrayList<TopLevelComplexType>();
        for (OpenAttrs openAttrs : getSimpleTypeOrComplexTypeOrGroup()) {
            if (openAttrs instanceof TopLevelComplexType) {
                elements.add((TopLevelComplexType) openAttrs);
            }
        }
        return elements;
    }

    @Override
    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    @Override
    public StringBuilder append(ObjectLocator locator,
            StringBuilder buffer,
            ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    @Override
    public StringBuilder appendFields(ObjectLocator locator,
            StringBuilder buffer,
            ToStringStrategy strategy) {
        super.appendFields(locator, buffer, strategy);
        {
            List<OpenAttrs> theIncludeOrImportOrRedefine;
            theIncludeOrImportOrRedefine = (this.isSetIncludeOrImportOrRedefine() ? this.getIncludeOrImportOrRedefine() : null);
            strategy.appendField(locator, this, "includeOrImportOrRedefine",
                                 buffer, theIncludeOrImportOrRedefine);
        }
        {
            List<OpenAttrs> theSimpleTypeOrComplexTypeOrGroup;
            theSimpleTypeOrComplexTypeOrGroup = (this.isSetSimpleTypeOrComplexTypeOrGroup() ? this.getSimpleTypeOrComplexTypeOrGroup() : null);
            strategy.appendField(locator, this, "simpleTypeOrComplexTypeOrGroup",
                                 buffer, theSimpleTypeOrComplexTypeOrGroup);
        }
        {
            String theTargetNamespace;
            theTargetNamespace = this.getTargetNamespace();
            strategy.appendField(locator, this, "targetNamespace", buffer,
                                 theTargetNamespace);
        }
        {
            String theVersion;
            theVersion = this.getVersion();
            strategy.appendField(locator, this, "version", buffer, theVersion);
        }
        {
            List<String> theFinalDefault;
            theFinalDefault = (this.isSetFinalDefault() ? this.getFinalDefault() : null);
            strategy.appendField(locator, this, "finalDefault", buffer,
                                 theFinalDefault);
        }
        {
            List<String> theBlockDefault;
            theBlockDefault = (this.isSetBlockDefault() ? this.getBlockDefault() : null);
            strategy.appendField(locator, this, "blockDefault", buffer,
                                 theBlockDefault);
        }
        {
            FormChoice theAttributeFormDefault;
            theAttributeFormDefault = this.getAttributeFormDefault();
            strategy.appendField(locator, this, "attributeFormDefault", buffer,
                                 theAttributeFormDefault);
        }
        {
            FormChoice theElementFormDefault;
            theElementFormDefault = this.getElementFormDefault();
            strategy.appendField(locator, this, "elementFormDefault", buffer,
                                 theElementFormDefault);
        }
        {
            String theId;
            theId = this.getId();
            strategy.appendField(locator, this, "id", buffer, theId);
        }
        {
            String theLang;
            theLang = this.getLang();
            strategy.appendField(locator, this, "lang", buffer, theLang);
        }
        return buffer;
    }

    public void setIncludeOrImportOrRedefine(List<OpenAttrs> value) {
        this.includeOrImportOrRedefine = null;
        List<OpenAttrs> draftl = this.getIncludeOrImportOrRedefine();
        draftl.addAll(value);
    }

    public void setSimpleTypeOrComplexTypeOrGroup(List<OpenAttrs> value) {
        this.simpleTypeOrComplexTypeOrGroup = null;
        List<OpenAttrs> draftl = this.getSimpleTypeOrComplexTypeOrGroup();
        draftl.addAll(value);
    }

    public void setFinalDefault(List<String> value) {
        this.finalDefault = null;
        List<String> draftl = this.getFinalDefault();
        draftl.addAll(value);
    }

    public void setBlockDefault(List<String> value) {
        this.blockDefault = null;
        List<String> draftl = this.getBlockDefault();
        draftl.addAll(value);
    }
}
