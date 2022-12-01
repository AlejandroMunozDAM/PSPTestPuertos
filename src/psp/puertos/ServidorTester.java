package psp.puertos;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ServidorTester {
    public static final int PUERTO = 5000;

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(PUERTO);
        while (true) {
            byte[] buffer = new byte[10000];
            DatagramPacket pkt = new DatagramPacket(buffer, buffer.length);
            socket.receive(pkt);
            Thread test = new Thread(new Test(socket,pkt));
            test.start();
        }
    }
}
