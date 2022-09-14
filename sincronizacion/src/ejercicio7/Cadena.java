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
public class Cadena {
    
    String caracter;
    
    public Cadena(String l){
        caracter = l;
    }
    
    public synchronized String getLetra(){
        return this.caracter;
    }
    
    public synchronized void setLetra(String letra){
        this.caracter = letra;
    }
    
    public synchronized void concatenar(String l){
        caracter = caracter + l;
    }
    
}
