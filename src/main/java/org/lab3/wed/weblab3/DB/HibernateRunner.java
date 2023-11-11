package org.lab3.wed.weblab3.DB;

import io.github.cdimascio.dotenv.Dotenv;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.lab3.wed.weblab3.DB.Entity.Results;
import org.lab3.wed.weblab3.DB.Services.ResultsService;

import java.time.LocalDateTime;

public class HibernateRunner {

    public static void main(String[] args) {
        ResultsService resultsService = ResultsService.getInstance();
        resultsService.saveResult(
                Results.builder()
                        .x(1.17733)
                        .y(2.277)
                        .r(377)
                        .hit(true)
                        .date(LocalDateTime.now())
                        .execTime(432423423)
                        .build()
        );
    }
}
