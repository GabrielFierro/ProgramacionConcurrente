/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

/**
 *
 * @author gabriel.fierro
 */
public class Jaula {
    private boolean estaComiendo, estaCorriendo, estaDurmiendo;

    public Jaula() {
        estaComiendo = false;
        estaCorriendo = false;
        estaDurmiendo = false;
    }
    
    public synchronized boolean estaComiendo(){
        return this.estaComiendo;
    }
    
    public synchronized void comer(){
        estaComiendo = true;
    }
    
    public synchronized boolean estaCorriendo(){
        return this.estaCorriendo;
    }
    
    public synchronized void correr(){
        estaCorriendo = true;
    }
    
    public synchronized boolean estaDurmiendo(){
        return this.estaDurmiendo;
    }
    
    public synchronized void dormir(){
        estaDurmiendo = true;
    }
    
}
