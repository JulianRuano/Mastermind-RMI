package sjuego.sop_rmi;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GestionJuegoInt  extends Remote{
    public int iniciarJuego(int identificacion) throws RemoteException;
}
