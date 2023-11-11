package org.lab3.wed.weblab3.DB;

import io.github.cdimascio.dotenv.Dotenv;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.lab3.wed.weblab3.DB.Entity.Results;

public class HibernateSessionFactoryUtil {
    private static volatile SessionFactory sessionFactory;
    private HibernateSessionFactoryUtil(){}
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            final Dotenv dotenv = Dotenv.load();
            synchronized (HibernateSessionFactoryUtil.class){
                if (sessionFactory == null){
                    Configuration configuration = new Configuration().configure();
                    configuration.addAnnotatedClass(Results.class);
                    sessionFactory = configuration
                            .setProperty(AvailableSettings.USER, dotenv.get("log"))
                            .setProperty(AvailableSettings.PASS, dotenv.get("pass"))
                            .buildSessionFactory();
                }
            }
        }
        return sessionFactory;
    }
}
