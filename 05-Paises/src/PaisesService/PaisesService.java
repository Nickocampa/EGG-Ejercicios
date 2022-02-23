package PaisesService;

import Paises.Paises;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class PaisesService {

    Scanner leer = new Scanner(System.in);
    ArrayList<String> listaPaises;

    public PaisesService() {
        this.listaPaises = new ArrayList();
    }

    public void listarPaises() {

        System.out.println("Ingrese por favor el pais a agregar en la lista de paises");
        listaPaises.add(leer.next());

        System.out.println("Fue guardado en la lista.");
        System.out.println("Desea agregar otro pais a la lista? Y/N");
        String respuesta = leer.next();
        if (respuesta.equalsIgnoreCase("Y")) {
            listarPaises();

        } else {
            for (String aux : listaPaises) {

                System.out.println(aux);
            }

        }

    }

    public void mostrarListaPaisesAZ() {
        System.out.println("****************************************************");
        Collections.sort(listaPaises);
        for (String aux : listaPaises) {

            System.out.println(aux);
        }

    }

    public void buscarPais() {

        System.out.println("Ingrese un pais a buscar");
        String paisBuscar = leer.next();

        Iterator aux2 = listaPaises.iterator();
        String str = "";
        while (aux2.hasNext()) {
            str = (String) aux2.next();
            if (str.equals(paisBuscar)) {
                aux2.remove();
                System.out.println("\nEl pais " + paisBuscar + " fue removido");
                break;
            } else System.out.println("El pais no se encontro en la lista");

        }
        System.out.println("*****************************************************");
        for (String aux : listaPaises) {

            System.out.println(aux);
        }

    }
}
