/**
 *
 *    geo-platform
 *    Rich webgis framework
 *    http://geo-platform.org
 *   ====================================================================
 *
 *   Copyright (C) 2008-2014 geoSDI Group (CNR IMAA - Potenza - ITALY).
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
// Generated on: 2012.07.16 at 11:59:54 AM CEST 
//


package org.geosdi.geoplatform.xml.ows.v110;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * Contents of typical Contents section of an OWS service metadata (Capabilities) document. This type shall be extended and/or restricted if needed for specific OWS use to include the specific metadata needed. 
 * 
 * <p>Java class for ContentsBaseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContentsBaseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/ows/1.1}DatasetDescriptionSummary" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.opengis.net/ows/1.1}OtherSource" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContentsBaseType", propOrder = {
    "datasetDescriptionSummary",
    "otherSource"
})
public class ContentsBaseType
    implements ToString
{

    @XmlElementRef(name = "DatasetDescriptionSummary", namespace = "http://www.opengis.net/ows/1.1", type = JAXBElement.class)
    protected List<JAXBElement<DatasetDescriptionSummaryBaseType>> datasetDescriptionSummary;
    @XmlElementRef(name = "OtherSource", namespace = "http://www.opengis.net/ows/1.1", type = JAXBElement.class)
    protected List<JAXBElement<MetadataType>> otherSource;

    /**
     * Unordered set of summary descriptions for the datasets available from this OWS server. This set shall be included unless another source is referenced and all this metadata is available from that source. Gets the value of the datasetDescriptionSummary property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datasetDescriptionSummary property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatasetDescriptionSummary().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link DatasetDescriptionSummaryBaseType }{@code >}
     * {@link JAXBElement }{@code <}{@link DatasetDescriptionSummaryBaseType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<DatasetDescriptionSummaryBaseType>> getDatasetDescriptionSummary() {
        if (datasetDescriptionSummary == null) {
            datasetDescriptionSummary = new ArrayList<JAXBElement<DatasetDescriptionSummaryBaseType>>();
        }
        return this.datasetDescriptionSummary;
    }

    /**
     * Unordered set of references to other sources of metadata describing the coverage offerings available from this server. Gets the value of the otherSource property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the otherSource property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOtherSource().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link MetadataType }{@code >}
     * {@link JAXBElement }{@code <}{@link MetadataType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<MetadataType>> getOtherSource() {
        if (otherSource == null) {
            otherSource = new ArrayList<JAXBElement<MetadataType>>();
        }
        return this.otherSource;
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
        {
            List<JAXBElement<DatasetDescriptionSummaryBaseType>> theDatasetDescriptionSummary;
            theDatasetDescriptionSummary = (((this.datasetDescriptionSummary!= null)&&(!this.datasetDescriptionSummary.isEmpty()))?this.getDatasetDescriptionSummary():null);
            strategy.appendField(locator, this, "datasetDescriptionSummary", buffer, theDatasetDescriptionSummary);
        }
        {
            List<JAXBElement<MetadataType>> theOtherSource;
            theOtherSource = (((this.otherSource!= null)&&(!this.otherSource.isEmpty()))?this.getOtherSource():null);
            strategy.appendField(locator, this, "otherSource", buffer, theOtherSource);
        }
        return buffer;
    }

    public void setDatasetDescriptionSummary(List<JAXBElement<DatasetDescriptionSummaryBaseType>> value) {
        this.datasetDescriptionSummary = null;
        List<JAXBElement<DatasetDescriptionSummaryBaseType>> draftl = this.getDatasetDescriptionSummary();
        draftl.addAll(value);
    }

    public void setOtherSource(List<JAXBElement<MetadataType>> value) {
        this.otherSource = null;
        List<JAXBElement<MetadataType>> draftl = this.getOtherSource();
        draftl.addAll(value);
    }

}
