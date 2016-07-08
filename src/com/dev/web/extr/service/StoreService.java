package com.dev.web.extr.service;

import com.dev.web.extr.model.dao.StoreDao;
import com.dev.web.extr.model.entity.Store;
import java.util.List;

/**
 *
 * @author javad
 */
public class StoreService {

    private static StoreDao storeDao;

    public StoreService() {
        storeDao = new StoreDao();
    }

    public void persist(Store entity) {
        storeDao.openCurrentSessionwithTransaction();
        storeDao.persist(entity);
        storeDao.closeCurrentSessionwithTransaction();
    }

    public void update(Store entity) {
        storeDao.openCurrentSessionwithTransaction();
        storeDao.update(entity);
        storeDao.closeCurrentSessionwithTransaction();
    }

    public Store findById(Integer id) {
        storeDao.openCurrentSession();
        Store store = storeDao.findById(id);
        storeDao.closeCurrentSession();
        return store;
    }

    public void delete(Integer id) {
        storeDao.openCurrentSessionwithTransaction();
        Store store = storeDao.findById(id);
        storeDao.delete(store);
        storeDao.closeCurrentSessionwithTransaction();
    }

    public List<Store> findAll() {
        storeDao.openCurrentSession();
        List<Store> stores = storeDao.findAll();
        storeDao.closeCurrentSession();
        return stores;
    }

    public void deleteAll() {
        storeDao.openCurrentSessionwithTransaction();
        storeDao.deleteAll();
        storeDao.closeCurrentSessionwithTransaction();
    }

    public StoreDao storeDao() {
        return storeDao;
    }
}
