package semaforos.cruceDeAutos;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author erick
 */
public class HiloControl extends Thread {

    private GestorCruce gestor;

    public HiloControl(GestorCruce gestor) {
        this.gestor = gestor;
    }

    public void run() {
        for (int i = 0; i < 30; i++) {
            try {
                this.gestor.cambiarSemaforo();
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloControl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
