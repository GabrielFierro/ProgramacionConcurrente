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
    private int turno;
    private String caracter;
    
    public Hilo(Cadena letr, int turno, String caracter) {
        l = letr;
        this.turno = turno;
        this.caracter = caracter;
    }

    public void run() {
        // redefinir el metodo
        int i = 0;
        
        if(this.turno == 0){
            concatenarXVeces(5);
        }else if(this.turno == 1){
            concatenarXVeces(3);
        }else{
            concatenarXVeces(6);
        }
        
    }
    
    public void concatenarXVeces(int cant){
        int i = 0;
        
        while(i<cant){
            l.concatenar(caracter);
            i++;
        }
    }
    
}
