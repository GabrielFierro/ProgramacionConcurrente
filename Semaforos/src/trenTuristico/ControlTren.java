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
public class ControlTren extends Thread{
    private Cabina cab;
    private int cantAsientos;
    
    public ControlTren(Cabina cab, int cantAsientos){
        this.cab = cab;
        this.cantAsientos = cantAsientos;
    }
    
    @Override
    public void run(){
        System.out.println("Controla si los pasajeros pueden subir al Tren");
    }
    
    public void puedenSubir(){
        boolean exito;
        exito = this.cab.puedenSubir(cantAsientos);
        if(exito){
            this.cab.subirPasajeros();
        }
    }
}
