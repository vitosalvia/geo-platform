/**
 *
 *    geo-platform
 *    Rich webgis framework
 *    http://geo-platform.org
 *   ====================================================================
 *
 *   Copyright (C) 2008-2021 geoSDI Group (CNR IMAA - Potenza - ITALY).
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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * Exends GridFunctionType with a lookUpTable.  This contains a list of indexes of members within the rangeSet corresponding with the members of the domainSet.  The domainSet is traversed in list order if it is enumerated explicitly, or in the order specified by a SequenceRule if the domain is an implicit set.    The length of the lookUpTable corresponds with the length of the subset of the domainSet for which the coverage is defined.
 * 
 * <p>Java class for IndexMapType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IndexMapType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}GridFunctionType">
 *       &lt;sequence>
 *         &lt;element name="lookUpTable" type="{http://www.opengis.net/gml}integerList"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndexMapType", propOrder = {
    "lookUpTable"
})
public class IndexMapType
    extends GridFunctionType
    implements ToString
{

    @XmlList
    @XmlElement(required = true)
    protected List<BigInteger> lookUpTable;

    /**
     * Gets the value of the lookUpTable property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lookUpTable property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLookUpTable().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BigInteger }
     * 
     * 
     */
    public List<BigInteger> getLookUpTable() {
        if (lookUpTable == null) {
            lookUpTable = new ArrayList<BigInteger>();
        }
        return this.lookUpTable;
    }

    public boolean isSetLookUpTable() {
        return ((this.lookUpTable!= null)&&(!this.lookUpTable.isEmpty()));
    }

    public void unsetLookUpTable() {
        this.lookUpTable = null;
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
            List<BigInteger> theLookUpTable;
            theLookUpTable = (this.isSetLookUpTable()?this.getLookUpTable():null);
            strategy.appendField(locator, this, "lookUpTable", buffer, theLookUpTable);
        }
        return buffer;
    }

    public void setLookUpTable(List<BigInteger> value) {
        this.lookUpTable = null;
        List<BigInteger> draftl = this.getLookUpTable();
        draftl.addAll(value);
    }

}
