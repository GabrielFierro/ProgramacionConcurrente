/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

/**
 *
 * @author gabriel.fierro
 */
public class Jaula {

    private Plato p;
    private Rueda r;
    private Hamaca h;

    public Jaula(Plato P, Rueda r, Hamaca h){
        this.p = p;
        this.r = r;
        this.h = h;
    }
    
    public boolean usarPlato() {
        System.out.println("Entro al metodo usarPlato()");
        this.p.usar();
        return true;
    }

    public boolean usarRueda() {
        r.usar();
        return true;
    }

    public boolean usarHamaca() {
        h.usar();
        return true;
    }

}
