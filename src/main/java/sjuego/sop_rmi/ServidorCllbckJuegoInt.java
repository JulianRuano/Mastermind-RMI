/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sjuego.sop_rmi;

import cliente.sop_rmi.JuegoCllbckInt;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author julianm
 */
public interface ServidorCllbckJuegoInt extends Remote{
    	public boolean registrarUsuario(JuegoCllbckInt  usuario) throws RemoteException;
        public void enviarMensaje(String mensaje)throws RemoteException;
        //Arreglo del 0 - 7 de 5 posiciones para los colores
        public void enviarColores(List<Integer> listaColores)throws RemoteException;
        public void enviarColoresIniciales(List<Integer> listaColoresIniciales)throws RemoteException;
        //Arreglo del 0 - 2 de 5 posiciones para las espigas
        public void enviarEspigas(List<Integer> listaEspigas)throws RemoteException;
}
