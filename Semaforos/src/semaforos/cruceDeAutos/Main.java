package semaforos.cruceDeAutos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author erick
 */
public class Main {

    public static void main(String[] args) {
        int cantHilos = 50;
        Auto[] autos = new Auto[cantHilos];
        GestorCruce gestor = new GestorCruce();
        HiloControl hiloControl = new HiloControl(gestor);
        crearAuto(gestor, autos, cantHilos);
        hiloControl.start();
        for (int i = 0; i < cantHilos; i++) {
            autos[i].start();
        }
        

    }

    public static void crearAuto(GestorCruce gestor, Auto[] autos, int h1) {
        int h2 = h1 % 2;
        char calle;
        for (int i = 0; i < h1; i++) {
            if (i % 2 != 0) {
                autos[i] = new Auto(gestor, 'o', "Auto " + i);
            } else {
                autos[i] = new Auto(gestor, 'n', "Auto " + i);
            }

        }

    }
}
