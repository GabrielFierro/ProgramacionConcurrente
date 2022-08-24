/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos.ejercicio2;

/**
 *
 * @author gabriel.fierro
 */
public class TesteoHilos {

    public static void main(String[] args) {
        Thread miHilo = new MiEjecucion();  // Creo un objeto de tipo Thread
        miHilo.start(); // Comienza la ejecucion del hilo
        System.out.println("En el main");
    }
}
