//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.7 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2015.06.18 alle 12:52:42 AM CEST 
//


package org.geosdi.geoplatform.xml.gml.v320;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.CopyStrategy;
import org.jvnet.jaxb2_commons.lang.CopyTo;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBCopyStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBMergeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.MergeFrom;
import org.jvnet.jaxb2_commons.lang.MergeStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * <p>Classe Java per CompositeSolidType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="CompositeSolidType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractSolidType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/gml}solidMember" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.opengis.net/gml}AggregationAttributeGroup"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompositeSolidType", propOrder = {
    "solidMember"
})
public class CompositeSolidType
    extends AbstractSolidType
    implements Cloneable, CopyTo, Equals, HashCode, MergeFrom, ToString
{

    @XmlElement(required = true)
    protected List<SolidPropertyType> solidMember;
    @XmlAttribute(name = "aggregationType")
    protected AggregationType aggregationType;

    /**
     * Gets the value of the solidMember property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the solidMember property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSolidMember().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SolidPropertyType }
     * 
     * 
     */
    public List<SolidPropertyType> getSolidMember() {
        if (solidMember == null) {
            solidMember = new ArrayList<SolidPropertyType>();
        }
        return this.solidMember;
    }

    public boolean isSetSolidMember() {
        return ((this.solidMember!= null)&&(!this.solidMember.isEmpty()));
    }

    public void unsetSolidMember() {
        this.solidMember = null;
    }

    /**
     * Recupera il valore della proprietà aggregationType.
     * 
     * @return
     *     possible object is
     *     {@link AggregationType }
     *     
     */
    public AggregationType getAggregationType() {
        return aggregationType;
    }

    /**
     * Imposta il valore della proprietà aggregationType.
     * 
     * @param value
     *     allowed object is
     *     {@link AggregationType }
     *     
     */
    public void setAggregationType(AggregationType value) {
        this.aggregationType = value;
    }

    public boolean isSetAggregationType() {
        return (this.aggregationType!= null);
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
            List<SolidPropertyType> theSolidMember;
            theSolidMember = this.getSolidMember();
            strategy.appendField(locator, this, "solidMember", buffer, theSolidMember);
        }
        {
            AggregationType theAggregationType;
            theAggregationType = this.getAggregationType();
            strategy.appendField(locator, this, "aggregationType", buffer, theAggregationType);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof CompositeSolidType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final CompositeSolidType that = ((CompositeSolidType) object);
        {
            List<SolidPropertyType> lhsSolidMember;
            lhsSolidMember = this.getSolidMember();
            List<SolidPropertyType> rhsSolidMember;
            rhsSolidMember = that.getSolidMember();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "solidMember", lhsSolidMember), LocatorUtils.property(thatLocator, "solidMember", rhsSolidMember), lhsSolidMember, rhsSolidMember)) {
                return false;
            }
        }
        {
            AggregationType lhsAggregationType;
            lhsAggregationType = this.getAggregationType();
            AggregationType rhsAggregationType;
            rhsAggregationType = that.getAggregationType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "aggregationType", lhsAggregationType), LocatorUtils.property(thatLocator, "aggregationType", rhsAggregationType), lhsAggregationType, rhsAggregationType)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
        {
            List<SolidPropertyType> theSolidMember;
            theSolidMember = this.getSolidMember();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "solidMember", theSolidMember), currentHashCode, theSolidMember);
        }
        {
            AggregationType theAggregationType;
            theAggregationType = this.getAggregationType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "aggregationType", theAggregationType), currentHashCode, theAggregationType);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public Object clone() {
        return copyTo(createNewInstance());
    }

    public Object copyTo(Object target) {
        final CopyStrategy strategy = JAXBCopyStrategy.INSTANCE;
        return copyTo(null, target, strategy);
    }

    public Object copyTo(ObjectLocator locator, Object target, CopyStrategy strategy) {
        final Object draftCopy = ((target == null)?createNewInstance():target);
        super.copyTo(locator, draftCopy, strategy);
        if (draftCopy instanceof CompositeSolidType) {
            final CompositeSolidType copy = ((CompositeSolidType) draftCopy);
            if (this.isSetSolidMember()) {
                List<SolidPropertyType> sourceSolidMember;
                sourceSolidMember = this.getSolidMember();
                @SuppressWarnings("unchecked")
                List<SolidPropertyType> copySolidMember = ((List<SolidPropertyType> ) strategy.copy(LocatorUtils.property(locator, "solidMember", sourceSolidMember), sourceSolidMember));
                copy.unsetSolidMember();
                List<SolidPropertyType> uniqueSolidMemberl = copy.getSolidMember();
                uniqueSolidMemberl.addAll(copySolidMember);
            } else {
                copy.unsetSolidMember();
            }
            if (this.isSetAggregationType()) {
                AggregationType sourceAggregationType;
                sourceAggregationType = this.getAggregationType();
                AggregationType copyAggregationType = ((AggregationType) strategy.copy(LocatorUtils.property(locator, "aggregationType", sourceAggregationType), sourceAggregationType));
                copy.setAggregationType(copyAggregationType);
            } else {
                copy.aggregationType = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new CompositeSolidType();
    }

    public void mergeFrom(Object left, Object right) {
        final MergeStrategy strategy = JAXBMergeStrategy.INSTANCE;
        mergeFrom(null, null, left, right, strategy);
    }

    public void mergeFrom(ObjectLocator leftLocator, ObjectLocator rightLocator, Object left, Object right, MergeStrategy strategy) {
        super.mergeFrom(leftLocator, rightLocator, left, right, strategy);
        if (right instanceof CompositeSolidType) {
            final CompositeSolidType target = this;
            final CompositeSolidType leftObject = ((CompositeSolidType) left);
            final CompositeSolidType rightObject = ((CompositeSolidType) right);
            {
                List<SolidPropertyType> lhsSolidMember;
                lhsSolidMember = leftObject.getSolidMember();
                List<SolidPropertyType> rhsSolidMember;
                rhsSolidMember = rightObject.getSolidMember();
                target.unsetSolidMember();
                List<SolidPropertyType> uniqueSolidMemberl = target.getSolidMember();
                uniqueSolidMemberl.addAll(((List<SolidPropertyType> ) strategy.merge(LocatorUtils.property(leftLocator, "solidMember", lhsSolidMember), LocatorUtils.property(rightLocator, "solidMember", rhsSolidMember), lhsSolidMember, rhsSolidMember)));
            }
            {
                AggregationType lhsAggregationType;
                lhsAggregationType = leftObject.getAggregationType();
                AggregationType rhsAggregationType;
                rhsAggregationType = rightObject.getAggregationType();
                target.setAggregationType(((AggregationType) strategy.merge(LocatorUtils.property(leftLocator, "aggregationType", lhsAggregationType), LocatorUtils.property(rightLocator, "aggregationType", rhsAggregationType), lhsAggregationType, rhsAggregationType)));
            }
        }
    }

    public void setSolidMember(List<SolidPropertyType> value) {
        List<SolidPropertyType> draftl = this.getSolidMember();
        draftl.addAll(value);
    }

    public CompositeSolidType withSolidMember(SolidPropertyType... values) {
        if (values!= null) {
            for (SolidPropertyType value: values) {
                getSolidMember().add(value);
            }
        }
        return this;
    }

    public CompositeSolidType withSolidMember(Collection<SolidPropertyType> values) {
        if (values!= null) {
            getSolidMember().addAll(values);
        }
        return this;
    }

    public CompositeSolidType withAggregationType(AggregationType value) {
        setAggregationType(value);
        return this;
    }

    public CompositeSolidType withSolidMember(List<SolidPropertyType> value) {
        setSolidMember(value);
        return this;
    }

    @Override
    public CompositeSolidType withSrsName(String value) {
        setSrsName(value);
        return this;
    }

    @Override
    public CompositeSolidType withSrsDimension(BigInteger value) {
        setSrsDimension(value);
        return this;
    }

    @Override
    public CompositeSolidType withAxisLabels(String... values) {
        if (values!= null) {
            for (String value: values) {
                getAxisLabels().add(value);
            }
        }
        return this;
    }

    @Override
    public CompositeSolidType withAxisLabels(Collection<String> values) {
        if (values!= null) {
            getAxisLabels().addAll(values);
        }
        return this;
    }

    @Override
    public CompositeSolidType withUomLabels(String... values) {
        if (values!= null) {
            for (String value: values) {
                getUomLabels().add(value);
            }
        }
        return this;
    }

    @Override
    public CompositeSolidType withUomLabels(Collection<String> values) {
        if (values!= null) {
            getUomLabels().addAll(values);
        }
        return this;
    }

    @Override
    public CompositeSolidType withAxisLabels(List<String> value) {
        setAxisLabels(value);
        return this;
    }

    @Override
    public CompositeSolidType withUomLabels(List<String> value) {
        setUomLabels(value);
        return this;
    }

    @Override
    public CompositeSolidType withMetaDataProperty(MetaDataPropertyType... values) {
        if (values!= null) {
            for (MetaDataPropertyType value: values) {
                getMetaDataProperty().add(value);
            }
        }
        return this;
    }

    @Override
    public CompositeSolidType withMetaDataProperty(Collection<MetaDataPropertyType> values) {
        if (values!= null) {
            getMetaDataProperty().addAll(values);
        }
        return this;
    }

    @Override
    public CompositeSolidType withDescription(StringOrRefType value) {
        setDescription(value);
        return this;
    }

    @Override
    public CompositeSolidType withDescriptionReference(ReferenceType value) {
        setDescriptionReference(value);
        return this;
    }

    @Override
    public CompositeSolidType withIdentifier(CodeWithAuthorityType value) {
        setIdentifier(value);
        return this;
    }

    @Override
    public CompositeSolidType withName(CodeType... values) {
        if (values!= null) {
            for (CodeType value: values) {
                getName().add(value);
            }
        }
        return this;
    }

    @Override
    public CompositeSolidType withName(Collection<CodeType> values) {
        if (values!= null) {
            getName().addAll(values);
        }
        return this;
    }

    @Override
    public CompositeSolidType withId(String value) {
        setId(value);
        return this;
    }

    @Override
    public CompositeSolidType withMetaDataProperty(List<MetaDataPropertyType> value) {
        setMetaDataProperty(value);
        return this;
    }

    @Override
    public CompositeSolidType withName(List<CodeType> value) {
        setName(value);
        return this;
    }

}