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
package org.geosdi.geoplatform.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import javax.jws.WebService;
import it.geosolutions.geoserver.rest.GeoServerRESTPublisher;
import it.geosolutions.geoserver.rest.GeoServerRESTReader;
import it.geosolutions.geoserver.rest.decoder.RESTCoverage;
import it.geosolutions.geoserver.rest.decoder.RESTCoverageStore;
import it.geosolutions.geoserver.rest.decoder.RESTFeatureType;
import it.geosolutions.geoserver.rest.decoder.RESTDataStoreList;
import it.geosolutions.geoserver.rest.decoder.utils.NameLinkElem;
import it.geosolutions.geoserver.rest.decoder.RESTStyleList;
import it.geosolutions.geoserver.rest.encoder.GSPostGISDatastoreEncoder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.zip.ZipFile;
import java.util.List;
import java.util.zip.ZipEntry;
import org.geosdi.geoplatform.exception.ResourceNotFoundFault;
import org.geosdi.geoplatform.responce.InfoPreview;
import org.geosdi.geoplatform.services.geotiff.GeoTiffOverviews;
import org.geosdi.geoplatform.services.geotiff.GeoTiffOverviewsConfiguration;
import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.data.DataSourceException;
import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.factory.Hints;
import org.geotools.gce.geotiff.GeoTiffReader;
import org.geotools.referencing.CRS;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.quartz.CalendarIntervalScheduleBuilder;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@WebService(endpointInterface = "org.geosdi.geoplatform.services.GPPublisherService")
public class GPPublisherServiceImpl implements GPPublisherService {

    protected Logger logger = LoggerFactory.getLogger(
            GPPublisherServiceImpl.class);

    class LayerInfo {
        String name;
        boolean isShp;
        String epsg;
        String sld;
    }
    private String RESTURL = "";
    private String RESTUSER = "";
    private String RESTPW = "";
    @Autowired
    private GeoServerRESTPublisher restPublisher;
    @Autowired
    private GeoServerRESTReader restReader;
    private String geoportalDir = "";
    @Autowired
    private PublisherScheduler scheduler;
    @Autowired
    private GeoTiffOverviewsConfiguration overviewsConfiguration;

    public GPPublisherServiceImpl(String RESTURL, String RESTUSER, String RESTPW,
            String geoportalDir) {
        this.RESTURL = RESTURL;
        this.RESTUSER = RESTUSER;
        this.RESTPW = RESTPW;
        this.geoportalDir = geoportalDir;
        File geoportalDirFile = new File(geoportalDir);
        if (!geoportalDirFile.exists()) {
            logger.error("The geoportaldir: " + geoportalDir + " does not exist!");
        }
        logger.info("GEOSERVER AT: " + RESTURL + ", USER: " + RESTUSER
                + ", PWD: " + RESTPW + ", USING DIR: " + geoportalDir);
    }

    /****************************
     *System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + "geoportal"+ System.getProperty("file.separator") + "shp";
     * @param workspace
     * @param dataStoreName
     * @param layerName
     * @return
     * @throws ResourceNotFoundFault
     * @throws FileNotFoundException
     * this service publishes the layer <layerName> we loaded in the previews workspace into the DB datastore identified by the <dataStoreName> and published into the <workspace> workspace
     */
    @Override
    public boolean publish(String sessionID, String workspace,
            String dataStoreName, String layerName) throws ResourceNotFoundFault, FileNotFoundException {
        logger.info("\n Start to publish " + layerName + " in " + workspace + ":" + dataStoreName);
        return this.unscheduleJob(layerName);
    }

    @Override
    public boolean publishAll(String sessionID, String workspace,
            String dataStoreName, List<String> layerNames) throws ResourceNotFoundFault, FileNotFoundException {
        for (String name : layerNames) {
            this.unscheduleJob(name);
        }
        return true;
    }

    @Override
    public boolean publishAllofPreview(String sessionID, String workspace,
            String dataStoreName) throws ResourceNotFoundFault, FileNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /*************************
     *
     * @param layerName
     * @return
     * @throws ResourceNotFoundFault
     * this service removes a layer from the workspace
     */
    public boolean removeSHPFromPreview(String workspace, String layerName) throws ResourceNotFoundFault {
        String userWorkspace = this.getWorkspace(workspace);
        logger.info("Removing shp " + layerName + " from " + userWorkspace);
        this.removeLayer(layerName);
        restPublisher.unpublishFeatureType(userWorkspace, layerName, layerName);
        reload();
        restPublisher.removeDatastore(userWorkspace, layerName);
        return true;
    }

    /*************************
     *
     * @param layerName
     * @return
     * @throws ResourceNotFoundFault
     * this service removes a layer from the workspace
     */
    public boolean removeTIFFromPreview(String userName, String layerName) throws ResourceNotFoundFault {
        String userWorkspace = getWorkspace(userName);
        logger.info("Removing tif " + layerName + " from " + userWorkspace);
        this.removeLayer(layerName);
        restPublisher.unpublishCoverage(userWorkspace, layerName, layerName);
        reload();
        restPublisher.removeCoverageStore(userWorkspace, layerName);
        return true;
    }

