/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trenTuristico;
import colores.Colores;
/**
 *
 * @author gabriel.fierro
 */
public class Main {

    public static void main(String[] args) {
        Colores c0 = new Colores("rojo");
        Colores c1 = new Colores("azul");
        Colores c2 = new Colores("cyan");
        Colores c3 = new Colores("violeta");

        int cantTickets = 3;
        int cantPasajeros = 4;
        Colores colors[] = {c0, c1, c2, c3};
        Cabina cab = new Cabina(cantTickets);
        Pasajero[] pasajeros = new Pasajero[cantPasajeros];
        Vendedor v = new Vendedor("Jorge", cab, cantPasajeros);

        for (int i = 0; i < cantPasajeros; i++) {
            pasajeros[i] = new Pasajero(colors[i].pintar("Pasajero " + (i)), cab);
        }

        for (int i = 0; i < cantPasajeros; i++) {
            pasajeros[i].start();
        }

        v.start();
    }

}
