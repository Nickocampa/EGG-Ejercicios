package Service;

import Subclases.Lavadora;
import Subclases.Televisor;
import Superclase.Electrodomesticos;
import java.util.ArrayList;
import java.util.Scanner;

public class ElectrodomesticosService {

    ArrayList<Electrodomesticos> electroservice = new ArrayList();
    int contador = 0;

    public ArrayList<Electrodomesticos> menu() {

        Scanner leer = new Scanner(System.in);

        System.out.println("**VAMOS A CARGAR LOS ELECTRODOMESTICOS**");
        System.out.println("**ELIJA UNA OPCION**");
        System.out.println("1-Cargar Lavarropas");
        System.out.println("2-Cargar Televisor");
        System.out.println("3-Mostrar Precio por electrodomestico");
        System.out.println("4-Mostrar precio total");
        System.out.println("5-SALIR");

        int opcion = leer.nextInt();
        if (opcion == 1 || opcion == 2) {
            contador++;
        }

        switch (opcion) {
            case 1:
                if (contador < 4) {
                    lavadora();
                } else {
                    System.out.println("Ya se cargaron 4 electrodomesticos");
                }
                menu();
                break;
            case 2:
                if (contador < 4) {
                    televisor();
                } else {
                    System.out.println("Ya se cargaron 4 electrodomesticos");
                }
                menu();
                break;
            case 3:
                mostrarPrecioUnitario();
                break;
            case 4:
                mostrarPrecioTotal();
                break;

            default:
                System.exit(0);

        }

        return electroservice;
    }

    public void lavadora() {

        Lavadora Lav = new Lavadora();
        Lav.crearLavadora();
        electroservice.add(Lav);
        menu();

    }

    public void televisor() {

        Televisor Tele = new Televisor();
        Tele.crearTelevisor();
        electroservice.add(Tele);
        menu();

    }

    public void mostrarPrecioUnitario() {

        for (Electrodomesticos auxiliarelectro : electroservice) {
            System.out.println("El precio del electrodomestico es $" + auxiliarelectro.getPrecio());
        }

        menu();
    }

    private void mostrarPrecioTotal() {

        Double precioTotal = 0.0;
        for (Electrodomesticos auxiliarelectro : electroservice) {
            precioTotal = precioTotal + auxiliarelectro.getPrecio();
        }
        System.out.println("El precio total de los electrodomesticos es de $" + precioTotal);
        menu();

    }

}
