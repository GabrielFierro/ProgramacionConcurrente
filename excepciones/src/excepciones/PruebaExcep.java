/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

import java.util.Scanner;

/**
 *
 * @author gabriel.fierro
 */
public class PruebaExcep {

    private static void edadPersona() {
        int edad = 0;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Ingrese la edad de la persona");
            edad = sc.nextInt();
            if (edad < 18) {
                throw new RuntimeException("La persona es menor de edad");
            }
        } catch (RuntimeException e) {
            throw e;
        }
    }

    private static void ruleta() {
        int valor = 0, min = 1, max = 20, numeroRandom;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Ingrese un valor");
            valor = sc.nextInt();
            numeroRandom = (int) Math.floor(Math.random() * (max - min + 1) + min);
            System.out.println("El numero random es: " + numeroRandom);
            if (valor != numeroRandom) {
                throw new RuntimeException("El numero ingresado no coincide con el de la ruleta");
            }else{
                System.out.println("Acertaste el numero");
            }
        } catch (RuntimeException e) {
            throw e;
        }
    }

    public static void main(String[] args) {
        //edadPersona();
        ruleta();
    }
}
