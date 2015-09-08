//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.7 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2015.08.25 alle 11:12:35 PM CEST 
//


package org.geosdi.geoplatform.xml.sld.v100;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/sld}BrightnessOnly" minOccurs="0"/>
 *         &lt;element ref="{http://www.opengis.net/sld}ReliefFactor" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "brightnessOnly",
    "reliefFactor"
})
@XmlRootElement(name = "ShadedRelief")
public class ShadedReliefElement
    implements ToString
{

    @XmlElement(name = "BrightnessOnly")
    protected Boolean brightnessOnly;
    @XmlElement(name = "ReliefFactor")
    protected Double reliefFactor;

    /**
     * Recupera il valore della proprietà brightnessOnly.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBrightnessOnly() {
        return brightnessOnly;
    }

    /**
     * Imposta il valore della proprietà brightnessOnly.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBrightnessOnly(Boolean value) {
        this.brightnessOnly = value;
    }

    public boolean isSetBrightnessOnly() {
        return (this.brightnessOnly!= null);
    }

    /**
     * Recupera il valore della proprietà reliefFactor.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getReliefFactor() {
        return reliefFactor;
    }

    /**
     * Imposta il valore della proprietà reliefFactor.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setReliefFactor(Double value) {
        this.reliefFactor = value;
    }

    public boolean isSetReliefFactor() {
        return (this.reliefFactor!= null);
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
            Boolean theBrightnessOnly;
            theBrightnessOnly = this.isBrightnessOnly();
            strategy.appendField(locator, this, "brightnessOnly", buffer, theBrightnessOnly);
        }
        {
            Double theReliefFactor;
            theReliefFactor = this.getReliefFactor();
            strategy.appendField(locator, this, "reliefFactor", buffer, theReliefFactor);
        }
        return buffer;
    }

}
