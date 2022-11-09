/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package los_pollos_hermanos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel.fierro
 */
public class Comedor {
    // Posee el recurso compartido
    private Semaphore semSilla = new Semaphore(1);
    private Semaphore semServir = new Semaphore(1);
    private Semaphore semComer = new Semaphore(1);
    private Semaphore semBeber = new Semaphore(0);
    
    public void sentarse(){
        try {
            semSilla.acquire(); // Toma el permiso 1 --> 0
        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void elegirComida(){
        semServir.release();    // Libera el permiso 0 --> 1
    }
    
    public void cocinar(){
        try {
            semServir.acquire();    // Toma el permiso 1 --> 0
        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void terminarDeCocinar(){
        semServir.release();    // Libera el permiso 0 --> 1
    }
    
    public void elegirBebida(){
        try {
            semBeber.acquire(); // Toma el permiso 1 --> 0
        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void empezarAComer(){
        semComer.release(); // Libera el permiso 0 --> 1
    }    
  
    public void entregarPlato(){
        try {
            semComer.acquire(); // Toma el permiso 1 --> 0
        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void pagarBebida(){
        semBeber.release(); // Libera el permiso 0 --> 1
    }
    
    public void volverATrabajar(){
        semSilla.release(); // Libera el permiso 0 --> 1
    }
    
}