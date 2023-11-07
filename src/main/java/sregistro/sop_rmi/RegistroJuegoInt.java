package sregistro.sop_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import sregistro.dto.RegistroDTO;

public interface RegistroJuegoInt extends Remote {

    public void enviarNotificacion(RegistroDTO objRegistro) throws RemoteException;
    public ArrayList<RegistroDTO> obtenerRegistro()throws RemoteException;
    
}
