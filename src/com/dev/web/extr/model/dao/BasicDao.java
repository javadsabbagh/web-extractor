package com.dev.web.extr.model.dao;

import java.io.Serializable;
import java.util.List;

/**
 * This DAO functionalities are common among all its implementations..
 * @author javad
 */
public interface BasicDao<T, Id extends Serializable> {

    public void persist(T entity);

    public void update(T entity);

    public T findById(Id id);

    public void delete(T entity);

    public List<T> findAll();

    public void deleteAll();
}
