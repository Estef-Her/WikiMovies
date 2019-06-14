package Entities;


// Generated Jun 8, 2019 10:22:04 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;


public class Usuario  implements java.io.Serializable {


     private String email;
     private String nombre;
     private String apellidos;
     private int edad;
     private String sexo;
     private String password;


    public Usuario() {
    }

	
    public Usuario(String email) {
        this.email = email;
    }

    public Usuario(String email, String nombre, String apellidos, int edad, String sexo, String password) {
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.sexo = sexo;
        this.password = password;
    }
   

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

 
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    
 
    public int getEdad() {
        return this.edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }

    
  
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

}


