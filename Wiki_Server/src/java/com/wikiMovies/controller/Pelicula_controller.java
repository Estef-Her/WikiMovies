/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wikiMovies.controller;

import java.io.IOException;
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
@WebServlet(name = "Pelicula", urlPatterns = {"/createPeli", "/updatePeli","/findAllPelis","/finPeliByID"})
public class Pelicula_controller extends HttpServlet {

    public Pelicula_controller(String nombre, String font1, String font2, String font3, String descripcion, String genero, String resumen, String trailer) {
    }

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
            case "/createPeli":
                this.doCreate(request,response);
                break;
            case "/updatePeli":
                this.doUpdate(request,response);
                break;
            case "/findAllPelis":
                this.getAll(request,response);
                break;
            case "/finPeliByID":
                this.getByID(request,response);
                break;    
            default:
               try{
                request.getRequestDispatcher("Home.jsp").
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
           Logger.getLogger(Pelicula_controller.class.getName()).log(Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           Logger.getLogger(Pelicula_controller.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IllegalAccessException ex) {
           Logger.getLogger(Pelicula_controller.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(Pelicula_controller.class.getName()).log(Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           Logger.getLogger(Pelicula_controller.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IllegalAccessException ex) {
           Logger.getLogger(Pelicula_controller.class.getName()).log(Level.SEVERE, null, ex);
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

    private void doCreate(HttpServletRequest request, HttpServletResponse response) {
        String nombre = (String)request.getParameter("nombre");
        String font1 = (String)request.getParameter("font1");
        String font2 = ((String)request.getParameter("font2"));
        String font3 = (String)request.getParameter("font3");
        String descripcion = (String)request.getParameter("descrip");
        String genero = (String)request.getParameter("genero");
        String resumen = (String)request.getParameter("resumen");
        String trailer = (String)request.getParameter("trailer");
        Pelicula_controller p = new Pelicula_controller(nombre,font1,font2,font3,descripcion,genero,resumen,trailer);
    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) {
        String nombre = (String)request.getParameter("nombre");
        String font1 = (String)request.getParameter("font1");
        String font2 = ((String)request.getParameter("font2"));
        String font3 = (String)request.getParameter("font3");
        String descripcion = (String)request.getParameter("descrip");
        String genero = (String)request.getParameter("genero");
        String resumen = (String)request.getParameter("resumen");
        String trailer = (String)request.getParameter("trailer");
        Pelicula_controller p = new Pelicula_controller(nombre,font1,font2,font3,descripcion,genero,resumen,trailer);
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void getByID(HttpServletRequest request, HttpServletResponse response) {
         String nombre = (String)request.getParameter("nombre");
    }

}
