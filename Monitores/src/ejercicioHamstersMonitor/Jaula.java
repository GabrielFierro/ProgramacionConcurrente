/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioHamstersMonitor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Jaula {
      private Plato p;
      private Rueda r;
      private int cant;

    public Jaula(Plato p, Rueda r, int cant) {
        this.p = p;
        this.r = r;
        this.cant=cant;
    }
    public void entrar(String n)
    {
        
              System.out.println("Entro a la jaula "+n);
              p.empezarAComer(n);
          try {
              Thread.sleep(4000);
          } catch (InterruptedException ex) {
              Logger.getLogger(Jaula.class.getName()).log(Level.SEVERE, null, ex);
          }
              p.terminarDeComer(n);
            r.rodar(n);
    }
}
