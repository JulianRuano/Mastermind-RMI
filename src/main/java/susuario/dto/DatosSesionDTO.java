package susuario.dto;

import java.io.Serializable;

public class DatosSesionDTO implements Serializable  {
    private int ID;
    private String nombreUsuario;
    private String clave;

    public DatosSesionDTO(int id,String clave){
        this.ID = id;
        this.clave = clave;
    }

    public DatosSesionDTO(int id,String usuario,String clave){
        this.ID = id;
        this.nombreUsuario = usuario;
        this.clave = clave;
    }

    public DatosSesionDTO(){
        this.ID = -1;
        this.nombreUsuario = "";
        this.clave = "";
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombreUsuario(){
        return nombreUsuario;
    }

    public void setNombreUsuario(String usuario){
        this.nombreUsuario = usuario;
    }

    public String getClave(){
        return clave;
    }

    public void setClave(String clave){
        this.clave = clave;
    }

    
}
