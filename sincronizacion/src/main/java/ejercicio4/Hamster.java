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
public class Hamster implements Runnable {

    private Jaula jau;
    private String nombre;

    public Hamster(Jaula j, String nombre) {
        this.jau = j;
        this.nombre = nombre;
    }

    public void run() {
        boolean plato_en_uso, rueda_en_uso, hamaca_en_uso;

        plato_en_uso = jau.usarPlato();

        if (plato_en_uso) {
            System.out.println("El hilo " + nombre + " esta usando el plato");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hamster.class.getName()).log(Level.SEVERE, null, ex);
            }
            jau.dejarPlato();
            System.out.println("El hilo " + nombre + " dejo de usar el plato");
        }

        rueda_en_uso = jau.usarRueda();
        if (rueda_en_uso) {
            System.out.println("El hilo " + nombre + " esta usando la rueda");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hamster.class.getName()).log(Level.SEVERE, null, ex);
            }
            jau.dejarRueda();
            System.out.println("El hilo " + nombre + " dejo de usar la rueda");
        }

        hamaca_en_uso = jau.usarHamaca();
        if (hamaca_en_uso) {
            System.out.println("El hilo " + nombre + " esta usando la hamaca");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hamster.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("El hilo " + nombre + " dejo de usar la hamaca");
            jau.dejarRueda();
        }
    }

}
