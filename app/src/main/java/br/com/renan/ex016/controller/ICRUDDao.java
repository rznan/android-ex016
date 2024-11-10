package br.com.renan.ex016.controller;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: renan santos carvalho
 */
public interface ICRUDDao<T> {
    void insert(T t) throws SQLException;

    void update(T t) throws SQLException;

    void delete(T t) throws SQLException;

    T findOne(T t) throws SQLException;

    List<T> findAll() throws SQLException;
}
