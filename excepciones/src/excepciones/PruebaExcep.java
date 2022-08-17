/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;
import java.util.Scanner;

/**
 *
 * @author gabriel.fierro
 */
public class PruebaExcep {
    private static void edadPersona(){
        int edad = 0;
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Ingrese la edad de la persona");
            edad = sc.nextInt(); 
            if(edad < 18){
                throw new Exception();
            }
        }catch(Exception e){
            System.out.println("Es menor de edad");
        }
    }
    
    public static void main(String[] args) {
        edadPersona();
    }
}
