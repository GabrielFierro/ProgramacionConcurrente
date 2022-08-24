/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos.ejercicio1;

/**
 *
 * @author gabriel.fierro
 */
public class TesteoRecurso {
    public static void main(String [] args){
        // Declaro y creo 2 objetos de tipo Cliente
        Cliente juan = new Cliente();
        juan.setName("Juan Lopez");
        Cliente ines = new Cliente();
        ines.setName("Ines Garcia");
        
        juan.start();   // inicia juan concurrentemente con main(). Invoca a juan.run() y vuelve inmediatamente
        ines.start();   // idem comentario de arriba
        Recurso.uso();
    }
    
}
