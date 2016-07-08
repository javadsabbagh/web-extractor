package com.dev.web.extr.model.dao;

import com.dev.web.extr.model.entity.City;
import com.dev.web.extr.service.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author javad
 */
public class CityDao implements BasicDao<City, Integer>{

    private Session currentSession;

    private Transaction currentTransaction;

    public CityDao() {
    }

    public Session openCurrentSession() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    @Override
    public void persist(City entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(City entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public City findById(Integer id) {
        City city = (City) getCurrentSession().get(City.class, id);
        return city;
    }

    @Override
    public void delete(City entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<City> findAll() {
        List<City> citys = (List<City>) getCurrentSession().createQuery("from City").list();
        return citys;
    }

    @Override
    public void deleteAll() {
        List<City> entityList = findAll();
        entityList.stream().
                forEach(this::delete);
    }
    
}
