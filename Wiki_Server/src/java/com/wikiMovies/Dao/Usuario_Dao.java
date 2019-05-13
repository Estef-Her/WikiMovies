/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wikiMovies.Dao;

import com.wikiMovies.domain.Usuario;
import com.wikiMovies.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Addiel
 */
public class Usuario_Dao extends HibernateUtil implements IBaseDAO<Usuario,Integer>{

    public Usuario_Dao() {
    }

    @Override
    public void add(Usuario o) {
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
    public Usuario merge(Usuario o) {
         try{
            operationStart();
            o = (Usuario)getSesion().merge(o);
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
    public void delete(Usuario o) {
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
    public Usuario findById(Integer id) {
        Usuario user = null;
         try{
            operationStart();
            user = (Usuario)getSesion().get(Usuario.class,id);
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
         return user;
    }

    @Override
    public List<Usuario> findAll() {
         List<Usuario> users = new ArrayList();
         try{
            operationStart();
            users = getSesion().createQuery("from Usuario").list();
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
    return users;
    }
 public Usuario findByData(String user, String passw) {
        Usuario log = new Usuario();
        List<Usuario> l= new ArrayList();
         String sql = "select * from Usuario where email = "+ "'"+ user +"'"+" and "+"password = " + "'" + passw + "';";
         try{
            operationStart();
            log = (Usuario) getSesion().createSQLQuery(sql);
            //log = l.get(0);
            getTransac().commit();
        }
        catch(HibernateException he){
            handleException(he);
            throw he;
        }
        finally{
        getSesion().close();
        }
         return log;
    }
  
}
