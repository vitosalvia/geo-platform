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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * A geodetic datum defines the precise location and orientation in 3-dimensional space of a defined ellipsoid (or sphere) that approximates the shape of the earth, or of a Cartesian coordinate system centered in this ellipsoid (or sphere). 
 * 
 * <p>Java class for GeodeticDatumType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeodeticDatumType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractDatumType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/gml}usesPrimeMeridian"/>
 *         &lt;element ref="{http://www.opengis.net/gml}usesEllipsoid"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeodeticDatumType", propOrder = {
    "usesPrimeMeridian",
    "usesEllipsoid"
})
public class GeodeticDatumType
    extends AbstractDatumType
    implements ToString
{

    @XmlElement(required = true)
    protected PrimeMeridianRefType usesPrimeMeridian;
    @XmlElement(required = true)
    protected EllipsoidRefType usesEllipsoid;

    /**
     * Gets the value of the usesPrimeMeridian property.
     * 
     * @return
     *     possible object is
     *     {@link PrimeMeridianRefType }
     *     
     */
    public PrimeMeridianRefType getUsesPrimeMeridian() {
        return usesPrimeMeridian;
    }

    /**
     * Sets the value of the usesPrimeMeridian property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrimeMeridianRefType }
     *     
     */
    public void setUsesPrimeMeridian(PrimeMeridianRefType value) {
        this.usesPrimeMeridian = value;
    }

    public boolean isSetUsesPrimeMeridian() {
        return (this.usesPrimeMeridian!= null);
    }

    /**
     * Gets the value of the usesEllipsoid property.
     * 
     * @return
     *     possible object is
     *     {@link EllipsoidRefType }
     *     
     */
    public EllipsoidRefType getUsesEllipsoid() {
        return usesEllipsoid;
    }

    /**
     * Sets the value of the usesEllipsoid property.
     * 
     * @param value
     *     allowed object is
     *     {@link EllipsoidRefType }
     *     
     */
    public void setUsesEllipsoid(EllipsoidRefType value) {
        this.usesEllipsoid = value;
    }

    public boolean isSetUsesEllipsoid() {
        return (this.usesEllipsoid!= null);
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
            PrimeMeridianRefType theUsesPrimeMeridian;
            theUsesPrimeMeridian = this.getUsesPrimeMeridian();
            strategy.appendField(locator, this, "usesPrimeMeridian", buffer, theUsesPrimeMeridian);
        }
        {
            EllipsoidRefType theUsesEllipsoid;
            theUsesEllipsoid = this.getUsesEllipsoid();
            strategy.appendField(locator, this, "usesEllipsoid", buffer, theUsesEllipsoid);
        }
        return buffer;
    }

}
