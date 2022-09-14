/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

/**
 *
 * @author gabriel.fierro
 */
public class Hilo implements Runnable {

    private Cadena l;
    private Turno t;
    private String caracter;

    public Hilo(Cadena letr, Turno turno, String caracter) {
        l = letr;
        this.t = turno;
        this.caracter = caracter;
    }

    public void run() {
        // redefinir el metodo
        int i = 0;

        if (t.getTurno() == 0) {
            concatenarXVeces(1);
        } else if (t.getTurno() == 1) {
            concatenarXVeces(2);
        } else {
            concatenarXVeces(3);
        }
        t.incrementarTurno();

    }

    public void concatenarXVeces(int cant) {
        int i = 0;

        while (i < cant) {
            l.concatenar(caracter);
            i++;
        }
    }

}
