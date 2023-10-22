package sjuego.dto;

import java.io.Serializable;

public class Juego_DTO implements Serializable {
    private int idPartida;
    private int idJugador;
    private int role;

    public Juego_DTO(){
        super();
    }

    public Juego_DTO(int idPartida, int idJugador, int role){
        this.idPartida = idPartida;
        this.idJugador = idJugador;
        this.role = role;
    }

    public int getIdPartida(){
        return idPartida;
    }

    public void setIdPartida(int idPartida){
        this.idPartida = idPartida;
    }

    public int getIdJugador(){
        return idJugador;
    }

    public void setIdJugador(int idJugador){
        this.idJugador = idJugador;
    }

    public int getRole(){
        return role;
    }

    public void setRole(int role){
        this.role = role;
    }
}
