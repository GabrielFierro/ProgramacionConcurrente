/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramon
 */
public class Main {

    public static void main(String[] args) {
        boolean esLaHora = true;
        int cantEmpleados = 10;
        // ........... 
        Reloj[] r = new Reloj[10];
        Controlador contr;

        // Creo un arreglo de relojes
        for (int i = 0; i < 10; i++) {
            r[i] = new Reloj(1, esLaHora);
        }
        // Cambio el estado de algunos relojes
        for (int i = 0; i < 10; i++) {
            r[i].cambiarEstado(i);
        }

        contr = new Controlador(r, cantEmpleados);
        contr.cargarEmpleados();    // Creo e inicializo los empleados

        System.out.println("Espera 5 segundos antes de despertar a un empleado");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("¿Es la hora de despertarse?");

        contr.iniciarProceso();  // Despierto a los empleados
    }
}
