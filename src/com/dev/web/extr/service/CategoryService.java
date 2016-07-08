package com.dev.web.extr.service;

import com.dev.web.extr.model.dao.CategoryDao;
import com.dev.web.extr.model.entity.Category;
import java.util.List;

/**
 *
 * @author javad
 */
public class CategoryService {

    private static CategoryDao categoryDao;

    public CategoryService() {
        categoryDao = new CategoryDao();
    }

    public void persist(Category entity) {
        categoryDao.openCurrentSessionwithTransaction();
        categoryDao.persist(entity);
        categoryDao.closeCurrentSessionwithTransaction();
    }

    public void update(Category entity) {
        categoryDao.openCurrentSessionwithTransaction();
        categoryDao.update(entity);
        categoryDao.closeCurrentSessionwithTransaction();
    }

    public Category findById(Integer id) {
        categoryDao.openCurrentSession();
        Category category = categoryDao.findById(id);
        categoryDao.closeCurrentSession();
        return category;
    }

    public void delete(Integer id) {
        categoryDao.openCurrentSessionwithTransaction();
        Category category = categoryDao.findById(id);
        categoryDao.delete(category);
        categoryDao.closeCurrentSessionwithTransaction();
    }

    public List<Category> findAll() {
        categoryDao.openCurrentSession();
        List<Category> categorys = categoryDao.findAll();
        categoryDao.closeCurrentSession();
        return categorys;
    }

    public void deleteAll() {
        categoryDao.openCurrentSessionwithTransaction();
        categoryDao.deleteAll();
        categoryDao.closeCurrentSessionwithTransaction();
    }

    public CategoryDao categoryDao() {
        return categoryDao;
    }
}
