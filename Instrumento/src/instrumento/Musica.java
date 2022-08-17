/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumento;

/**
 *
 * @author gabriel.fierro
 */
import java.util.*;

class Instrumento {

    public void tocar() {
        System.out.println("Instrumento.tocar()");
    }

    public String tipo() {
        return "Instrumento";
    }

    public void afinar() {
        System.out.println("Instrumento: " + tipo());
    }
}

class Guitarra extends Instrumento {

    public void tocar() {
        System.out.println("Guitarra.tocar()");
    }

    public String tipo() {
        return "Guitarra";
    }

}

class Piano extends Instrumento {

    public void tocar() {
        System.out.println("Piano.tocar()");

    }

    public String tipo() {
        return "Piano";
    }

}

class Saxofon extends Instrumento {

    public void tocar() {
        System.out.println("Saxofon.tocar()");
    }

    public String tipo() {
        return "Saxofon";
    }

}

// Un tipo de Guitarra
class Guzla extends Guitarra {

    public void tocar() {
        System.out.println("Guzla.tocar()");
    }

}

public class Musica {
// No importa el tipo de Instrumento,
// seguirá funcionando debido a Polimorfismo:

    static void afinar(Instrumento i) {
// ...
        i.afinar();
    }

    static void afinarTodo(Instrumento[] e) {
        for (int i = 0; i < e.length; i++) {
            afinar(e[i]);
        }
    }

    public static void main(String[] args) {
        Instrumento[] orquesta = new Instrumento[5];
        int i = 0;
// Up-casting al asignarse el Arreglo
        orquesta[i++] = new Guitarra();
        orquesta[i++] = new Piano();
        orquesta[i++] = new Saxofon();
        orquesta[i++] = new Guzla();
        orquesta[i++] = new Guitarra();
        //orquesta[i++] = new Ukelele();
        afinarTodo(orquesta);
    }
} //clase Musica
