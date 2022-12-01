package psp.puertos;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final int LENGTH = 1000;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un puerto para conectarte: ");
        int puerto = sc.nextInt();
        DatagramSocket socket = new DatagramSocket(puerto);
        System.out.print("Introduce el primer puerto del rango a testear: ");
        int primerPuerto = sc.nextInt();
        System.out.print("Introduce el ultimo puerto del rango a testear (max 65535): ");
        int ultimoPuerto = sc.nextInt();
        byte[] buffer = String.format("%d-%d", primerPuerto, ultimoPuerto).getBytes(StandardCharsets.UTF_8);
        SocketAddress direccion = new InetSocketAddress("localhost", ServidorTester.PUERTO);
        DatagramPacket pkt = new DatagramPacket(buffer, buffer.length, direccion);

        socket.send(pkt);
        buffer = new byte[10000];
        pkt = new DatagramPacket(buffer, 0, buffer.length);
        socket.receive(pkt);
        String msg = new String(pkt.getData(), 0, pkt.getLength(), StandardCharsets.UTF_8);
        System.out.println("PUERTOS ABIERTOS: "+msg);
    }
}