/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comederos_de_animales;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel.fierro
 */
public class Comedor {

    // Recurso compartido
    private Semaphore hayAnimales; // Semaforo generico para perros
    private Semaphore hayEspacio;  // Semaforo generico para gatos
    private Semaphore mutex = new Semaphore(1); // Semaforo binario para controlar el acceso al recurso compartido

    public Comedor(int cantidad) {
        hayAnimales = new Semaphore(0);
        hayEspacio = new Semaphore(cantidad);
    }

    public void comer() {
        try {
            hayEspacio.acquire();   // Toma el permiso N --> N-1
            mutex.acquire();    // Toma el permiso 1 --> 0

            hayAnimales.release(); // Libera el permiso 0 --> 1
        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void terminarDeComer() {
        hayEspacio.release();
        try {
            hayAnimales.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        mutex.release();
    }

}
