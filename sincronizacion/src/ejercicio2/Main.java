    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

/**
 *
 * @author gabriel.fierro
 */
public class Main {

    public static void main(String[] args) {
        Personaje principal = new Personaje();
        Orco orc = new Orco(principal);
        Curandero cur = new Curandero(principal);
        Thread Orco = new Thread(orc, "Orco");
        Thread Curandero = new Thread(cur, "Curandero");

        System.out.println("Inicia el hilo del main");

        Orco.start();
        Curandero.start();

        try {
            Orco.join();
            System.out.println("El jugador recibio daño, su vida se redujo a: " + principal.getVida());
            Curandero.join();
            System.out.println("El jugador recibio cura, su vida se incremento a: " + principal.getVida());
        } catch (InterruptedException ex) {

        }

        System.out.println("Finaliza el hilo del main");
    }
}
