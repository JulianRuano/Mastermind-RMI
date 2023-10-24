package cliente.sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import cliente.ClienteDeObjetos;

public class UsuarioCllbckImpl extends UnicastRemoteObject implements UsuarioCllbckInt
{
    private ClienteDeObjetos objCliente; 
    
    public UsuarioCllbckImpl() throws RemoteException
    {
            super();		
    }

    @Override
    public void notificar(String mensaje, int cantidadUsuarios) throws RemoteException {
        String msj;
        System.out.println("Mensaje enviado del servidor: " + mensaje);       
        System.out.println("Cantidad de usuarios conectados: " + cantidadUsuarios );
        msj = mensaje;
        
       objCliente.notificacion(msj);
    }
    
    public void objCliente(ClienteDeObjetos prmCliente){
        this.objCliente = prmCliente;      
    }

}
