package org.lab3.wed.weblab3;

import lombok.Data;

import org.lab3.wed.weblab3.DB.Entity.Results;
import org.lab3.wed.weblab3.DB.Services.ResultsService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@Data
@SessionScoped
public class OutResultsBean implements Serializable {
    private List<Results> results = null;
    public List<Results> getResults() {
        if (results == null){
            try {
                results = ResultsService.getInstance().findAllResults();
            } catch (Exception e) {
                System.err.println("Error findAllResults DB");
            }
        }
        return results;
    }

    public void clearTable() {
        try {
            ResultsService.getInstance().clearTable();
            results.clear();
        } catch (Exception e) {
            System.err.println("Error clearTable DB" );
        }
    }
}
