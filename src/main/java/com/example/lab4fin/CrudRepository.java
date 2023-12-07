package com.example.lab4fin;

import java.util.List;

public interface CrudRepository<T, ID> {
    T save(T entity);
    T findById(ID id);
    void deleteById(ID id);

    List<Pizza> findAll();

}
