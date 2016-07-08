package com.dev.web.extr.service;

import com.dev.web.extr.model.dao.ProvinceDao;
import com.dev.web.extr.model.entity.Province;
import java.util.List;

/**
 *
 * @author Javad
 */
public class ProvinceService {

    private static ProvinceDao provinceDao;

    public ProvinceService() {
        provinceDao = new ProvinceDao();
    }

    public void persist(Province entity) {
        provinceDao.openCurrentSessionwithTransaction();
        provinceDao.persist(entity);
        provinceDao.closeCurrentSessionwithTransaction();
    }

    public void update(Province entity) {
        provinceDao.openCurrentSessionwithTransaction();
        provinceDao.update(entity);
        provinceDao.closeCurrentSessionwithTransaction();
    }

    public Province findById(Integer id) {
        provinceDao.openCurrentSession();
        Province province = provinceDao.findById(id);
        provinceDao.closeCurrentSession();
        return province;
    }

    public void delete(Integer id) {
        provinceDao.openCurrentSessionwithTransaction();
        Province province = provinceDao.findById(id);
        provinceDao.delete(province);
        provinceDao.closeCurrentSessionwithTransaction();
    }

    public List<Province> findAll() {
        provinceDao.openCurrentSession();
        List<Province> provinces = provinceDao.findAll();
        provinceDao.closeCurrentSession();
        return provinces;
    }

    public void deleteAll() {
        provinceDao.openCurrentSessionwithTransaction();
        provinceDao.deleteAll();
        provinceDao.closeCurrentSessionwithTransaction();
    }

    public ProvinceDao provinceDao() {
        return provinceDao;
    }
}
