package org.lab3.wed.weblab3.DB;

import io.github.cdimascio.dotenv.Dotenv;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.lab3.wed.weblab3.DB.Entity.Results;

import java.time.LocalDateTime;

public class HibernateRunner {
    private static final Dotenv dotenv = Dotenv.load();
    private static final String path2 = dotenv.get("log");
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Results.class);
        try ( SessionFactory ses = configuration
                .setProperty(AvailableSettings.USER, dotenv.get("log"))
                .setProperty(AvailableSettings.PASS, dotenv.get("pass"))
                .buildSessionFactory();
             Session session = ses.openSession()
        ) {
            session.beginTransaction();

            session.save(Results.builder()
                            .id(2)
                            .x(1.1)
                            .y(2.2)
                            .z(3)
                            .hit(true)
                            .date(LocalDateTime.now())
                            .execTime(432423423)
                    .build());

            session.getTransaction().commit();
        }
    }
}
