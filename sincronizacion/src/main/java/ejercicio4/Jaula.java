/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.ejercicio4;

/**
 *
 * @author gabriel.fierro
 */
public class Jaula {

    private Plato p;
    private Rueda r;
    private Hamaca h;

    public Jaula(Plato p, Rueda r, Hamaca h) {
        this.p = p;
        this.r = r;
        this.h = h;
    }

    public boolean usarPlato() {
        boolean exito = p.usar();
        return exito;

    }

    public void dejarPlato() {
        p.dejarPlato();
    }

    public boolean usarRueda() {
        boolean exito = r.usar();
        return exito;
    }

    public void dejarRueda() {
        r.dejarRueda();
    }

    public boolean usarHamaca() {
        boolean exito = h.usar();
        return exito;
    }

    public void dejarHamaca() {
        h.dejarHamaca();
    }

    @Override
    public String toString() {
        String resultado = "";
        resultado = "Plato: " + p.toString() + ", rueda: " + r.toString() + ", hamaca: " + h.toString();
        return resultado;
    }

}
