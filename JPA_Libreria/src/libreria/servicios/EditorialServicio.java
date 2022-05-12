package libreria.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;

public class EditorialServicio {

    Scanner leer = new Scanner(System.in);
    Editorial editorial = new Editorial();
    List<Editorial> editoriales = new ArrayList<>();
    String editorialId;
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
            for (Editorial aux : editoriales) {                
                if (aux.getId().equalsIgnoreCase(seleccionUsuario)) {
                    editorial = aux;
                }                
            }            
        }
        return editorial;

    }

    public Editorial crearEditorial() {
        
        editorial.setAlta(Boolean.TRUE);
        System.out.println("Ingrese el nombre de la editorial");
        editorial.setNombre(leer.next());
        //Nos conectamos para crear la editorial
         em.getTransaction().begin();
        //Persistimos el objeto
        em.persist(editorial);
        //Terminamos la transacción con el método commit. Commit en programación significa confirmar un conjunto de cambios, en este caso persistir el objeto*/
        em.getTransaction().commit();
               
        return editorial;
    }

    void buscarEditorial() {
        try {
            System.out.println("Ingrese el nombre de la editorial a buscar");
            String editorialBuscada = leer.next();
            Query query = em.createQuery("SELECT e FROM Editorial e WHERE e.nombre = :nombre");
            query.setParameter("nombre", editorialBuscada);
            Editorial result = (Editorial) query.getSingleResult();
            System.out.println("La editorial *" + result.getNombre() + "* se encontro en la lista");
        } catch (Exception e) {
            System.out.println("La editorial no se encontro en la base de datos");
            buscarEditorial();
        } 
    }
    
    

}
