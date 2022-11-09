/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planta_embotelladora;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel.fierro
 */
public class Embotellador extends Thread {

    private String nombre;
    private Buffer fab;
    private Caja caja;
    private Lock botellaDeAgua;
    private Lock botellaDeVino;
    private Condition hayLugarA;
    private Condition hayLugarV;
    private int cantidadTotalDeBotellas;
    private int contBotellas;

    public Embotellador(String nombre, Buffer fab, int cantidadTotalDeBotellas, Caja caja) {
        this.nombre = nombre;
        this.fab = fab;
        this.caja = caja;
        this.cantidadTotalDeBotellas = cantidadTotalDeBotellas;
        this.contBotellas = 0;
        botellaDeAgua = new ReentrantLock(true);
        hayLugarA = botellaDeAgua.newCondition();    
        // Variable de condicion asociada al lock accesoBotella
        botellaDeVino = new ReentrantLock(true);
        hayLugarV = botellaDeVino.newCondition();
    }

    public void prepararBotella() {
        try {
            botellaDeAgua.lock();
            while (contBotellas >= cantidadTotalDeBotellas) {
                System.out.println(nombre + " debe esperar para llenar la caja");
                hayLugarA.await();
            }
            System.out.println("Empieza a llenar la caja");
            contBotellas++;
        } catch (InterruptedException ex) {
            Logger.getLogger(Embotellador.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            botellaDeAgua.unlock();
        }

    }

}
