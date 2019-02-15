package org.geosdi.geoplatform.connector.geoserver.model.bbox;

import lombok.Getter;
import lombok.ToString;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@Getter
@ToString
public abstract class GPGeoserverBoundingBox<CRS extends Object> implements IGPGeoserverBoundingBox<CRS> {

    private static final long serialVersionUID = 2844724464394541360L;
    //
    private Double maxx;
    private Double maxy;
    private Double minx;
    private Double miny;
}