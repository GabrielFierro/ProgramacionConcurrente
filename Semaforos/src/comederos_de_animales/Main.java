/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comederos_de_animales;

/**
 *
 * @author gabriel.fierro
 */
public class Main {

    public static void main(String[] args) {
        Comedor comedor = new Comedor(50);
        Gato gato = new Gato(comedor, 50);
        Perro perro = new Perro(comedor, 1);

        gato.start();
        perro.start();
    }
}
