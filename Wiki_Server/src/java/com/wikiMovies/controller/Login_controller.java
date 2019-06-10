/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wikiMovies.controller;

import Dao.Service;
import Dao.ServicioUsuario;
import Entities.Usuario;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Addiel
 */
@WebServlet(name = "Login", urlPatterns = {"/doLogin", "/doLogout"})
public class Login_controller extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException, SQLException, InstantiationException, IllegalAccessException {
        switch(request.getServletPath()){
            case "/doLogin":
                this.doLogin(request,response);
                break;
            case "/doLogout":
                this.doLogout(request,response);
                break;
            default:           
                request.getRequestDispatcher("index.html");             
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
            Logger.getLogger(Login_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Login_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login_controller.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Login_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Login_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login_controller.class.getName()).log(Level.SEVERE, null, ex);
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

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{           
            Usuario u = new Usuario();
            u.setEmail((String) request.getParameter("email"));
            u.setPassword((String) request.getParameter("key"));            
            Gson g = new Gson(); 
            PrintWriter out = response.getWriter();           
            if(Service.instance().doLogin(u.getEmail(),u.getPassword())){
            u = ServicioUsuario.instance().cargarPerfil(u.getEmail(), u.getPassword());
            String user = g.toJson(u);
            out.write(user);          
            response.setStatus(200);
            }else{
            response.sendError(2);
            }
           
        }
        catch(Exception e){
            response.setStatus(400); // faild    
           
        }
    }

     protected void doLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try{
        request.getSession().invalidate();       
        request.getRequestDispatcher("index.html").
                forward( request, response);
       }
       catch(Exception e){           
            response.setStatus(400); // faild    
            request.getRequestDispatcher("index.html").
                forward( request, response);
        }
    }

}
