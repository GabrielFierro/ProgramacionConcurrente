/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioHamstersMonitor;

/**
 *
 * @author Usuario
 */
public class MainHamster {

    public static void main(String[] args) {
        Plato p = new Plato(3);
        Rueda r = new Rueda();

        Thread[] hamsters = new Thread[3];
        for (int i = 0; i < 3; i++) {
            hamsters[i] = new Thread(new HamsterMonitor(p, r, "Hamster " + (i + 1)));
            hamsters[i].start();
        }
    }
}
