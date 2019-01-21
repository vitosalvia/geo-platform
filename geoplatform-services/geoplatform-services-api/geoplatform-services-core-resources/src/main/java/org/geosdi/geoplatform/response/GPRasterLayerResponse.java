package org.geosdi.geoplatform.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.geosdi.geoplatform.core.model.GPRasterLayer;

import javax.annotation.Nonnull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

import static com.google.common.base.Preconditions.checkArgument;
import static javax.annotation.meta.When.NEVER;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@Getter
@ToString
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class GPRasterLayerResponse implements Serializable {

    private static final long serialVersionUID = 7216996084094454511L;
    //
    @XmlElement(name = "rasterLayer")
    private GPRasterLayer rasterLayer;

    /**
     * @param theRasterLayer
     */
    @JsonCreator
    public GPRasterLayerResponse(@Nonnull(when = NEVER) @JsonProperty(value = "rasterLayer") GPRasterLayer theRasterLayer) {
        checkArgument(theRasterLayer != null, "The Parameter rasterLayer must not be null.");
        this.rasterLayer = theRasterLayer;
    }
}
