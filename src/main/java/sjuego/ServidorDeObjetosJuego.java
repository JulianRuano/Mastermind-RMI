package sjuego;

import utilidades.UtilidadesConsola;
import utilidades.UtilidadesRegistroS;
import java.rmi.RemoteException;
import sjuego.sop_rmi.GestionJuegoImpl;
import sjuego.sop_rmi.ServidorCllbckJuegoImpl;

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

        //Callback
        ServidorCllbckJuegoImpl objRemotoCllbck = new ServidorCllbckJuegoImpl();  
        
        try {
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemoto, direccionIpNS, numPuertoNS, "ObjetoRemotoJuego");
        
            UtilidadesRegistroS.arrancarNS(numPuertoNS);
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemotoCllbck, direccionIpNS, numPuertoNS,
                    "servidorCllbckJuego");
        } catch (RemoteException e) {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" + e.getMessage());
        }
    }
}
