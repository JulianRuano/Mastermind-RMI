package sregistro.dto;

import java.io.Serializable;

public class Partida_DTO implements Serializable {
    private int idPartida;
    private int idJugador1;
    private int idJugador2;

    public Partida_DTO(int idPartida, int idJugador1, int idJugador2) {
        this.idPartida = idPartida;
        this.idJugador1 = idJugador1;
        this.idJugador2 = idJugador2;
    }
        

    public int getidPartida() {
        return idPartida;
    }

    public void setidPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public int getidJugador1() {
        return idJugador1;
    }

    public void setidJugador1(int idJugador1) {
        this.idJugador1 = idJugador1;
    }

    public int getidJugador2() {
        return idJugador2;
    }

    public void setidJugador2(int idJugador2) {
        this.idJugador2 = idJugador2;
    }
    
}
