package psp.puertos;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Introduce el primer puerto del rango a testear: ");
        Scanner sc = new Scanner(System.in);
        int primerPuerto = sc.nextInt();
        System.out.print("Introduce el ultimo puerto del rango a testear: ");
        int ultimoPuerto = sc.nextInt();

        TesterPuerto testerPuerto = new TesterPuerto();
        ArrayList<Integer> resultado = testerPuerto.testearRango(primerPuerto, ultimoPuerto);
        System.out.println(resultado);

    }
}