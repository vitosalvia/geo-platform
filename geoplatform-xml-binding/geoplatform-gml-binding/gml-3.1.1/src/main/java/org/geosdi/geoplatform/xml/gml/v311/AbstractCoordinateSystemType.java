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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * A coordinate system (CS) is the set of coordinate system axes that spans a given coordinate space. A CS is derived from a set of (mathematical) rules for specifying how coordinates in a given space are to be assigned to points. The coordinate values in a coordinate tuple shall be recorded in the order in which the coordinate system axes associations are recorded, whenever those coordinates use a coordinate reference system that uses this coordinate system. This abstract complexType shall not be used, extended, or restricted, in an Application Schema, to define a concrete subtype with a meaning equivalent to a concrete subtype specified in this document. 
 * 
 * <p>Java class for AbstractCoordinateSystemType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractCoordinateSystemType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractCoordinateSystemBaseType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/gml}csID" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.opengis.net/gml}remarks" minOccurs="0"/>
 *         &lt;element ref="{http://www.opengis.net/gml}usesAxis" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractCoordinateSystemType", propOrder = {
    "csID",
    "remarks",
    "usesAxis"
})
@XmlSeeAlso({
    ObliqueCartesianCSType.class,
    VerticalCSType.class,
    LinearCSType.class,
    SphericalCSType.class,
    EllipsoidalCSType.class,
    CartesianCSType.class,
    CylindricalCSType.class,
    TemporalCSType.class,
    UserDefinedCSType.class,
    PolarCSType.class
})
public abstract class AbstractCoordinateSystemType
        extends AbstractCoordinateSystemBaseType {

    private List<IdentifierType> csID;
    protected StringOrRefType remarks;
    @XmlElement(required = true)
    private List<CoordinateSystemAxisRefType> usesAxis;

    public AbstractCoordinateSystemType() {
    }

    /**
     * @param csID the csID to set
     */
    public void setCsID(List<IdentifierType> csID) {
        this.csID = csID;
    }

    /**
     * Set of alternative identifications of this coordinate system. The first csID, if any, is normally the primary identification code, and any others are aliases. Gets the value of the csID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the csID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCsID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentifierType }
     * 
     * 
     */
    public List<IdentifierType> getCsID() {
        if (csID == null) {
            setCsID(new ArrayList<IdentifierType>());
        }
        return this.csID;
    }

    /**
     * Comments on or information about this coordinate system, including data source information. 
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

    /**
     * @param usesAxis the usesAxis to set
     */
    public void setUsesAxis(List<CoordinateSystemAxisRefType> usesAxis) {
        this.usesAxis = usesAxis;
    }

    /**
     * Ordered sequence of associations to the coordinate system axes included in this coordinate system. Gets the value of the usesAxis property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usesAxis property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsesAxis().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CoordinateSystemAxisRefType }
     * 
     * 
     */
    public List<CoordinateSystemAxisRefType> getUsesAxis() {
        if (usesAxis == null) {
            setUsesAxis(new ArrayList<CoordinateSystemAxisRefType>());
        }
        return this.usesAxis;
    }

    @Override
    public String toString() {
        return "AbstractCoordinateSystemType{ " + "csID = " + csID
                + ", remarks = " + remarks + ", usesAxis = "
                + usesAxis + '}';
    }
}
