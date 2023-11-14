/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package susuario;

import utilidades.UtilidadesRegistroS;
import utilidades.UtilidadesConsola;
import java.rmi.RemoteException;
import susuario.sop_rmi.*;

public class ServidorDeObjetos {
    public static void main(String args[]) throws RemoteException {

        int numPuertoRMIRegistry = 3000;
        String direccionIpRMIRegistry = "localhost";

        //System.out.println("Cual es el la dirección ip donde se encuentra  el rmiregistry ");
        //direccionIpRMIRegistry = UtilidadesConsola.leerCadena();
        //System.out.println("Cual es el número de puerto por el cual escucha el rmiregistry ");
        //numPuertoRMIRegistry = UtilidadesConsola.leerEntero();

        GestorUsuariosImpl objRemoto = new GestorUsuariosImpl();// se leasigna el puerto de escucha del objeto remoto
        ServidorCllbckImpl objRemotoCllbck = new ServidorCllbckImpl();       
        
        try {
            UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistry);
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemoto, direccionIpRMIRegistry, numPuertoRMIRegistry,
                    "gestionUsuarios");
            
            UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistry);
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemotoCllbck, direccionIpRMIRegistry, numPuertoRMIRegistry,
                    "servidorCllbck");
            System.out.println("**** cll ****");

        } catch (Exception e) {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" + e.getMessage());
        }

    }
}
