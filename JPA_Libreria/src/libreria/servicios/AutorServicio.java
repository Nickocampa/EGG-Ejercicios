package libreria.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Autor;

public class AutorServicio {

    Scanner leer = new Scanner(System.in);
    Autor autor = new Autor();
    List<Autor> autores = new ArrayList<>();
    String autorId;
    //CREAR ENTITY MANAGER//
    EntityManager em = Persistence.createEntityManagerFactory("JPA_LibreriaPU").createEntityManager();

    public Autor elegirAutor() {

        //MENSAJE PARA EL USUARIO//
        System.out.println("Elija un autor de la lista");
        //TRAER DE LA BASE DE DATOS LOS AUTORES CARGADOS//

        try {
            autores = em.createQuery("SELECT a FROM Autor a").getResultList();
        } catch (Exception e) {
            System.out.println("No hay Autores cargados, vamos a cargar uno");
            crearAutor();
        }
        //MOSTRAR LOS AUTORES
        for (Autor auxiliarAutores : autores) {
            System.out.println("Autor N# " + auxiliarAutores.getId() + " " + auxiliarAutores.getNombre());
        }
        //SI NO ESTA EN LA LISTA//
        System.out.println("Si su autor no se encuentra en la lista, presione 0");
        String seleccionUsuario = leer.next();
        if (seleccionUsuario.equals("0")) {
            autor = crearAutor();
            
        } else {             
            for (Autor aux : autores) {                
                if (aux.getId().equalsIgnoreCase(seleccionUsuario)) {
                    autor = aux;
                }                
            }            
        }
        return autor;
    }

    public Autor crearAutor() {
        
        autor.setAlta(Boolean.TRUE);
        System.out.println("Ingrese el nombre del autor");
        autor.setNombre(leer.next());
        //Nos conectamos para crear el autor
         em.getTransaction().begin();
        //Persistimos el objeto
        em.persist(autor);
        //Terminamos la transacción con el método commit. Commit en programación significa confirmar un conjunto de cambios, en este caso persistir el objeto*/
        em.getTransaction().commit();
               
        return autor;
    }
}
