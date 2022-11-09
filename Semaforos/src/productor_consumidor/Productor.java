/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productor_consumidor;

import java.util.Random;

/**
 *
 * @author gabriel.fierro
 */
public class Productor extends Thread {

    private Random r = new Random();
    private Buffer b;
    private int tam;

    public Productor(Buffer b, int tam) {
        this.b = b;
        this.tam = tam;
    }

    @Override
    public void run() {
        for (int i = 0; i < tam; i++) {
            int aux = r.nextInt(10);
            try {
                b.poner(aux);
                System.out.println("El productor puso " + aux + " en el buffer");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

}
