/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1TPO;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Transbordador {
    private int cantAutosBarco;
    private boolean orilla; 
 //Nos indicara en que orilla esta el barco.
 //true: Los autos puede subirse. 
 //false: Los autos no pueden subirse

    public Transbordador() {
        this.cantAutosBarco = 0;
        this.orilla = true;
    }
    
    public synchronized void subir(){
        while(!orilla || cantAutosBarco == 10){ 
            try {
                //Si el barco esta lleno o esta en la orilla opuesta esperamos
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Transbordador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Si el barco esta en la orilla este y tiene espacio subimos
        cantAutosBarco++;
        System.out.println("Un auto se subio al barco");
        if (cantAutosBarco == 10){
            notifyAll(); //Indicamos que un auto se subio
        }
    }
    
    public synchronized void ir(){
        try {
            while(cantAutosBarco < 10){ //Mientras haya espacio para mas autos esperamos
                wait();
            }
            //Si el barco esta lleno entonces hace el viaje
            System.out.println("El barco esta lleno, sale de viaje");
            Thread.sleep(5000);
            System.out.println("El barco llego a la orilla oeste");
            orilla = false; //Avisamos que se llego a la orilla oeste
            notifyAll();
        } catch (InterruptedException ex) {
            Logger.getLogger(Transbordador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized void bajar(){
        while(orilla){ 
            try {
                //Esperamos que el barco llegue a la orilla oeste
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Transbordador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Si estamos en la orilla oeste bajamos
        cantAutosBarco--;
        System.out.println("Se baja un auto");
        if (cantAutosBarco == 0) {
            notifyAll(); //Notificamos que nos bajamos del barco
        }
    }
    
    public synchronized void volver(){
        try {
            //Mientas queden autos en el transbordador esperamos
            while(cantAutosBarco > 0){ 
                wait();
            }
            //Si el transbordador esta vacio entonces volvemos
            System.out.println("El barco esta vacio, vuelve");
            Thread.sleep(5000);
            System.out.println("El barco llego a la orilla este");
            orilla = true; //Avisamos que se volvio a la orilla este
            notifyAll();
        } catch (InterruptedException ex) {
            Logger.getLogger(Transbordador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
