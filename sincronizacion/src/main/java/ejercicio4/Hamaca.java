/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4;

/**
 *
 * @author Gabriel Fierro
 */
public class Hamaca {

    private boolean en_uso;

    public Hamaca() {
        en_uso = false;
    }

    public synchronized void usar() {
        en_uso = true;
    }

    public synchronized void dejarHamaca() {
        en_uso = false;
    }
}
