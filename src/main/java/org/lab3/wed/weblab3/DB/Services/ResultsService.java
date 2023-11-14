package org.lab3.wed.weblab3.DB.Services;

import org.lab3.wed.weblab3.DB.DAOimpl.CheckAreaDAOimpl;
import org.lab3.wed.weblab3.DB.Entity.Results;

import java.util.List;

public class ResultsService {
    private final CheckAreaDAOimpl checkAreaDAOimpl = CheckAreaDAOimpl.getInstance();
    public static volatile ResultsService INSTANCE;
    private ResultsService() {}
    public static ResultsService getInstance(){
        if (INSTANCE == null){
            synchronized (ResultsService.class){
                if (INSTANCE == null){
                    INSTANCE = new ResultsService();
                }
            }
        }
        return INSTANCE;
    }
    public List<Results> findAllResults() throws Exception {
        return checkAreaDAOimpl.findAll();
    }

    public void saveResult(Results results) throws Exception {
        checkAreaDAOimpl.save(results);
    }

    public void deleteResult(Results results) throws Exception {
        checkAreaDAOimpl.delete(results);
    }

    public void updateResult(Results results) throws Exception {
        checkAreaDAOimpl.update(results);
    }

    public void clearTable() throws Exception{
        checkAreaDAOimpl.clearTable();
    }

}
