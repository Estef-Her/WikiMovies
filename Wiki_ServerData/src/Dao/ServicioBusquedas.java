/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Favorito;

import Entities.Usuario;
import Entities.WikiGenero;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Addiel
 */
public class ServicioBusquedas extends Service{
    private static ServicioBusquedas uniqueInstance;
    public static ServicioBusquedas instance(){
        if (uniqueInstance == null){
            uniqueInstance = new ServicioBusquedas();
        }
        return uniqueInstance;
    }    
         
    public Favorito tipoFavorito(ResultSet rs){
        try{
            Usuario aux  = new  Usuario();
            Favorito f = new Favorito();
            aux.setEmail(rs.getString("usuario"));
            f.setPuntuacion(rs.getDouble("puntuacion"));
            f.setPelicula(rs.getString("pelicula"));
            f.setUsuario(aux);
            return f;
        }
        catch (SQLException ex) {
            return null;
        }
    }            
    public WikiGenero tipoWikiGenero(ResultSet rs){
        try{
            Usuario aux  = new  Usuario();
            WikiGenero w = new WikiGenero();
            aux.setEmail(rs.getString("usuario"));
            w.setUsuario(aux);
            w.setDescripcion(rs.getString("nombre"));         
            return w;
        }
        catch (SQLException ex) {
            return null;
        }
    }        
    public Usuario tipoUsuario(ResultSet rs){
        try{
            Usuario u = new Usuario();
            u.setNombre(rs.getString("nombre"));
            u.setApellidos(rs.getString("apellidos"));
            u.setEdad(rs.getInt("edad"));
            u.setSexo(rs.getString("sexo"));
            u.setPassword(rs.getString("password"));
            u.setRol(rs.getString("rol"));
            u.setEmail(rs.getString("email"));          
            return u;
        }
        catch (SQLException ex) {
            return null;
        }
    }
    
   
    public ArrayList<Favorito> verFavoritosXusuario(String email) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
            ArrayList<Favorito> favoritos = new ArrayList();
            try {
               conectar();
           } catch (ClassNotFoundException e) {
               throw new AccesoADatos.GlobalException("No se ha localizado el driver");
           } catch (SQLException e) {
               throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
           }
           CallableStatement pstmt=null;

           try {
               pstmt = conexion.prepareCall("{? = call verFavoritosXusuario(?)}");
               pstmt.registerOutParameter(1, OracleTypes.CURSOR);
               pstmt.setString(2,email);
               pstmt.execute();               
               ResultSet rs = (ResultSet) pstmt.getObject(1); 
                   while(rs.next()){
                       favoritos.add(this.tipoFavorito(rs));
                   }                         
           } catch (SQLException e) {
               throw new AccesoADatos.GlobalException(e.getMessage());
           } finally {
               try {
                   if (pstmt != null) {
                       pstmt.close();
                   }
                   desconectar();
               } catch (SQLException e) {
                   throw new AccesoADatos.GlobalException("Estatutos invalidos o nulos");
               }
       }
            return favoritos;      

   }    
 
    public ArrayList<WikiGenero> verGenerosXusuario(String email) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
            ArrayList<WikiGenero> generos = new ArrayList();
            try {
               conectar();
           } catch (ClassNotFoundException e) {
               throw new AccesoADatos.GlobalException("No se ha localizado el driver");
           } catch (SQLException e) {
               throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
           }
           CallableStatement pstmt=null;

           try {
               pstmt = conexion.prepareCall("{? = call verGenerosXusuario(?)}");
               pstmt.registerOutParameter(1, OracleTypes.CURSOR);
               pstmt.setString(2,email);
               pstmt.execute();               
               ResultSet rs = (ResultSet) pstmt.getObject(1); 
                   while(rs.next()){
                       generos.add(this.tipoWikiGenero(rs));
                   }                         
           } catch (SQLException e) {
               throw new AccesoADatos.GlobalException(e.getMessage());
           } finally {
               try {
                   if (pstmt != null) {
                       pstmt.close();
                   }
                   desconectar();
               } catch (SQLException e) {
                   throw new AccesoADatos.GlobalException("Estatutos invalidos o nulos");
               }
       }
            return generos;      

   }    
}
