/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planta_embotelladora;

/**
 *
 * @author gabriel.fierro
 */
public class Caja {
    private int capacidadMaxima;
    
    public Caja(){
        this.capacidadMaxima = 10;
    }
    
    public boolean estaLlena(int cant){
        boolean exito = false;
        if(cant == this.capacidadMaxima){
            exito = true;
        }
        return exito;
    }
}
