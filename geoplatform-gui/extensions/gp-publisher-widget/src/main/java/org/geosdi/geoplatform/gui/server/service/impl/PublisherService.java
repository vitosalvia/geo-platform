/*
 *  geo-platform
 *  Rich webgis framework
 *  http://geo-platform.org
 * ====================================================================
 *
 * Copyright (C) 2008-2011 geoSDI Group (CNR IMAA - Potenza - ITALY).
 *
 * This program is free software: you can redistribute it and/or modify it 
 * under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or 
 * (at your option) any later version. This program is distributed in the 
 * hope that it will be useful, but WITHOUT ANY WARRANTY; without 
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR 
 * A PARTICULAR PURPOSE. See the GNU General Public License 
 * for more details. You should have received a copy of the GNU General 
 * Public License along with this program. If not, see http://www.gnu.org/licenses/ 
 *
 * ====================================================================
 *
 * Linking this library statically or dynamically with other modules is 
 * making a combined work based on this library. Thus, the terms and 
 * conditions of the GNU General Public License cover the whole combination. 
 * 
 * As a special exception, the copyright holders of this library give you permission 
 * to link this library with independent modules to produce an executable, regardless 
 * of the license terms of these independent modules, and to copy and distribute 
 * the resulting executable under terms of your choice, provided that you also meet, 
 * for each linked independent module, the terms and conditions of the license of 
 * that module. An independent module is a module which is not derived from or 
 * based on this library. If you modify this library, you may extend this exception 
 * to your version of the library, but you are not obligated to do so. If you do not 
 * wish to do so, delete this exception statement from your version. 
 *
 */
package org.geosdi.geoplatform.gui.server.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Properties;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.slf4j.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.geosdi.geoplatform.core.model.GPUser;
import org.geosdi.geoplatform.cxf.GeoPlatformPublishClient;
import org.geosdi.geoplatform.exception.ResourceNotFoundFault;
import org.geosdi.geoplatform.gui.global.GeoPlatformException;
import org.geosdi.geoplatform.gui.server.SessionUtility;
import org.geosdi.geoplatform.gui.server.service.IPublisherService;
import org.geosdi.geoplatform.gui.utility.GPSessionTimeout;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Nazzareno Sileno - CNR IMAA geoSDI Group
 * @email nazzareno.sileno@geosdi.org
 */
@Service("publisherService")
public class PublisherService implements IPublisherService, InitializingBean {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private GeoPlatformPublishClient geoPlatformPublishClient;
    private HttpGet httpget;
    private DefaultHttpClient httpclient;
    private HttpContext localContext;
    private HttpHost targetHost;
    @Autowired
    private SessionUtility sessionUtility;
//    @Value("${classpath:/#{wsProperties['cluster_reload_url']}}")
//    @Value("${cluster_reload_url}")
    @Resource
    private Properties wsProperties;

    @Override
    public void afterPropertiesSet() throws Exception {
        String url = wsProperties.getProperty("cluster_reload_url");
        this.httpget = new HttpGet(url);
        String hostUrl = wsProperties.getProperty("cluster_reload_host_url");
//        this.get = new HttpGet(url);
        targetHost = new HttpHost(hostUrl);
        // Create AuthCache instance
        AuthCache authCache = new BasicAuthCache();
        // Generate BASIC scheme object and add it to the local auth cache
        BasicScheme basicAuth = new BasicScheme();
        authCache.put(targetHost, basicAuth);

        // Add AuthCache to the execution context
        BasicHttpContext localcontext = new BasicHttpContext();
        localcontext.setAttribute(ClientContext.AUTH_CACHE, authCache);

        localContext = new BasicHttpContext();
        this.httpclient = new DefaultHttpClient();
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT),
                new UsernamePasswordCredentials(
                wsProperties.getProperty("cluser_reload_username"),
                wsProperties.getProperty("cluser_reload_password")));
        httpclient.setCredentialsProvider(credsProvider);
    }

    @Override
    public String publishLayerPreview(HttpServletRequest httpServletRequest, List<String> layerList, boolean reloadCluster) throws GeoPlatformException {
        GPUser user = null;
        try {
            user = sessionUtility.getUserAlreadyFromSession(httpServletRequest);
        } catch (GPSessionTimeout timeout) {
            throw new GeoPlatformException(timeout);
        }
        String result = null;
        try {
            geoPlatformPublishClient.getPublishService().publishAll(
                    httpServletRequest.getSession().getId(), "previews", "dataTest", layerList);
            if (reloadCluster) {
                HttpResponse response = httpclient.execute(targetHost, httpget, localContext);
//                HttpResponse response = httpclient.execute(get, localContext);
                InputStream is = response.getEntity().getContent();
                Writer writer = new StringWriter();
                char[] buffer = new char[1024];
                try {
                    Reader reader = new BufferedReader(
                            new InputStreamReader(is, "UTF-8"));
                    int n;
                    while ((n = reader.read(buffer)) != -1) {
                        writer.write(buffer, 0, n);
                    }
                } finally {
                    is.close();
                }
                result = writer.toString();
//                URL url = new URL(wsProperties.getProperty("cluster_reload_url"));
//                URLConnection connection = url.openConnection();
//                connection.connect();
//                // Get the response
////            BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
////            StringBuilder sb = new StringBuilder();
////            String line;
////            while ((line = rd.readLine()) != null) {
////                sb.append(line);
////            }
////            rd.close();
////            System.out.println("Conessione effettuata: " + sb.toString());
            }
        } catch (ResourceNotFoundFault ex) {
            logger.error("Error on publish shape: " + ex);
            System.out.println("Error on publish shape: " + ex);
            throw new GeoPlatformException("Error on publish shape.");
        } catch (FileNotFoundException ex) {
            logger.error("Error on publish shape: " + ex);
            System.out.println("Error on publish shape: " + ex);
            throw new GeoPlatformException("Error on publish shape.");
        } catch (MalformedURLException e) {
            logger.error("Error on cluster url: " + e);
            System.out.println("Error on cluster url: " + e);
            throw new GeoPlatformException("Error on cluster url.");
        } catch (IOException e) {
            logger.error("Error on reloading cluster: " + e);
            System.out.println("Error on reloading cluster: " + e);
            throw new GeoPlatformException("Error on reloading cluster.");
        }
        return result;
    }

    @Override
    public void kmlPreview(HttpServletRequest httpServletRequest, String url)
            throws GeoPlatformException {
        // TODO
    }

    /**
     * @param geoPlatformServiceClient the geoPlatformServiceClient to set
     */
    @Autowired
    public void setGeoPlatformPublishClient(
            @Qualifier("geoPlatformPublishClient") GeoPlatformPublishClient geoPlatformPublishClient) {
        this.geoPlatformPublishClient = geoPlatformPublishClient;
    }
}