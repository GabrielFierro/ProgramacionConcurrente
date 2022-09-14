/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4;

/**
 *
 * @author Gabriel Fierro
 */
public class Plato {

    private boolean en_uso;

    public Plato() {
        en_uso = false;
    }

    public synchronized void usar() {
        System.out.println("Entro al metodo usar() de la clase Plato");
        en_uso = true;
    }

    public synchronized void dejarPlato() {
        en_uso = false;
    }
}
