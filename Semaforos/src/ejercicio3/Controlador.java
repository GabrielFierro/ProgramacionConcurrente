/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3;

/**
 *
 * @author Ramon
 */
public class Controlador extends Thread {

    // Zona de declaracion de variables
    private Reloj[] reloj;
    private Empleado[] empleado;

    public Controlador(Reloj[] reloj, int cant) {
        this.reloj = reloj;
        empleado = new Empleado[cant];
    }

    public void cargarEmpleados() {
        // Inicializo los empleados

        for (int j = 0; j < empleado.length; j++) {
            empleado[j] = new Empleado(this.reloj[j], "Empleado: " + j);
        }

    }

    public void iniciarProceso() {
        for (int i = 0; i < empleado.length; i++) {
            empleado[i].start();
        }
    }

}
