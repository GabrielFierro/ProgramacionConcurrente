/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1TPO;

/**
 *
 * @author Usuario
 */
public class Capitan implements Runnable{
    private Transbordador barco;

    public Capitan(Transbordador barco) {
        this.barco = barco;
    }

    @Override
    public void run() {
        while(true){
            barco.ir();//2
            barco.volver();//4
        }
    }
}
