/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Entities.Usuario;
import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 *
 * @author Addiel
 */
public class ServicioFavoritos extends Service{
    private static final String CREARFAVORITO= "{call crearFavorito(?,?,?}";
    private static final String MODIFICARFAVORITO= "{call modificarFavorito(?,?,?)}";
    private static final String ELIMINARFAVORITO= "{call eliminarFavorito(?)}";
    private static ServicioFavoritos uniqueInstance;
    public static ServicioFavoritos instance(){
        if (uniqueInstance == null){
            uniqueInstance = new ServicioFavoritos();
        }
        return uniqueInstance;
    }
    
    public void crearFavorito(Usuario usuario, String pelicula, Double puntuacion) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, InstantiationException, IllegalAccessException  	{
       try {
           conectar();
       } catch (ClassNotFoundException e) {
           throw new AccesoADatos.GlobalException("No se ha localizado el driver");
       } catch (SQLException e) {
           throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
       }
       CallableStatement pstmt=null;

       try {
           pstmt = conexion.prepareCall(CREARFAVORITO);
           pstmt.setString(1,usuario.getEmail());
           pstmt.setString(2,pelicula);
           pstmt.setDouble(3,puntuacion);          
           boolean resultado = pstmt.execute();
           if (resultado == true) {
               throw new AccesoADatos.NoDataException("No se realizo la insercion");
           }

       } catch (SQLException e) {
           e.printStackTrace();
           throw new AccesoADatos.GlobalException("Llave duplicada");
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
   }     
  
    public void modificarFavorito(Usuario usuario, String pelicula, Double puntuacion) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, InstantiationException, IllegalAccessException, Exception  	{
       try {
           conectar();
       } catch (ClassNotFoundException e) {
           throw new AccesoADatos.GlobalException("No se ha localizado el driver");
       } catch (SQLException e) {
           throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
       }
       CallableStatement pstmt=null;
       
       try {
           pstmt = conexion.prepareCall(MODIFICARFAVORITO);
           pstmt.setString(1,usuario.getEmail());
           pstmt.setString(2,pelicula);
           pstmt.setDouble(3,puntuacion);
           int count = pstmt.executeUpdate();
           if (count < 0){
               throw new AccesoADatos.GlobalException("Error al actualizar informacion del alumno");
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
               throw new AccesoADatos.GlobalException(e.getMessage());
           }
       }
   }      
    public void eliminarFavorito(String email) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, InstantiationException, IllegalAccessException  	{
       try {
           conectar();
       } catch (ClassNotFoundException e) {
           throw new AccesoADatos.GlobalException("No se ha localizado el driver");
       } catch (SQLException e) {
           throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
       }
       CallableStatement pstmt=null;

       try {
           pstmt = conexion.prepareCall(ELIMINARFAVORITO);
           pstmt.setString(1,email);
           boolean resultado = pstmt.execute();
           if (resultado == true) {
               throw new AccesoADatos.NoDataException("No se realizo la inserci�n");
           }

       } catch (SQLException e) {
           throw new AccesoADatos.GlobalException("Llave duplicada");
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
   }      
   
    
}