    private InfoPreview getTIFURLByLayerName(String userName, String layerName) {
        RESTCoverage featureType = restReader.getCoverage(restReader.getLayer(
                layerName));
        String userWorkspace = getWorkspace(userName);
        InfoPreview info = null;
        try {
            info = new InfoPreview(RESTURL, userWorkspace, layerName,
                    featureType.getMinX(), featureType.getMinY(),
                    featureType.getMaxX(), featureType.getMaxY(), featureType.getCRS());
        } catch (Exception e) {
            logger.info(
                    "The layer " + layerName + " is published in the " + userWorkspace + " workspace, but the server cannot provide info");
            info = new InfoPreview(layerName,
                    "The layer " + layerName + " is published in the " + userWorkspace + " workspace, but the server cannot provide info");
        }
        return info;
    }

    /*******************************
     *
     * @param layerName
     * @return
     * @throws ResourceNotFoundFault
     * get the URL to the PNG if the layer dataStoreName
     */
    private InfoPreview getSHPURLByDataStoreName(String userName, String layerName) throws ResourceNotFoundFault {
        RESTFeatureType featureType = restReader.getFeatureType(restReader.getLayer(layerName));
        String userWorkspace = getWorkspace(userName);
        InfoPreview info = null;
        try {
            info = new InfoPreview(RESTURL, userWorkspace, layerName,
                    featureType.getMinX(), featureType.getMinY(),
                    featureType.getMaxX(), featureType.getMaxY(), featureType.getCRS());
        } catch (Exception e) {
            logger.info(
                    "The layer " + layerName + " is published in the " + userWorkspace + " workspace, but the server cannot provide info");
            info = new InfoPreview(layerName,
                    "The layer " + layerName + " is published in the " + userWorkspace + " workspace, but the server cannot provide info");
        }
        return info;
    }

    /*************************
     *
     * @return
     * @throws ResourceNotFoundFault
     * this methods returns the list of the datastores in the user workspace. For each datastore the info to find the PNG is also specified
     */
    @Override
    public List<InfoPreview> getPreviewDataStores(String userName) throws ResourceNotFoundFault {
        reload();
        List<InfoPreview> listPreviews = new ArrayList<InfoPreview>();
        String userWorkspace = getWorkspace(userName);
        RESTDataStoreList list = restReader.getDatastores(userWorkspace);
        for (NameLinkElem element : list) {
            String name = element.getName();
            InfoPreview item = getSHPURLByDataStoreName(userName, name);
            listPreviews.add(item);
        }
        return listPreviews;
    }

