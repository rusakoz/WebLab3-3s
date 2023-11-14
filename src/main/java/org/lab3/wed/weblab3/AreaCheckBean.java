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
    FormDataBean dataBean;
    @Inject
    OutResultsBean resBean;

    public void areaCheck(){
        final double X = dataBean.getX();
        final double Y = Double.parseDouble(dataBean.getY());
        final double R = Double.parseDouble(dataBean.getR());
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
        try {
            ResultsService.getInstance().saveResult(resultsEntity);
        } catch (Exception e) {
            System.err.println("Ошибка сохранения данных");
        }

        List<Results> resultsList = resBean.getResults();
        resultsList.add(resultsEntity);
        resBean.setResults(resultsList);

    }
}
