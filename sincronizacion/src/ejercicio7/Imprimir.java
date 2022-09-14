/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

/**
 *
 * @author gabriel.fierro
 */
public class Imprimir {

    public static void main(String[] args) {
        Cadena l = new Cadena("");
        Thread[] hilos = new Thread[2];
        Hilo hilo = new Hilo(l, 0, "A");
        Hilo hilo1 = new Hilo(l, 1, "B");
        Hilo hilo2 = new Hilo(l, 2, "C");

        Thread h1 = new Thread(hilo);
        Thread h2 = new Thread(hilo1);
        Thread h3 = new Thread(hilo2);

        h1.start();
        h2.start();
        h3.start();

        try {
            h1.join();
            h2.join();
            h3.join();
        } catch (InterruptedException ex) {

        }
        
        System.out.println("Obtener letras concatenadas: " + l.getLetra());
        // AAAAABBBCCCCCC
    }

}
