/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wikiMovies.Dao;

import java.util.List;

/**
 *
 * @author Addiel
 * @param <T>
 * @param <K>
 */
public interface IBaseDAO <T,Integer>{
    public abstract void add(T o);
    public abstract T merge(T o);
    public abstract void delete(T o);
    public abstract T findById(Integer o);
    public abstract List<T> findAll();
}
