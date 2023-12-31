package org.lab3.wed.weblab3.DB;

import io.github.cdimascio.dotenv.Dotenv;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class EntityManagerFactoryUtil {
    private static volatile EntityManagerFactory entityManagerFactory;
    private static final Map<String, String> properties = new HashMap<>();
    private EntityManagerFactoryUtil(){}

    public static EntityManagerFactory getSessionFactory() {
        if (entityManagerFactory == null) {
            final Dotenv dotenv = Dotenv.load();
            synchronized (EntityManagerFactoryUtil.class){
                if (entityManagerFactory == null){
                    properties.put("javax.persistence.jdbc.user", dotenv.get("log"));
                    properties.put("javax.persistence.jdbc.password", dotenv.get("pass"));
                    entityManagerFactory = Persistence.createEntityManagerFactory("eclipseLink", properties);
                }
            }
        }
        return entityManagerFactory;
    }

    // Hibernate
//    public static SessionFactory getSessionFactory() {
//        if (sessionFactory == null) {
//            final Dotenv dotenv = Dotenv.load();
//            synchronized (HibernateSessionFactoryUtil.class){
//                if (sessionFactory == null){
//                    Configuration configuration = new Configuration().configure();
//                    configuration.addAnnotatedClass(Results.class);
//                    sessionFactory = configuration
//                            .setProperty(AvailableSettings.USER, dotenv.get("log"))
//                            .setProperty(AvailableSettings.PASS, dotenv.get("pass"))
//                            .buildSessionFactory();
//                }
//            }
//        }
//        return sessionFactory;
//    }
}
