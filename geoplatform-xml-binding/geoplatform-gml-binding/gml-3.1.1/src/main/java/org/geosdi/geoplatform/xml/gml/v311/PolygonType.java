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
// Generated on: 2012.04.17 at 10:27:36 PM CEST 
//
package org.geosdi.geoplatform.xml.gml.v311;

import org.geosdi.geoplatform.gml.api.AbstractRingProperty;
import org.geosdi.geoplatform.gml.api.Polygon;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A Polygon is a special surface that is defined by a single surface patch. The
 * boundary of this patch is coplanar and the polygon uses planar interpolation
 * in its interior. It is backwards compatible with the Polygon of GML 2,
 * GM_Polygon of ISO 19107 is implemented by PolygonPatch.
 *
 * <p>Java class for PolygonType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained
 * within this class.
 *
 * <pre>
 * &lt;complexType name="PolygonType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractSurfaceType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/gml}exterior" minOccurs="0"/>
 *         &lt;element ref="{http://www.opengis.net/gml}interior" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlRootElement(name = "Polygon")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PolygonType", propOrder = {
        "exterior",
        "interior"
})
public class PolygonType extends AbstractSurfaceType implements ToString, Polygon {

    @XmlElementRef(name = "exterior", namespace = "http://www.opengis.net/gml",
            type = JAXBElement.class)
    protected JAXBElement<AbstractRingPropertyType> exterior;
    @XmlElementRef(name = "interior", namespace = "http://www.opengis.net/gml",
            type = JAXBElement.class)
    protected List<JAXBElement<AbstractRingPropertyType>> interior;

    /**
     * Gets the value of the exterior property.
     *
     * @return possible object is null null null null null null null null null
     * null null null null null     {@link JAXBElement }{@code <}{@link AbstractRingPropertyType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractRingPropertyType }{@code >}
     *
     */
    public JAXBElement<AbstractRingPropertyType> getExterior() {
        return exterior;
    }

    /**
     * Sets the value of the exterior property.
     *
     * @param value allowed object is null null null null null null null null
     * null null null null null null     {@link JAXBElement }{@code <}{@link AbstractRingPropertyType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractRingPropertyType }{@code >}
     *
     */
    public void setExterior(JAXBElement<AbstractRingPropertyType> value) {
        this.exterior = value;
    }

    @Override
    public void setExteriorValue(
            JAXBElement<? extends AbstractRingProperty> value) {
        this.exterior = new JAXBElement<AbstractRingPropertyType>(
                value.getName(),
                (Class<AbstractRingPropertyType>) value.getDeclaredType(),
                (AbstractRingPropertyType) value.getValue());
    }

    @Override
    public boolean isSetExterior() {
        return (this.exterior != null);
    }

    /**
     * Gets the value of the interior property.
     *
     * <p> This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the interior property.
     *
     * <p> For example, to add a new item, do as follows:
     * <pre>
     *    getInterior().add(newItem);
     * </pre>
     *
     *
     * <p> Objects of the following type(s) are allowed in the list null null
     * null null null null null null null null null null null null     {@link JAXBElement }{@code <}{@link AbstractRingPropertyType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractRingPropertyType }{@code >}
     *
     *
     */
    public List<JAXBElement<AbstractRingPropertyType>> getInterior() {
        if (interior == null) {
            interior = new ArrayList<JAXBElement<AbstractRingPropertyType>>();
        }
        return this.interior;
    }

    @Override
    public void addInteriorValue(
            JAXBElement<? extends AbstractRingProperty> value) {
        getInterior().add(new JAXBElement<AbstractRingPropertyType>(
                value.getName(),
                (Class<AbstractRingPropertyType>) value.getDeclaredType(),
                (AbstractRingPropertyType) value.getValue()));
    }

    @Override
    public boolean isSetInterior() {
        return ((this.interior != null) && (!this.interior.isEmpty()));
    }

    public void unsetInterior() {
        this.interior = null;
    }

    @Override
    public List<AbstractRingProperty> getInteriorValues() {
        List<AbstractRingProperty> interiorValues = new ArrayList<AbstractRingProperty>();

        if (isSetInterior()) {
            for (JAXBElement<AbstractRingPropertyType> element : interior) {
                AbstractRingProperty abstractRing = element.getValue();
                interiorValues.add(abstractRing);
            }
        }
        return interiorValues;
    }

    @Override
    public AbstractRingProperty getExteriorValue() {
        return isSetExterior() ? exterior.getValue() : null;
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
            JAXBElement<AbstractRingPropertyType> theExterior;
            theExterior = this.getExterior();
            strategy.appendField(locator, this, "exterior", buffer, theExterior);
        }
        {
            List<JAXBElement<AbstractRingPropertyType>> theInterior;
            theInterior = (this.isSetInterior() ? this.getInterior() : null);
            strategy.appendField(locator, this, "interior", buffer, theInterior);
        }
        return buffer;
    }

    public void setInterior(List<JAXBElement<AbstractRingPropertyType>> value) {
        this.interior = null;
        List<JAXBElement<AbstractRingPropertyType>> draftl = this.getInterior();
        draftl.addAll(value);
    }
}
