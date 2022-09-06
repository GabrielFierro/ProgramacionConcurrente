/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.sincronizacion;

import java.util.Random;

/**
 *
 * @author Gabriel Fierro
 */
public class TestSuma {
    public static void main(String[] args) {
        // Definir los numeros randoms
        int min = 1, max = 10, tamanio = 10, fin;
        int[] numeros = new int[tamanio];
        Contador elContador = new Contador();
        Thread[] hilos = new Thread[5]; // Creo un arreglo de Hilos de tipo Thread de tamaño fijo = 5
        fin = tamanio / hilos.length;
        Suma miSuma = new Suma(elContador, numeros, 0, fin); // Definir mi objeto de tipo Suma

        for (int i = 0; i < tamanio; i++) {
            numeros[i] = rand(min, max);
        }
        
        System.out.println("Inicia el hilo del main");
        
        for (int j = 0; j < hilos.length; j++) {
            hilos[j] = new Thread(miSuma);
            hilos[j].start();
        }
        for (int k = 0; k < hilos.length; k++) {
            try {
                hilos[k].join();
            } catch (InterruptedException ex) {

            }
            
        }
        mostrarNumeros(numeros);
        System.out.println("contador: " + elContador.getValor());
    }

    public static int rand(int min, int max) {
        if (min > max || (max - min + 1 > Integer.MAX_VALUE)) {
            throw new IllegalArgumentException("Invalid range");
        }

        return new Random().nextInt(max - min + 1) + min;
    }

    public static void mostrarNumeros(int[] arreglo) {
        int resultado = 0;
        for (int i = 0; i < arreglo.length; i++) {
            resultado = resultado + arreglo[i];
            System.out.print(arreglo[i] + " + ");
        }
        System.out.println("El resultado de la suma secuencial es: " + resultado);
    }
}
