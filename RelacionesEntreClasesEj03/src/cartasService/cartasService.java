package cartasService;

import Enums.numeros;
import Enums.palos;
import carta.Carta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class cartasService {

    ArrayList<Carta> maso = new ArrayList();
    ArrayList<Carta> masoResto = new ArrayList();
    Scanner leer = new Scanner(System.in);

    public void mensajeInicial() {

        System.out.println("VAMOS A JUGAR A LAS CARTAS");

    }

    public void crearCartas() {
        //usando los ENUMS numeros y palos crea la baraja completa
        //recorre los palos
        for (palos auxpalos : palos.values()) {
            //recorre los numeros
            for (numeros auxnum : numeros.values()) {
                Carta carta = new Carta();
                carta.setNumero(auxnum);
                carta.setPalo(auxpalos);
                //crea el maso de cartas agregando de a una.
                maso.add(carta);
            }
        }

    }

    public void barajar() {
        //shuffle mezcla la lista
        Collections.shuffle(maso);
        System.out.println("Se barajo el maso");
        System.out.println("");

    }

    public void mostrarBaraja() {

        System.out.println(maso.toString());

    }

    //contador de veces ingresado a siguienteCarta//
    int contSiguienteCarta = 0;

    public void siguienteCarta() {
        //carta auxiliar para mostrar y pasar a otro maso//
        Carta cartaAuxiliar = new Carta();
        System.out.println("Carta siguiente");
        //Uso carta auxiliar para removerla de un maso, mostrarla y pasarla a otro//
        cartaAuxiliar = maso.get(0);
        System.out.println(cartaAuxiliar);
        System.out.println("");

        masoResto.add(cartaAuxiliar);
        maso.remove(0);

        //Aumento el contador de veces que ingrese a siguiente carta//
        contSiguienteCarta++;

    }

    public void cantCartasDisponibles() {

        int cartasDisponibles = maso.size();
        System.out.println("Quedan " + cartasDisponibles + " en el maso");
    }

    public void darCartas() {

        System.out.println("Cuantas cartas desea?");
        int cantidadDeCartas = leer.nextInt();
        //Chequeo que existan suficientes cartas//
        if (cantidadDeCartas <= maso.size()) {

            for (int i = 0; i < cantidadDeCartas; i++) {
                //uso el metodo ya creado siguiente carta//
                siguienteCarta();
            }
        } else {
            System.out.println("No hay cartas suficientes en el maso");
            //recursividad para volver a la opcion dar cartas//
            darCartas();
        }

    }

    public void cartasEnElMonton() {
        //imprimo maso con el resto de cartas
        System.out.println(masoResto.toString());
    }

    public void menu() {

        System.out.println("ELIJA UNA OPCION");
        System.out.println("1-Barajar");
        System.out.println("2-Repartir una carta");
        System.out.println("3-Cantidad de Cartas disponibles");
        System.out.println("4-Dar Cartas");
        System.out.println("5-Cartas en el monton");
        System.out.println("6-Mostrar baraja");
        System.out.println("7-SALIR");

        int opcion = leer.nextInt();
        if (opcion > 0 && opcion < 8) {
            switch (opcion) {

                case 1:
                    barajar();
                    menu();
                    break;
                case 2:
                    if (!maso.isEmpty()) {
                        siguienteCarta();
                        menu();

                    } else {
                        System.out.println("El maso no tiene mas cartas para repartir");
                        menu();
                    }

                    break;
                case 3:
                    cantCartasDisponibles();
                    menu();
                    break;
                case 4:
                    darCartas();
                    menu();
                    break;
                case 5:
                    cartasEnElMonton();
                    menu();
                    break;
                case 6:
                    mostrarBaraja();
                    menu();
                    break;
                default:

            }
        } else {
        }

    }

}
