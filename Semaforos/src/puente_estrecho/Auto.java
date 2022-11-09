/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puente_estrecho;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel.fierro
 */
public class Auto extends Thread{
    private String tipo;
    private Puente puente;

    public Auto(Puente puente, String tipo){
        this.puente = puente;
        this.tipo = tipo;
    }
    
    @Override
    public void run(){
        try {
            System.out.println("Los autos esperan para cruzar el puente");
            if(this.tipo.equalsIgnoreCase("norte")){
                puente.cruzarNorte("norte");
                puente.terminoDeCruzarNorte("norte");
            }else if(this.tipo.equalsIgnoreCase("sur")){
                puente.cruzarSur("sur");
                puente.terminoDeCruzarNorte("sur");
            }
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Auto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
