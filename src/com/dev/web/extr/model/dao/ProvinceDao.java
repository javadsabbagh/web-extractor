package com.dev.web.extr.model.dao;

import com.dev.web.extr.model.entity.Province;
import com.dev.web.extr.service.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author javad
 */
public class ProvinceDao implements BasicDao<Province, Integer> {

    private Session currentSession;

    private Transaction currentTransaction;

    public ProvinceDao() {
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
    public void persist(Province entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Province entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Province findById(Integer id) {
        Province province = (Province) getCurrentSession().get(Province.class, id);
        return province;
    }

    @Override
    public void delete(Province entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Province> findAll() {
        List<Province> provinces = (List<Province>) getCurrentSession().createQuery("from Province").list();
        return provinces;
    }

    @Override
    public void deleteAll() {
        List<Province> entityList = findAll();
        entityList.stream().
                forEach(this::delete);
    }
}
