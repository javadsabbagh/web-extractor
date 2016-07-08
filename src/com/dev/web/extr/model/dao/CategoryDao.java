package com.dev.web.extr.model.dao;

import com.dev.web.extr.model.entity.Category;
import com.dev.web.extr.service.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author javad
 */
public class CategoryDao implements BasicDao<Category, Integer> {

    private Session currentSession;

    private Transaction currentTransaction;

    public CategoryDao() {
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
    public void persist(Category entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Category entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Category findById(Integer id) {
        Category category = (Category) getCurrentSession().get(Category.class, id);
        return category;
    }

    @Override
    public void delete(Category entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> findAll() {
        List<Category> categorys = (List<Category>) getCurrentSession().createQuery("from Category").list();
        return categorys;
    }

    @Override
    public void deleteAll() {
        List<Category> entityList = findAll();
        entityList.stream().
                forEach(this::delete);
    }

}
