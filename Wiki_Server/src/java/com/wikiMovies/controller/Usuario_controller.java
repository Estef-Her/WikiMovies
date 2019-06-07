/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wikiMovies.controller;

import com.google.gson.Gson;
import com.wikiMovies.domain.Usuario;
import com.wikiMovies.services.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
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
@WebServlet(name = "Usuario", urlPatterns = {"/createUser", "/updateUser","/findAllUser","/finUserByID","/deleteUser"})
public class Usuario_controller extends HttpServlet {

   

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
         throws ServletException, IOException, SQLException, InstantiationException, IllegalAccessException {
        switch(request.getServletPath()){
            case "/createUser":
                this.doCreate(request,response);
                break;
            case "/updateUser":
                this.doUpdate(request,response);
                break;
            case "/findAllUser":
                this.getAll(request,response);
                break;
            case "/finUserByID":
                this.getByID(request,response);
                break;    
            case "/deleteUser": 
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
           Logger.getLogger(Usuario_controller.class.getName()).log(Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           Logger.getLogger(Usuario_controller.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IllegalAccessException ex) {
           Logger.getLogger(Usuario_controller.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(Usuario_controller.class.getName()).log(Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           Logger.getLogger(Usuario_controller.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IllegalAccessException ex) {
           Logger.getLogger(Usuario_controller.class.getName()).log(Level.SEVERE, null, ex);
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

    private void doCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String nombre = (String)request.getParameter("nombre");
        String apellidos = (String)request.getParameter("apellidos");
        BigDecimal edad = BigDecimal.valueOf(Double.valueOf(request.getParameter("edad")));
        String sexo = (String)request.getParameter("sexo");
        String password = (String)request.getParameter("key");
        String email = (String)request.getParameter("email");
        String rol = (String)request.getParameter("rol");
        Usuario u = new Usuario( email,  nombre,  apellidos,  edad,  sexo,  password,  rol);
        Service.instance().getServicio_Usuario().add(u);
        boolean respuesta=true;
        out.write(gson.toJson(respuesta));
    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String nombre = (String)request.getParameter("nombre");
        String apellidos = (String)request.getParameter("apellidos");
        BigDecimal edad = BigDecimal.valueOf(Double.valueOf(request.getParameter("edad")));
        String sexo = (String)request.getParameter("sexo");
        String password = (String)request.getParameter("key");
        String email = (String)request.getParameter("email");
        String rol = (String)request.getParameter("rol");
        Usuario u = new Usuario( email,  nombre,  apellidos,  edad,  sexo,  password,  rol);
        Service.instance().getServicio_Usuario().merge(u);
        boolean respuesta=true;
        out.write(gson.toJson(respuesta));
    }

   @SuppressWarnings("empty-statement")
    private void getAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();        
        ArrayList<Usuario> users =  (ArrayList<Usuario>)   Service.instance().getServicio_Usuario().findAll();       
        while(users.remove(null));
        JSONArray jsArray = new JSONArray();
        for(Usuario c: users){
           jsArray.put(c);
        }
        String us = gson.toJson(jsArray);
        out.write(us);
    }

    private void getByID(HttpServletRequest request, HttpServletResponse response) throws IOException {
       PrintWriter out = response.getWriter(); 
       Gson gson = new Gson(); 
       String email = (String)request.getParameter("email");       
       Usuario u =  (Usuario)Service.instance().getServicio_Usuario().findByEmail(email);               
       String us = gson.toJson(u);
       out.write(us);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String nombre = (String)request.getParameter("nombre");
        String apellidos = (String)request.getParameter("apellidos");
        BigDecimal edad = BigDecimal.valueOf(Double.valueOf(request.getParameter("edad")));
        String sexo = (String)request.getParameter("sexo");
        String password = (String)request.getParameter("key");
        String email = (String)request.getParameter("email");
        String rol = (String)request.getParameter("rol");
        Usuario u = new Usuario( email,  nombre,  apellidos,  edad,  sexo,  password,  rol);
        Service.instance().getServicio_Usuario().delete(u);
        boolean respuesta=true;
        out.write(gson.toJson(respuesta));
    }

}
