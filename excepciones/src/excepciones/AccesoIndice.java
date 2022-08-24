/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author gabriel.fierro
 */
public class AccesoIndice {

    public static double acceso_por_indice(double[] v, int j) throws IndiceFueraDeRangoException {
        if ((0 <= j) && (j <= v.length)) {
            return v[j];
        } else {
            throw new IndiceFueraDeRangoException("El indice " + j + " no existe en el vector");
        }
    }

    public static void main(String[] args) {
        double[] v = new double[15];
        acceso_por_indice(v, 16);
    }
}
