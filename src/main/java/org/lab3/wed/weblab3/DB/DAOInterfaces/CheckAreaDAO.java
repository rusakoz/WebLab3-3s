package org.lab3.wed.weblab3.DB.DAOInterfaces;

import org.lab3.wed.weblab3.DB.Entity.Results;

import java.util.List;

public interface CheckAreaDAO {
    Results findById(long id);
    void save(Results results);
    void delete(Results results);
    void update(Results results);
    List<Results> findAll();
}
