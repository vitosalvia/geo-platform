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
package org.geosdi.geoplatform.support.jackson.jts.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.geojson.GeoJsonObject;
import org.geosdi.geoplatform.support.jackson.jts.deserializer.geometry.writer.bridge.implementor.JTSGeometryWriterImplementor;
import org.locationtech.jts.geom.Geometry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.geosdi.geoplatform.support.jackson.jts.deserializer.geometry.writer.bridge.implementor.JTSGeometryWriterImplementor.JTSGeometryWriterImplementorKey.forClass;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
abstract class GPJTSDeserializer<JTS extends Geometry, GEOJSON extends GeoJsonObject> extends JsonDeserializer<JTS>
        implements IGPJTSDeserializer<JTS> {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public JTS deserialize(JsonParser p, DeserializationContext ctxt) throws IOException,
            JsonProcessingException {
        ObjectCodec objectCodec = p.getCodec();
        logger.debug(":::::::::::::::::::::::::::::Called {}\n", this.getDeserializerName());
        GeoJsonObject geoJsonObject = objectCodec.readValue(p, GeoJsonObject.class);
        if (!canParseGeometry(geoJsonObject))
            throw new IllegalStateException(this.getDeserializerName() + " can't parse GeoJson Geometry " +
                    geoJsonObject);
        return parseGeometry(geoJsonObject);
    }

    /**
     * @param geoJsonObject
     * @return {@link JTSGeometryWriterImplementor}
     * @throws Exception
     */
    protected JTSGeometryWriterImplementor<GEOJSON, JTS> getJTSGeometryImplementorWriter(GeoJsonObject geoJsonObject)
            throws Exception {
        return (JTSGeometryWriterImplementor<GEOJSON, JTS>) JTS_GEOMETRY_WRITER_IMPLEMENTOR_STORE.getImplementorByKey(forClass(geoJsonObject.getClass()));
    }
}
