/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

/**
 *
 * @author gabriel.fierro
 */
public class Turno {
    // Atributo
    private int t;
    
    public Turno(){
        this.t = 0;
    }
    
    public synchronized int getTurno(){
        return this.t;
    }
    
    public synchronized void setTurno(int t){
        this.t = t;
    }
    
    public synchronized void incrementarTurno(){
        t = t + 1;
    }
    
}
