package com.dev.web.extr.service;

import com.dev.web.extr.model.dao.CityDao;
import com.dev.web.extr.model.entity.City;
import java.util.List;

/**
 *
 * @author javad
 */
public class CityService {

    private static CityDao cityDao;

    public CityService() {
        cityDao = new CityDao();
    }

    public void persist(City entity) {
        cityDao.openCurrentSessionwithTransaction();
        cityDao.persist(entity);
        cityDao.closeCurrentSessionwithTransaction();
    }

    public void update(City entity) {
        cityDao.openCurrentSessionwithTransaction();
        cityDao.update(entity);
        cityDao.closeCurrentSessionwithTransaction();
    }

    public City findById(Integer id) {
        cityDao.openCurrentSession();
        City city = cityDao.findById(id);
        cityDao.closeCurrentSession();
        return city;
    }

    public void delete(Integer id) {
        cityDao.openCurrentSessionwithTransaction();
        City city = cityDao.findById(id);
        cityDao.delete(city);
        cityDao.closeCurrentSessionwithTransaction();
    }

    public List<City> findAll() {
        cityDao.openCurrentSession();
        List<City> citys = cityDao.findAll();
        cityDao.closeCurrentSession();
        return citys;
    }

    public void deleteAll() {
        cityDao.openCurrentSessionwithTransaction();
        cityDao.deleteAll();
        cityDao.closeCurrentSessionwithTransaction();
    }

    public CityDao cityDao() {
        return cityDao;
    }
}
