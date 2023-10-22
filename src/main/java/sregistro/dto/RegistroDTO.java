package sregistro.dto;

import java.io.Serializable;

public class RegistroDTO implements Serializable {
    private int id_juego;
    private int id_jugador1;
    private int id_jugador2;

    public RegistroDTO(int id_juego, int id_jugador1, int id_jugador2) {
        this.id_juego = id_juego;
        this.id_jugador1 = id_jugador1;
        this.id_jugador2 = id_jugador2;
    }
        

    public int getId_juego() {
        return id_juego;
    }

    public void setId_juego(int id_juego) {
        this.id_juego = id_juego;
    }

    public int getId_jugador1() {
        return id_jugador1;
    }

    public void setId_jugador1(int id_jugador1) {
        this.id_jugador1 = id_jugador1;
    }

    public int getId_jugador2() {
        return id_jugador2;
    }

    public void setId_jugador2(int id_jugador2) {
        this.id_jugador2 = id_jugador2;
    }
    
}
