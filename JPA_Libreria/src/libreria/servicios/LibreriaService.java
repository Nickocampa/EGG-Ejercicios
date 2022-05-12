package libreria.servicios;

import java.util.Scanner;

public class LibreriaService {

    Scanner leer = new Scanner(System.in);
    LibroServicio lS = new LibroServicio();
    AutorServicio aS = new AutorServicio();
    EditorialServicio eS = new EditorialServicio();

    public void mensajeMenu() {

        System.out.println(
                "1) Agregar autor.\n"
                + "2) Agregar editorial.\n"
                + "3) Añadir un libro.\n"
                + "4) Dar de alta/baja un libro.\n"
                + "5) Buscar un Autor por nombre.\n"
                + "5) Buscar una editorial por nombre.\n"
                + "6) Buscar libro por ISBN.\n"
                + "7) Buscar libro por Titulo.\n"
                + "8) Buscar libro/s por Autor.\n"
                + "9) Buscar libro/s por Editorial.\n"    
                + "10) SALIR");
    }

    public void menu() throws Exception {

        String opcionElegida = null;

        System.out.println("/*************************************************/");
        System.out.println("Seleccione una opcion");

        mensajeMenu();

        opcionElegida = leer.next();

        try {

            int opcion = Integer.parseInt(opcionElegida);

            if (opcion < 1 || opcion > 10) {
                throw new Exception("Las opciones van de 1 a 10");
            }
        } catch (Exception e) {
            System.out.println("Las opciones van de 1 a 10");
            menu();
        }

        switch (opcionElegida) {
            case "1":
                aS.crearAutor();
                menu();
                break;
            case "2":
                eS.crearEditorial();
                menu();
                break;
            case "3":
                lS.crearLibro();
                menu();
                break;
            case "4":
                lS.darAltaBajaModificarLibro();
                menu();
                break;
            case "5":
                aS.buscarAutor();
                menu();
                break;
            case "6":
                eS.buscarEditorial();
                menu();
                break;
            case "7":
                lS.buscarPorTitulo();
                menu();
                break;
            case "8":
                lS.buscarLibroPorAutor();
                menu();
                break;
            case "9":
                lS.buscarLibroPorEditorial();
                menu();
                break;
            case "10":
                System.exit(0);
                break;

        }

    }

}
