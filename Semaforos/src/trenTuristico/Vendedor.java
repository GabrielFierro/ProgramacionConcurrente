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
public class Vendedor extends Thread {
    // Clase correspondiente al vendedor que es quien vende tickets en la Cabina

    private String nombre;
    private Cabina cab;
    private int cantTickets;
    private boolean exito;

    public Vendedor(String nombre, Cabina cab, int cantTickets) {
        this.nombre = nombre;
        this.cab = cab;
        this.cantTickets = cantTickets;
    }

    @Override
    public void run() {
        int cantPasajesDisp = 0;
        cantPasajesDisp = cab.getCantidadDePasajesDisponibles();
        for (int i = 0; i < this.cantTickets; i++) {
            try {
                System.out.println("\nTiene disponible " + cantPasajesDisp + " pasajes para vender");
                exito = cab.puedeEmitirPasaje();
                if (exito) {
                    System.out.println("El vendedor " + this.nombre + " vendio un ticket" + "\n");
                    Thread.sleep(100);
                    cab.venderPasaje();
                } else {
                    System.out.println("El vendedor " + this.nombre + " no pudo vender el ticket" + "\n");
                }
                cantPasajesDisp--;
            } catch (InterruptedException ex) {
                Logger.getLogger(Vendedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
