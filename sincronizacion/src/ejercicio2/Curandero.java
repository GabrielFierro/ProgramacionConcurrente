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
public class Curandero implements Runnable{
    private Personaje p;
    
    public Curandero(Personaje p) {
        this.p = p;
    }
    
    public void run(){
        p.curar(5);
        //System.out.println("La vida del personaje " + Thread.currentThread().getName() + " despues de curarse es: " + p.getVida());
    }
}
