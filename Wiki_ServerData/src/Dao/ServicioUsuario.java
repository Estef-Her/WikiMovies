/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import AccesoADatos.GlobalException;
import AccesoADatos.NoDataException;
import Entities.Usuario;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Addiel
 */
public class ServicioUsuario extends Service {
     private static final String CREARUSUARIO= "{call crearUsuario(?,?,?,?,?,?)}";
     private static final String MODIFICARUSUARIO= "{call modificarUsuario(?,?,?,?,?,?)}";
     private static final String ELIMINARUSUARIO= "{call eliminarUsuario(?)}";
     private static final String CARGARPERFIL = "{? = call getPerfil(?,?)}";
     private static ServicioUsuario uniqueInstance;
     public static ServicioUsuario instance(){
        if (uniqueInstance == null){
            uniqueInstance = new ServicioUsuario();
        }
        return uniqueInstance;
    }
     
     public void crearUsuario(String nombre, String apellidos, int edad, String sexo,String password, String email) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(CREARUSUARIO);          
            pstmt.setString(1,nombre);
            pstmt.setString(2,apellidos);
            pstmt.setString(3,password);
            pstmt.setString(4,email);
            pstmt.setInt(5,edad);  
            pstmt.setString(6,sexo);
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
     public void modificarCurso(String nombre, String apellidos, int edad, String sexo,String password, String email) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        
        try {
            pstmt = conexion.prepareCall(MODIFICARUSUARIO);
            pstmt.setString(1,nombre);
            pstmt.setString(2,apellidos);
            pstmt.setString(3,password);
            pstmt.setString(4,email);
            pstmt.setInt(5,edad);  
            pstmt.setString(6,sexo);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new AccesoADatos.NoDataException("No se realizo la actualizacion");
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
    
        
    public void eliminarUsuario(String email) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, InstantiationException, IllegalAccessException  	{
       try {
           conectar();
       } catch (ClassNotFoundException e) {
           throw new AccesoADatos.GlobalException("No se ha localizado el driver");
       } catch (SQLException e) {
           throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
       }
       CallableStatement pstmt=null;

       try {
           pstmt = conexion.prepareCall(ELIMINARUSUARIO);
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
    
  
    public Usuario cargarPerfil(String email) throws InstantiationException, GlobalException, NoDataException, IllegalAccessException{
        ArrayList<Usuario> users = new ArrayList();
           try {
               conectar();
           } catch (ClassNotFoundException e) {
               throw new AccesoADatos.GlobalException("No se ha localizado el driver");
           } catch (SQLException e) {
               throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
           }
           CallableStatement pstmt=null;
           try {
               pstmt = conexion.prepareCall("{? = call buscar_usuario_email(?)}");  
               pstmt.registerOutParameter(1, OracleTypes.CURSOR);
               pstmt.setString(2,email);
               pstmt.execute();
               ResultSet rs = (ResultSet) pstmt.getObject(1);
                   while(rs.next()){
                       users.add(ServicioBusquedas.instance().tipoUsuario(rs));
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
            return users.get(0);
    } 
}

