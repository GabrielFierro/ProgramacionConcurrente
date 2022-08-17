/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

class Uno {

    private static int metodo() {
        int valor = 0;
        try {
            valor = valor + 1;  // Incrementa en 1 es decir valor = 1
            valor = valor + Integer.parseInt("ABC");    // Lanza error y se dirige al catch con valor = 1
            valor = valor + 1;
            System.out.println("Valor al fin al del try: " + valor);
        } catch (NumberFormatException e) {
            // Entra al catch con valor = 1
            System.out.println("Valor al final del catch: " + valor);
            // Como no hay error imprime el resultado de valor que era 1
        } finally {
            // Ejecuta finally incrementando en 1 a la variable valor, debido a que catch capturo anteriormente la excepcion 
            valor = valor + 1;  // entonces valor vale 2
            System.out.println("Valor al final de finally : " + valor);
        }
        // Termina de ejecutar el try/catch capturando la expecion en el catch, el finally y continua con las siguientes lineas de codigo
        valor = valor + 1;  // Por ultimo valor vale 3
        System.out.println("Valor antes del return: " + valor);
        return valor;
    }

    public static void main(String[] args) {
        try {
            System.out.println(metodo());
        } catch (Exception e) {
            System.err.println(" Excepcion en metodo () ");
            e.printStackTrace();
        }
    }

}
