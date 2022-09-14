/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.ejercicio4;

/**
 *
 * @author Gabriel Fierro
 */
public class Rueda {

    private boolean en_uso;

    public Rueda() {
        en_uso = false;
    }
    
    public synchronized boolean usar() {
        if (!en_uso) {
            en_uso = true;
        }
        return en_uso;
    }

    public synchronized void dejarRueda() {
        en_uso = false;
    }

    public String toString() {
        return "en_uso: " + en_uso;
    }

}
