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
public class MiEjecucion extends Thread {

    public void run() {
        // Metodo publico run que invoca al metodo ir()
        ir();
    }

    public void ir() {
        // Metodo publico ir que invoca al metodo hacerMas()
        hacerMas();
    }

    public void hacerMas() {
        // Metodo publico que imprime un mensaje por pantalla
        System.out.println("En la pila");
    }

}
