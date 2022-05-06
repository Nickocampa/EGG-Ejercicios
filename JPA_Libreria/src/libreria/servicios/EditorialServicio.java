package libreria.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Editorial;

public class EditorialServicio {

    Scanner leer = new Scanner(System.in);
    Editorial editorial = new Editorial();
    List<Editorial> editoriales = new ArrayList<>();
    //CREAR ENTITY MANAGER//
    EntityManager em = Persistence.createEntityManagerFactory("JPA_LibreriaPU").createEntityManager();

    public Editorial elegirEditorial() {
        
        //MENSAJE PARA EL USUARIO//
        System.out.println("Elija una editorial de la lista");
        //TRAER DE LA BASE DE DATOS LAS EDITORIALES CARGADAS//

        try {
            editoriales = em.createQuery("SELECT a FROM Editorial a").getResultList();
        } catch (Exception e) {
            System.out.println("No hay Editoriales cargadas, vamos a cargar una");
            crearEditorial();
        }

        //MOSTRAR LAS EDITORIALES
        for (Editorial auxiliarEditoriales : editoriales) {
            System.out.println("Editorial N# " + auxiliarEditoriales.getId() + " " + auxiliarEditoriales.getNombre());
        }
        //SI NO ESTA EN LA LISTA//
        System.out.println("Si su editorial no se encuentra en la lista, presione 0");
        String seleccionUsuario = leer.next();
        if (seleccionUsuario.equals("0")) {
            editorial = crearEditorial();
        } else {
            editorial.setAlta(Boolean.TRUE); 
            for (Editorial aux : editoriales) {
                
                if (aux.getId().equalsIgnoreCase(seleccionUsuario)) {
                    editorial.setNombre(aux.getNombre());
                }                
            }            
        }
        return editorial;

    }

    public Editorial crearEditorial() {

        editorial.setAlta(Boolean.TRUE);
        System.out.println("Ingrese el nombre de la editorial");
        String nombre = leer.next();
        editorial.setNombre(nombre);
        
        return editorial;
    }

}
