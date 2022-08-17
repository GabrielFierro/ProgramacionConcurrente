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
class Tres{
    private static int metodo(){
    int valor =0;   // Valor empieza en 0
    try{
        valor= valor +1;    // Valor = 1
        valor = valor + Integer.parseInt("W");  // Intenta parsear el character W a entero, da error y se dirige al catch con valor = 1
        valor = valor + 1;
        System.out.println("Valor al final del try: " + valor);
    } catch (NumberFormatException e){  // Atrapa las excepciones de Formato de numero
        valor = valor + Integer.parseInt("W");   // Vuelve a dar error al intentar parsear el caracter W, se dirige al finally
        System.out. println ("Valor al final del catch: " + valor);
    }finally{   // Como la sentencia catch no capturo el error que se provoco en el try y se produjo otra dentro de si mismo, ingresa al finally
        valor = valor + 1;  // Ingreso con valor = 1 por lo que ahora valor = 2
        System.out.println("Valor al final de finally: " + valor);   // Muestra 2 por pantalla
    }
    // Termina de ejecutar el catch, finally y continua con la ejecucion pero "arrastrando" el error de excepcion al intentar parsear un String a numero 
    valor = valor + 1;  // Se da el error aca
    System.out. println ("Valor antes del return: " + valor); 
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
