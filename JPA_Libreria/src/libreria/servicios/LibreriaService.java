package libreria.servicios;

import java.util.Scanner;

public class LibreriaService {

    Scanner leer = new Scanner(System.in);
    LibroServicio lS = new LibroServicio();

    public void mensajeMenu() {

        System.out.println(
                  "1) Añadir un libro\n"/*
                + "2) Crear los métodos para dar de alta/bajo o editar dichas entidades.\n"
                + "3) Búsqueda de un Autor por nombre.\n"
                + "4) Búsqueda de un libro por ISBN.\n"
                + "5) Búsqueda de un libro por Título.\n"
                + "6) Búsqueda de un libro/s por nombre de Autor.\n"
                + "7) Búsqueda de un libro/s por nombre de Editorial.\n"
                + "8) Agregar las siguientes validaciones a todas las funcionalidades de la aplicación:\n"
                + "  • Validar campos obligatorios.\n"
                + "  • No ingresar datos duplicados.\n"*/
                + "9) SALIR");

    }

    public void menu() throws Exception    {

        String opcionElegida = null;

        System.out.println("/*************************************************/");
        System.out.println("Seleccione una opcion");

        mensajeMenu();

        opcionElegida = leer.next();
        
        try {
            
            int opcion = Integer.parseInt(opcionElegida);

            if (opcion < 1 || opcion > 9) {
                throw new Exception("Las opciones van de 0 a 9");
            }
        } catch (Exception e) {
            System.out.println("Las opciones van de 1 a 9");
            menu();
        }

        switch (opcionElegida) {
            case "1":
                lS.crearLibro();
                menu();
                break;
            /*case "2":

                menu();
                break;
            case "3":

                menu();
                break;
            case "4":

                menu();
                break;
            case "5":

                menu();
                break;
            case "6":

                menu();
                break;
            case "7":

                menu();
                break;
            case "8":

                menu();
                break;*/
            case "9":
                System.exit(0);
                break;

        }

    }

}
