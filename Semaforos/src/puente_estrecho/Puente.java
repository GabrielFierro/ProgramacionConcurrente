/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puente_estrecho;

import java.util.concurrent.Semaphore;

/**
 *
 * @author gabriel.fierro
 */
public class Puente {

    // Recurso compartido
    private int capacidadMaxima;
    private int contAutosNorte;
    private int contAutosSur;
    private Semaphore norte;
    private Semaphore sur;
    private Semaphore mutex;

    public Puente(int capacidadMaxima, int cantAutosNorte, int cantAutosSur) {
        this.capacidadMaxima = capacidadMaxima;
        this.norte = new Semaphore(cantAutosNorte);    // n permisos
        this.sur = new Semaphore(cantAutosSur);    // n permisos
        mutex = new Semaphore(1);
        this.contAutosNorte = 0;
        this.contAutosSur = 0;
    }

    public void cruzarNorte(String tipo) throws InterruptedException {
        this.contAutosNorte++;
        mutex.acquire();
        if (this.contAutosNorte <= this.capacidadMaxima) {
            norte.acquire();
            System.out.println("Auto " + tipo + " del norte cruzando el puente");
        }
    }

    public void terminoDeCruzarNorte(String tipo) throws InterruptedException {
        mutex.release();
        norte.acquire();
        System.out.println("Auto " + tipo + " del norte termino de cruzar el puente");
        this.contAutosNorte--;
    }

    public void cruzarSur(String tipo) throws InterruptedException {
        this.contAutosSur++;
        mutex.acquire();
        if (this.contAutosSur <= this.capacidadMaxima) {
            sur.acquire();
            System.out.println("Auto " + tipo + " del sur cruzando el puente");
        }
    }
    
    public void terminoDeCruzarSur(String tipo) throws InterruptedException {
        mutex.release();
        sur.acquire();
        System.out.println("Auto " + tipo + " del sur termino de cruzar el puente");
        this.contAutosSur--;
    }
}
