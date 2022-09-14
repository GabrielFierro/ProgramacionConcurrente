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
public class Orco implements Runnable{
    
    private Personaje p;
    
    public Orco(Personaje p) {
        this.p = p;
    }
    
    public void run(){
        p.golpear(3);
        //System.out.println("La vida del personaje " + Thread.currentThread().getName() + " despues de recibir daño es: " + p.getVida());
    }
}
