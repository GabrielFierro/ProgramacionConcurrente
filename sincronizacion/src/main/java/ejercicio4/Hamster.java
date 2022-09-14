/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel.fierro
 */
public class Hamster implements Runnable{
    Plato p = new Plato();
    Rueda r = new Rueda();
    Hamaca h = new Hamaca();
    Jaula j = new Jaula(p, r, h);
    
    public Hamster(Jaula j){
        this.j = j;
    }
    
    public void run(){
        boolean exito;
        
        exito = j.usarPlato();
        if(exito){
            System.out.println("El hilo " + Thread.currentThread().getName() + " esta usando el plato");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hamster.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Termino el hilo");
        }
    }
    
}
