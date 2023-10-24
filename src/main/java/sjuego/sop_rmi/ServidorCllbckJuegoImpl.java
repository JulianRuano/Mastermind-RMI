package sjuego.sop_rmi;

import cliente.sop_rmi.JuegoCllbckInt;
import cliente.sop_rmi.UsuarioCllbckInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julianm
 */
public class ServidorCllbckJuegoImpl extends UnicastRemoteObject implements ServidorCllbckJuegoInt{
    
     private List<JuegoCllbckInt> usuarios;//lista que almacena la referencia remota de los clientes

    public ServidorCllbckJuegoImpl() throws RemoteException
    {
        super();
        usuarios= new ArrayList();
    }
    
     @Override
    public synchronized boolean  registrarUsuario(JuegoCllbckInt usuario) throws RemoteException {
       //método que unicamente puede ser accedido por un hilo
	System.out.println("Invocando al método registrar usuario desde el servidor");
        boolean bandera=false;
        if (!usuarios.contains(usuario))
        {
            bandera=usuarios.add(usuario);  
        }        
        return bandera;       
    }
   
    @Override
    public void enviarMensaje(String mensaje)throws RemoteException {
        
          notificarUsuarios("un cliente envio el siguiente mensaje: " + mensaje);
    }
    
    private void notificarUsuarios(String mensaje) throws RemoteException {
        System.out.println("Invocando al método notificar usuarios desde el servidor");
        for(JuegoCllbckInt objUsuario: usuarios)
        {
            objUsuario.notificar(mensaje);//el servidor hace el callback
            
        }
    }
}
