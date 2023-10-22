package susuario.dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {
    private int ID;
    private String nombres;
    private String nombreUsuario;
    private int edad;
    private String clave;

    public UsuarioDTO(int id, String nombres, String nombreUsuario,int edad, String clave) {
        this.ID = id;
        this.nombres = nombres;
        this.nombreUsuario = nombreUsuario;
        this.edad = edad;
        this.clave = clave;
    }

    public UsuarioDTO() {
        this.ID = 0;
        this.nombres = "";
        this.nombreUsuario = "";
        this.clave = "";
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getClave() {
        return this.clave;
    }

}
