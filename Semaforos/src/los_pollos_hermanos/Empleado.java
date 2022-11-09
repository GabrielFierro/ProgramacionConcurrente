/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package los_pollos_hermanos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel.fierro
 */
public class Empleado implements Runnable {

    private Comedor comedor;
    private int accion;

    public Empleado(Comedor comedor, int accion) {
        this.comedor = comedor;
        this.accion = accion;
    }

    @Override
    public void run() {

        switch (accion) {
            case 1:
                beber(comedor);
                break;
            case 2:
                comer(comedor);
                break;
            case 3:
                beber(comedor);
                comer(comedor);
                break;
            default:
                break;
        }
        comedor.volverATrabajar();

    }

    public void comer(Comedor comedor) {
        comedor.sentarse();
        System.out.println(Thread.currentThread().getName() + " se sento");
        comedor.elegirComida();
        System.out.println(Thread.currentThread().getName() + " esta eligiendo su comida");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        comedor.empezarAComer();
        System.out.println(Thread.currentThread().getName() + " esta comiendo");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        comedor.entregarPlato();
        System.out.println(Thread.currentThread().getName() + " termino de comer. Vuelve a trabajar");
    }

    public void beber(Comedor comedor) {
        comedor.sentarse();
        System.out.println(Thread.currentThread().getName() + " se sento");
        comedor.elegirBebida();
        System.out.println(Thread.currentThread().getName() + " esta eligiendo su bebida");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(Thread.currentThread().getName() + " esta bebiendo");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        comedor.pagarBebida();
        System.out.println(Thread.currentThread().getName() + " termino de tomar. Vuelve a trabajar");
    }
}
