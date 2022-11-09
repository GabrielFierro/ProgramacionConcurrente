/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trenTuristico;

/**
 *
 * @author gabriel.fierro
 */
public class Tren {
    
    public void arriboPasajero(){
        System.out.println("Se subio un pasajero al tren");
    }
    
    public void iniciarViaje() throws InterruptedException{
        System.out.println("Iniciar viaje...");
        Thread.sleep(4000);
    }
}