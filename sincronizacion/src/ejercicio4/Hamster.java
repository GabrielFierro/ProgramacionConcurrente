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
    Jaula j = new Jaula();
    
    public Hamster(Jaula j){
        this.j = j;
    }
    
    public void run(){
        // Un hilo de tipo Hamster empieza a comer
        j.comer();
        if(j.estaComiendo()){
            System.out.println("El hamster " + Thread.currentThread().getName() + " esta comiendo");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hamster.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // Un hilo de tipo Hamster empieza a correr
        j.correr();
        if(j.estaCorriendo()){
            System.out.println("El hamster " + Thread.currentThread().getName() + " esta corriendo");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hamster.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // Un hilo de tipo Hamster se va a descansar
        j.dormir();
        if(j.estaDurmiendo()){
            System.out.println("El hamster " + Thread.currentThread().getName() + " esta corriendo");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hamster.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
