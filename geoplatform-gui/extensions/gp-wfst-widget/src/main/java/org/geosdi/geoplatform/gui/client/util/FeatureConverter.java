/**
 *
 *    geo-platform
 *    Rich webgis framework
 *    http://geo-platform.org
 *   ====================================================================
 *
 *   Copyright (C) 2008-2016 geoSDI Group (CNR IMAA - Potenza - ITALY).
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
package org.geosdi.geoplatform.gui.client.util;

import com.google.common.collect.Lists;
import java.util.List;
import org.geosdi.geoplatform.connector.wfs.response.AttributeDTO;
import org.geosdi.geoplatform.gui.client.model.wfs.AttributeDetail;

/**
 *
 * @author Vincenzo Monteverde <vincenzo.monteverde@geosdi.org>
 */
public class FeatureConverter {

    private FeatureConverter() {
    }

    public static AttributeDetail convert(AttributeDTO attributeDTO) {
        AttributeDetail attribute = new AttributeDetail();
        attribute.setName(attributeDTO.getName());
        attribute.setValue(attributeDTO.getValue() == null
                ? "" : attributeDTO.getValue());
        attribute.setType(attributeDTO.getType());
        attribute.setMaxOccurs(attributeDTO.getMaxOccurs());
        attribute.setMinOccurs(attributeDTO.getMinOccurs());
        attribute.setNillable(attributeDTO.isNillable());
        return attribute;
    }

    public static AttributeDTO convert(AttributeDetail attribute) {
        AttributeDTO attributeDTO = new AttributeDTO();
        attributeDTO.setName(attribute.getName());
        attributeDTO.setValue(attribute.getValue());
        attributeDTO.setType(attribute.getType());
        attributeDTO.setMaxOccurs(attribute.getMaxOccurs());
        attributeDTO.setMinOccurs(attribute.getMinOccurs());
        attributeDTO.setNillable(attribute.isNillable());
        return attributeDTO;
    }

    public static List<AttributeDetail> convertDTOs(List<AttributeDTO> attributesDTO) {
        assert (attributesDTO != null) : "Attributes DTO must be not null.";
        List<AttributeDetail> attributes = Lists.<AttributeDetail>newArrayListWithCapacity(attributesDTO.size());
        for (AttributeDTO attributeDTO : attributesDTO) {
            attributes.add(FeatureConverter.convert(attributeDTO));
        }
        return attributes;
    }

    public static List<AttributeDTO> convertDetails(List<AttributeDetail> attributes) {
        assert (attributes != null) : "Attributes must be not null.";
        List<AttributeDTO> attributesDTO = Lists.<AttributeDTO>newArrayListWithCapacity(attributes.size());
        for (AttributeDetail attribute : attributes) {
            attributesDTO.add(FeatureConverter.convert(attribute));
        }
        return attributesDTO;
    }
}
