/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.sop_rmi;

import cliente.ClienteDeObjetos;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author julianm
 */
public class JuegoCllbckImpl  extends UnicastRemoteObject implements JuegoCllbckInt{
     
    private ClienteDeObjetos objCliente; 
    
    public JuegoCllbckImpl() throws RemoteException
    {
        super();		
    }
    
    @Override
    public void notificar(String mensaje) throws RemoteException{
        System.out.println(mensaje);
        this.objCliente.notificacion(mensaje);
    }
    
    public void enviarCliente(ClienteDeObjetos prmCliente){
        this.objCliente = prmCliente;      
    }
}
