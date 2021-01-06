/**
 *
 *    geo-platform
 *    Rich webgis framework
 *    http://geo-platform.org
 *   ====================================================================
 *
 *   Copyright (C) 2008-2021 geoSDI Group (CNR IMAA - Potenza - ITALY).
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
package org.geosdi.geoplatform.connector.geoserver.model.datastores.body;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import org.geosdi.geoplatform.connector.geoserver.model.connection.IGPGeoserverConnectionParam;
import org.geosdi.geoplatform.connector.geoserver.model.connection.adapter.GPGeoserverConnectionMapParamAdapter;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.meta.When;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Map;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.lang.Boolean.TRUE;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;
import static javax.annotation.meta.When.NEVER;
import static javax.xml.bind.annotation.XmlAccessType.FIELD;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@ToString
@Getter
@XmlRootElement(name = "dataStore")
@XmlAccessorType(value = FIELD)
public class GPGeoserverCreateDatastoreBody implements IGPGeoserverCreateDatastoreBody {

    private static final long serialVersionUID = 7108296717342669829L;
    //
    private String name;
    private String description;
    private Boolean enabled;
    @XmlJavaTypeAdapter(value = GPGeoserverConnectionMapParamAdapter.class)
    private Map<String, String> connectionParameters;

    /**
     * @param theName
     * @param theConnectionParameters
     */
    @JsonCreator
    GPGeoserverCreateDatastoreBody(@Nonnull(when = NEVER) @JsonProperty(value = "name") String theName, @Nullable @JsonProperty(value = "description") String theDescription,
            @Nullable @JsonProperty(value = "enabled") Boolean theEnabled, @Nonnull(when = NEVER) @JsonProperty(value = "connectionParameters") Map<String, String> theConnectionParameters) {
        checkArgument((theName != null) && !(theName.trim().isEmpty()), "The Parameter name must not be null or an empty string.");
        checkArgument(theConnectionParameters != null, "The Parameter connectionParameters must not be null.");
        this.name = theName;
        this.description = theDescription;
        this.enabled = ((theEnabled != null) ? theEnabled : TRUE);
        this.connectionParameters = theConnectionParameters;
    }

    /**
     * @return {@link Boolean}
     */
    @Override
    public Boolean isEnabled() {
        return this.enabled;
    }

    /**
     * @param theParam
     * @param <Param>
     * @return {@link IGPGeoserverCreateDatastoreBody}
     * @throws Exception
     */
    @Override
    public <Param extends IGPGeoserverConnectionParam> GPGeoserverCreateDatastoreBody addParam(@Nonnull(when = NEVER) Param theParam) throws Exception {
        checkNotNull(theParam, "The Parameter param must not be null.");
        checkArgument((theParam.getKey() != null) && !(theParam.getKey().trim().isEmpty()), "The Parameter key must not be null or an empty string.");
        checkArgument((theParam.getValue() != null) && !(theParam.getValue().trim().isEmpty()), "The Parameter value must not be null or an empty string.");
        this.connectionParameters.put(theParam.getKey(), theParam.getValue());
        return this;
    }

    /**
     * @param theParams
     * @return {@link IGPGeoserverCreateDatastoreBody}
     * @throws Exception
     */
    @Override
    public <Param extends IGPGeoserverConnectionParam> GPGeoserverCreateDatastoreBody addParams(@Nonnull(when = When.NEVER) Param... theParams) throws Exception {
        checkNotNull(theParams, "The Parameter params must not be null");
        this.connectionParameters.putAll(stream(theParams)
                .filter(Objects::nonNull)
                .filter(param -> (param.getKey() != null) && !(param.getKey().trim().isEmpty()))
                .filter(param -> (param.getValue() != null) && !(param.getValue().trim().isEmpty()))
                .collect(toMap(k -> k.getKey(), v -> v.getValue())));
        return this;
    }
}