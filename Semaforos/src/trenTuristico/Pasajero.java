/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trenTuristico;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel.fierro
 */
public class Pasajero extends Thread {
    // Clase correspondiente al pasajero que es quien compra tickets en la Cabina

    private String nombre;
    private Cabina cab; //Recurso compartido
    private ControlTren ct;

    public Pasajero(String nombre, Cabina cab, ControlTren ct) {
        this.nombre = nombre;
        this.cab = cab;
        this.ct = ct;
    }

    @Override
    public void run() {
        boolean exito;
        try {
            exito = this.cab.puedeComprarPasaje();
            System.out.println("El " + this.nombre + " esta intentando comprar un ticket");
            Thread.sleep(100);
            if (exito) {
                System.out.println("El " + this.nombre + " pudo adquirir el pasaje" + "\n");
                this.cab.comprarPasaje();
            } else {
                System.out.println("El " + this.nombre + " no pudo adquirir el pasaje" + "\n");
            }
            if (this.cab.compraronTickets()) {
                System.out.println("Entro aca");
                this.ct.puedenSubir();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Pasajero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
