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
public class ServicioWikiGeneros extends Service{
    private static final String CREARGENERO= "{call crearGenero(?,?}";
    private static final String MODIFICARGENERO= "{call modificarGenero(?,?)}";
    private static final String ELIMINARGENERO= "{call eliminarGenero(?)}";
    private static ServicioWikiGeneros uniqueInstance;
    public static ServicioWikiGeneros instance(){
        if (uniqueInstance == null){
            uniqueInstance = new ServicioWikiGeneros();
        }
        return uniqueInstance;
    }
     
     public void crearGenero(Usuario usuario, String descripcion) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, InstantiationException, IllegalAccessException  	{
       try {
           conectar();
       } catch (ClassNotFoundException e) {
           throw new AccesoADatos.GlobalException("No se ha localizado el driver");
       } catch (SQLException e) {
           throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
       }
       CallableStatement pstmt=null;

       try {
           pstmt = conexion.prepareCall(CREARGENERO);
           pstmt.setString(1,usuario.getEmail());
           pstmt.setString(2,descripcion);

          
           boolean resultado = pstmt.execute();
           if (resultado == true) {
               throw new AccesoADatos.NoDataException("No se realizo la inserci�n");
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
  
    public void modificarGenero(Usuario usuario, String descripcion) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, InstantiationException, IllegalAccessException, Exception  	{
       try {
           conectar();
       } catch (ClassNotFoundException e) {
           throw new AccesoADatos.GlobalException("No se ha localizado el driver");
       } catch (SQLException e) {
           throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
       }
       CallableStatement pstmt=null;
       
       try {
           pstmt = conexion.prepareCall(MODIFICARGENERO);
           pstmt.setString(1,usuario.getEmail());
           pstmt.setString(2,descripcion);
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
    public void eliminarGenero(String email) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, InstantiationException, IllegalAccessException  	{
       try {
           conectar();
       } catch (ClassNotFoundException e) {
           throw new AccesoADatos.GlobalException("No se ha localizado el driver");
       } catch (SQLException e) {
           throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
       }
       CallableStatement pstmt=null;

       try {
           pstmt = conexion.prepareCall(ELIMINARGENERO);
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
