package sjuego.sop_rmi;

import cliente.sop_rmi.JuegoCllbckInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julianm
 */
public class ServidorCllbckJuegoImpl extends UnicastRemoteObject implements ServidorCllbckJuegoInt{
    
     private final List<JuegoCllbckInt> usuarios;//lista que almacena la referencia remota de los clientes

    public ServidorCllbckJuegoImpl() throws RemoteException
    {
        super();
        usuarios= new ArrayList<>();
    }
    
     @Override
    public synchronized boolean  registrarUsuario(JuegoCllbckInt usuario) throws RemoteException {
       //método que unicamente puede ser accedido por un hilo
	System.out.println("Invocando al método registrar usuario desde el servidor");
        boolean bandera=false;
        if (!usuarios.contains(usuario))
        {
            bandera=usuarios.add(usuario); 
            System.out.println("*****************"+usuarios.size()+"*******************");
        }        
        return bandera;       
    }
   
    @Override
    public void enviarMensaje(String mensaje)throws RemoteException {
        
          notificarUsuarios("un cliente envio el siguiente mensaje: " + mensaje);
    }

    @Override
    public void enviarColores(List<Integer> lista) throws RemoteException {
        System.out.println("Invocando al método enviarColores desde el servidor");
        for(JuegoCllbckInt objUsuario: usuarios)
        {
            objUsuario.notificarColores(lista);//el servidor hace el callback
            
        }
    }
    
    @Override
     public void enviarEspigas(List<Integer> listaEspigas)throws RemoteException{
        System.out.println("Invocando al método enviarEspigas desde el servidor");
        for(JuegoCllbckInt objUsuario: usuarios)
        {
            objUsuario.notificarEspigas(listaEspigas);
            
        }        
     }
     
     @Override
     public void enviarColoresIniciales(List<Integer> listaColoresIniciales)throws RemoteException{
         System.out.println("Invocando al método enviarColoresIniciales desde el servidor");
         
        for(JuegoCllbckInt objUsuario: usuarios)
        {
            objUsuario.notificarColoresIniciales(listaColoresIniciales);
            
        }         
     }
    
    private void notificarUsuarios(String mensaje) throws RemoteException {
        System.out.println("Invocando al método notificar usuarios desde el servidor");
        for(JuegoCllbckInt objUsuario: usuarios)
        {
            objUsuario.notificar(mensaje);//el servidor hace el callback
            
        }
    }
}
