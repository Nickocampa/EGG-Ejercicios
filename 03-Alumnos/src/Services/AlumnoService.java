package Services;

import Alumno.Alumno;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author NCampanella
 */
public class AlumnoService {

    Scanner leer = new Scanner(System.in);
    ArrayList<Alumno> listaAlumnos;

    public AlumnoService() {
        this.listaAlumnos = new ArrayList();
    }

    //METODO PARA CREAR EL ALUMNO CON ATRIBUTOS//
    public void crearAlumno() {
        //CREAR EL A1 (DE LA CLASE SERVICIO)DEL TIPO ALUMNO CON CONSTRUCTOR VACIO//
        Alumno alumnoServicio = new Alumno();
        //PEDIR EL NOMBRE //
        System.out.println("Indique el nombre del alumno");
        alumnoServicio.setNombreAlumno(leer.next());

        //GUARDAR LAS NOTAS//
        ArrayList<Integer> auxNotas = new ArrayList();
        int suma = 0;
        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese la nota# " + (i + 1) + " del alumno " + alumnoServicio.getNombreAlumno());
            //GUARDAR NOTAS EN ARRAYLIST AUX//
            int notaIngresada = leer.nextInt();
            suma = suma + notaIngresada;
            auxNotas.add(i, notaIngresada);
        }
        int promedio = suma / 3;

        //PASAR NOTAS DEL ARRAY Y PROMEDIO AL ALUMNO//
        alumnoServicio.setNotas(auxNotas);
        alumnoServicio.setPromedio(promedio);
        listaAlumnos.add(alumnoServicio);

        //PREGUNTAR SI QUIEREN AGREGAR MAS ALUMNOS//
        System.out.println("Desea agragar otro alumno Y/N");
        String opcion = leer.next();

        //CONDICION PARA VOLVER A CARGAR UN ALUMNO//
        if (opcion.equalsIgnoreCase("Y")) {
            //RECURRENCIA PARA ENTRAR A PEDIR DATOS DE NUEVO//
            crearAlumno();
        }
    }

    public void mostrarLista() {

        listaAlumnos.forEach((alumno) -> {
            System.out.println(alumno);
        });
    }

    public void buscarAlumno() {
        //BUSCAR EL ALUMNO//
        System.out.println("Ingrese el nombre del alumno a buscar");
        //GUARDAR LA OPCION DEL USUARIO EN UNA VARIABLE AUXILIAR//
        String opcionIngresada = leer.next();
        //BUSCAR EN LISTA DE ALUMNOS//
        for (Alumno aux : listaAlumnos) {

            if (opcionIngresada.equalsIgnoreCase(aux.getNombreAlumno())) {
                System.out.println("El alumno " + opcionIngresada + " se encontro en la lista.");
                System.out.println("El promedio de " + opcionIngresada + " es " + aux.getPromedio());

            } else System.out.println("El alumno NO esta en la lista");
        }
    }
}
