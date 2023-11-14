package org.lab3.wed.weblab3.DB.DAOInterfaces;

import org.lab3.wed.weblab3.DB.Entity.Results;

import java.util.List;

public interface CheckAreaDAO {
    void save(Results results) throws Exception;
    void delete(Results results) throws Exception;
    void update(Results results) throws Exception;
    List<Results> findAll() throws Exception;
    void clearTable() throws Exception;
}
