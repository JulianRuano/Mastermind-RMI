package sregistro.sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import sregistro.dto.RegistroDTO;


public class RegistroJuegoImpl extends UnicastRemoteObject implements RegistroJuegoInt {

    //Declaramos una lista de registros
    private final ArrayList<RegistroDTO> misRegistros;

    public RegistroJuegoImpl() throws RemoteException {
        super();
        this.misRegistros = new ArrayList<> ();
        // Cargar los registros del archivo registros-juegos.txt
        cargarRegistrosArchivo();
    }

    @Override
    public void enviarNotificacion(RegistroDTO objRegistro) throws RemoteException {
        System.out.println("Notificacion recibida");
        System.out.println("Id del juego: " + objRegistro.getId_juego());
        System.out.println("Id del jugador 1: " + objRegistro.getId_jugador1());
        System.out.println("Id del jugador 2: " + objRegistro.getId_jugador2());

        //Agregamos el registro a la lista
        misRegistros.add(objRegistro);
        // Guardar el registro en un archivo registros-juegos.txt
        guardarRegistroArchivo();
    }
    
    @Override
    public ArrayList<RegistroDTO> obtenerRegistro()throws RemoteException{
        return misRegistros;
    }

    private void guardarRegistroArchivo() {
        // Guardar el registro en un archivo registros-juegos.txt
        // Descomponer el registro asi id_juego, id_jugador1, id_jugador2
        try {
            try (FileWriter archivo = new FileWriter("registros-juegos.txt")) {
                for (RegistroDTO registro : misRegistros) {
                    archivo.write(registro.getId_juego() + "," + registro.getId_jugador1() + "," + registro.getId_jugador2() + "\n");
                }
            }
            System.out.println("Registros guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el registro en el archivo");
        }      
    }

    private void cargarRegistrosArchivo() {
        // Cargar los registros del archivo registros-juegos.txt
        // Descomponer el registro asi id_juego, id_jugador1, id_jugador2
        // Agregar el registro a la lista
        System.out.println("Registros cargados");
        try {
            try (FileReader archivo = new FileReader("registros-juegos.txt")) {
                int caracter = archivo.read();
                String registro = "";
                while (caracter != -1) {
                    if (caracter == '\n') {
                        String[] datos = registro.split(",");
                        RegistroDTO objRegistro = new RegistroDTO();
                        objRegistro.setId_juego(Integer.parseInt(datos[0]));
                        objRegistro.setId_jugador1(Integer.parseInt(datos[1]));
                        objRegistro.setId_jugador2(Integer.parseInt(datos[2]));
                        misRegistros.add(objRegistro);
                        registro = "";
                    } else {
                        registro += (char) caracter;
                    }
                    caracter = archivo.read();
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al cargar los registros del archivo");
        }   
    }

    
}
