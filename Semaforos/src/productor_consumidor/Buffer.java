/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productor_consumidor;

import java.util.concurrent.Semaphore;

/**
 *
 * @author gabriel.fierro
 */
public class Buffer {

    private int[] b;
    private int punteroAProductoColocado = 0, punteroAProductoExtraido = 0;
    private Semaphore mutex = new Semaphore(1); // Semaforo binario
    private Semaphore hayDatos; // Semaforo generico
    private Semaphore hayEspacio;   // Semaforo generico

    public Buffer(int cantidad) {
        b = new int[cantidad];
        hayDatos = new Semaphore(0, true);  
        hayEspacio = new Semaphore(cantidad, true);
    }

    public void poner(int dato) throws InterruptedException {
        hayEspacio.acquire();   // Toma el permiso N --> N-1
        mutex.acquire();	// Toma el permiso 1 --> 0

        b[punteroAProductoColocado] = dato;
        punteroAProductoColocado = (punteroAProductoColocado + 1) % b.length;

        mutex.release();	// Libera el permiso 0 --> 1
        hayDatos.release();	// Libera el permiso 0 --> 1
    }

    public int extraer() throws InterruptedException {
        hayDatos.acquire();     // Toma el permiso N --> N-1
        mutex.acquire();	// Toma el permiso 1 --> 0

        int actual = punteroAProductoExtraido;
        punteroAProductoExtraido = (punteroAProductoExtraido + 1) % b.length;

        mutex.release();	// Libera el permiso 0 --> 1
        hayEspacio.release();	// Libera el permiso N --> N+1

        return b[actual];
    }

}
