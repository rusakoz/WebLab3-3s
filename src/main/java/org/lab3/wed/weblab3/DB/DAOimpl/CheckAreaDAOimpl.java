package org.lab3.wed.weblab3.DB.DAOimpl;

import org.hibernate.Session;
import org.lab3.wed.weblab3.DB.DAOInterfaces.CheckAreaDAO;
import org.lab3.wed.weblab3.DB.Entity.Results;
import org.lab3.wed.weblab3.DB.HibernateSessionFactoryUtil;

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
    public Results findById(long id) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Results.class, id);
        }
    }

    @Override
    public void save(Results results) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(results);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Results results) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(results);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Results results) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(results);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Results> findAll() {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return (List<Results>) session.createQuery("From Results").list();
        }
    }
}
