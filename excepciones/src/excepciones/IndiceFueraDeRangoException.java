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
public class IndiceFueraDeRangoException extends ArrayIndexOutOfBoundsException {
    public IndiceFueraDeRangoException(String mensaje){
        super(mensaje);
    }
    
}
