package org.geosdi.geoplatform.connector.bridge.store;

import org.geosdi.geoplatform.connector.bridge.finder.GPWMSGetFeatureInfoReaderFinder;
import org.geosdi.geoplatform.connector.bridge.implementor.GPWMSGetFeatureInfoReader;
import org.geosdi.geoplatform.connector.server.request.WMSFeatureInfoFormat;
import org.geosdi.geoplatform.support.bridge.finder.GPImplementorFinder;
import org.geosdi.geoplatform.support.bridge.implementor.GPImplementor.GPImplementorKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.function.Function.identity;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class GPWMSGetFeatureInfoReaderStore implements WMSGetFeatureInfoReaderStore {

    private static final long serialVersionUID = -2890021272284084197L;
    //
    private static final Logger logger = LoggerFactory.getLogger(GPWMSGetFeatureInfoReaderStore.class);
    private static final GPImplementorFinder<GPWMSGetFeatureInfoReader<?>> finder = new GPWMSGetFeatureInfoReaderFinder<>();
    private static final Map<WMSFeatureInfoFormat, GPWMSGetFeatureInfoReader<?>> wmsGetFeatureInfoReaders;

    static {
        wmsGetFeatureInfoReaders = finder.getValidImplementors()
                .stream()
                .collect(Collectors.toMap(k -> k.getKey().getImplementorKey(), identity()));
        logger.debug("@@@@@@@@@@@@@@@@@@@@@@{} up with {} values.\n\n", GPWMSGetFeatureInfoReaderStore.class.getSimpleName(),
                wmsGetFeatureInfoReaders.size());
    }

    /**
     * @param key
     * @return {@link GPWMSGetFeatureInfoReader<?>}
     * @throws Exception
     */
    @Override
    public GPWMSGetFeatureInfoReader<?> getImplementorByKey(GPImplementorKey key) throws Exception {
        checkArgument((key != null), "The Parameter key must not be null");
        logger.trace("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@Try to find WMSGetFeatureInfoReader with Key : {}\n", key);
        return wmsGetFeatureInfoReaders.get(key);
    }

    /**
     * @return {@link Set<GPWMSGetFeatureInfoReader<?>>}
     */
    @Override
    public Set<GPWMSGetFeatureInfoReader<?>> getAllImplementors() {
        return Collections.unmodifiableSet(finder.getAllImplementors());
    }

    /**
     * @return {@link Collection<GPWMSGetFeatureInfoReader<?>>}
     */
    @Override
    public Collection<GPWMSGetFeatureInfoReader<?>> getValidImplementors() {
        return Collections.unmodifiableCollection(finder.getValidImplementors());
    }
}