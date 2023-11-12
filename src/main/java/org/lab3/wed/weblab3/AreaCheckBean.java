package org.lab3.wed.weblab3;

import lombok.Data;
import org.lab3.wed.weblab3.DB.Entity.Results;
import org.lab3.wed.weblab3.DB.Services.ResultsService;
import org.lab3.wed.weblab3.Model.CheckHit;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Named
@Data
public class AreaCheckBean implements Serializable {

    @Inject
    FormDataXBean xBean;
    @Inject
    FormDataYBean yBean;
    @Inject
    FormDataRBean rBean;
    @Inject
    OutResultsBean resBean;

    public void areaCheck(){
        final double X = Double.parseDouble(xBean.getX());
        final double Y = Double.parseDouble(yBean.getY());
        final double R = Double.parseDouble(rBean.getR());
        final long startCheck = System.nanoTime();
        final boolean hit = CheckHit.checkHit(X, Y, R);
        final long endCheck = System.nanoTime();

        Results resultsEntity = Results.builder()
                .x(X)
                .y(Y)
                .r(R)
                .hit(hit)
                .date(LocalDateTime.now())
                .execTime(endCheck - startCheck)
                .build();
        ResultsService.getInstance().saveResult(resultsEntity);

        List<Results> resultsList = resBean.getResults();
        resultsList.add(resultsEntity);
        resBean.setResults(resultsList);

    }
}
