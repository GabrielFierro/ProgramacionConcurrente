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
import java.io.*;

public class Cuatro {
    private static int metodo(){
        int valor = 0;
        try{
            System.out.println("Entro al try");
            valor = valor + 1;  // Valor empieza en 1
            valor = valor + Integer.parseInt("w"); // Intenta parsear el String W a entero y produce error. Por lo que, se saltea las siguientes lineas de codigo
            // del try y busca algun catch que capture el error propagado por la Excepcion. En este caso, le agregue un catch para que capture la Excepcion de tipo 
            // NumberFormatException
            valor = valor + 1; 
            System.out.println("Valor al final del try: " + valor);
            throw new IOException();    // crea una instancia de IOException pero no es leida
        }catch(NumberFormatException e){    // Entra a este catch con la excepcion NumberFormatException
            System.out.println("Fallo en el NumberFormat");
        }
        catch(IOException e){  // No ingresa aca debido a que no trata la excepcion provocada en el try
            System.out.println("Entro al catch");
            valor = valor + Integer.parseInt("42"); 
            System.out.println("Valor al final del catch: " + valor);
        }
        finally{   // Entra al finally con valor = 1
            valor = valor + 1;  // A valor le asigna el resultado de sumar 1 + 1, ahora valor = 2
            System.out.println("Valor al final de finally: " + valor);  // Muestra por pantalla valor = 2
        }
        valor = valor + 1;  // A valor le asigna el resultado de sumar 2 + 1, valor = 3
        System.out.println("Valor antes del return: " + valor); // Muestra por pantalla 3
        return valor;
    }
    public static void main(String[] args){
        try{
            System.out.println(metodo());
        }catch(Exception e){
            System.out.println("Excepcion en metodo()");
            e.printStackTrace();
        }
    }
}
