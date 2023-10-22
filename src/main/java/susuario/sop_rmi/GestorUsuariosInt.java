
package susuario.sop_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import susuario.dto.UsuarioDTO;
import susuario.dto.DatosSesionDTO;

//Hereda de la clase Remote, lo cual la convierte en interfaz remota
public interface GestorUsuariosInt extends Remote
{
    //Definicion del primer método remoto
    public boolean registrarUsuario(UsuarioDTO objUsuario) throws RemoteException;
    //cada definición del método debe especificar que puede lanzar la excepción java.rmi.RemoteException
    
    //Definicion del segundo método remoto
    public int consultarCantidadUsuarios() throws RemoteException; 
    //cada definición del método debe especificar que puede lanzar la excepción java.rmi.RemoteException
    
    //Definicion del tercer método remoto
    public UsuarioDTO consultarUsuario(int identificacion)throws RemoteException;
     //cada definición del método debe especificar que puede lanzar la excepción java.rmi.RemoteException

    public boolean eliminarUsuario(int identificacion) throws RemoteException;

    public boolean actualizarUsuario(UsuarioDTO objUsuario) throws RemoteException;

    public UsuarioDTO iniciarSesion(DatosSesionDTO objSesion) throws RemoteException;


}


