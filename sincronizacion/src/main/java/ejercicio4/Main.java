/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

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
        Hamster ham = new Hamster(j);

        Thread hilo1 = new Thread(ham, "Carlitos");
        Thread hilo2 = new Thread(ham, "Juan");
        Thread hilo3 = new Thread(ham, "Pepe");

        hilo1.start();
        hilo2.start();
        hilo3.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
