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

        EntityManager em = Persistence.createEntityManagerFactory("JPA_LibreriaPU").createEntityManager();
        Libro libro = new Libro();

        System.out.println("Ingrese el numero ISBN");
        libro.setIsbn(leer.next());

        System.out.println("Ingrese el titulo del libro");
        libro.setTitulo(leer.next());

        System.out.println("Ingrese el año de edicion");
        libro.setAnio(leer.nextInt());
        libro.setAlta(true);
        
        //Iniciamos una transacción con el método getTransaction().begin();
        em.getTransaction().begin();
        //Persistimos el objeto
        em.persist(libro);
        //Terminamos la transacción con el método commit. Commit en programación significa confirmar un conjunto de cambios, en este caso persistir el objeto*/
        em.getTransaction().commit();
        em.close();
        
        AutorServicio aS = new AutorServicio();
        Autor autor = new Autor();
        autor=aS.elegirAutor();                             
        
        EditorialServicio eS = new EditorialServicio();
        libro.setEditorial(eS.elegirEditorial());   
        Editorial editorial = new Editorial();
        editorial=eS.elegirEditorial();
        
        libro.setAutor(autor); 
        libro.setEditorial(editorial);
                
        em.getTransaction().begin();
        em.merge(libro);
        em.getTransaction().commit();
        em.close();
        
        

    }

}
