package semaforos.cruceDeAutos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author erick
 */
public class GestorCruce {

    private Semaphore semOeste = new Semaphore(1);
    private Semaphore semNorte = new Semaphore(0);
    //sirve para saber que semaforo esta activo actualmente
    private char semActivo = 'o';

    public GestorCruce() {
    }

    //metodos de los autos q llegan por el norte
    public void llegaNorte(String nombre) {
        try {
            this.semNorte.acquire();
            System.out.println("Auto " + nombre + " cruzando por semaforo Norte");
        } catch (InterruptedException ex) {
            Logger.getLogger(GestorCruce.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void saleNorte(String nombre) {
        System.out.println("Auto " + nombre + " termino de crusar por sem norte");
        this.semNorte.release();

    }
    //metodos de los autos que llegan por el Oeste

    public void llegaOeste(String nombre) {
        try {

            this.semOeste.acquire();
            System.out.println("Auto " + nombre + " cruzando por semaforo Oeste");
        } catch (InterruptedException ex) {
            Logger.getLogger(GestorCruce.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void saleOeste(String nombre) {
        System.out.println("Auto " + nombre + " termino de crusar por sem Oeste");
        this.semOeste.release();

    }
    //metodo del HiloControl

    public void cambiarSemaforo() {

        if (semActivo == 'o') {
            try {
                this.semOeste.acquire();
                System.out.println("semaforo Norte esta ahora activo");
                this.semNorte.release();

            } catch (InterruptedException ex) {
                Logger.getLogger(GestorCruce.class.getName()).log(Level.SEVERE, null, ex);
            }

            semActivo = 'n';
        } else {
            try {
                this.semNorte.acquire();
                System.out.println("semaforo Oeste esta ahora activo");
                this.semOeste.release();

            } catch (InterruptedException ex) {
                Logger.getLogger(GestorCruce.class.getName()).log(Level.SEVERE, null, ex);
            }
            semActivo = 'o';
        }

    }

}
