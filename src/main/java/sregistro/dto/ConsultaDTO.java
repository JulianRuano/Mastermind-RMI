package sregistro.dto;

import java.io.Serializable;
/**
 *
 * @author julianm
 */
public class ConsultaDTO implements Serializable {
    private int Ganador;
    private int Perdedor;
    private int puntaje1;
    private int puntaje2;

    public ConsultaDTO(int Ganador, int Perdedor, int puntaje1, int puntaje2) {
        this.Ganador = Ganador;
        this.Perdedor = Perdedor;
        this.puntaje1 = puntaje1;
        this.puntaje2 = puntaje2;
    }

    public int getGanador() {
        return Ganador;
    }

    public void setGanador(int Ganador) {
        this.Ganador = Ganador;
    }

    public int getPerdedor() {
        return Perdedor;
    }

    public void setPerdedor(int Perdedor) {
        this.Perdedor = Perdedor;
    }

    public int getPuntaje1() {
        return puntaje1;
    }

    public void setPuntaje1(int puntaje1) {
        this.puntaje1 = puntaje1;
    }

    public int getPuntaje2() {
        return puntaje2;
    }

    public void setPuntaje2(int puntaje2) {
        this.puntaje2 = puntaje2;
    }
}
