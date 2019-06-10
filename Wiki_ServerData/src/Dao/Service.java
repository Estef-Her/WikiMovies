/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import AccesoADatos.GlobalException;
import AccesoADatos.NoDataException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Addiel
 */
public class Service {
     private static final String DOLOGIN= "{?= call login(?,?)}";
     protected Connection conexion= null;
    private static Service uniqueInstance;
    
    public static Service instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Service();
        }
        return uniqueInstance;
    }
    public Service() {
        
    }
    protected void conectar() throws SQLException,ClassNotFoundException, InstantiationException, IllegalAccessException 
    {
        Class.forName("oracle.jdbc.OracleDriver").newInstance();
        conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","k1n9r4d2");    
    }  
    protected void desconectar() throws SQLException{
        if(!conexion.isClosed())
        {
            conexion.close();
        }
    }
    private Connection getJdbcMydbsource() throws NamingException {
        Context c = new InitialContext();
        try {
            return ((DataSource) c.lookup("jdbc/Mydbsource")).getConnection();
        } catch (NamingException | SQLException ex) {
        }
        return null;
    }    
    public boolean doLogin(String user, String password) throws InstantiationException, IllegalAccessException, GlobalException, NoDataException{
        boolean resp= true;       
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new AccesoADatos.GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new AccesoADatos.NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt=null;
        int respuesta =0;
        try {
            pstmt = conexion.prepareCall(DOLOGIN);
            pstmt.setString(2,user);
            pstmt.setString(3,password);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.execute();    
             ResultSet rs = (ResultSet) pstmt.getObject(1);  
                while(rs.next()){
                    respuesta=rs.getInt("EXIST");
                } 
                if(respuesta==0){
             resp=false;}
            
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
        return resp;
    }
     
}
