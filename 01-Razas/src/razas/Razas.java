package razas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*1. Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo String. El programa pedirá una raza de perro en un bucle, el mismo se guardará en la lista y
después se le preguntará al usuario si quiere guardar otro perro o si quiere salir. Si decide salir, se mostrará todos los perros guardados en el ArrayList.
Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le pedirá un perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista.
Si el perro está en la lista, se eliminará el perro que ingresó el usuario y se mostrará la lista ordenada. Si el perro no se encuentra en la lista, se le informará al usuario y
se mostrará la lista ordenada.
 *
 */
public class Razas {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        int i = 0;
        String respuesta = "";

        ArrayList<String> razas = new ArrayList();

        do {
            System.out.println("Desea agregar una raza a la lista? Y/N");
            respuesta = leer.next();

            if (respuesta.equalsIgnoreCase("Y")) {
                System.out.println("Ingrese la raza");
                String raza = leer.next();
                razas.add(raza);
            }

        } while (respuesta.equalsIgnoreCase("Y"));

        razas.forEach((aux) -> {
            System.out.println(aux);
        });

        Collections.sort(razas);
        
        System.out.println("La lista ordenada es:");
        
        razas.forEach((aux) -> {
            System.out.println(aux);
        });

        System.out.println("Ingrese una raza a buscar");
        String razaBuscar = leer.next();

        Iterator aux2 = razas.iterator();
        String str = "";
        while (aux2.hasNext()) {
            str = (String) aux2.next();
            if (str.equals(razaBuscar)) {
                aux2.remove();
                System.out.println("\nLa raza "+ razaBuscar + " fue removida");
                break;
            }
        }        
        razas.forEach((aux) -> {
            System.out.println(aux);
        });
        
    }

}
