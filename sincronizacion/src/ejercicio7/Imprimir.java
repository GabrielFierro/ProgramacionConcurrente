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
        Turno t = new Turno();
        
        Hilo hilo = new Hilo(l, t, "A");
        Hilo hilo1 = new Hilo(l, t, "B");
        Hilo hilo2 = new Hilo(l, t, "C");

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
