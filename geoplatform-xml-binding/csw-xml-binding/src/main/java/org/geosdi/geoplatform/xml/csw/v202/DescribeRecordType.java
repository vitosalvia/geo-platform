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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * This request allows a user to discover elements of the
 *          information model supported by the catalogue. If no TypeName 
 *          elements are included, then all of the schemas for the 
 *          information model must be returned.
 *       
 *          schemaLanguage - preferred schema language
 *                           (W3C XML Schema by default)
 *          outputFormat - preferred output format (application/xml by default)
 * 
 * <p>Java class for DescribeRecordType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DescribeRecordType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/cat/csw/2.0.2}RequestBaseType">
 *       &lt;sequence>
 *         &lt;element name="TypeName" type="{http://www.w3.org/2001/XMLSchema}QName" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="outputFormat" type="{http://www.w3.org/2001/XMLSchema}string" default="application/xml" />
 *       &lt;attribute name="schemaLanguage" type="{http://www.w3.org/2001/XMLSchema}anyURI" default="http://www.w3.org/XML/Schema" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DescribeRecordType", propOrder = {
    "typeName"
})
public class DescribeRecordType
    extends RequestBaseType
    implements Serializable, ToString
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "TypeName")
    protected List<QName> typeName;
    @XmlAttribute(name = "outputFormat")
    protected String outputFormat;
    @XmlAttribute(name = "schemaLanguage")
    @XmlSchemaType(name = "anyURI")
    protected String schemaLanguage;

    /**
     * Gets the value of the typeName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the typeName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTypeName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QName }
     * 
     * 
     */
    public List<QName> getTypeName() {
        if (typeName == null) {
            typeName = new ArrayList<QName>();
        }
        return this.typeName;
    }

    /**
     * Gets the value of the outputFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutputFormat() {
        if (outputFormat == null) {
            return "application/xml";
        } else {
            return outputFormat;
        }
    }

    /**
     * Sets the value of the outputFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutputFormat(String value) {
        this.outputFormat = value;
    }

    /**
     * Gets the value of the schemaLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchemaLanguage() {
        if (schemaLanguage == null) {
            return "http://www.w3.org/XML/Schema";
        } else {
            return schemaLanguage;
        }
    }

    /**
     * Sets the value of the schemaLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchemaLanguage(String value) {
        this.schemaLanguage = value;
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
            List<QName> theTypeName;
            theTypeName = (((this.typeName!= null)&&(!this.typeName.isEmpty()))?this.getTypeName():null);
            strategy.appendField(locator, this, "typeName", buffer, theTypeName);
        }
        {
            String theOutputFormat;
            theOutputFormat = this.getOutputFormat();
            strategy.appendField(locator, this, "outputFormat", buffer, theOutputFormat);
        }
        {
            String theSchemaLanguage;
            theSchemaLanguage = this.getSchemaLanguage();
            strategy.appendField(locator, this, "schemaLanguage", buffer, theSchemaLanguage);
        }
        return buffer;
    }

    public void setTypeName(List<QName> value) {
        this.typeName = null;
        List<QName> draftl = this.getTypeName();
        draftl.addAll(value);
    }

}
