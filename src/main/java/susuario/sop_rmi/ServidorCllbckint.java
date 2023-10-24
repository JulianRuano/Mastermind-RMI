package susuario.sop_rmi;;

import cliente.sop_rmi.UsuarioCllbckInt;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServidorCllbckint extends Remote
{
	public boolean registrarUsuario(UsuarioCllbckInt  usuario) throws RemoteException;
        public void enviarMensaje(String mensaje)throws RemoteException;
       
}