    /**************
     *
     * @param file the ZIP file from where extracting the info
     * @return the information of the shapefile
     * this method extracts from a zip file containing the shape files, the name, the CRS and the geometry types
     */
    private List<LayerInfo> getInfoFromCompressedShape(String userName, File file,
            String tempUserDir, String tempUserZipDir, String tempUserTifDir) {
        logger.info("Call to getInfoFromCompressedShape");
        System.setProperty("org.geotools.referencing.forceXY", "true");
        List<String> shpEntryNameList = new ArrayList<String>();
        List<String> tifEntryNameList = new ArrayList<String>();
        List<ZipEntry> sldEntryList = new ArrayList<ZipEntry>();
        List<LayerInfo> infoShapeList = new ArrayList<LayerInfo>();
        ZipFile zipSrc = null;
        try {
            // decomprime il contenuto di file nella cartella <tmp>/geoportal/shp
            zipSrc = new ZipFile(file);
            Enumeration<? extends ZipEntry> entries = zipSrc.entries();
            String destinationDir = null;
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                String entryName = entry.getName();
                File newFile = new File(entryName);
                if (newFile.isDirectory()) {
                    continue;
                }
                //   entryName = entryName.replaceAll("/", "_");
                //    logger.info("\n ********** INFO:"+entryName);

                int lastIndex = entryName.lastIndexOf('/');
                entryName = entryName.substring(lastIndex + 1);
                destinationDir = tempUserDir;
                if (entryName.equals("")) {
                    continue;
                } else if (entryName.endsWith(".tif") || entryName.endsWith(".tiff")) {
                    logger.info("INFO: Found geotiff file " + entryName);
                    tifEntryNameList.add(entryName);
                    destinationDir = tempUserTifDir;
                } else if (entryName.endsWith(".shp")) {
                    logger.info("INFO: Found shape file " + entryName);
                    shpEntryNameList.add(entryName);
                } else if (entryName.endsWith(".sld")) {
                    logger.info("Adding sld to entry list");
                    sldEntryList.add(entry);
                    continue;
                }
                PublishUtility.extractEntryToFile(entry, zipSrc, destinationDir);
            }
            //Verificare presenza file sld associato a geotiff
            for (ZipEntry sldEntry : sldEntryList) {
                int lastIndex = sldEntry.getName().lastIndexOf('/');
                int endNamePos = sldEntry.getName().lastIndexOf('.');
                String sldEntryName = sldEntry.getName().substring(lastIndex + 1, endNamePos);
                System.out.println("sldEntryName: " + sldEntryName);
                if (this.isDuplicatedName(sldEntryName, tifEntryNameList)) {//geotiff sld
                    logger.info("in geotiff sld");
                    PublishUtility.extractEntryToFile(sldEntry, zipSrc, tempUserTifDir);
                } else {//shp sld
                    logger.info("in shp sld");
                    PublishUtility.extractEntryToFile(sldEntry, zipSrc, tempUserDir);
                }
            }// fine decompressione
        } catch (Exception e) {
            logger.error("ERRORE : " + e);
        } finally {
            try {
                zipSrc.close();
            } catch (IOException ex) {
            }
        }
        infoShapeList.addAll(this.analyzeShpList(shpEntryNameList, userName, tempUserDir, tempUserZipDir));
        infoShapeList.addAll(this.analyzeTifList(tifEntryNameList, userName, tempUserTifDir));
        // svuota la cartella degli shape <tmp>/geoportal/shp
        File directory = new File(tempUserDir);
        File[] files = directory.listFiles();
        for (File f : files) {
            f.delete();
        }
        return infoShapeList;
    }
    
    private boolean isDuplicatedName(String sldName, List<String> tifEntryNameList){
        for (String tifEntryName : tifEntryNameList) {
            String tifName = tifEntryName.substring(0, tifEntryName.lastIndexOf('.'));
            if(tifName.equals(sldName)){
                return true;
            }
        }
        return false;
    }
    
    private List<LayerInfo> analyzeTifList(List<String> tifEntryNameList, String userName,
            String tempUserTifDir) {
        List<LayerInfo> infoTifList = new ArrayList<LayerInfo>();
        for (String tifFileName : tifEntryNameList) {
            LayerInfo info = new LayerInfo();
            info.isShp = false;
            String origName = tifFileName.substring(0, tifFileName.lastIndexOf("."));
            info.name = userName + "_" + origName;
            File oldGeotifFile = new File(tempUserTifDir, tifFileName);
            File newGeoTifFile = PublishUtility.copyFile(oldGeotifFile, tempUserTifDir, info.name + ".tif", true);
            oldGeotifFile.delete();
            info.epsg = "EPSG:" + this.getCRSFromGeotiff(newGeoTifFile);
            String SLDFileName = origName + ".sld";
            File fileSLD = new File(tempUserTifDir, SLDFileName);
            if (fileSLD.exists()) {
                info.sld = this.publishSLD(fileSLD, info.name);
            } else {
                info.sld = "default_raster";
            }
            infoTifList.add(info);
        }
        return infoTifList;
    }

    private String publishSLD(File fileSLD, String layerName) {
        reload();
        logger.info("\n INFO: FOUND STYLE FILE. TRYING TO PUBLISH WITH " + layerName + " NAME");
        boolean returnPS = false;
        if (existsStyle(layerName)) {
            restPublisher.removeStyle(layerName);
        }
        returnPS = restPublisher.publishStyle(fileSLD, layerName);
        logger.info("\n INFO: PUBLISH STYLE RESULT " + returnPS);
        return layerName;
    }

    private List<LayerInfo> analyzeShpList(List<String> shpEntryNameList, String userName,
            String tempUserDir, String tempUserZipDir) {
        List<LayerInfo> infoShapeList = new ArrayList<LayerInfo>();
        for (String shpFileName : shpEntryNameList) {
            // start analizing shape
            logger.info("Extracting info from " + shpFileName);
            LayerInfo info = new LayerInfo();
            info.isShp = true;
            String origName = shpFileName.substring(0, shpFileName.length() - 4);
            info.name = userName + "_shp_" + origName;
            File shpFile = new File(tempUserDir + shpFileName);
            FileDataStore store = null;
            SimpleFeatureSource featureSource = null;
            try {
                store = FileDataStoreFinder.getDataStore(shpFile);
                featureSource = store.getFeatureSource();
            } catch (IOException ex) {
                this.logger.error("Error analyzing shp list: " + ex);
            }
            String geomType = featureSource.getSchema().getGeometryDescriptor().getType().getName().toString();
            String SLDFileName = origName + ".sld";
            File fileSLD = new File(tempUserDir + SLDFileName);
            if (fileSLD.exists()) {
                info.sld = this.publishSLD(fileSLD, info.name);
            } else if (geomType.equals("MultiPolygon")) {
                info.sld = "default_polygon";
            } else if (geomType.equals("MultiLineString")) {
                info.sld = "default_polyline";
            } else if (geomType.equals("Point")) {
                info.sld = "default_point";
            } else {
                info.sld = info.name;
            }
            logger.info("\n INFO: STYLE " + info.sld + " for " + info.name);
            Integer code = null;
            try {
//                    System.out.println("Info sull'epsg: " + featureSource.getSchema().getCoordinateReferenceSystem());
                code = CRS.lookupEpsgCode(
                        featureSource.getSchema().getCoordinateReferenceSystem(),
                        true);
            } catch (Exception e) {
            }
            if (code != null) {
                info.epsg = "EPSG:" + code.toString();
            } else {
                info.epsg = "EPSG:4326";
            }
            // fine analisi shape
            infoShapeList.add(info);
            PublishUtility.compressFiles(tempUserZipDir, tempUserDir, info.name + ".zip",
                    origName, info.name); // questo metodo comprime in un file <nomeshape>.zip gli shp file associati: shp, dbf, shx e prj
        }
        return infoShapeList;
    }

    /***************
     *
     * @param layer the layer to remove
     * @return
     *  perform a REST call for deleting the layer
     */
    private boolean removeLayer(String layer) {
        String sUrl = RESTURL + "/rest/layers/" + layer + "?purge=true";
        return HttpUtilsLocal.delete(sUrl, RESTUSER, RESTPW);
    }

    /*************
     *
     * @param styleName
     * @return
     * check whether the style styleName exists
     */
    public boolean existsStyle(String styleName) {
        RESTStyleList styleList = restReader.getStyles();
        for (int i = 0; i < styleList.size(); i++) {
            if (styleList.get(i).getName().equalsIgnoreCase(styleName)) {
                return true;
            }
        }
        return false;
    }

    /**************
     *
     * @param workspace
     * @param dataStoreName
     * @return
     * check whether the layer layerName exists in the workspace workspace
     */
    public boolean existsDataStore(String workspace, String dataStoreName) {
        RESTDataStoreList workspaceDataStores = restReader.getDatastores(workspace);
        for (int i = 0; i < workspaceDataStores.size(); i++) {
            if (workspaceDataStores.get(i).getName().equals(dataStoreName)) {
                return true;
            }
        }
        return false;
    }

    /*******************
     *
     * @return
     * reload the catalogue of geoserver
     */
    private String reload() {
        String sUrl = RESTURL + "/rest/reload";
        return HttpUtilsLocal.post(sUrl, "", "text/html", RESTUSER, RESTPW);
    }

    /********************
     *
     * @param userName
     * @return
     *
     * creates the workspace if not exists or returns the existing one
     */
    private String getWorkspace(String userName) {
        List<String> workspaces = restReader.getWorkspaceNames();
        String userWorkspace = userName;
        if (!workspaces.contains(userWorkspace)) {
            restPublisher.createWorkspace(userWorkspace);
        }
        return userWorkspace;
    }

    private Integer getCRSFromGeotiff(File file) {
        Integer code = null;
        try {
            GeoTiffReader geotiffReader = new GeoTiffReader(file, new Hints(Hints.FORCE_LONGITUDE_FIRST_AXIS_ORDER, Boolean.TRUE));
            GridCoverage2D coverage = (GridCoverage2D) geotiffReader.read(null);
            CoordinateReferenceSystem crs = coverage.getCoordinateReferenceSystem2D();
            code = CRS.lookupEpsgCode(crs, false);
        } catch (DataSourceException ex) {
            logger.error("Errore retrieving the crs: " + ex);
        } catch (IOException ioe) {
            logger.error("Errore retrieving the crs: " + ioe);
        } catch (FactoryException ioe) {
            logger.error("Errore retrieving the crs: " + ioe);
        }
        return code;
    }

    //The layerName must be unique otherwise the Geoserver can't publish the same layer
    //in two different workspaces (verify!)
    //It is not possible to publish different layers on the same "storeName"
    @Override
    public InfoPreview uploadTIFInPreview(String username, File file, boolean overwrite) throws ResourceNotFoundFault {
        logger.info("Call to uploadTIFInPreview");
        InfoPreview infoPreview = null;
        String userWorkspace = getWorkspace(username);
        String epsg = "EPSG:" + this.getCRSFromGeotiff(file);
        String sld = "default_raster";
//        String dataStoreName = username + "_" + PublishUtility.tifDirName;
        String fileName = username + "_" + file.getName().substring(0, file.getName().lastIndexOf("."));
        File fileInTifDir = null;
        //TODO: Se il layer esiste ma è richiesto di fare overwrite bisogna sovrascriverlo: cancellare ed aggiungere il file
        if (!existsDataStore(userWorkspace, fileName)) {
            String pathInTifDir = this.geoportalDir + username + System.getProperty("file.separator")
                    + PublishUtility.tifDirName + System.getProperty("file.separator");
            fileInTifDir = PublishUtility.copyFile(file, pathInTifDir, fileName + ".tif", overwrite);
            if (fileInTifDir == null) {
                infoPreview = new InfoPreview(fileName,
                        "The file " + fileInTifDir + " already exists, you must overwrite it");
                return infoPreview;
            }
            infoPreview = this.publishTifInPreview(username, userWorkspace, fileInTifDir, fileName, epsg, sld);
        } else {
            infoPreview = getTIFURLByLayerName(username, fileName);
            infoPreview.setMessage(
                    "The data store " + fileName + " in " + userWorkspace + " already exists");
        }
        this.addTifCleanerJob(userWorkspace, fileName, fileInTifDir.getAbsolutePath());
        return infoPreview;
    }

    private boolean unscheduleJob(String completeLayerName) {
        boolean result = false;
        try {
            TriggerKey key = new TriggerKey(completeLayerName, PublisherScheduler.PUBLISHER_GROUP);
            result = this.scheduler.getScheduler().unscheduleJob(key);
            logger.debug("Job unscheduled: " + result);
        } catch (SchedulerException ex) {
            logger.error("Error unscheduling publisher cleaner job: " + ex);
        }
        return result;
    }

    private void addShpCleanerJob(String userWorkspace, InfoPreview infoPreview) {
        String layerName = infoPreview.getDataStoreName();
        TriggerKey triggerKey = new TriggerKey(userWorkspace + ":" + layerName, PublisherScheduler.PUBLISHER_GROUP);
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.add(Calendar.MINUTE, 30);
        Trigger trigger = TriggerBuilder.newTrigger().forJob(this.scheduler.getCleanerJobShpDetail()).
                withIdentity(triggerKey).
                withDescription("Runs after 30 minutes").
                startAt(calendar.getTime()).
                withSchedule(CalendarIntervalScheduleBuilder.calendarIntervalSchedule().
                withMisfireHandlingInstructionFireAndProceed()).
                build();
        trigger.getJobDataMap().put(PublisherShpCleanerJob.USER_WORKSPACE, userWorkspace);
        trigger.getJobDataMap().put(PublisherShpCleanerJob.LAYER_NAME, layerName);
        trigger.getJobDataMap().put(PublisherShpCleanerJob.PUBLISHER_SERVICE, this);
        this.scheduleTrigger(triggerKey, trigger);
    }

    private void addShpCleanerJob(String userWorkspace, List<InfoPreview> infoPreviewList) {
        for (InfoPreview infoPreview : infoPreviewList) {
            this.addShpCleanerJob(userWorkspace, infoPreview);
        }
    }

    private void scheduleTrigger(TriggerKey triggerKey, Trigger trigger) {
        try {
            if (this.scheduler.getScheduler().checkExists(triggerKey)) {
                this.scheduler.getScheduler().rescheduleJob(triggerKey, trigger);
            } else {
                this.scheduler.getScheduler().scheduleJob(trigger);
            }
        } catch (SchedulerException ex) {
            logger.error("Error adding publisher cleaner job: " + ex);
        }
    }

    private void addTifCleanerJob(String userWorkspace, String layerName, String filePath) {
        TriggerKey triggerKey = new TriggerKey(userWorkspace + ":" + layerName, PublisherScheduler.PUBLISHER_GROUP);
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.add(Calendar.MINUTE, 30);
        Trigger trigger = TriggerBuilder.newTrigger().forJob(this.scheduler.getCleanerJobTifDetail()).
                withIdentity(triggerKey).
                withDescription("Runs after 30 minutes").
                startAt(calendar.getTime()).
                withSchedule(CalendarIntervalScheduleBuilder.calendarIntervalSchedule().
                withMisfireHandlingInstructionFireAndProceed()).
                build();
        trigger.getJobDataMap().put(PublisherTifCleanerJob.USER_WORKSPACE, userWorkspace);
        trigger.getJobDataMap().put(PublisherTifCleanerJob.FILE_NAME, layerName);
        trigger.getJobDataMap().put(PublisherTifCleanerJob.FILE_PATH, filePath);
        trigger.getJobDataMap().put(PublisherTifCleanerJob.PUBLISHER_SERVICE, this);
        this.scheduleTrigger(triggerKey, trigger);
    }

    /******************************
     *
     * @param file
     * @return returns the URL to the PNG of the layer uploaded in the ZIP file
     * @throws ResourceNotFoundFault this exception may be launched when: the ZIP file does not contain a SHP file
     * this service upload in the user workspace a shapefile. The ZIP file must contain the shp, the prj, the shx and the dbf files. 
     * Otherwise, an exception is raised
     ******************************/
    @Override
    public List<InfoPreview> uploadZIPInPreview(String sessionID, String userName, File file) throws ResourceNotFoundFault {
        logger.info("Call to uploadZIPInPreview");
        reload();
        String tempUserDir = PublishUtility.createDir(this.geoportalDir + userName);
        String tempUserZipDir = PublishUtility.createDir(tempUserDir + PublishUtility.zipDirName);
        String tempUserTifDir = PublishUtility.createDir(tempUserDir + PublishUtility.tifDirName);
        // decompress the zip file in the <tmp>/shp directory, read info and create <layername>.zip files for each layer in <tmp>/zip
        // and decompress the geotiff files in user/tiff direcotry
        List<LayerInfo> infoShapeList = getInfoFromCompressedShape(userName, file,
                tempUserDir, tempUserZipDir, tempUserTifDir);
        if (infoShapeList.isEmpty()) {
            throw new ResourceNotFoundFault("The ZIP archive does not contain shp or geotiff files");
        }
        List<InfoPreview> infoPreviewList = new ArrayList<InfoPreview>();
        String userWorkspace = getWorkspace(userName);
        InfoPreview infoPreview = null;
        for (LayerInfo info : infoShapeList) {
            if (info.isShp) {
                infoPreview = this.publishShpInPreview(userName, userWorkspace, info, tempUserZipDir);
                this.addShpCleanerJob(userWorkspace, infoPreview);
            } else {
                File fileInTifDir = new File(tempUserTifDir, info.name + ".tif");
                infoPreview = this.publishTifInPreview(userName, userWorkspace, fileInTifDir, info.name,
                        info.epsg, info.sld);
                this.addTifCleanerJob(userWorkspace, info.name, fileInTifDir.getAbsolutePath());
            }
            infoPreviewList.add(infoPreview);
        }
        return infoPreviewList;
    }

    private InfoPreview publishTifInPreview(String userName, String userWorkspace,
            File fileInTifDir, String fileName, String epsg, String sld) {
        InfoPreview infoPreview = null;
        GeoTiffOverviews.overviewTiff(overviewsConfiguration, fileInTifDir.getAbsolutePath());
        try {
//                logger.info(
//                        "\n INFO: STYLE TO PUBLISH " + info.sld + " NAME :" + info.name);
//                logger.info(
//                        "\n INFO: CREATE DATASTORE " + userWorkspace + " NAME :" + info.name);
            RESTCoverageStore store = restPublisher.publishExternalGeoTIFF(userWorkspace,
                    fileName, fileInTifDir, epsg, sld);
            if (store != null) {
                logger.info(
                        fileInTifDir + " correctly published in the " + userWorkspace + " workspace");
                infoPreview = getTIFURLByLayerName(userName, fileName);
            } else {
                logger.info(
                        "Some problems occured when publishing " + fileInTifDir
                        + " into the " + userWorkspace + " workspace: may be the layer is already published in a db");
                infoPreview = new InfoPreview(fileName,
                        "Some problems occured when publishing " + fileInTifDir
                        + " into the " + userWorkspace + " workspace");
            }
        } catch (Exception ex) {
            logger.info("Some problems occured when publishing " + fileName
                    + " into the " + userWorkspace + " workspace");
            ex.printStackTrace();
            infoPreview = new InfoPreview(fileName, "Some problems occured when publishing "
                    + fileName + " into the " + userWorkspace + " workspace");
        }
        // calculate the PNG URL to return
        infoPreview.setUrl(infoPreview.getUrl() + "/wms");
        return infoPreview;
    }

    private InfoPreview publishShpInPreview(String userName, String userWorkspace, LayerInfo info,
            String tempUserZipDir) {
        InfoPreview infoPreview = null;
        String datatStoreName = info.name;
        // check if the dataStore already exists
        if (!existsDataStore(userWorkspace, datatStoreName)) {
            GSPostGISDatastoreEncoder encoder = PublishUtility.generateEncoder(datatStoreName);
            restPublisher.createPostGISDatastore(userName, encoder);
        } else {
            boolean result = restPublisher.unpublishFeatureType(userWorkspace, datatStoreName, info.name);
            logger.info("Removing existing FeatureType: " + info.name + " with result: " + result);
        }
        // create the <layername>.zip file
        String fileName = tempUserZipDir + info.name + ".zip";
        File tempFile = new File(fileName);
        //publish the <layername>.zip file in the user workspace
        logger.info(
                "\n INFO: STYLE TO PUBLISH " + info.sld + " NAME :" + info.name);
        logger.info(
                "\n INFO: CREATE DATASTORE " + userWorkspace + " NAME :" + info.name);
        try {
            boolean published = restPublisher.publishShp(userWorkspace, datatStoreName, info.name, tempFile, info.epsg, info.sld);
            if (published) {
                logger.info(
                        info.name + " correctly published in the " + userWorkspace + " workspace " + info.name);
                infoPreview = getSHPURLByDataStoreName(userWorkspace, info.name);
            } else {
                logger.info(
                        "Some problems occured when publishing " + info.name + " into the " + userWorkspace + " workspace: may be the layer is already published in a db");
                infoPreview = new InfoPreview(info.name,
                        "Some problems occured when publishing " + info.name + " into the " + userWorkspace + " workspace");
            }
        } catch (Exception ex) {
            logger.info(
                    "Some problems occured when publishing " + info.name + " into the " + userWorkspace + " workspace");
            ex.printStackTrace();
            infoPreview = new InfoPreview(info.name,
                    "Some problems occured when publishing " + info.name + " into the " + userWorkspace + " workspace");
        } finally {
            tempFile.delete();
        }
        //This code returns the previous publisher layer without overwriting it
//            } else {
//                infoPreview = getSHPURLByDataStoreName(username, info.name);
//                infoPreview.setMessage(
//                        "The data store " + datatStoreName + " in " + userWorkspace + " already exists");
//            }
        // calculate the PNG URL to return
        infoPreview.setUrl(infoPreview.getUrl() + "/wms");
        return infoPreview;
    }

    /***********************
     *
     * @param shpFile
     * @param dbfFile
     * @param shxFile
     * @param prjFile
     * @return
     * @throws ResourceNotFoundFault
     * this service uploads in the previews workspace a shapefile. The shapefile file must contain the shp, the prj, the shx and the dbf files. Otherwise, an exception is raised
     */
    @Override
    public List<InfoPreview> uploadShapeInPreview(String sessionID, String username, File shpFile,
            File dbfFile, File shxFile, File prjFile, File sldFile) throws ResourceNotFoundFault {
//        InfoPreview infoPreview = null;
//        List<InfoPreview> listInfoPreview = new ArrayList<InfoPreview>();
//        String name = shpFile.getName().substring(0,
//                shpFile.getName().length() - 4);
//        String tempUserDirZIP = PublishUtility.createDir(this.zipTempDir + sessionID);
//        try {
//            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
//                    tempUserDirZIP + "temp.zip"));
//            out = PublishUtility.compress(out, shpFile);
//            out = PublishUtility.compress(out, dbfFile);
//            out = PublishUtility.compress(out, shxFile);
//            out = PublishUtility.compress(out, prjFile);
//            if (sldFile != null) {
//                out = PublishUtility.compress(out, sldFile);
//            }
//            out.close();
//            File compressedFile = new File(tempUserDirZIP + "temp.zip");
//            // compressedFile.deleteOnExit();
//            return uploadZIPInPreview(sessionID, username, compressedFile);
//        } catch (Exception ex) {
//            logger.info(
//                    "the zip file cannot be created because some files are missing or are malformed");
//            infoPreview = new InfoPreview(name,
//                    "Some problems occured when publishing " + name + " into the " + previewWorkspace + " workspace. The zip file cannot be created because some files are missing or are malformed. Check whether the shp, dbf, shx, prj files are well-formed");
//            listInfoPreview.add(infoPreview);
//            return listInfoPreview;
//        }
        return null;
    }
