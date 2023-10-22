package sregistro.sop_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import sregistro.dto.RegistroDTO;

public interface RegistroJuegoInt extends Remote {

    public void enviarNotificacion(RegistroDTO objRegistro) throws RemoteException;
    
}
