/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puente_estrecho;

/**
 *
 * @author gabriel.fierro
 */
public class Main {
    
    public static void main(String[] args){
        int cantAutos = 5;
        Puente puente = new Puente(cantAutos, cantAutos, cantAutos);
        Auto[] autosNorte = new Auto[cantAutos];
        Auto[] autosSur = new Auto[cantAutos];
        
        Thread[] hilosAutos = new Thread[cantAutos];

        for (int i = 0; i < cantAutos; i++) {
            autosNorte[i] = new Auto(puente, "norte");
            autosSur[i] = new Auto(puente, "sur");
        }
        
        for (int j = 0; j < cantAutos; j++) {
            autosNorte[j].start();
        }
        
        for (int j = 0; j < cantAutos; j++) {
            autosSur[j].start();
        }
        
    }
}
