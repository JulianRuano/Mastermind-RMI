/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.sop_rmi;

import cliente.ClienteDeObjetos;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import vistas.GUIJuego;
import vistas.GUIJuegoJ2;

/**
 *
 * @author julianm
 */
public class JuegoCllbckImpl  extends UnicastRemoteObject implements JuegoCllbckInt{
     
    private ClienteDeObjetos objCliente; 
    private GUIJuego objJugador1;
    private GUIJuegoJ2 objJugador2;
    
    public JuegoCllbckImpl() throws RemoteException
    {
        super();		
    }
    
    @Override
    public void notificar(String mensaje) throws RemoteException{
        System.out.println(mensaje);
        System.out.println("cliente.sop_rmi.JuegoCllbckImpl.notificar()");
        if (objCliente != null) {
            objCliente.notificacion(mensaje);
        }

    }

    @Override
    public void notificarColores(List<Integer> lista) throws RemoteException {
        System.out.println("Invocando al método notificar colores desde el cliente");
        if (objJugador2 != null) {
            objJugador2.actulizarTablero(lista);           
        }

    }
    
    @Override
    public void notificarEspigas(List<Integer> listaEspigas)throws RemoteException {
        System.out.println("Invocando al método notificar espigas desde el cliente");
        
    }
    
    @Override
    public void notificarColoresIniciales(List<Integer> listaColoresIniciales) throws RemoteException{
       System.out.println("Invocando al método notificarColoresIniciales desde el cliente");
        if (objJugador1 != null) {
            objJugador1.CargarColoresValidos(listaColoresIniciales);
        }
       
    }
    
    public void enviarCliente(ClienteDeObjetos prmCliente){
        this.objCliente = prmCliente;      
    }
    
    public void enviarJugador1(GUIJuego prmJugador1){
        this.objJugador1 = prmJugador1;
    }
        
    public void enviarJugador2(GUIJuegoJ2 prmJugador2){
        this.objJugador2 = prmJugador2;
    }
    
}
