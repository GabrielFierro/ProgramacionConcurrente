/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constructores;

/**
 *
 * @author gabriel.fierro
 */
public class Persona {

    // Siempre que creemos más constructores debemos definir un constructor sin 
    // parámetros
    Persona() {
        this("Gabriel");
        System.out.println("Constructor por defecto");
    }

    Persona(String nombre) {
        this(10, "Argentina");
        System.out.println("Nombre: " + nombre);
    }

    Persona(int numero, String lugar) {
        System.out.println("Numero: " + numero + ", lugar: " + lugar);
    }

    public static void main(String[] args) {
        Persona p1 = new Persona();
    }
}
