package org.lab3.wed.weblab3;

import lombok.Data;

import org.lab3.wed.weblab3.DB.Entity.Results;
import org.lab3.wed.weblab3.DB.Services.ResultsService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.List;

@Named
@Data
@ApplicationScoped
public class OutResultsBean {
    private List<Results> results = null;
    public List<Results> getResults(){
        if (results == null){
            results = ResultsService.getInstance().findAllResults();
        }
        return results;
    }
}
