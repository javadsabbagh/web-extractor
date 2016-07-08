package com.dev.web.extr.model.dao;

import com.dev.web.extr.model.entity.Store;
import com.dev.web.extr.service.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author javad
 */
public class StoreDao implements BasicDao<Store, Integer> {

    private Session currentSession;

    private Transaction currentTransaction;

    public StoreDao() {
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
    public void persist(Store entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Store entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Store findById(Integer id) {
        Store store = (Store) getCurrentSession().get(Store.class, id);
        return store;
    }

    @Override
    public void delete(Store entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Store> findAll() {
        List<Store> stores = (List<Store>) getCurrentSession().createQuery("from Store").list();
        return stores;
    }

    @Override
    public void deleteAll() {
        List<Store> entityList = findAll();
        entityList.stream().
                forEach(this::delete);
    }

}
