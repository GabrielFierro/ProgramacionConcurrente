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
class Dos{
    private static int metodo(){
    int valor =0;   // Valor empieza en 0
    try{
        valor= valor +1;    // Valor = 1
        valor = valor + Integer.parseInt("W");  // Intenta parsear el character W a entero, da error y se dirige al catch con valor = 1
        valor = valor + 1;
        System.out.println("Valor al final del try: " + valor);
    } catch (NumberFormatException e){  // Atrapa las excepciones de Formato de numero
        valor = valor + Integer.parseInt("42");   // A valor le asigna el resultado de sumar 1 + 42, valor = 43
        System.out. println ("Valor al final del catch: " + valor); // Muestra 43 por pantalla
    }finally{   // Como la sentencia catch capturo el error que se provoco en el try, ingresa al finally
        valor = valor + 1;  // Ingreso con valor = 43 por lo que ahora valor = 44
        System.out.println("Valor al final de finally: "+ valor);   // Muestra 44 por pantalla
    }
    // Termina de ejecutar el catch, finally y continua con la ejecucion
    valor = valor + 1;  // valor = 45
    System.out. println ("Valor antes del return: " + valor);   // Muestra 45 por pantalla
    return valor;
    }
    public static void main(String[] args){
        try{
            System.out.println(metodo());
        }catch(Exception e){
            System.err.println("Excepcion en metodo()");
            e.printStackTrace();
        }
    }
}