package libreria.servicios;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;

public class LibroServicio {

    Scanner leer = new Scanner(System.in);

    public void crearLibro() {
        //Creamos el EM para conectarnos a la libreria
        EntityManager em = Persistence.createEntityManagerFactory("JPA_LibreriaPU").createEntityManager();
        //Creamos la entidad Libro
        Libro libro = new Libro();
        //Pedimos los datos por teclado
        System.out.println("Ingrese el numero ISBN");
        libro.setIsbn(leer.next());

        System.out.println("Ingrese el titulo del libro");
        libro.setTitulo(leer.next());

        System.out.println("Ingrese el año de edicion");
        libro.setAnio(leer.nextInt());
        //Seteamos el ALTA del libro
        libro.setAlta(true);              
        //Creamos el objeto aS para acceder a la clase AutorServicio        
        AutorServicio aS = new AutorServicio();              
        //Creamos el objeto AUTOR eligiendo de la lista con el metodo ELEGIR AUTOR
        Autor autor = aS.elegirAutor();
        //Seteamos el AUTOR a la entidad libro
        libro.setAutor(autor);
        //Creamos el objeto eS para acceder a la clase EditorialServicio 
        EditorialServicio eS = new EditorialServicio();
        //Creamos el objeto EDITORIAL eligiendo de la lista con el metodo ELEGIR EDITORIAL
        Editorial editorial = eS.elegirEditorial();
        //Seteamos la editorial a la entidad libro
        libro.setEditorial(editorial);
        
        em.getTransaction().begin();
        //Persistimos el objeto
        em.persist(libro);
        //Terminamos la transacción con el método commit. Commit en programación significa confirmar un conjunto de cambios, en este caso persistir el objeto*/
        em.getTransaction().commit();                        
 
    }

}
