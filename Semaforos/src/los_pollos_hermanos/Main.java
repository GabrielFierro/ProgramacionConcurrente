/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package los_pollos_hermanos;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel.fierro
 */
public class Main {

    public static void main(String[] args) {
        // Zona de declaracion de hilos
        Comedor comedor = new Comedor();    // Recurso Compartido
        Mozo mozo = new Mozo(comedor);    // Hilo
        Cocinero cocinero = new Cocinero(comedor);  // Hilo
        Thread hiloMozo = new Thread(mozo, "Mozo 1");
        Thread hiloCocinero = new Thread(cocinero, "Cocinero 1");
        // Zona de declaracion de variables
        int min = 1, max = 3;
        int opcion;

        System.out.println("1) Tomar"
                + "\n2) Comer"
                + "\n3) Tomar y Comer");

        opcion = (int) Math.floor(Math.random() * (max - min + 1) + min);
        System.out.println("El empleado eligio la opcion: " + opcion);

        Empleado empleado = new Empleado(comedor, 3); // Hilo
        Thread hiloEmpleado = new Thread(empleado, "Empleado 1");

        hiloEmpleado.start();
        switch (opcion) {
            case 1:
                hiloMozo.start();
                break;
            case 2:
                hiloCocinero.start();
                break;
            case 3:
                hiloMozo.start();
                hiloCocinero.start();
            default:
                break;
        }
    }
}
