package PeliculaService;

import Comparadores.Comparators;
import Pelicula.Pelicula;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PeliculaService {

    Scanner leer = new Scanner(System.in);
    ArrayList<Pelicula> listaPeliculas;

    public PeliculaService() {
        this.listaPeliculas = new ArrayList();
    }

    public void crearLista() {

        //CREO EL OBJETO PELI//
        Pelicula peli = new Pelicula();

        //PIDO DATOS POR TECLADO//
        System.out.println("Ingrese el titulo de la pelicula");
        peli.setTitulo(leer.next());
        System.out.println("Ingrese el director");
        peli.setDirector(leer.next());
        System.out.println("Ingrese Duracion de la la pelicula " + peli.getTitulo());
        peli.setDuracion(leer.nextInt());

        //CARGO OBJETO A LA LISTA//
        listaPeliculas.add(peli);

        //PREGUNTAR SI CARGA MAS PELICULAS//
        System.out.println("Desea cargar otra pelicula? Y/N");
        String respuesta = leer.next();
        if (respuesta.equalsIgnoreCase("Y")) {

            crearLista();
        }

    }

    public void mostrarPeliculas() {

        System.out.println("Las peliculas ingresadas son: ");
        for (Pelicula aux : listaPeliculas) {

            System.out.println("-Pelicula #" + (listaPeliculas.indexOf(aux) + 1) + ": " + aux.getTitulo());

        }

    }

    public void mostrarDuracionMay() {
        System.out.println("Las peliculas con duracion mayor a una hora son: ");
        for (Pelicula aux : listaPeliculas) {
            if (aux.getDuracion() > 1) {
                System.out.println("- " + aux.getTitulo());

            }

        }

    }

    public void ordenarMayMen() {
        System.out.println("La lista ordenada por duracion de mayor a menor es: ");
        Collections.sort(listaPeliculas, Comparators.duracionMayMen);
        for (Pelicula aux : listaPeliculas) {
            System.out.println("Titulo: " + aux.getTitulo() + " / Duracion: " + aux.getDuracion());

        }

    }

    public void ordenarMenMAy() {
        System.out.println("La lista ordenada por duracion de menor a mayor es: ");
        Collections.sort(listaPeliculas, Comparators.duracionMenMay);
        for (Pelicula aux : listaPeliculas) {
            System.out.println("Titulo: " + aux.getTitulo() + " / Duracion: " + aux.getDuracion());

        }

    }

    public void ordenarAZnombre() {
        System.out.println("La lista ordenada por titulo de pelicula: ");
        Collections.sort(listaPeliculas, Comparators.tituloAZ);
        for (Pelicula aux : listaPeliculas) {
            System.out.println("Titulo: " + aux.getTitulo());

        }

    }

    public void ordenarAZdirector() {
        System.out.println("La lista ordenada por director de la pelicula: ");
        Collections.sort(listaPeliculas, Comparators.directorAZ);
        for (Pelicula aux : listaPeliculas) {
            System.out.println("Titulo: " + aux.getTitulo() + " / Director: " + aux.getDirector());
            

        }

    }

}
