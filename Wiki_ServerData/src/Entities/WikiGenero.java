package Entities;

public class WikiGenero  implements java.io.Serializable {


     private String descripcion;
     private Usuario usuario;

    public WikiGenero() {
    }

    public WikiGenero(String descripcion, Usuario usuario) {
        this.descripcion = descripcion;
        this.usuario = usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

   
}


