/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.sop_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author julianm
 */
public interface JuegoCllbckInt extends Remote{
     public void notificar(String mensaje) throws RemoteException;
     public void notificarColores(List<Integer> listaColores) throws RemoteException;
     public void notificarEspigas(List<Integer> listaEspigas) throws RemoteException;
     public void notificarColoresIniciales(List<Integer> listaColoresIniciales) throws RemoteException;
     public void notificarGanador(String mensaje,boolean valor) throws RemoteException;
}
