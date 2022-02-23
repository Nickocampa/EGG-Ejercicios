package Services;

import java.util.ArrayList;
import java.util.Scanner;
import mascotAPP.entidades.Mascota;

public class ServiceCollections {

    private Scanner leer;
    private ArrayList<Mascota> mascotas;

    public ServiceCollections() {
        this.leer = new Scanner(System.in).useDelimiter("\n");
        this.mascotas = new ArrayList();
    }

    /*
     * Creo Mascotas
     * @return 
     */
    public Mascota crearMascota() {

        System.out.println("Ingrese el nombre de la mascota");
        String nombre = leer.next();

        System.out.println("Ingrese el apodo de la mascota");
        String apodo = leer.next();

        System.out.println("Introducir tipo");
        String tipo = leer.next();

        return new Mascota(nombre, apodo, tipo);

    }

    public void agregarMascota(Mascota m) {
        mascotas.add(m);

    }

    public void mostrarMascotas() {

        System.out.println("Las mascotas de lista de mascotas son:");
        for (Mascota aux : mascotas) {
            System.out.println(aux.toString());
        }
        System.out.println("cantidad = " + mascotas.size());

    }

    /*
     * crea mascotas todos chiquitos
     * @param cantidad equivale a la cantidad de mascotas a crear y anadir a la lista 
     */
    public void fabricaChiquitos(int cantidad) {

        for (int i = 0; i < cantidad; i++) {
            mascotas.add(new Mascota("Fer", "Chiquito", "Beagle"));
        }

    }

    /*
   * Crea mascotas por teclado
   * @param cantidad  
     */
    public void fabricaMascota(int cantidad) {

        for (int i = 0; i < cantidad; i++) {

            Mascota mascotaCreada = crearMascota();

            agregarMascota(mascotaCreada);

            System.out.println(mascotaCreada.toString());

        }

    }

    public void actualizarMascota(int index) {

        if (index <= (mascotas.size() - 1)) {
            System.out.println("");
            System.out.println("-------------Actualizar-------------");

            Mascota m = mascotas.get(index);
            m.setApodo("Roberto");
        } else {

            System.out.println("Error de indice");
        }

    }

    public void eliminarMascota(int index) {

        if (index <= (mascotas.size() - 1)) {

            mascotas.remove(index);
        } else {

            System.out.println("Error de indice");

        }
    }

}
