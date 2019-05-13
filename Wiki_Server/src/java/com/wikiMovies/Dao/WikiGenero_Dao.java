/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wikiMovies.Dao;

import com.wikiMovies.domain.WikiGeneros;
import com.wikiMovies.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Addiel
 */
public class WikiGenero_Dao extends HibernateUtil implements IBaseDAO<WikiGeneros,Integer>{

    @Override
    public void add(WikiGeneros o) {
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
    public WikiGeneros merge(WikiGeneros o) {
        try{
            operationStart();
            o = (WikiGeneros)getSesion().merge(o);
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
    public void delete(WikiGeneros o) {
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
    public WikiGeneros findById(Integer id) {
         WikiGeneros wiki = null;
         try{
            operationStart();
            wiki = (WikiGeneros)getSesion().get(WikiGeneros.class,id);
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
         return wiki;
    }

    @Override
    public List<WikiGeneros> findAll() {
         List<WikiGeneros> generos = new ArrayList();
         try{
            operationStart();
            generos = getSesion().createQuery("from Wiki_Generos").list();
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
    return generos;
    }

    
}
