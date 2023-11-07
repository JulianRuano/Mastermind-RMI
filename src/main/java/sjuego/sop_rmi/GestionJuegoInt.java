package sjuego.sop_rmi;
import java.rmi.Remote;
import java.rmi.RemoteException;
import sregistro.dto.ConsultaDTO;

public interface GestionJuegoInt  extends Remote{
    public int iniciarJuego(int identificacion) throws RemoteException;
    public ConsultaDTO consultarDatos()throws RemoteException;
}
