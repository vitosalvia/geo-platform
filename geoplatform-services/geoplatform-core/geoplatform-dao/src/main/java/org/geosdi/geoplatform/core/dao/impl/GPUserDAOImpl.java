//<editor-fold defaultstate="collapsed" desc="License">
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
//</editor-fold>
package org.geosdi.geoplatform.core.dao.impl;

import com.googlecode.genericdao.search.ISearch;
import com.googlecode.genericdao.search.Search;
import java.util.List;

import org.geosdi.geoplatform.core.dao.GPUserDAO;
import org.geosdi.geoplatform.core.model.GPUser;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author giuseppe
 * 
 */
@Transactional
public class GPUserDAOImpl extends BaseDAO<GPUser, Long> implements GPUserDAO {

    @Override
    public void persist(GPUser... users) {
        super.persist(users);
    }

    @Override
    public GPUser merge(GPUser user) {
        return super.merge(user);
    }

    @Override
    public GPUser[] merge(GPUser... users) {
        return super.merge(users);
    }

    @Override
    public boolean remove(GPUser user) {
        return super.remove(user);
    }

    @Override
    public boolean removeById(Long userId) {
        return super.removeById(userId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<GPUser> search(ISearch search) {
        return super.search(search);
    }

    @Override
    public GPUser findByUsername(String username) {
        Search search = new Search();
        search.addFilterEqual("username", username);
        return super.searchUnique(search);
    }

    @Override
    public GPUser findByEmail(String email) {
        Search search = new Search();
        search.addFilterEqual("emailAddress", email);
        return super.searchUnique(search);
    }

//    @Override
//    public boolean resetDefaultProject(Long defaultProjectId) {
//        Search search = new Search();
//        search.addFilterEqual("defaultProject.id", defaultProjectId);
//
//        List<GPUser> users = super.search(search);
//        for (GPUser user : users) {
//            user.setDefaultProject(null);
//            super.merge(user);
//        }
//
//        return true;
//    }
}
