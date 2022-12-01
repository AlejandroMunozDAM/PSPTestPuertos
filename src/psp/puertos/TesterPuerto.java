package psp.puertos;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

public class TesterPuerto {

    public ArrayList<Integer> testearRango(int primerPuerto, int ultimoPuerto) {
        ArrayList<Integer> puertosAbiertos = new ArrayList<>();
        for (int i = primerPuerto; i <= ultimoPuerto; i++) {
            int puerto = i;
            try {
                ServerSocket serverSocket = new ServerSocket(puerto);
                serverSocket.close();
            } catch (IOException e) {
                puertosAbiertos.add(puerto);
            }
        }
        return puertosAbiertos;
    }
}
