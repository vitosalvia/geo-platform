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
// Generated on: 2012.04.17 at 10:27:36 PM CEST 
//


package org.geosdi.geoplatform.xml.gml.v311;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * A non-abstract generic collection type that can be used as a document element for a collection of any GML types - Geometries, Topologies, Features ...
 * 
 * FeatureCollections may only contain Features.  GeometryCollections may only contain Geometrys.  Bags are less constrained  they must contain objects that are substitutable for gml:_Object.  This may mix several levels, including Features, Definitions, Dictionaries, Geometries etc.  
 * 
 * The content model would ideally be 
 *    member 0..*
 *    members 0..1
 *    member 0..*
 * for maximum flexibility in building a collection from both homogeneous and distinct components: 
 * included "member" elements each contain a single Object
 * an included "members" element contains a set of Objects 
 * 
 * However, this is non-deterministic, thus prohibited by XSD.
 * 
 * <p>Java class for BagType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BagType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractGMLType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/gml}member" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.opengis.net/gml}members" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BagType", propOrder = {
    "member",
    "members"
})
public class BagType
    extends AbstractGMLType
    implements ToString
{

    protected List<AssociationType> member;
    protected ArrayAssociationType members;

    /**
     * Gets the value of the member property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the member property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMember().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AssociationType }
     * 
     * 
     */
    public List<AssociationType> getMember() {
        if (member == null) {
            member = new ArrayList<AssociationType>();
        }
        return this.member;
    }

    public boolean isSetMember() {
        return ((this.member!= null)&&(!this.member.isEmpty()));
    }

    public void unsetMember() {
        this.member = null;
    }

    /**
     * Gets the value of the members property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayAssociationType }
     *     
     */
    public ArrayAssociationType getMembers() {
        return members;
    }

    /**
     * Sets the value of the members property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayAssociationType }
     *     
     */
    public void setMembers(ArrayAssociationType value) {
        this.members = value;
    }

    public boolean isSetMembers() {
        return (this.members!= null);
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
            List<AssociationType> theMember;
            theMember = (this.isSetMember()?this.getMember():null);
            strategy.appendField(locator, this, "member", buffer, theMember);
        }
        {
            ArrayAssociationType theMembers;
            theMembers = this.getMembers();
            strategy.appendField(locator, this, "members", buffer, theMembers);
        }
        return buffer;
    }

    public void setMember(List<AssociationType> value) {
        this.member = null;
        List<AssociationType> draftl = this.getMember();
        draftl.addAll(value);
    }

}
