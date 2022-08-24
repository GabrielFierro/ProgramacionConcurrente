/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

/**
 *
 * @author gabriel.fierro
 */
public class Recurso {
    public static void uso(){
        Thread t = Thread.currentThread();
        System.out.println("En recurso soy:" + t.getName());
    }
}
