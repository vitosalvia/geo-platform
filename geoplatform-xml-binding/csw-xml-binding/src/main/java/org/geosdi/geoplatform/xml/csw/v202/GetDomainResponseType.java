//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.12 at 10:02:34 AM CEST 
//


package org.geosdi.geoplatform.xml.csw.v202;

import java.io.Serializable;
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
 * Returns the actual values for some property. In general this is a
 *          subset of the value domain (that is, set of permissible values),
 *          although in some cases these may be the same.
 * 
 * <p>Java class for GetDomainResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetDomainResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DomainValues" type="{http://www.opengis.net/cat/csw/2.0.2}DomainValuesType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetDomainResponseType", propOrder = {
    "domainValues"
})
public class GetDomainResponseType
    implements Serializable, ToString
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "DomainValues", required = true)
    protected List<DomainValuesType> domainValues;

    /**
     * Gets the value of the domainValues property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the domainValues property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDomainValues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DomainValuesType }
     * 
     * 
     */
    public List<DomainValuesType> getDomainValues() {
        if (domainValues == null) {
            domainValues = new ArrayList<DomainValuesType>();
        }
        return this.domainValues;
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
            List<DomainValuesType> theDomainValues;
            theDomainValues = (((this.domainValues!= null)&&(!this.domainValues.isEmpty()))?this.getDomainValues():null);
            strategy.appendField(locator, this, "domainValues", buffer, theDomainValues);
        }
        return buffer;
    }

    public void setDomainValues(List<DomainValuesType> value) {
        this.domainValues = null;
        List<DomainValuesType> draftl = this.getDomainValues();
        draftl.addAll(value);
    }

}
