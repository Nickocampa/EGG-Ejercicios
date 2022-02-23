/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicko;
import 
java.util.Scanner;

/**
 *
 * @author NCampanella
 */
public class Nicko {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese los numeros a sumar");
        System.out.print("Numero 1= ");
        int num1 =leer.nextInt();
        System.out.print("Numero 2= ");
        int num2=leer.nextInt();
       int total;
       
       total=num1+num2;
       
        System.out.println("La suma de los numeros " + num1 +" y " + num2 + " es igual a " + total);
               
               
    }
    
}