//
//    /**********************
//     *
//     * @param userName this is the user name who
//     * @param list the list of
//     * @param shpFileName
//     * @return
//     * @throws ResourceNotFoundFault
//     * @throws Exception
//     */
//    @Override
//    public byte[] createSHP(String sessionID, List<Feature> list,
//            String shpFileName) throws ResourceNotFoundFault, Exception {
//        SimpleFeatureTypeBuilder typeBuilder = new SimpleFeatureTypeBuilder();
//        logger.info("\n INFO: Parsing feature schema");
//        if (list.size() > 0) {
//            GeometryFactory geometryFactory = new GeometryFactory();
//
//            WKTReader reader = new WKTReader(geometryFactory);
//            try {
//                Geometry geometry = reader.read(list.get(0).getWkt());
//                typeBuilder.setDefaultGeometry("the_geom");
//                typeBuilder.add("the_geom", geometry.getClass());
//            } catch (ParseException e) {
//                throw new ResourceNotFoundFault(
//                        "Cannot identify the geometry class");
//            }
//            List<Attribute> attributes = list.get(0).getAttributes();
//            for (Attribute attribute : attributes) {
//                Class clazz = null;
//                if (attribute.getType().equals("int")) {
//                    clazz = Integer.class;
//                }
//                if (attribute.getType().equals("double")) {
//                    clazz = Double.class;
//                }
//                if (attribute.getType().equals("float")) {
//                    clazz = Float.class;
//                }
//                if (attribute.getType().equals("String")) {
//                    clazz = String.class;
//                }
//                if (attribute.getType().equals("char")) {
//                    clazz = Character.class;
//                }
//                typeBuilder.add(attribute.getName(), clazz);
//            }
//
//        }
//
//        typeBuilder.setName("SHP_CREATION");
//        logger.info("\n  INFO: Parsing feature data ");
//        SimpleFeatureBuilder fb = new SimpleFeatureBuilder(
//                typeBuilder.buildFeatureType());
//        SimpleFeatureCollection result = FeatureCollections.newCollection();
//        GeometryFactory geometryFactory = new GeometryFactory();
//        WKTReader reader = new WKTReader(geometryFactory);
//        Geometry geometry = null;
//        int featureID = 0;
//        for (Feature feature : list) {
//            List<Attribute> attributes = feature.getAttributes();
//            try {
//                geometry = reader.read(feature.getWkt());
//            } catch (ParseException e) {
//                continue;
//            }
//            fb.set("the_geom", geometry);
//            for (Attribute attribute : attributes) {
//                Object value = null;
//                logger.info(
//                        "Name: " + attribute.getName() + " type:" + attribute.getType() + " value: " + attribute.getValue());
//                if (attribute.getType().equals("int")) {
//                    value = new Integer(Integer.parseInt(attribute.getValue()));
//                }
//                if (attribute.getType().equals("double")) {
//                    value = new Double(Double.parseDouble(attribute.getValue()));
//                }
//                if (attribute.getType().equals("float")) {
//                    value = new Float(Float.parseFloat(attribute.getValue()));
//                }
//                if (attribute.getType().equals("String")) {
//                    value = attribute.getValue();
//                }
//                fb.set(attribute.getName(), value);
//                result.add(fb.buildFeature("feature_" + (featureID++)));
//            }
//
//
//        }
//        logger.info("\n  INFO: Creating SHP files ");
//        FeatureWriter<SimpleFeatureType, SimpleFeature> writer = null;
//        SimpleFeatureIterator iterator = null;
//        Transaction transaction = null;
//        try {
//            String tempUserDir = PublishUtility.createDir(
//                    this.shpTempDir + sessionID);
//            ShapefileDataStoreFactory dataStoreFactory = new ShapefileDataStoreFactory();
//            Map<String, Serializable> params = new HashMap<String, Serializable>();
//            String shpFullPathName = tempUserDir + shpFileName;
//            File newFile = new File(shpFullPathName);
//            params.put("url", newFile.toURI().toURL());
//            params.put("create spatial index", Boolean.TRUE);
//            ShapefileDataStore newDataStore = (ShapefileDataStore) dataStoreFactory.createNewDataStore(
//                    params);
//            newDataStore.forceSchemaCRS(DefaultGeographicCRS.WGS84);
//            newDataStore.createSchema(result.getSchema()); // DA ECCEZIONE
//            writer = newDataStore.getFeatureWriter(Transaction.AUTO_COMMIT);
//            iterator = result.features();
//            transaction = new DefaultTransaction("Reproject");
//            while (iterator.hasNext()) {
//                // copy the contents of each feature and transform the geometry
//                SimpleFeature feature = iterator.next();
//                SimpleFeature copy = writer.next();
//                copy.setAttributes(feature.getAttributes());
//                Geometry geometrySource = (Geometry) feature.getDefaultGeometry();
//                copy.setDefaultGeometry(geometrySource);
//                writer.write();
//            }
//            transaction.commit();
//            logger.info("\n  INFO: Compressing SHP Files ");
//            String tempUserZipDir = PublishUtility.createDir(this.zipTempDir + sessionID);
//            String name = shpFileName.substring(0, shpFileName.length() - 4);
//            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
//                    tempUserZipDir + name + ".zip"));
//            out = PublishUtility.compress(out, new File(
//                    tempUserDir + name + ".shp"));
//            out = PublishUtility.compress(out, new File(
//                    tempUserDir + name + ".dbf"));
//            out = PublishUtility.compress(out, new File(
//                    tempUserDir + name + ".shx"));
//            out = PublishUtility.compress(out, new File(
//                    tempUserDir + name + ".prj"));
//            out.close();
//            return getStreamOfByteFromFile(tempUserZipDir + name + ".zip");
//        } catch (MalformedURLException ex) {
//            throw new ResourceNotFoundFault("Malformed URL Exception");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            throw new ResourceNotFoundFault("IO Exception");
//        } catch (Exception ex) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            ex.printStackTrace();
//            throw new ResourceNotFoundFault("Exception");
//        } finally {
//            writer.close();
//            iterator.close();
//            transaction.close();
//        }
//    }
//
//    private byte[] getStreamOfByteFromFile(String fileName) throws FileNotFoundException, IOException {
//        File file = new File(fileName);
//        InputStream is = new FileInputStream(file);
//
//        // Get the size of the file
//        long length = file.length();
//
//        if (length > Integer.MAX_VALUE) {
//            // File is too large
//        }
//
//        // Create the byte array to hold the data
//        byte[] bytes = new byte[(int) length];
//
//        // Read in the bytes
//        int offset = 0;
//        int numRead = 0;
//        while (offset < bytes.length && (numRead = is.read(bytes, offset,
//                bytes.length - offset)) >= 0) {
//            offset += numRead;
//        }
//
//        // Ensure all the bytes have been read in
//        if (offset < bytes.length) {
//            throw new IOException(
//                    "Could not completely read file " + file.getName());
//        }
//
//        // Close the input stream and return bytes
//        is.close();
//        return bytes;
//    }
//
//    private boolean exportCRS(File shpFile, int code) {
//        SimpleFeatureSource featureSource = null;
//        FeatureWriter<SimpleFeatureType, SimpleFeature> writer = null;
//        Transaction transaction = null;
//        MathTransform transform = null;
//        try {
//            FileDataStore store = FileDataStoreFinder.getDataStore(shpFile);
//            featureSource = store.getFeatureSource();
//            SimpleFeatureType schema = featureSource.getSchema();
//            CoordinateReferenceSystem dataCRS = schema.getCoordinateReferenceSystem();
//            CoordinateReferenceSystem toCRS = CRS.decode("EPSG:" + code);
//            boolean lenient = true; // allow for some error due to different datums
//            transform = CRS.findMathTransform(dataCRS, toCRS, lenient);
//            DataStoreFactorySpi factory = new ShapefileDataStoreFactory();
//            Map<String, Serializable> create = new HashMap<String, Serializable>();
//            create.put("url", shpFile.toURI().toURL());
//            create.put("create spatial index", Boolean.TRUE);
//            DataStore dataStore = factory.createNewDataStore(create);
//            SimpleFeatureType featureType = SimpleFeatureTypeBuilder.retype(
//                    schema, toCRS);
//            dataStore.createSchema(featureType);
//            transaction = new DefaultTransaction("Reproject");
//            writer = dataStore.getFeatureWriterAppend(featureType.getTypeName(),
//                    transaction);
//        } catch (Exception e) {
//            return false;
//        }
//
//        SimpleFeatureCollection featureCollection = null;
//        SimpleFeatureIterator iterator = null;
//        try {
//            featureCollection = featureSource.getFeatures();
//            iterator = featureCollection.features();
//            while (iterator.hasNext()) {
//                // copy the contents of each feature and transform the geometry
//                SimpleFeature feature = iterator.next();
//                SimpleFeature copy = writer.next();
//                copy.setAttributes(feature.getAttributes());
//
//                Geometry geometry = (Geometry) feature.getDefaultGeometry();
//                Geometry geometry2 = JTS.transform(geometry, transform);
//
//                copy.setDefaultGeometry(geometry2);
//                writer.write();
//            }
//            transaction.commit();
//            return true;
//        } catch (Exception problem) {
//            try {
//                problem.printStackTrace();
//                transaction.rollback();
//                return false;
//            } catch (IOException ex) {
//                return false;
//            }
//        } finally {
//            try {
//                writer.close();
//                iterator.close();
//                transaction.close();
//                return false;
//            } catch (IOException ex) {
//                return false;
//            }
//
//        }
//    }
}
