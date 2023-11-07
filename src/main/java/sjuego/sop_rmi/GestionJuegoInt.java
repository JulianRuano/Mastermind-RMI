package sjuego.sop_rmi;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import sregistro.dto.RegistroDTO;

public interface GestionJuegoInt  extends Remote{
    public int iniciarJuego(int identificacion) throws RemoteException;
    public ArrayList<RegistroDTO> consultarDatos()throws RemoteException;
}
