package sjuego;

import utilidades.UtilidadesConsola;
import utilidades.UtilidadesRegistroS;
import java.rmi.RemoteException;
import sjuego.sop_rmi.GestionJuegoImpl;

public class ServidorDeObjetosJuego {
    public static void main(String args[]) throws RemoteException{
        int numPuertoNS;
        String direccionIpNS;

        System.out.println("Cual es el la direcciOn ip donde se encuentra  el N_S");
        direccionIpNS = UtilidadesConsola.leerCadena();
        System.out.println("Cual es el número de puerto por el cual escucha el N_S");
        numPuertoNS = UtilidadesConsola.leerEntero();

        GestionJuegoImpl objRemoto = new GestionJuegoImpl();
        objRemoto.consultarReferenciaRemota(direccionIpNS, numPuertoNS);

        try {
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemoto, direccionIpNS, numPuertoNS, "ObjetoRemotoJuego");
        } catch (Exception e) {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" + e.getMessage());
        }
    }
}
