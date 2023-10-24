package susuario.sop_rmi;

import cliente.sop_rmi.UsuarioCllbckInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServidorCllbckImpl extends UnicastRemoteObject implements ServidorCllbckint {

    private List<UsuarioCllbckInt> usuarios;//lista que almacena la referencia remota de los clientes

    public ServidorCllbckImpl() throws RemoteException
    {
        super();
        usuarios= new ArrayList();
    }
    
    @Override
    public synchronized boolean  registrarUsuario(UsuarioCllbckInt usuario) throws RemoteException {
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
        for(UsuarioCllbckInt objUsuario: usuarios)
        {
            objUsuario.notificar(mensaje, usuarios.size());//el servidor hace el callback
            
        }
    }

}
