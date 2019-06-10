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
     private static final String CREARUSUARIO= "{call crearUsuario(?,?,?,?,?,?,?)}";
     private static final String MODIFICARUSUARIO= "{call modificarUsuario(?,?,?,?,?,?,?)}";
     private static final String ELIMINARUSUARIO= "{call eliminarUsuario(?)}";
     private static final String CARGARPERFIL = "{? = call getPerfil(?,?)}";
     private static ServicioUsuario uniqueInstance;
     public static ServicioUsuario instance(){
        if (uniqueInstance == null){
            uniqueInstance = new ServicioUsuario();
        }
        return uniqueInstance;
    }
     
     public void crearUsuario(String nombre, String apellidos, int edad, String sexo,String password, String email, String rol) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
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
            pstmt.setInt(3,edad);  
            pstmt.setString(4,sexo);
            pstmt.setString(5,password);
            pstmt.setString(6,email);
            pstmt.setString(7,rol);
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
     public void modificarCurso(String nombre, String apellidos, int edad, String sexo,String password, String email, String rol) throws AccesoADatos.GlobalException, AccesoADatos.NoDataException, SQLException, InstantiationException, IllegalAccessException  	{
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
            pstmt.setInt(3,edad);  
            pstmt.setString(4,sexo);
            pstmt.setString(5,password);
            pstmt.setString(6,email);
            pstmt.setString(7,rol);
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
    
  
    public Usuario cargarPerfil(String user, String password) throws InstantiationException, GlobalException, NoDataException, IllegalAccessException{
        Usuario u = new Usuario();
        ArrayList<Usuario> aux = new ArrayList();
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        try {
            pstmt = conexion.prepareCall(CARGARPERFIL);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setString(2,user);
            pstmt.setString(3,password);
            pstmt.execute();                            
            ResultSet rs = (ResultSet) pstmt.getObject(1); 
            while(rs.next()){
               aux.add(ServicioBusquedas.instance().tipoUsuario(rs));
            }                         
            u = aux.get(0);
            
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
        return u;
    } 
}

