/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wikiMovies.controller;

import AccesoADatos.GlobalException;
import AccesoADatos.NoDataException;
import Dao.ServicioBusquedas;
import Dao.ServicioWikiGeneros;
import Entities.Usuario;
import Entities.WikiGenero;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;

/**
 *
 * @author Addiel
 */
@WebServlet(name = "WikiGenero", urlPatterns = {"/createWiki", "/updateWiki","/findAllWiki","/finWikiByID","/deleteGenr"})
public class WikiGenero_controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException, SQLException, InstantiationException, IllegalAccessException, GlobalException, NoDataException, Exception {
        switch(request.getServletPath()){
            case "/createWiki":
                this.doCreate(request,response);
                break;
            case "/updateWiki":
                this.doUpdate(request,response);
                break;
            case "/findAllWiki":
                this.getAll(request,response);
                break;
            case "/finWikiByID":
                this.getByID(request,response);
                break;
            case "/deleteGenr":
                this.delete(request,response);
                break;    
            default:
               try{
                request.getRequestDispatcher("index.html").
                        forward( request, response);
                }
               catch(Exception e){ 
                    String error = e.getMessage();
                    request.setAttribute("error",e);
                    request.getRequestDispatcher("Error.jsp").forward(request, response);

                }
                break;
        }
  }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        processRequest(request, response);
    } catch (SQLException ex) {
        Logger.getLogger(WikiGenero_controller.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        Logger.getLogger(WikiGenero_controller.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        Logger.getLogger(WikiGenero_controller.class.getName()).log(Level.SEVERE, null, ex);
    } catch (NoDataException ex) {
        Logger.getLogger(WikiGenero_controller.class.getName()).log(Level.SEVERE, null, ex);
    } catch (Exception ex) {
        Logger.getLogger(WikiGenero_controller.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        processRequest(request, response);
    } catch (SQLException ex) {
        Logger.getLogger(WikiGenero_controller.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        Logger.getLogger(WikiGenero_controller.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        Logger.getLogger(WikiGenero_controller.class.getName()).log(Level.SEVERE, null, ex);
    } catch (NoDataException ex) {
        Logger.getLogger(WikiGenero_controller.class.getName()).log(Level.SEVERE, null, ex);
    } catch (Exception ex) {
        Logger.getLogger(WikiGenero_controller.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void doCreate(HttpServletRequest request, HttpServletResponse response) throws IOException, GlobalException, NoDataException, InstantiationException, IllegalAccessException {
       try{ PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String email = (String)request.getParameter("email");
        Usuario u = new Usuario();
        u.setEmail(email);
        String descripcion = (String)request.getParameter("descrip");        
        ServicioWikiGeneros.instance().crearGenero(u, descripcion);
        boolean respuesta=true;
        out.write(gson.toJson(respuesta));}
       catch(Exception e){
            response.setStatus(400); // faild    
        }
    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, NoDataException, InstantiationException, IllegalAccessException, Exception {
         PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String email = (String)request.getParameter("email");
        Usuario u = new Usuario();
        u.setEmail(email);
        String descripcion = (String)request.getParameter("descrip");        
        ServicioWikiGeneros.instance().modificarGenero(u, descripcion);
        boolean respuesta=true;
        out.write(gson.toJson(respuesta));
    }

@SuppressWarnings("empty-statement")
    private void getAll(HttpServletRequest request, HttpServletResponse response) throws IOException, GlobalException, NoDataException, SQLException, InstantiationException, IllegalAccessException {
        PrintWriter out = response.getWriter();
        Gson gson = new Gson(); 
        String email = (String)request.getParameter("email");
        ArrayList<WikiGenero> generos =  (ArrayList<WikiGenero>)  ServicioBusquedas.instance().verGenerosXusuario(email);       
        while(generos.remove(null));
        JSONArray jsArray = new JSONArray();
        for(WikiGenero c: generos){
           jsArray.put(c);
        }
        String generes = gson.toJson(jsArray);
        out.write(generes);
    }

@SuppressWarnings("empty-statement")
    private void getByID(HttpServletRequest request, HttpServletResponse response) throws IOException, GlobalException, NoDataException, SQLException, InstantiationException, IllegalAccessException {
         PrintWriter out = response.getWriter();
        Gson gson = new Gson(); 
        String email = (String)request.getParameter("email");
        ArrayList<WikiGenero> generos =  (ArrayList<WikiGenero>)  ServicioBusquedas.instance().verGenerosXusuario(email);       
        while(generos.remove(null));
        JSONArray jsArray = new JSONArray();
        for(WikiGenero c: generos){
           jsArray.put(c);
        }
        String generes = gson.toJson(jsArray);
        out.write(generes);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, GlobalException, NoDataException, InstantiationException, IllegalAccessException {
        try{PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String email = (String)request.getParameter("email");    
        Usuario aux = new Usuario();
        aux.setEmail(email);
        ServicioWikiGeneros.instance().eliminarGenero(email);
        boolean respuesta=true;
        out.write(gson.toJson(respuesta));}
        catch(Exception e){
            response.setStatus(400); // faild    
        }
    }

}
