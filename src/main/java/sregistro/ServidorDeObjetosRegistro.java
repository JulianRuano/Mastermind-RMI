package sregistro;

import utilidades.UtilidadesRegistroS;
import utilidades.UtilidadesConsola;
import java.rmi.RemoteException;
import sregistro.sop_rmi.*;

public class ServidorDeObjetosRegistro {
    public static void main(String args[]) throws RemoteException {

        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";

        System.out.println("Cual es el la dirección ip donde se encuentra  el rmiregistry ");
        direccionIpRMIRegistry = UtilidadesConsola.leerCadena();
        System.out.println("Cual es el número de puerto por el cual escucha el rmiregistry ");
        numPuertoRMIRegistry = UtilidadesConsola.leerEntero();

        RegistroJuegoImpl objRemoto = new RegistroJuegoImpl();// se leasigna el puerto de escucha del objeto remoto

        try {
            UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistry);
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemoto, direccionIpRMIRegistry, numPuertoRMIRegistry,
                    "registroJuego");

        } catch (Exception e) {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" + e.getMessage());
        }
    }
    
}
