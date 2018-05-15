/**
 * geo-platform
 * Rich webgis framework
 * http://geo-platform.org
 * ====================================================================
 * <p>
 * Copyright (C) 2008-2018 geoSDI Group (CNR IMAA - Potenza - ITALY).
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
package org.geosdi.geoplatform.gui.client.widget.wfs;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import org.geosdi.geoplatform.gui.client.puregwt.map.event.FeatureMapWidthEvent;
import org.geosdi.geoplatform.gui.client.puregwt.map.event.IncreaseWidthEvent;
import org.geosdi.geoplatform.gui.client.puregwt.toolbar.event.DecreasePaddingEvent;
import org.geosdi.geoplatform.gui.client.puregwt.toolbar.event.EditingToolbarPaddingEvent;
import org.geosdi.geoplatform.gui.client.widget.GeoPlatformContentPanel;
import org.geosdi.geoplatform.gui.puregwt.GPEventBus;

import javax.inject.Inject;

import static java.lang.Boolean.TRUE;

/**
 * @author Vito Salvia- CNR IMAA geoSDI Group
 * @email vito.salvia@gmail.com
 */
public class LayerSelectionWidget extends GeoPlatformContentPanel {

    public static final String ID = WFSWidgetNames.LAYER_SELECTION.name();
    //
    private final GPEventBus bus;
    //
    private FormPanel formPanel;
    private final FeatureMapWidthEvent increaseWidthEvent = new IncreaseWidthEvent();
    private final EditingToolbarPaddingEvent decreasePaddingEvent = new DecreasePaddingEvent();

    @Inject
    public LayerSelectionWidget(GPEventBus theBus) {
        super(TRUE);
        this.bus = theBus;
    }

    @Override
    public void addComponent() {
        this.createFormPanel();
    }

    @Override
    public void initSize() {
    }

    @Override
    public void collapse() {
        this.increaseWidthEvent.setWidth(super.getWidth());
        this.bus.fireEvent(increaseWidthEvent);
        this.bus.fireEvent(decreasePaddingEvent);
        super.collapse();
    }

    @Override
    public void setPanelProperties() {
        super.setId(ID);
        super.head.setText("Layer Selection");
        super.setBorders(false);
        super.setScrollMode(Style.Scroll.AUTO);
    }

    private void createFormPanel() {
        this.formPanel = new FormPanel();
        formPanel.setHeaderVisible(false);
        formPanel.setBorders(false);
        formPanel.setBodyBorder(false);
        formPanel.setLayout(new FlowLayout());
        super.add(formPanel);
    }
}