package com.dev.web.extr.app;

import com.dev.web.extr.model.Employee;
import com.dev.web.extr.service.HibernateUtil;
import java.util.Date;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
 
/**
 * @author Pankaj Kumar
 */ 
public class HibernateAnnotationConfigMain {
 
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("David");
        emp.setRole("Developer");
        emp.setInsertTime(new Date());
         
        //Get Session
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        Session session = sessionFactory.getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(emp);
        //Commit transaction
        session.getTransaction().commit();
        System.out.println("Employee ID="+emp.getId());
         
        //terminate session factory, otherwise program won't end
        sessionFactory.close();
    }
 
}