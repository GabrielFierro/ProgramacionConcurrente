/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productor_consumidor;

/**
 *
 * @author gabriel.fierro
 */
public class Consumidor extends Thread {

    // Zona de declaracion de atributos
    Buffer b;
    private int tam;

    public Consumidor(Buffer b, int tam) {
        this.b = b;
        this.tam = tam;
    }

    @Override
    public void run() {
        for (int i = 0; i < tam; i++) {
            int aux;
            try {
                aux = b.extraer();
                System.out.println("El consumidor saco " + aux + " del buffer");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

}
