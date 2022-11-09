package semaforos.cruceDeAutos;

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
public class Auto extends Thread {

    private GestorCruce gestor;
    private char calle;
    String nombre;
    
    public Auto(GestorCruce gestor, char calle, String nombre) {
        this.gestor = gestor;
        this.calle = calle;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        if (this.calle == 'n') {
            this.gestor.llegaNorte(nombre);
            this.gestor.saleNorte(nombre);
        } else {
            this.gestor.llegaOeste(nombre);
            this.gestor.saleOeste(nombre);

        }
    }

}
