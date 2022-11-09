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
    private Semaphore ticketsAVender;   // Semaforo generico que controla la cantidad
    // de tickets maximos que se puede vender para 1 viaje
    private Semaphore mutex;
    private int cantTicketComprado; // Cantidad de tickets que se venden
    private int cantMaxDeTickets; // Cantidad maxima de tickets a vender
    private int contPasajerosSentados;
    private ArrayList<Thread> array_list = new ArrayList<Thread>();

    public Cabina(int cantMaxDeTickets) {
        this.cantMaxDeTickets = cantMaxDeTickets;
        this.cantTicketComprado = 0;
        this.contPasajerosSentados = 0;
        this.ticketsAVender = new Semaphore(cantMaxDeTickets); // ej: 10
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
        //this.salaDeEspera.enviarPasajero(this.cantTicketComprado, Thread.currentThread);
        this.array_list.add(this.cantTicketComprado, Thread.currentThread());   // Simula la sala de espera
        // no es necesario esto
        // para ello utilizo un semaforo binario para bloquearlos
        this.cantTicketComprado++;
        mutex.release();
    }

    public int getCantidadDePasajesDisponibles() {
        return this.cantMaxDeTickets;
    }

    public void subirPasajeros() {
        this.array_list.forEach((n) -> {
            System.out.println("El " + n.getName() + " se subio al tren");
        });
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
