/**
 *
 *    geo-platform
 *    Rich webgis framework
 *    http://geo-platform.org
 *   ====================================================================
 *
 *   Copyright (C) 2008-2016 geoSDI Group (CNR IMAA - Potenza - ITALY).
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
// Generated on: 2012.04.18 at 10:59:48 AM CEST 
//


package org.geosdi.geoplatform.xml.filter.v110;

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
 * <p>Java class for UnaryLogicOpType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UnaryLogicOpType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/ogc}LogicOpsType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element ref="{http://www.opengis.net/ogc}comparisonOps"/>
 *           &lt;element ref="{http://www.opengis.net/ogc}spatialOps"/>
 *           &lt;element ref="{http://www.opengis.net/ogc}logicOps"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UnaryLogicOpType", propOrder = {
    "comparisonOps",
    "spatialOps",
    "logicOps"
})
public class UnaryLogicOpType
    extends LogicOpsType
    implements ToString
{

    @XmlElementRef(name = "comparisonOps", namespace = "http://www.opengis.net/ogc", type = JAXBElement.class)
    protected JAXBElement<? extends ComparisonOpsType> comparisonOps;
    @XmlElementRef(name = "spatialOps", namespace = "http://www.opengis.net/ogc", type = JAXBElement.class)
    protected JAXBElement<? extends SpatialOpsType> spatialOps;
    @XmlElementRef(name = "logicOps", namespace = "http://www.opengis.net/ogc", type = JAXBElement.class)
    protected JAXBElement<? extends LogicOpsType> logicOps;

    /**
     * Gets the value of the comparisonOps property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PropertyIsNullType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinaryComparisonOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinaryComparisonOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinaryComparisonOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinaryComparisonOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ComparisonOpsType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PropertyIsBetweenType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinaryComparisonOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinaryComparisonOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PropertyIsLikeType }{@code >}
     *     
     */
    public JAXBElement<? extends ComparisonOpsType> getComparisonOps() {
        return comparisonOps;
    }

    /**
     * Sets the value of the comparisonOps property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PropertyIsNullType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinaryComparisonOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinaryComparisonOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinaryComparisonOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinaryComparisonOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ComparisonOpsType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PropertyIsBetweenType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinaryComparisonOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinaryComparisonOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PropertyIsLikeType }{@code >}
     *     
     */
    public void setComparisonOps(JAXBElement<? extends ComparisonOpsType> value) {
        this.comparisonOps = value;
    }

    public boolean isSetComparisonOps() {
        return (this.comparisonOps!= null);
    }

    /**
     * Gets the value of the spatialOps property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BinarySpatialOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinarySpatialOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BBOXType }{@code >}
     *     {@link JAXBElement }{@code <}{@link SpatialOpsType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinarySpatialOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinarySpatialOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinarySpatialOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinarySpatialOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DistanceBufferType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinarySpatialOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DistanceBufferType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinarySpatialOpType }{@code >}
     *     
     */
    public JAXBElement<? extends SpatialOpsType> getSpatialOps() {
        return spatialOps;
    }

    /**
     * Sets the value of the spatialOps property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BinarySpatialOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinarySpatialOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BBOXType }{@code >}
     *     {@link JAXBElement }{@code <}{@link SpatialOpsType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinarySpatialOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinarySpatialOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinarySpatialOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinarySpatialOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DistanceBufferType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinarySpatialOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DistanceBufferType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinarySpatialOpType }{@code >}
     *     
     */
    public void setSpatialOps(JAXBElement<? extends SpatialOpsType> value) {
        this.spatialOps = value;
    }

    public boolean isSetSpatialOps() {
        return (this.spatialOps!= null);
    }

    /**
     * Gets the value of the logicOps property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BinaryLogicOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link UnaryLogicOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinaryLogicOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LogicOpsType }{@code >}
     *     
     */
    public JAXBElement<? extends LogicOpsType> getLogicOps() {
        return logicOps;
    }

    /**
     * Sets the value of the logicOps property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BinaryLogicOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link UnaryLogicOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BinaryLogicOpType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LogicOpsType }{@code >}
     *     
     */
    public void setLogicOps(JAXBElement<? extends LogicOpsType> value) {
        this.logicOps = value;
    }

    public boolean isSetLogicOps() {
        return (this.logicOps!= null);
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
            JAXBElement<? extends ComparisonOpsType> theComparisonOps;
            theComparisonOps = this.getComparisonOps();
            strategy.appendField(locator, this, "comparisonOps", buffer, theComparisonOps);
        }
        {
            JAXBElement<? extends SpatialOpsType> theSpatialOps;
            theSpatialOps = this.getSpatialOps();
            strategy.appendField(locator, this, "spatialOps", buffer, theSpatialOps);
        }
        {
            JAXBElement<? extends LogicOpsType> theLogicOps;
            theLogicOps = this.getLogicOps();
            strategy.appendField(locator, this, "logicOps", buffer, theLogicOps);
        }
        return buffer;
    }

}
