package org.geosdi.geoplatform.services.builder;

import com.google.common.collect.Lists;
import org.geosdi.geoplatform.core.model.GPBBox;
import org.geosdi.geoplatform.core.model.GPLayerInfo;
import org.geosdi.geoplatform.response.RasterLayerDTO;
import org.geotools.ows.wms.CRSEnvelope;
import org.geotools.ows.wms.Layer;
import org.geotools.ows.wms.StyleImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;
import static javax.annotation.meta.When.NEVER;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public interface GPRasterLayerDTOBuilder extends Serializable {

    /**
     * @param layer
     * @param urlServer
     * @return {@link List<RasterLayerDTO>}
     * @throws Exception
     */
    List<RasterLayerDTO> convertToLayerList(@Nonnull(when = NEVER) Layer layer, @Nonnull(when = NEVER) String urlServer) throws Exception;

    class RasterLayerDTOBuilder implements GPRasterLayerDTOBuilder {

        private static final Logger logger = LoggerFactory.getLogger(GPRasterLayerDTOBuilder.class);
        //
        private final static String EPSG_4326 = "EPSG:4326";
        private final static String EPSG_3857 = "EPSG:3857";
        private final static String EPSG_GOOGLE = "EPSG:900913";
        protected static final String GEB = "earthbuilder.google.com";

        /**
         * @param layer
         * @param urlServer
         * @return {@link List<RasterLayerDTO>}
         * @throws Exception
         */
        @Override
        public List<RasterLayerDTO> convertToLayerList(@Nonnull(when = NEVER) Layer layer, @Nonnull(when = NEVER) String urlServer) throws Exception {
            checkArgument(layer != null, "The Parameter layer must not be null.");
            checkArgument((urlServer != null) && !(urlServer.trim().isEmpty()), "The Parameter urlServer must not be null or an empty string.");
            List<RasterLayerDTO> shortLayers = Lists.newArrayList();
            RasterLayerDTO raster = this.getRasterAndSubRaster(layer, layer, urlServer);
            shortLayers.add(raster);
            return shortLayers;
        }

        /**
         * @param ancestorLayer
         * @param layer
         * @param urlServer
         * @return {@link RasterLayerDTO}
         */
        private RasterLayerDTO getRasterAndSubRaster(Layer ancestorLayer, Layer layer, String urlServer) {
            RasterLayerDTO raster = this.convertLayerToRaster(ancestorLayer, layer, urlServer);
            List<Layer> subLayerList = layer.getLayerChildren();
            List<RasterLayerDTO> subRasterList = Lists.<RasterLayerDTO>newArrayListWithExpectedSize(subLayerList.size());
            raster.setSubLayerList(subRasterList);
            // ADD subRaster
            for (Layer layerIth : subLayerList) {
                RasterLayerDTO rasterIth = this.getRasterAndSubRaster(ancestorLayer, layerIth, urlServer);
                subRasterList.add(rasterIth);
            }
            return raster;
        }

        /**
         * @param ancestorLayer
         * @param layer
         * @param urlServer
         * @return {@link RasterLayerDTO}
         */
        private RasterLayerDTO convertLayerToRaster(Layer ancestorLayer, Layer layer, String urlServer) {
            RasterLayerDTO raster = new RasterLayerDTO();
            raster.setUrlServer(this.getUrlServer(urlServer));
            raster.setName(layer.getName());
            raster.setAbstractText(layer.get_abstract());
            if (layer.getTitle() == null || layer.getTitle().trim().equals("")) {
                raster.setTitle(layer.getName());
            } else {
                raster.setTitle(layer.getTitle());
            }
            Map<String, CRSEnvelope> additionalBounds = layer.getBoundingBoxes();
            logger.debug("ADDITIONAL BOUNDS ############################### {}", additionalBounds.toString());
            if (!additionalBounds.isEmpty()) {
                if (additionalBounds.containsKey(EPSG_GOOGLE)
                        || additionalBounds.containsKey(EPSG_3857)) {
                    CRSEnvelope env = additionalBounds
                            .get(EPSG_GOOGLE);
                    if (env == null) {
                        env = additionalBounds.get(EPSG_3857);
                    }
                    raster.setBbox(this.createBbox(env));
                    raster.setSrs(env.getEPSGCode());
                } else {
                    raster.setBbox(this.createBbox(layer.getLatLonBoundingBox()));
                    raster.setSrs(EPSG_4326);
                }

            } else {
                additionalBounds = ancestorLayer.getBoundingBoxes();
                if (additionalBounds.containsKey(EPSG_GOOGLE)
                        || additionalBounds.containsKey(EPSG_3857)) {
                    CRSEnvelope env = additionalBounds
                            .get(EPSG_GOOGLE);
                    if (env == null) {
                        env = additionalBounds.get(EPSG_3857);
                    }
                    raster.setBbox(this.createBbox(env));
                    raster.setSrs(env.getEPSGCode());
                    logger.info("GOOGLE");
                } else {
                    raster.setBbox(this.createBbox(ancestorLayer.getLatLonBoundingBox()));
                    raster.setSrs(EPSG_4326);
                    logger.info("4326");
                }

            }
            logger.debug("Raster Name: {}", raster.getName());
            logger.debug("Raster BBOX: {}", raster.getBbox());
            logger.debug("Raster SRS: {}", raster.getSrs());
            if (urlServer.contains(GEB)) {
                if (layer.getLatLonBoundingBox() != null) {
                    raster.setBbox(this.createBbox(layer.getLatLonBoundingBox()));
                }
                raster.setSrs(EPSG_4326);
            }

            // Set LayerInfo of Raster Ith
            GPLayerInfo layerInfo = new GPLayerInfo();
            layerInfo.setQueryable(layer.isQueryable());
            if (layer.getKeywords() != null) {
                List<String> keywordList = Arrays.asList(layer.getKeywords());
                if (keywordList.size() > 0) {
                    layerInfo.setKeywords(keywordList);
                }
            }
            raster.setLayerInfo(layerInfo);

            // Set Styles of Raster Ith
            List<StyleImpl> stylesImpl = layer.getStyles();
            logger.debug("\n*** Layer \"{}\" has {} SubLayers and {} StyleImpl ***",
                    layer.getTitle(), layer.getLayerChildren().size(),
                    stylesImpl.size());
            raster.setStyleList(this.createStyleList(stylesImpl));
            return raster;
        }

        /**
         * @param stylesImpl
         * @return {@link List<String>}
         */
        private List<String> createStyleList(List<StyleImpl> stylesImpl) {
            List<String> styleList = new ArrayList<String>(stylesImpl.size());
            for (StyleImpl style : stylesImpl) {
                styleList.add(style.getName());
            }
            return styleList;
        }

        /**
         * @param env
         * @return {@link GPBBox}
         */
        private GPBBox createBbox(CRSEnvelope env) {
            return ((env != null) ? new GPBBox(env.getMinX(), env.getMinY(), env.getMaxX(),
                    env.getMaxY()) : new GPBBox(-179, -89, 179, 89));
        }

        /**
         * @param urlServer
         * @return {@link String}
         */
        private String getUrlServer(String urlServer) {
            int index = -1;
            if (urlServer.contains(".map")) {
                index = urlServer.indexOf(".map") + 4;
            } else if (urlServer.contains("mapserv.exe")
                    || urlServer.contains("mapserver")
                    || urlServer.contains("mapserv")
                    || urlServer.contains("usertoken")
                    || urlServer.contains("map")) {
                index = urlServer.indexOf("&");
            } else {
                index = urlServer.indexOf("?");
                // index += 1;
            }
            if (index != -1) {
                String newUrl = urlServer.substring(0, index);
                return newUrl;
            }
            return urlServer;
        }
    }
}