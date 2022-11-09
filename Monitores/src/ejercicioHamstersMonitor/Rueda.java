/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioHamstersMonitor;

/**
 *
 * @author Usuario
 */
public class Rueda {

    public synchronized void rodar(String nombre) {
        System.out.println(nombre + " empieza a rodar");
        try {
            Thread.sleep((long) (Math.random() * 1500));
        } catch (InterruptedException ex) {

        }
    }
    
    public synchronized void terminoDeRodar(String nombre) {
        System.out.println(nombre + " termina de rodar");
        try {
            Thread.sleep((long) (Math.random() * 1500));
        } catch (InterruptedException ex) {

        }
    }
    
}
