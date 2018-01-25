/**
 *
 *    geo-platform
 *    Rich webgis framework
 *    http://geo-platform.org
 *   ====================================================================
 *
 *   Copyright (C) 2008-2018 geoSDI Group (CNR IMAA - Potenza - ITALY).
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
package org.geosdi.geoplatform.gui.client.widget.baselayer.factory;

import com.google.common.collect.Lists;
import org.geosdi.geoplatform.gui.client.widget.baselayer.factory.adapater.MapBaseLayerAdapter;
import org.geosdi.geoplatform.gui.client.widget.baselayer.model.GPBaseLayer;
import org.geosdi.geoplatform.gui.factory.baselayer.GPBaseLayerCreator;
import org.geosdi.geoplatform.gui.factory.baselayer.GPBaseLayerFactory;
import org.geosdi.geoplatform.gui.global.baselayer.GPBaseLayerValue;
import org.geosdi.geoplatform.gui.global.enumeration.BaseLayerValue;
import org.gwtopenmaps.openlayers.client.layer.Layer;

import java.util.List;

/**
 * @author Nazzareno Sileno - CNR IMAA geoSDI Group
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 *
 * @email nazzareno.sileno@geosdi.org
 * @email giuseppe.lascaleia@geosdi.org
 */
public class GPMapBaseLayerFactory {

    private static final GPBaseLayerFactory BASE_LAYER_FACTORY = new GPBaseLayerFactory();
    private static final MapBaseLayerAdapter MAP_BASE_LAYER_ADAPTER = new MapBaseLayerAdapter();

    public static List<GPBaseLayer> getBaseLayerList() {
        return Lists.<GPBaseLayer>newArrayList(MAP_BASE_LAYER_ADAPTER
                .adapt(BASE_LAYER_FACTORY.lookupBaseLayers()).values());
    }

    public static GPBaseLayer getGPBaseLayer(BaseLayerValue baseLayerEnum) {
        Layer layer = BASE_LAYER_FACTORY.findBaseLayer(baseLayerEnum);
        return (layer != null) ? MAP_BASE_LAYER_ADAPTER.adaptBaseLayer(baseLayerEnum, layer) : null;
    }

    public static void registerBaseLayer(GPBaseLayerValue value, GPBaseLayerCreator layerCreator) {
        BASE_LAYER_FACTORY.registerBaseLayer(value, layerCreator);
    }

    public static void removeBaseLayer(GPBaseLayerValue value) {
        BASE_LAYER_FACTORY.removeBaseLayer(value);
    }
}
