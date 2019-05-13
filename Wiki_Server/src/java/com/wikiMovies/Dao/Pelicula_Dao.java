/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wikiMovies.Dao;

import com.wikiMovies.domain.Pelicula;
import com.wikiMovies.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Addiel
 */
public class Pelicula_Dao extends HibernateUtil implements IBaseDAO<Pelicula,Integer>{

    @Override
    public void add(Pelicula o) {
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
    public Pelicula merge(Pelicula o) {
         try{
            operationStart();
            o = (Pelicula)getSesion().merge(o);
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
    public void delete(Pelicula o) {
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
    public Pelicula findById(Integer id) {
         Pelicula peli = null;
         try{
            operationStart();
            peli = (Pelicula)getSesion().get(Pelicula.class,id);
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
         return peli;
    }

    @Override
    public List<Pelicula> findAll() {
        List<Pelicula> pelis = new ArrayList();
         try{
            operationStart();
            pelis = getSesion().createQuery("from Pelicula").list();
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
    return pelis;
    }

    
    
}
