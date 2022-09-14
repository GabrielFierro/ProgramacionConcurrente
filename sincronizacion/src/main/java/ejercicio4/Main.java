/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.ejercicio4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel.fierro
 */
public class Main {

    public static void main(String[] args) {
        Plato p = new Plato();
        Rueda r = new Rueda();
        Hamaca h = new Hamaca();
        Jaula j = new Jaula(p, r, h);  // Creamos una instancia de Jaula que posee las acciones
        Hamster ham1 = new Hamster(j, "Carlitos");
        Hamster ham2 = new Hamster(j, "Juan");
        Hamster ham3 = new Hamster(j, "Pepe");

        Thread hilo1 = new Thread(ham1);
        Thread hilo2 = new Thread(ham2);
        Thread hilo3 = new Thread(ham3);
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
        // Los hilos pasan a estado runnable
        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
