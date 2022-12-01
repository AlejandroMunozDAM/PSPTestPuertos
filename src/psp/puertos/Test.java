package psp.puertos;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

class Test implements Runnable {
    private DatagramSocket socket;
    private DatagramPacket pkt;

    public Test(DatagramSocket socket, DatagramPacket pkt) {
        this.socket = socket;
        this.pkt = pkt;
    }

    @Override
    public void run() {
        String msg = new String(pkt.getData(), 0, pkt.getLength(), StandardCharsets.UTF_8);
        String[] puertos = msg.split("\\-");

        ArrayList<Integer> puertosAbiertos = new ArrayList<>();
        for (int i = Integer.parseInt(puertos[0]); i <= Integer.parseInt(puertos[1]); i++) {
            int puerto = i;
            try {
                ServerSocket serverSocket = new ServerSocket(puerto);
                serverSocket.close();
            } catch (IOException e) {
                puertosAbiertos.add(puerto);
            }
        }

        msg = puertosAbiertos.toString();
        byte[] buffer = msg.getBytes(StandardCharsets.UTF_8);
        SocketAddress direccion = new InetSocketAddress("localhost", pkt.getPort());
        pkt = new DatagramPacket(buffer, buffer.length, direccion);
        System.out.println(msg);

        try {
            socket.send(pkt);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
