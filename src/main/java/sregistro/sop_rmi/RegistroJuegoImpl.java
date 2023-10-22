package sregistro.sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import sregistro.dto.RegistroDTO;


public class RegistroJuegoImpl extends UnicastRemoteObject implements RegistroJuegoInt {

    //Declaramos una lista de registros
    private ArrayList<RegistroDTO> misRegistros;

    public RegistroJuegoImpl() throws RemoteException {
        super();
        this.misRegistros = new ArrayList<RegistroDTO> ();
    }

    @Override
    public void enviarNotificacion(RegistroDTO objRegistro) throws RemoteException {
        System.out.println("Notificacion recibida");
        System.out.println("Id del juego: " + objRegistro.getId_juego());
        System.out.println("Id del jugador 1: " + objRegistro.getId_jugador1());
        System.out.println("Id del jugador 2: " + objRegistro.getId_jugador2());

        //Agregamos el registro a la lista
        misRegistros.add(objRegistro);
    }

    
}
