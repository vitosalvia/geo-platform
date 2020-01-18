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
// Generated on: 2012.04.18 at 11:27:19 AM CEST 
//


package org.geosdi.geoplatform.xml.ows.v100;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * General metadata identifying and describing a set of data. This type shall be extended if needed for each specific OWS to include additional metadata for each type of dataset. If needed, this type should first be restricted for each specific OWS to change the multiplicity (or optionality) of some elements. 
 * 
 * <p>Java class for IdentificationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IdentificationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/ows}DescriptionType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/ows}Identifier" minOccurs="0"/>
 *         &lt;element ref="{http://www.opengis.net/ows}BoundingBox" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.opengis.net/ows}OutputFormat" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.opengis.net/ows}AvailableCRS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.opengis.net/ows}Metadata" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IdentificationType", propOrder = {
    "identifier",
    "boundingBox",
    "outputFormat",
    "availableCRS",
    "metadata"
})
public class IdentificationType
    extends DescriptionType
    implements ToString
{

    @XmlElement(name = "Identifier")
    protected CodeType identifier;
    @XmlElementRef(name = "BoundingBox", namespace = "http://www.opengis.net/ows", type = JAXBElement.class)
    protected List<JAXBElement<? extends BoundingBoxType>> boundingBox;
    @XmlElement(name = "OutputFormat")
    protected List<String> outputFormat;
    @XmlElementRef(name = "AvailableCRS", namespace = "http://www.opengis.net/ows", type = JAXBElement.class)
    protected List<JAXBElement<String>> availableCRS;
    @XmlElement(name = "Metadata")
    protected List<MetadataType> metadata;

    /**
     * Optional unique identifier or name of this dataset. 
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getIdentifier() {
        return identifier;
    }

    /**
     * Sets the value of the identifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setIdentifier(CodeType value) {
        this.identifier = value;
    }

    /**
     * Unordered list of zero or more bounding boxes whose union describes the extent of this dataset. Gets the value of the boundingBox property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the boundingBox property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBoundingBox().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link WGS84BoundingBoxType }{@code >}
     * {@link JAXBElement }{@code <}{@link BoundingBoxType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends BoundingBoxType>> getBoundingBox() {
        if (boundingBox == null) {
            boundingBox = new ArrayList<JAXBElement<? extends BoundingBoxType>>();
        }
        return this.boundingBox;
    }

    /**
     * Unordered list of zero or more references to data formats supported for server outputs. Gets the value of the outputFormat property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outputFormat property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutputFormat().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getOutputFormat() {
        if (outputFormat == null) {
            outputFormat = new ArrayList<String>();
        }
        return this.outputFormat;
    }

    /**
     * Unordered list of zero or more available coordinate reference systems. Gets the value of the availableCRS property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the availableCRS property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAvailableCRS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<String>> getAvailableCRS() {
        if (availableCRS == null) {
            availableCRS = new ArrayList<JAXBElement<String>>();
        }
        return this.availableCRS;
    }

    /**
     * Optional unordered list of additional metadata about this data(set). A list of optional metadata elements for this data identification could be specified in the Implementation Specification for this service. Gets the value of the metadata property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the metadata property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMetadata().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MetadataType }
     * 
     * 
     */
    public List<MetadataType> getMetadata() {
        if (metadata == null) {
            metadata = new ArrayList<MetadataType>();
        }
        return this.metadata;
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE2;
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
            CodeType theIdentifier;
            theIdentifier = this.getIdentifier();
            strategy.appendField(locator, this, "identifier", buffer, theIdentifier);
        }
        {
            List<JAXBElement<? extends BoundingBoxType>> theBoundingBox;
            theBoundingBox = (((this.boundingBox!= null)&&(!this.boundingBox.isEmpty()))?this.getBoundingBox():null);
            strategy.appendField(locator, this, "boundingBox", buffer, theBoundingBox);
        }
        {
            List<String> theOutputFormat;
            theOutputFormat = (((this.outputFormat!= null)&&(!this.outputFormat.isEmpty()))?this.getOutputFormat():null);
            strategy.appendField(locator, this, "outputFormat", buffer, theOutputFormat);
        }
        {
            List<JAXBElement<String>> theAvailableCRS;
            theAvailableCRS = (((this.availableCRS!= null)&&(!this.availableCRS.isEmpty()))?this.getAvailableCRS():null);
            strategy.appendField(locator, this, "availableCRS", buffer, theAvailableCRS);
        }
        {
            List<MetadataType> theMetadata;
            theMetadata = (((this.metadata!= null)&&(!this.metadata.isEmpty()))?this.getMetadata():null);
            strategy.appendField(locator, this, "metadata", buffer, theMetadata);
        }
        return buffer;
    }

    public void setBoundingBox(List<JAXBElement<? extends BoundingBoxType>> value) {
        this.boundingBox = null;
        List<JAXBElement<? extends BoundingBoxType>> draftl = this.getBoundingBox();
        draftl.addAll(value);
    }

    public void setOutputFormat(List<String> value) {
        this.outputFormat = null;
        List<String> draftl = this.getOutputFormat();
        draftl.addAll(value);
    }

    public void setAvailableCRS(List<JAXBElement<String>> value) {
        this.availableCRS = null;
        List<JAXBElement<String>> draftl = this.getAvailableCRS();
        draftl.addAll(value);
    }

    public void setMetadata(List<MetadataType> value) {
        this.metadata = null;
        List<MetadataType> draftl = this.getMetadata();
        draftl.addAll(value);
    }

}
