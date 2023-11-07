package sjuego.sop_rmi;

import cliente.sop_rmi.JuegoCllbckInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author julianm
 */
public class ServidorCllbckJuegoImpl extends UnicastRemoteObject implements ServidorCllbckJuegoInt{
    
     private final List<JuegoCllbckInt> usuarios;//lista que almacena la referencia remota de los clientes
     List<Integer> coloresIniciales, colores, espigas;
     int puntaje1 = 0;
     int puntaje2 = 0;

    public ServidorCllbckJuegoImpl() throws RemoteException
    {
        super();
        usuarios = new ArrayList<>();
        coloresIniciales = new ArrayList<>();
        colores = new ArrayList<>();
        espigas = new ArrayList<>();
    }
    
     @Override
    public synchronized boolean  registrarUsuario(JuegoCllbckInt usuario) throws RemoteException {
       //método que unicamente puede ser accedido por un hilo
	System.out.println("Invocando al método registrar usuario desde el servidor");
        boolean bandera=false;
        if (!usuarios.contains(usuario))
        {
            bandera=usuarios.add(usuario); 
            System.out.println("*****************"+usuarios.size()+"*******************");
        }        
        return bandera;       
    }
   
    @Override
    public void enviarMensaje(String mensaje)throws RemoteException {
        
          notificarUsuarios("un cliente envio el siguiente mensaje: " + mensaje);
    }

    @Override
    public void enviarColores(List<Integer> listaColores) throws RemoteException {
        System.out.println("Invocando al método enviarColores desde el servidor");
        colores = listaColores;
        verificarGanador();
        for(JuegoCllbckInt objUsuario: usuarios)
        {           
            objUsuario.notificarColores(listaColores);//el servidor hace el callback           
        }
        notificarUsuarios("Nuevos colores");
    }
    
    @Override
     public void enviarEspigas(List<Integer> listaEspigas)throws RemoteException{
        System.out.println("Invocando al método enviarEspigas desde el servidor");
        this.espigas = listaEspigas;
        verificarEspigas();
        for(JuegoCllbckInt objUsuario: usuarios)
        {
            objUsuario.notificarEspigas(listaEspigas);           
        }   
        notificarUsuarios("Nuevas espigas");
     }
     
     @Override
     public void enviarColoresIniciales(List<Integer> listaColoresIniciales)throws RemoteException{
         System.out.println("Invocando al método enviarColoresIniciales desde el servidor");
         this.coloresIniciales = listaColoresIniciales; 
        for(JuegoCllbckInt objUsuario: usuarios)
        {          
            objUsuario.notificarColoresIniciales(listaColoresIniciales);                      
        }         
     }
    
    private void notificarUsuarios(String mensaje) throws RemoteException {
        System.out.println("Invocando al método notificar usuarios desde el servidor");
        for(JuegoCllbckInt objUsuario: usuarios)
        {
            objUsuario.notificar(mensaje);//el servidor hace el callback            
        }
    }
    
    private void verificarGanador() throws RemoteException{
        //Verificar si el jugador gano y enviamos el mensaje
        if(colores.equals(coloresIniciales)){
            for(JuegoCllbckInt objUsuario: usuarios)
            {
                if (puntaje1 >= puntaje2) {
                    objUsuario.notificarGanador("Jugador 1: "+puntaje1+ " Jugador 2: "+puntaje2, true);
                    objUsuario.notificar("Fin del juego");
                }
                if (puntaje1 < puntaje2) {
                    objUsuario.notificarGanador("Jugador 1: "+puntaje1+ " Jugador 2: "+puntaje2, false);
                    objUsuario.notificar("Fin del juego...");
                }
                
            }
        }else{
            puntaje2++;
        }   

    }

    private void verificarEspigas() throws RemoteException{
        //Verificamos si las espigas son correctas si no le sumamos un punto al puntaje1
        //Recorremos la lista de colores y la comparamos con la lista de colores iniciales
        for(int i = 0; i < colores.size(); i++){
            if(Objects.equals(colores.get(i), coloresIniciales.get(i))){
                if (espigas.get(i) != 2) {
                    puntaje1++;                                      
                }
            }
        }
    }
}
