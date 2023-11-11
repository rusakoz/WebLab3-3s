package org.lab3.wed.weblab3;

import lombok.Data;
import org.lab3.wed.weblab3.DB.Entity.Results;
import org.lab3.wed.weblab3.DB.Services.ResultsService;
import org.lab3.wed.weblab3.Model.CheckHit;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;

@Named
@Data
public class AreaCheckBean implements Serializable {

    @Inject
    FormDataXBean xBean;
    @Inject
    FormDataYBean yBean;
    @Inject
    FormDataRBean rBean;

    public void areaCheck(){
        final double X = Double.parseDouble(xBean.getX());
        final double Y = Double.parseDouble(yBean.getY());
        final double R = Double.parseDouble(rBean.getR());
        final long startCheck = System.nanoTime();
        final boolean hit = CheckHit.checkHit(X, Y, R);
        final long endCheck = System.nanoTime();

        ResultsService.getInstance().saveResult(Results.builder()
                        .x(X)
                        .y(Y)
                        .r(R)
                        .hit(hit)
                        .date(LocalDateTime.now())
                        .execTime(endCheck - startCheck)
                .build());
    }
}
