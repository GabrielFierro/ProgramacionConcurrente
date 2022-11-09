/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioHamstersMonitor;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class JaulaSemaforo {

    private Semaphore plato;
    private Semaphore rueda;

    public JaulaSemaforo() {
        plato = new Semaphore(3);
        rueda = new Semaphore(1);

    }

    public void comer(String n) {
        pedirPlato(n);
        comiendo(n);
        dejarPlato(n);
    }

    public void hacerEjercicio(String n) {
        pedirRueda(n);
        corriendo(n);
        dejarRueda(n);

    }

    private void pedirRueda(String n) {
        try {
            System.out.println("Esta cerca de la rueda" + n);
            rueda.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(JaulaSemaforo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void corriendo(String n) {
        try {
            System.out.println("Esta corriendo " + n);
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(JaulaSemaforo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void dejarRueda(String n) {
        System.out.println("Dejo de correr " + n);

        rueda.release();
    }

    private void pedirPlato(String n) {
        try {
            System.out.println("Esta cerca el plato" + n);
            plato.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(JaulaSemaforo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void comiendo(String n) {
        try {
            System.out.println("Esta comiendo " + n);
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(JaulaSemaforo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void dejarPlato(String n) {
        System.out.println("Dejo de comer " + n);

        plato.release();
    }

}
