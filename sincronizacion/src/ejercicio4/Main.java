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
        Jaula j = new Jaula();  // Creamos una instancia de Jaula que posee las acciones
        Hamster h = new Hamster(j);

        Thread hilo1 = new Thread(h, "Carlitos");
        Thread hilo2 = new Thread(h, "Juan");
        Thread hilo3 = new Thread(h, "Pepe");

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
