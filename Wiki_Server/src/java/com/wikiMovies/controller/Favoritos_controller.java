/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wikiMovies.controller;

import AccesoADatos.GlobalException;
import AccesoADatos.NoDataException;
import Dao.ServicioBusquedas;
import Dao.ServicioFavoritos;
import Entities.Favorito;
import Entities.Usuario;
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
@WebServlet(name = "Favoritos", urlPatterns = {"/createFavorito", "/updateFavorito","/findAllFav","/findFavID","/deleteFavorite"})
public class Favoritos_controller extends HttpServlet {

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
         throws ServletException, IOException, SQLException, InstantiationException, IllegalAccessException, Exception {
        switch(request.getServletPath()){
            case "/createFavorito":
                this.doCreate(request,response);
                break;
            case "/updateFavorito":
                this.doUpdate(request,response);
                break;
            case "/findAllFav":
                this.getAll(request,response);
                break;    
            case "/findFavID":
                this.getByID(request,response);
                break;
            case "/deleteFavorite":
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
          Logger.getLogger(Favoritos_controller.class.getName()).log(Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
          Logger.getLogger(Favoritos_controller.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
          Logger.getLogger(Favoritos_controller.class.getName()).log(Level.SEVERE, null, ex);
      } catch (Exception ex) {
          Logger.getLogger(Favoritos_controller.class.getName()).log(Level.SEVERE, null, ex);
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
          Logger.getLogger(Favoritos_controller.class.getName()).log(Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
          Logger.getLogger(Favoritos_controller.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
          Logger.getLogger(Favoritos_controller.class.getName()).log(Level.SEVERE, null, ex);
      } catch (Exception ex) {
          Logger.getLogger(Favoritos_controller.class.getName()).log(Level.SEVERE, null, ex);
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
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String email = (String)request.getParameter("email");
        Usuario aux = new Usuario();
        aux.setEmail(email);
        String pelicula = (String)request.getParameter("pelicula");
        Double puntuacion = Double.valueOf(request.getParameter("puntuacion"));                  
        ServicioFavoritos.instance().crearFavorito(aux, pelicula, puntuacion);
        boolean respuesta=true;
        out.write(gson.toJson(respuesta));
    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, NoDataException, InstantiationException, IllegalAccessException, Exception {
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String email = (String)request.getParameter("email");
        Usuario aux = new Usuario();
        aux.setEmail(email);
        String pelicula = (String)request.getParameter("pelicula");
        Double puntuacion = Double.valueOf(request.getParameter("puntuacion"));                  
        ServicioFavoritos.instance().modificarFavorito(aux, pelicula, puntuacion);      
        boolean respuesta=true;
        out.write(gson.toJson(respuesta));
    }

  @SuppressWarnings("empty-statement")
    private void getAll(HttpServletRequest request, HttpServletResponse response) throws IOException, GlobalException, NoDataException, SQLException, InstantiationException, IllegalAccessException {
       PrintWriter out = response.getWriter();
       Gson gson = new Gson(); 
       String email = (String)request.getParameter("email");
       ArrayList<Favorito> favoritos =  (ArrayList<Favorito>) ServicioBusquedas.instance().verFavoritosXusuario(email);       
        while(favoritos.remove(null));
        JSONArray jsArray = new JSONArray();
        for(Favorito c: favoritos){
           jsArray.put(c);
        }
        String favs = gson.toJson(jsArray);
        out.write(favs);
    }

  @SuppressWarnings("empty-statement")
    private void getByID(HttpServletRequest request, HttpServletResponse response) throws IOException, GlobalException, NoDataException, SQLException, InstantiationException, IllegalAccessException {
       PrintWriter out = response.getWriter();
       Gson gson = new Gson(); 
       String email = (String)request.getParameter("email");
       ArrayList<Favorito> favoritos =  (ArrayList<Favorito>) ServicioBusquedas.instance().verFavoritosXusuario(email);       
        while(favoritos.remove(null));
        JSONArray jsArray = new JSONArray();
        for(Favorito c: favoritos){
           jsArray.put(c);
        }
        String favs = gson.toJson(jsArray);
        out.write(favs);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, GlobalException, NoDataException, InstantiationException, IllegalAccessException {
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String email = (String)request.getParameter("email");
        Usuario aux = new Usuario();
        aux.setEmail(email);  
        ServicioFavoritos.instance().eliminarFavorito(email);
        boolean respuesta=true;
        out.write(gson.toJson(respuesta));
    }

}
