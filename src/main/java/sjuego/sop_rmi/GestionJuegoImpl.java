package sjuego.sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import sregistro.dto.RegistroDTO;
import sregistro.sop_rmi.RegistroJuegoInt;
import utilidades.UtilidadesRegistroC;

public class GestionJuegoImpl extends UnicastRemoteObject implements GestionJuegoInt {

    private RegistroJuegoInt objReferenciaRemota;
    int idJuego = 1;
    int idJugador1 = 0;
    int idJugador2 = 0;

            

    public GestionJuegoImpl() throws RemoteException {
        super(); // invoca al constructor de la clase base
    }

    @Override
    public int iniciarJuego(int identificacion){      
        if(idJugador1 == 0){
            this.idJugador1 = identificacion;
            System.out.println("El jugador con identificacion " + identificacion + " ha iniciado el juego");
            return 1; // Salio bien
        } 
        if(idJugador1 != identificacion && idJugador2 != identificacion){
                try {
                    this.idJugador2 = identificacion;
                    generarNumeroAleatorio();
                    RegistroDTO obj = new RegistroDTO(idJuego, idJugador1, idJugador2);
                    objReferenciaRemota.enviarNotificacion(obj);

                    System.out.println("El jugador con identificacion " + identificacion + " ha iniciado el juego");
                    return 2; // Salio bien
                } catch (RemoteException e) {
                    System.out.println("Error al enviar la notificacion");
                }
        }else{          
            System.out.println("El jugador con identificacion " + identificacion + " ya inicio el juego");
            return 3; // jugador duplicado
        }      
        return 4; //Fallo inesperado en el servidor
    }
    
    
    @Override
    public ArrayList<RegistroDTO> consultarDatos()throws RemoteException{
        try {
             return objReferenciaRemota.obtenerRegistro();         
        } catch (RemoteException e) {
             System.out.println("Error al enviar la notificacion");
        }
        return null;            
    }

    public void generarNumeroAleatorio(){
        this.idJuego = (int) (Math.random() * 1000) + 1;
    }
    
    
    public void consultarReferenciaRemota(String direccionIpRMIRegistry, int numPuertoRMIRegistry){
        System.out.println(" ");
        System.out.println("Desde consultarReferenciaRemotaDeNotificacion()...");
        this.objReferenciaRemota = (RegistroJuegoInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry,
                numPuertoRMIRegistry, "registroJuego");
    }
}
