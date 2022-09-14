/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

/**
 *
 * @author gabriel.fierro
 */
public class Personaje {
    
    private int vida;
    
    public Personaje() {
        vida = 10;
    }
    
    public synchronized int getVida(){
        return vida;
    }
    
    public synchronized void setVida(int vida){
        this.vida = vida;
    }
    
    public synchronized void golpear(int daño){
        vida = vida - daño;
    }
    
    public synchronized void curar(int cura){
        vida = vida + cura;
    }
    
}
