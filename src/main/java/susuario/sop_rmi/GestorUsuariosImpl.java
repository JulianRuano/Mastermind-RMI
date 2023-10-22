package susuario.sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import susuario.dto.DatosSesionDTO;
import susuario.dto.UsuarioDTO;

/*
Clase que implementa la interface remota GestorUsuariosInt
*/

public class GestorUsuariosImpl extends UnicastRemoteObject implements GestorUsuariosInt {
    private ArrayList<UsuarioDTO> misUsuarios;

    public GestorUsuariosImpl() throws RemoteException {
        super(); // invoca al constructor de la clase base //asigna un puerto de escucha al OR
        this.misUsuarios = new ArrayList<UsuarioDTO>();
        System.out.println("Se instanció el objeto remoto gestorUsuarios");
        misUsuarios.add(new UsuarioDTO(0,"admin","admin",0,"admin"));
    }

    @Override
    public boolean registrarUsuario(UsuarioDTO objUsuario) throws RemoteException {
        System.out.println("Entrando a registrar usuario");
        boolean bandera = false;

        if(verificarUsuario(objUsuario.getID())){
            return false;
        }

        if (misUsuarios.size() < 6) {
            bandera = misUsuarios.add(objUsuario);
            System.out.println("Usuario registrado: identificación: " + objUsuario.getID() + ", nombres: "
                    + objUsuario.getNombres() + ", Usuario. " + objUsuario.getNombreUsuario());
        }
        return bandera;
    }

    @Override
    public int consultarCantidadUsuarios() throws RemoteException {
        System.out.println("Entrando a Cantidad");
        return misUsuarios.size();
    }

    @Override
    public UsuarioDTO consultarUsuario(int identificacion) throws RemoteException {

        System.out.println("Entrando a consultar usuario");
        UsuarioDTO objUsuario = null;

        for (int i = 0; i < this.misUsuarios.size(); i++) {
            if (this.misUsuarios.get(i).getID() == identificacion) {
                objUsuario = this.misUsuarios.get(i);
                break;
            }
        }
        return objUsuario;
    }

    public boolean verificarUsuario(int indentificacion) {
        boolean bandera = false;

        for (int i = 0; i < this.misUsuarios.size(); i++) {
            if (this.misUsuarios.get(i).getID() == indentificacion) {
                bandera = true;
                break;
            }
        }
        return bandera;
    }

    @Override
    public boolean eliminarUsuario(int identificacion) throws RemoteException {
        System.out.println("Entrando a eliminar usuario");
        boolean bandera = false;

        for (int i = 0; i < this.misUsuarios.size(); i++) {
            if (this.misUsuarios.get(i).getID() == identificacion) {
                this.misUsuarios.remove(i);
                bandera = true;
                break;
            }
        }
        return bandera;
    }

    @Override
    public boolean actualizarUsuario(UsuarioDTO objUsuario) throws RemoteException {
        System.out.println("Entrando a actualizar usuario");
        boolean bandera = false;

        for (int i = 0; i < this.misUsuarios.size(); i++) {
            if (this.misUsuarios.get(i).getID() == objUsuario.getID()) {
                this.misUsuarios.set(i, objUsuario);
                bandera = true;
                break;
            }
        }
        return bandera;
    }

    @Override
    public UsuarioDTO iniciarSesion(DatosSesionDTO objSesion){
        System.out.println("Entrando a iniciar sesion");
        UsuarioDTO objUsuario = null;

        for (int i = 0; i < this.misUsuarios.size(); i++) {
            if (this.misUsuarios.get(i).getID() == objSesion.getID()
                    && this.misUsuarios.get(i).getClave().equals(objSesion.getClave())
                    && this.misUsuarios.get(i).getNombreUsuario().equals(objSesion.getNombreUsuario())) {
                objUsuario = this.misUsuarios.get(i);
                break;
            }
        }
        return objUsuario;      
    }
}
