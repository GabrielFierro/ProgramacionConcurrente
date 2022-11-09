/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trenTuristico;

import java.util.ArrayList;
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
    private Semaphore ticketsAVender;   // Semaforo binario que controla la cantidad
    // de tickets maximos que se puede vender para 1 viaje
    private Semaphore mutex;
    private int cantTicketComprado; // Cantidad de tickets que se venden
    private int cantMaxDeTickets; // Cantidad maxima de tickets a vender
    private int contPasajerosSentados;

    public Cabina(int cantMaxDeTickets) {
        this.cantMaxDeTickets = cantMaxDeTickets;
        this.cantTicketComprado = 0;
        this.contPasajerosSentados = 0;
        this.ticketsAVender = new Semaphore(cantMaxDeTickets);
        this.mutex = new Semaphore(1);
    }

    public boolean puedeEmitirPasaje() throws InterruptedException {
        // Verifica si puede emitir un pasaje
        boolean exito = false;
        if (cantTicketComprado < cantMaxDeTickets) {
            exito = true;
        }
        return exito;
    }

    public boolean puedeComprarPasaje() throws InterruptedException {
        // Verifica si puede comprar un pasaje
        mutex.acquire();
        boolean exito = false;
        if (cantTicketComprado < cantMaxDeTickets) {
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

    public int getCantidadDePasajesDisponibles() {
        return this.cantMaxDeTickets;
    }

    public boolean compraronTickets() {
        return cantMaxDeTickets >= cantTicketComprado;
    }

    public boolean puedenSubir(int cantAsientos) {
        boolean exito = false;

        if (cantAsientos > this.cantMaxDeTickets) { 
            this.contPasajerosSentados++;
            exito = true;
        }
        return exito;
    }

}
