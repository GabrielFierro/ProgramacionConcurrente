/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package los_pollos_hermanos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel.fierro
 */
public class Mozo extends Thread {

    private Comedor comedor;

    public Mozo(Comedor comedor) {
        this.comedor = comedor;
    }

    @Override
    public void run() {
        comedor.elegirBebida();
        eligeBebida();   // Llama al metodo cocina
        System.out.println("El mozo entrega la bebida");
    }

    public void eligeBebida() {
        System.out.println("Eligiendo bebida...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
