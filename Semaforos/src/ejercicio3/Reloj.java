/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3;

import java.util.concurrent.Semaphore;
import java.util.Arrays;

/**
 *
 * @author Ramon
 */
public class Reloj {

    private int cantMax;
    private boolean esLaHora;
    Semaphore mutex = new Semaphore(1);
    Semaphore hayEmpleado;
//    Semaphore empleadoTrabajando = new Semaphore(1); // Esta demas, puedo trabajar directamente con el mutex*

    public Reloj(int cantEmp, boolean esLaHora) {
        this.cantMax = cantEmp;
        this.esLaHora = esLaHora;
        hayEmpleado = new Semaphore(10);
    }

    public void despertar() throws InterruptedException {
        mutex.acquire();    // tomo el permiso de mutex
        hayEmpleado.release();
        //espera();

        if (esLaHora) {
//            empleadoTrabajando.acquire();   // * en este momento tengo 2 semaforos tomando permisos, pero no necesito este ya que tengo a mutex y es el primero que toma 1 permiso y bloquea todo
            System.out.println("ES LA HORA, A DESPERTARSE");
            System.out.println("Se levanta el empleado: " + Thread.currentThread().getName() + " y trabaja durante un tiempo");
            Thread.sleep(4000);
            System.out.println("Termino de trabajar");
//            empleadoTrabajando.release();
        } else {
            System.out.println("Aun no es la hora de: " + Thread.currentThread().getName() + " , sigue durmiendo");
        }
        mutex.release();
    }

    public void espera() throws InterruptedException {
        System.out.println("Verifico si es su hora antes de sonar la alarma");
        System.out.println("Espero 2 segundos...");
        Thread.sleep(2000);
    }

    public void cambiarEstado(int cantE) {
        int i;

        for (i = 0; i < cantE; i++) {
            if (i % 2 == 0) {
                this.esLaHora = false;
            } else {
                this.esLaHora = true;
            }
        }
    }

}
