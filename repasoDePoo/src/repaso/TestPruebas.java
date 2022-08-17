/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repaso;

/**
 *
 * @author gabriel.fierro
 */
public class TestPruebas {

    public static void main(String[] args) {
        PruebaUno aux[] = new PruebaUno[3];
        int i = 0;
        aux[i++] = new PruebaUno(4);
        aux[i++] = new RedefinicionUno(4);
        aux[i++] = new PruebaUno(14);
        for (PruebaUno elem : aux) {
            System.out.println(elem.aCadena());
        }
    }
}
