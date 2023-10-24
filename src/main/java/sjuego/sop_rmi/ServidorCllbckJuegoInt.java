/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sjuego.sop_rmi;

import cliente.sop_rmi.JuegoCllbckInt;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author julianm
 */
public interface ServidorCllbckJuegoInt extends Remote{
    	public boolean registrarUsuario(JuegoCllbckInt  usuario) throws RemoteException;
        public void enviarMensaje(String mensaje)throws RemoteException;
}
