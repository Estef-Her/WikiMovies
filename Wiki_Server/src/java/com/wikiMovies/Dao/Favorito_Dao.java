/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wikiMovies.Dao;

import com.wikiMovies.domain.Favoritos;
import com.wikiMovies.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Addiel
 */
public class Favorito_Dao extends HibernateUtil implements IBaseDAO<Favoritos,Integer> {

    @Override
    public void add(Favoritos o) {
        try{
            operationStart();
            getSesion().save(o);
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
    }

    @Override
    public Favoritos merge(Favoritos o) {
        try{
            operationStart();
            o = (Favoritos)getSesion().merge(o);
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
         return o;
    }

    @Override
    public void delete(Favoritos o) {
          try{
            operationStart();
            getSesion().delete(o);
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
    }

    @Override
    public Favoritos findById(Integer id) {
       Favoritos fav = null;
         try{
            operationStart();
            fav = (Favoritos)getSesion().get(Favoritos.class,id);
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
         return fav;
    }

    @Override
    public List<Favoritos> findAll() {
         List<Favoritos> listaFav = new ArrayList();
         try{
            operationStart();
            listaFav = getSesion().createQuery("from Favoritos").list();
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
    return listaFav;
    }

    
    
}
