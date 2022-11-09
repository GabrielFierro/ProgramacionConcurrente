/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1TPO;

import Ejercicio1TPO.Auto;
import Ejercicio1TPO.Capitan;
import Ejercicio1TPO.Transbordador;

/**
 *
 * @author Usuario
 */
public class main {
    
    //FALTA CONSIDERAR SI NO LLEGAN A LLENAR LA CANTIDAD DE AUTOS
    public static void main(String[]args){
        Thread[] auto;
        Transbordador barco = new Transbordador();
        Thread cap = new Thread(new Capitan(barco));
        auto = new Thread[20];
        // Transbordador es el recurso compartido 
        // Capitan es un hilo  y Auto es otro hilo
        // capitan --> barco 
        // auto --> barco
        for (int i = 0; i < 20; i++){
            auto[i] = new Thread(new Auto(barco));
            auto[i].start();
        }
        cap.start();
    }
}
