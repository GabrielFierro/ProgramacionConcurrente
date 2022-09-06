/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.sincronizacion;

/**
 *
 * @author gabriel.fierro
 */
public class Suma implements Runnable {

    private int[] arreglo;
    private Contador acum;
    private int inicio, fin;
    
    public Suma(Contador acum, int[] arreglo, int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
        this.acum = acum;
        this.arreglo = arreglo;
    }

    public void run() {
        // redefinir el metodo
        int resultado = 0;
        int longitud = arreglo.length;
        
        int j = inicio;
        while(j < fin){
            resultado += this.arreglo[j];
            j++;
        }
        inicio = fin;
        if(fin < longitud){
            fin += 2;
        }
        acum.incrementar(resultado);
    }
}
