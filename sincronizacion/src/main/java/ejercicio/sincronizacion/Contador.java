/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ejercicio.sincronizacion;

/**
 *
 * @author Gabriel Fierro
 */
public class Contador {

    int valor;
    
    public Contador() {
        valor = 0;
    }

    public synchronized int getValor() {
        return valor;
    }
    
    public synchronized void setValor(int nro) {
        valor = nro;
    }
    
    public synchronized void incrementar() {
        valor = valor + 1;
        //this.setValor(this.getValor()+1);
    }

    public synchronized void incrementar(int incremento) {
        valor = valor + incremento;
        //this.setValor(this.getValor()+incremento);
    }
}
