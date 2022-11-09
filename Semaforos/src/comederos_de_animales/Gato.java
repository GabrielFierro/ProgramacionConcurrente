/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comederos_de_animales;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel.fierro
 */
public class Gato extends Thread {

    private Comedor comedor;
    private int tam;

    public Gato(Comedor comedor, int tam) {
        this.comedor = comedor;
        this.tam = tam;
    }

    @Override
    public void run() {
        for (int i = 0; i < tam; i++) {
            comedor.comer();
            comiendo();
            comedor.terminarDeComer();
            System.out.println("El gato termino de comer");
        }
    }

    public void comiendo() {
        System.out.println("El gato esta comiendo");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Gato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
