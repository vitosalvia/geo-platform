/*
 *  geo-platform
 *  Rich webgis framework
 *  http://geo-platform.org
 * ====================================================================
 *
 * Copyright (C) 2008-2012 geoSDI Group (CNR IMAA - Potenza - ITALY).
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
package org.geosdi.geoplatform.gui.client.widget;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.google.gwt.event.shared.EventBus;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.geosdi.geoplatform.gui.client.widget.components.MainViewFinderWidget;
import org.geosdi.geoplatform.gui.client.widget.components.filters.FiltersFinderWidget;

/**
 *
 * @author Vincenzo Monteverde <vincenzo.monteverde@geosdi.org>
 * @author Giuseppe La Scaleia <giuseppe.lascaleia@geosdi.org>
 */
@Singleton
public class CatalogFinderWidget extends GeoPlatformWindow {

    private TreePanel tree;
    private FiltersFinderWidget filtersWidget;
    private MainViewFinderWidget mainViewWidget;
    private EventBus bus;

    @Inject
    public CatalogFinderWidget(FiltersFinderWidget filtersWidget,
            MainViewFinderWidget mainViewWidget, EventBus bus) {
        super(true);
        this.filtersWidget = filtersWidget;
        this.mainViewWidget = mainViewWidget;
        this.bus = bus;
    }

    public CatalogFinderWidget(boolean lazy) {
        super(lazy);
    }

    public CatalogFinderWidget(boolean lazy, TreePanel theTree) {
        super(lazy);
        tree = theTree;
    }

    @Override
    public void addComponent() {
        // TODO
        // For now the component are added here but we must use GIN for initialization
        addWestWidget();
        addCenterWidget();
    }

    @Override
    public void initSize() {
        super.setSize(950, 600);
        super.setHeading("GeoPlatform Catalog Finder UI");
    }

    @Override
    public void setWindowProperties() {
        super.setResizable(false);
        super.setModal(false);
        super.setCollapsible(true);
        super.setPlain(true);

        super.setLayout(new BorderLayout());
    }

    private void addWestWidget() {
        BorderLayoutData westData = new BorderLayoutData(LayoutRegion.WEST, 350);
        westData.setMargins(new Margins(0, 5, 0, 0));

        super.add(this.filtersWidget, westData);
    }

    private void addCenterWidget() {
        BorderLayoutData centerData = new BorderLayoutData(LayoutRegion.CENTER);
        centerData.setMargins(new Margins(0));

        super.add(this.mainViewWidget, centerData);
    }
}
