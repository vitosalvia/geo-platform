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
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2019.03.07 alle 09:04:14 AM CET 
//


package org.geosdi.geoplatform.xml.filter.v110;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Classe Java per ArithmeticOperatorsType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ArithmeticOperatorsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice maxOccurs="unbounded"&gt;
 *         &lt;element ref="{http://www.opengis.net/ogc}SimpleArithmetic"/&gt;
 *         &lt;element name="Functions" type="{http://www.opengis.net/ogc}FunctionsType"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArithmeticOperatorsType", propOrder = {
    "simpleArithmeticOrFunctions"
})
public class ArithmeticOperatorsType implements ToString2
{

    @XmlElements({
        @XmlElement(name = "SimpleArithmetic", type = SimpleArithmetic.class),
        @XmlElement(name = "Functions", type = FunctionsType.class)
    })
    protected List<Object> simpleArithmeticOrFunctions;

    /**
     * Gets the value of the simpleArithmeticOrFunctions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the simpleArithmeticOrFunctions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSimpleArithmeticOrFunctions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SimpleArithmetic }
     * {@link FunctionsType }
     * 
     * 
     */
    public List<Object> getSimpleArithmeticOrFunctions() {
        if (simpleArithmeticOrFunctions == null) {
            simpleArithmeticOrFunctions = new ArrayList<Object>();
        }
        return this.simpleArithmeticOrFunctions;
    }

    public boolean isSetSimpleArithmeticOrFunctions() {
        return ((this.simpleArithmeticOrFunctions!= null)&&(!this.simpleArithmeticOrFunctions.isEmpty()));
    }

    public void unsetSimpleArithmeticOrFunctions() {
        this.simpleArithmeticOrFunctions = null;
    }

    public String toString() {
        final ToStringStrategy2 strategy = JAXBToStringStrategy.INSTANCE2;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
        {
            List<Object> theSimpleArithmeticOrFunctions;
            theSimpleArithmeticOrFunctions = (this.isSetSimpleArithmeticOrFunctions()?this.getSimpleArithmeticOrFunctions():null);
            strategy.appendField(locator, this, "simpleArithmeticOrFunctions", buffer, theSimpleArithmeticOrFunctions, this.isSetSimpleArithmeticOrFunctions());
        }
        return buffer;
    }

    public void setSimpleArithmeticOrFunctions(List<Object> value) {
        this.simpleArithmeticOrFunctions = null;
        if (value!= null) {
            List<Object> draftl = this.getSimpleArithmeticOrFunctions();
            draftl.addAll(value);
        }
    }

}
