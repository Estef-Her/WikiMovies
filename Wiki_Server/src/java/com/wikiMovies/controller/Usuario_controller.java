/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wikiMovies.controller;

import AccesoADatos.GlobalException;
import AccesoADatos.NoDataException;
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
         throws ServletException, IOException, SQLException, InstantiationException, IllegalAccessException, GlobalException, NoDataException {
        switch(request.getServletPath()){
            case "/createUser":
                this.doCreate(request,response);
                break;
            case "/updateUser":
                this.doUpdate(request,response);
                break;
            case "/findAllUser":
                //this.getAll(request,response);
                break;
            case "/finUserByID":
                this.getByEmail(request,response);
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
       } catch (GlobalException ex) {
           Logger.getLogger(Usuario_controller.class.getName()).log(Level.SEVERE, null, ex);
       } catch (NoDataException ex) {
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
       } catch (GlobalException ex) {
           Logger.getLogger(Usuario_controller.class.getName()).log(Level.SEVERE, null, ex);
       } catch (NoDataException ex) {
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

    private void doCreate(HttpServletRequest request, HttpServletResponse response) throws IOException, GlobalException, NoDataException, SQLException, InstantiationException, IllegalAccessException {
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String nombre = (String)request.getParameter("nombre");
        String apellidos = (String)request.getParameter("apellidos");
        int edad = Integer.valueOf(request.getParameter("edad"));
        String sexo = (String)request.getParameter("sexo");
        String password = (String)request.getParameter("key");
        String email = (String)request.getParameter("email");
        ServicioUsuario.instance().crearUsuario(nombre, apellidos, edad, sexo, password, email);
        boolean respuesta=true;
        out.write(gson.toJson(respuesta));
    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, GlobalException, NoDataException, SQLException, InstantiationException, IllegalAccessException {
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
         String nombre = (String)request.getParameter("nombre");
        String apellidos = (String)request.getParameter("apellidos");
        int edad = Integer.valueOf(request.getParameter("edad"));
        String sexo = (String)request.getParameter("sexo");
        String password = (String)request.getParameter("key");
        String email = (String)request.getParameter("email");
        ServicioUsuario.instance().modificarCurso(nombre, apellidos, edad, sexo, password, email);
        boolean respuesta=true;
        out.write(gson.toJson(respuesta));
    }

  /* @SuppressWarnings("empty-statement")
    private void getAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();        
        ArrayList<Usuario> users =  (ArrayList<Usuario>)  ServicioBusquedas;       
        while(users.remove(null));
        JSONArray jsArray = new JSONArray();
        for(Usuario c: users){
           jsArray.put(c);
        }
        String us = gson.toJson(jsArray);
        out.write(us);
    }*/

    private void getByEmail(HttpServletRequest request, HttpServletResponse response) throws IOException, InstantiationException, GlobalException, NoDataException, IllegalAccessException {
       PrintWriter out = response.getWriter(); 
       Gson gson = new Gson(); 
       String email = (String)request.getParameter("email");       
       Usuario u =  (Usuario)ServicioUsuario.instance().cargarPerfil(email);               
       String us = gson.toJson(u);
       out.write(us);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, GlobalException, NoDataException, InstantiationException, IllegalAccessException {
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();       
        String email = (String)request.getParameter("email");     
        ServicioUsuario.instance().eliminarUsuario(email);
        boolean respuesta=true;
        out.write(gson.toJson(respuesta));
    }

}
