/**
 * geo-platform
 * Rich webgis framework
 * http://geo-platform.org
 * ====================================================================
 * <p>
 * Copyright (C) 2008-2019 geoSDI Group (CNR IMAA - Potenza - ITALY).
 * <p>
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version. This program is distributed in the
 * hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details. You should have received a copy of the GNU General
 * Public License along with this program. If not, see http://www.gnu.org/licenses/
 * <p>
 * ====================================================================
 * <p>
 * Linking this library statically or dynamically with other modules is
 * making a combined work based on this library. Thus, the terms and
 * conditions of the GNU General Public License cover the whole combination.
 * <p>
 * As a special exception, the copyright holders of this library give you permission
 * to link this library with independent modules to produce an executable, regardless
 * of the license terms of these independent modules, and to copy and distribute
 * the resulting executable under terms of your choice, provided that you also meet,
 * for each linked independent module, the terms and conditions of the license of
 * that module. An independent module is a module which is not derived from or
 * based on this library. If you modify this library, you may extend this exception
 * to your version of the library, but you are not obligated to do so. If you do not
 * wish to do so, delete this exception statement from your version.
 */
package org.geosdi.geoplatform.experimental.el.rest.api.dao.index;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.Strings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.geosdi.geoplatform.experimental.el.api.model.Document;
import org.geosdi.geoplatform.experimental.el.rest.api.dao.mapping.ElasticSeachRestMappingDAO;
import org.geosdi.geoplatform.support.jackson.GPJacksonSupport;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkArgument;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static javax.annotation.meta.When.NEVER;
import static org.elasticsearch.client.RequestOptions.DEFAULT;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public abstract class ElasticSearchRestIndexDAO<D extends Document> extends ElasticSeachRestMappingDAO<D> implements GPElasticSearchRestIndexDAO<D> {

    /**
     * @param theEntityClass
     * @param theJacksonSupport
     */
    protected ElasticSearchRestIndexDAO(@Nonnull(when = NEVER) Class<D> theEntityClass, @Nullable GPJacksonSupport theJacksonSupport) {
        super(theEntityClass, theJacksonSupport);
    }

    /**
     * @return {@link Boolean}
     * @throws Exception
     */
    @Override
    public Boolean createIndex() throws Exception {
        if (!existIndex()) {
            logger.debug("###############################Called {}#createIndex with Param : {}\n", this.getClass().getSimpleName(), getIndexName());
            CreateIndexRequest createIndexRequest = new CreateIndexRequest(this.getIndexName());
            XContentBuilder xContentBuilder = this.preparePutMapping();
            if ((this.isCreateMapping()) && (xContentBuilder != null)) {
                logger.debug("#####################TRYING TO PUT MAPPING with SOURCE : \n{}\n", Strings.toString(xContentBuilder));
                createIndexRequest.source(xContentBuilder);
            }
            return this.elasticSearchRestHighLevelClient.indices().create(createIndexRequest, DEFAULT).isAcknowledged();
        } else {
            logger.debug("##############################Index with name : {}, already exist.", this.getIndexName());
            return FALSE;
        }
    }

    /**
     * @param theActionListener
     * @throws Exception
     */
    @Override
    public void createIndexAsync(@Nonnull(when = NEVER) ActionListener<CreateIndexResponse> theActionListener) throws Exception {
        checkArgument(theActionListener != null, "The Parameter actionListener must not be null.");
        if (!existIndex()) {
            logger.debug("###############################Called {}#createIndexAsync with Param : {}\n", this.getClass().getSimpleName(), getIndexName());
            CreateIndexRequest createIndexRequest = new CreateIndexRequest(this.getIndexName());
            XContentBuilder xContentBuilder = this.preparePutMapping();
            if ((this.isCreateMapping()) && (xContentBuilder != null)) {
                logger.debug("#####################TRYING TO PUT MAPPING with SOURCE : \n{}\n",
                        Strings.toString(xContentBuilder));
                createIndexRequest.source(xContentBuilder);
            }
            this.elasticSearchRestHighLevelClient.indices().createAsync(createIndexRequest, DEFAULT, theActionListener);
        } else {
            logger.debug("##############################Index with name : {}, already exist.", this.getIndexName());
        }
    }

    /**
     * @return {@link Boolean}
     * @throws Exception
     */
    @Override
    public Boolean deleteIndex() throws Exception {
        logger.debug("###############################Called {}#deleteIndex with Param : {}\n", this.getClass().getSimpleName(), getIndexName());
        return this.elasticSearchRestHighLevelClient.indices().delete(new DeleteIndexRequest(this.getIndexName()), DEFAULT).isAcknowledged();
    }

    /**
     * @param theActionListener
     * @throws Exception
     */
    @Override
    public void deleteIndexAsync(@Nonnull(when = NEVER) ActionListener<AcknowledgedResponse> theActionListener) throws Exception {
        checkArgument(theActionListener != null, "The Parameter actionListener must not be null.");
        logger.debug("###############################Called {}#deleteIndexAsync with Param : {}\n", this.getClass().getSimpleName(), getIndexName());
        this.elasticSearchRestHighLevelClient.indices().deleteAsync(new DeleteIndexRequest(this.getIndexName()), DEFAULT, theActionListener);
    }

    /**
     * @return {@link Boolean}
     * @throws Exception
     */
    @Override
    public Boolean existIndex() throws Exception {
        return this.elasticSearchRestHighLevelClient.indices().exists(new GetIndexRequest(this.getIndexName()).humanReadable(TRUE), DEFAULT);
    }

    /**
     * @throws Exception
     */
    @Override
    protected void onStartUp() throws Exception {
        super.onStartUp();
        if (this.isUpElasticSearchCluster()) {
            if ((!createIndex()) && (this.getSettings().isCreateMapping())) {
                logger.debug("#######################Trying to create mapping for {}\n", this.elasticSearchRestMapper.getDocumentClassName());
                XContentBuilder builder = this.preparePutMapping();
                if (builder != null) {
                    AcknowledgedResponse putMappingResponse = this.putMapping(builder, this::createPutMappingRequest);
                    logger.debug("########################## {}\n", ((putMappingResponse.isAcknowledged()) ? "PUT_MAPPING_STATUS IS OK." : "PUT_MAPPING NOT CREATED."));
                    logger.debug("::::::::::::::::::::::GET_MAPPING_AS_STRING:::::::::::::: : \n{}\n", this.loadMappingAsString());
                } else {
                    logger.debug("#########################There is no XContentBuilder defined so skip PutMapping.\n");
                }
            }
        } else {
            logger.debug("####################Can't putMapping for : {}, because ElasticSearch is down.\n", this.elasticSearchRestMapper.getDocumentClassName());
        }
    }
}