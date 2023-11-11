package org.lab3.wed.weblab3;

import lombok.Data;

import org.lab3.wed.weblab3.DB.Entity.Results;
import org.lab3.wed.weblab3.DB.Services.ResultsService;

import javax.inject.Named;
import java.util.List;

@Named
@Data
public class OutResultsBean {
    public List<Results> getResults(){
        return ResultsService.getInstance().findAllResults();
    }
}
