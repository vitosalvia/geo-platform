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


package org.geosdi.geoplatform.xml.iso19139.v20060504.src;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for SV_PlatformSpecificServiceSpecification_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SV_PlatformSpecificServiceSpecification_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.isotc211.org/2005/srv}SV_PlatformNeutralServiceSpecification_Type">
 *       &lt;sequence>
 *         &lt;element name="DCP" type="{http://www.isotc211.org/2005/srv}DCPList_PropertyType"/>
 *         &lt;element name="implementation" type="{http://www.isotc211.org/2005/srv}SV_Service_PropertyType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SV_PlatformSpecificServiceSpecification_Type", propOrder = {
    "dcp",
    "implementation"
})
public class SVPlatformSpecificServiceSpecificationType
    extends SVPlatformNeutralServiceSpecificationType
    implements ToString
{

    @XmlElement(name = "DCP", required = true)
    protected DCPListPropertyType dcp;
    @XmlElement(required = true)
    protected List<SVServicePropertyType> implementation;

    /**
     * Gets the value of the dcp property.
     * 
     * @return
     *     possible object is
     *     {@link DCPListPropertyType }
     *     
     */
    public DCPListPropertyType getDCP() {
        return dcp;
    }

    /**
     * Sets the value of the dcp property.
     * 
     * @param value
     *     allowed object is
     *     {@link DCPListPropertyType }
     *     
     */
    public void setDCP(DCPListPropertyType value) {
        this.dcp = value;
    }

    public boolean isSetDCP() {
        return (this.dcp!= null);
    }

    /**
     * Gets the value of the implementation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the implementation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImplementation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SVServicePropertyType }
     * 
     * 
     */
    public List<SVServicePropertyType> getImplementation() {
        if (implementation == null) {
            implementation = new ArrayList<SVServicePropertyType>();
        }
        return this.implementation;
    }

    public boolean isSetImplementation() {
        return ((this.implementation!= null)&&(!this.implementation.isEmpty()));
    }

    public void unsetImplementation() {
        this.implementation = null;
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
            DCPListPropertyType theDCP;
            theDCP = this.getDCP();
            strategy.appendField(locator, this, "dcp", buffer, theDCP);
        }
        {
            List<SVServicePropertyType> theImplementation;
            theImplementation = (this.isSetImplementation()?this.getImplementation():null);
            strategy.appendField(locator, this, "implementation", buffer, theImplementation);
        }
        return buffer;
    }

    public void setImplementation(List<SVServicePropertyType> value) {
        this.implementation = null;
        List<SVServicePropertyType> draftl = this.getImplementation();
        draftl.addAll(value);
    }

}
