/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trenTuristico;

import java.util.concurrent.Semaphore;

/**
 *
 * @author gabriel.fierro
 */
public class Cabina {

    /* 
    Recurso compartido al que acceden X cantidad de pasajeros que desean
    comprar tickets.
    Pueden comprar una cantidad maxima determinada por un semaforo generico,
    y aquellos que no alcanzan a comprar quedan en lista de espera, para ello
    debo bloquear la compra
     */
    private Semaphore espera;
    private Semaphore ticketsAVender;   // Semaforo generico que controla la cantidad
    // de tickets maximos que se puede vender para 1 viaje
    private Semaphore mutex;
    private int cantTicketComprado; // Contador que controla la cantidad de 
    // tickets que se venden
    private int cantTicketsAVender; // Contador que controla la cantidad maxima
    // de tickets a vender

    public Cabina(int cantTicketsAVender) {
        this.cantTicketsAVender = cantTicketsAVender;
        this.cantTicketComprado = 0;
        this.ticketsAVender = new Semaphore(cantTicketsAVender); // ej: 10
        this.mutex = new Semaphore(1);
        this.espera = new Semaphore(0);
    }

    public boolean puedeEmitirPasaje() throws InterruptedException {
        // Verifica si puede emitir un pasaje
        boolean exito = false;
        if (cantTicketComprado < cantTicketsAVender) {
            exito = true;
        }
        return exito;
    }

    public boolean puedeComprarPasaje() throws InterruptedException {
        // Verifica si puede comprar un pasaje
        mutex.acquire();
        boolean exito = false;
        if (cantTicketComprado < cantTicketsAVender) {
            exito = true;
        }
        return exito;
    }

    public void venderPasaje() throws InterruptedException {
        ticketsAVender.acquire();
    }

    public void comprarPasaje() {
        this.cantTicketComprado++;
        mutex.release();
    }
    
    public int cantidadDePasajesDisponibles(){
        return this.cantTicketsAVender;
    }

}