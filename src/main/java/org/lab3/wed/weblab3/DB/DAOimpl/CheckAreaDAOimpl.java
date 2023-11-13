package org.lab3.wed.weblab3.DB.DAOimpl;

import org.hibernate.Session;
import org.lab3.wed.weblab3.DB.DAOInterfaces.CheckAreaDAO;
import org.lab3.wed.weblab3.DB.Entity.Results;
import org.lab3.wed.weblab3.DB.HibernateSessionFactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CheckAreaDAOimpl implements CheckAreaDAO {
    public static volatile CheckAreaDAOimpl INSTANCE;

    private CheckAreaDAOimpl(){}

    public static CheckAreaDAOimpl getInstance(){
        if (INSTANCE == null){
            synchronized (CheckAreaDAOimpl.class){
                if (INSTANCE == null){
                    INSTANCE = new CheckAreaDAOimpl();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void save(Results results) {
        EntityManagerFactory entityManagerFactory = HibernateSessionFactoryUtil.getSessionFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(results);
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void delete(Results results) {
        EntityManagerFactory entityManagerFactory = HibernateSessionFactoryUtil.getSessionFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(results);
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void update(Results results) {
        EntityManagerFactory entityManagerFactory = HibernateSessionFactoryUtil.getSessionFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(results);
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public List<Results> findAll() {
        List<Results> list = null;
        try{
            EntityManagerFactory entityManagerFactory = HibernateSessionFactoryUtil.getSessionFactory();
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            list = entityManager.createQuery("FROM Results r").getResultList();
            entityManager.close();
        }catch (Exception e) {
            System.err.println(e);
        }
        return list;
    }

//    @Override
//    public void save(Results results) {
//        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
//            session.beginTransaction();
//            session.save(results);
//            session.getTransaction().commit();
//        }
//    }
//
//    @Override
//    public void delete(Results results) {
//        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
//            session.beginTransaction();
//            session.delete(results);
//            session.getTransaction().commit();
//        }
//    }
//
//    @Override
//    public void update(Results results) {
//        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
//            session.beginTransaction();
//            session.update(results);
//            session.getTransaction().commit();
//        }
//    }
//
//    @Override
//    public List<Results> findAll() {
//        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
//            return (List<Results>) session.createQuery("From Results").list();
//        }
//    }
}
