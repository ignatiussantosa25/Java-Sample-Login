/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;


/**
 *
 * @author Ignatius
 */
public class FunctionsDAO {

    private Session session;
    private Transaction transaction;
    private final SessionFactory factory;
    public FunctionsDAO fdao;

    public FunctionsDAO() {
        factory = HibernateUtil.getSessionFactory();
    }

    public final boolean save(Object object) {
        boolean flag = false;
        try {
            session = factory.getCurrentSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
            flag = true;
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
//            session.close();
        }
        return flag;
    }
    

    public final boolean delete(Class type, Serializable srlzbl) {
        boolean flag = false;
        try {
            session = factory.getCurrentSession();
            transaction = session.beginTransaction();
            session.delete(session.get(type, srlzbl));
            transaction.commit();
            flag = true;
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
//            session.close();
        }
        return flag;
    }

    public final List<Object> getAll(String query) {
        List<Object> data = new ArrayList<>();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            data = session
                    .createQuery(query)
                    .list();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
//            session.close();
        }
        return data;
    }

    public final Object getById(String query) {
        Object obj = new Object();
        try {
            session = factory.getCurrentSession();
            transaction = session.beginTransaction();
            obj = session.createQuery(query).uniqueResult();
            
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
//            session.close();
        }
        return obj;
    }
}
