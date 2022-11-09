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
public class Cocinero extends Thread {

    private Comedor comedor;

    public Cocinero(Comedor comedor) {
        this.comedor = comedor;
    }

    @Override
    public void run() {
        comedor.cocinar();
        cocina();   // Llama al metodo cocina
        System.out.println("Termino de cocinar. El cocinero entrega el plato");
        comedor.terminarDeCocinar();
    }

    public void cocina() {
        System.out.println("Cocinando...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
