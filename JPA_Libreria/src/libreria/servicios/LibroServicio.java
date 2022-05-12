package libreria.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;

public class LibroServicio {

    Scanner leer = new Scanner(System.in);
    EntityManager em = Persistence.createEntityManagerFactory("JPA_LibreriaPU").createEntityManager();
    AutorServicio aS = new AutorServicio();
    EditorialServicio eS = new EditorialServicio();
    
    public void crearLibro() {
        //Creamos el EM para conectarnos a la libreria
        EntityManager em = Persistence.createEntityManagerFactory("JPA_LibreriaPU").createEntityManager();
        //Creamos la entidad Libro
        Libro libro = new Libro();
        //Pedimos los datos por teclado buscando errores y repeticiones//
        libro.setIsbn(cargarISBN());
        libro.setTitulo(cargarTitulo());
        libro.setAnio(cargarAnioEdicion());
        //Seteamos el ALTA del libro
        libro.setAlta(true);
        System.out.println("Indicar la cantidad de ejemplares");
        libro.setEjemplares(leer.nextInt());
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

        //Comenzamos la conexion a la base de datos//
        em.getTransaction().begin();
        //Persistimos el objeto
        em.persist(libro);
        //Terminamos la transacción con el método commit. Commit en programación significa confirmar un conjunto de cambios, en este caso persistir el objeto//
        em.getTransaction().commit();

    }

    public String cargarISBN() {
        String isbn = null;
        try {
            System.out.println("Ingrese el numero ISBN");
            isbn = leer.next();
        } catch (Exception e) {
            System.out.println("Error al cargar el numero, intentelo nuevamente");
            cargarISBN();
        }
        try {
            Query query = em.createQuery("SELECT e FROM Libro e WHERE e.isbn = :isbn");
            query.setParameter("isbn", isbn);
            Libro libroDelQuery = (Libro) query.getSingleResult();

            if (libroDelQuery.getIsbn().equals(isbn)) {
                System.out.println("El ISBN ya se encuentra en la base de datos");
                cargarISBN();
            }
        } catch (Exception e) {
            return isbn;
        }
        return isbn;
    }

    public String cargarTitulo() {
        String titulo = null;
        try {
            System.out.println("Ingrese el titulo del libro");
            titulo = leer.next();
        } catch (Exception e) {
            System.out.println("Error al cargar el titulo, intentelo nuevamente");
            cargarTitulo();
        }

        try {
            Query query = em.createQuery("SELECT e FROM Libro e WHERE e.titulo = :titulo");
            query.setParameter("titulo", titulo);
            Libro libroDelQuery = (Libro) query.getSingleResult();

            if (libroDelQuery.getIsbn().equals(titulo)) {
                System.out.println("El titulo del libro ya se encuentra en la base de datos");
                cargarISBN();
            }
        } catch (Exception e) {
            return titulo;
        }
        return titulo;
    }

    public int cargarAnioEdicion() {
        int anio = 0;
        try {
            System.out.println("Ingrese el año de edicion del libro");
            anio = leer.nextInt();
        } catch (Exception e) {
            System.out.println("Error al cargar el titulo, intentelo nuevamente");
            cargarAnioEdicion();
        }
        return anio;
    }

    public void darAltaBajaModificarLibro() {

        Libro libro = new Libro();
        List<Libro> libros = new ArrayList<>();
        libros = em.createQuery("SELECT a FROM Libro a").getResultList();

        for (Libro aux : libros) {
            System.out.println("Id: " + aux.getId() + " Titulo: " + aux.getTitulo());
        }
        String seleccion = null;
        int bandera = 0;

        do {
            System.out.println("De la lista de libros, cual desea dar de BAJA/ALTA/Modificar??");
            try {
                seleccion = leer.next();
                libro = em.find(Libro.class, seleccion);
                System.out.println("Desea modificar atributos del libro?");
                String opcionModi;

                try {
                    opcionModi = leer.next();
                    if (opcionModi.equalsIgnoreCase("Y")) {
                        modificarLibroCargado(libro);
                    }
                } catch (Exception e) {
                    System.out.println("Error de seleccion / Intente de nuevo");
                    darAltaBajaModificarLibro();
                }
                System.out.println("Desea dar de ALTA/BAJA el libro? Y/N");
                String opcionAltaBaja = leer.next();
                if (opcionAltaBaja.equalsIgnoreCase("Y")) {

                    bandera = 0;
                    if (libro.getAlta()) {
                        libro.setAlta(Boolean.FALSE);
                        System.out.println("El libro *" + libro.getTitulo() + "* se dio de baja");
                    } else {
                        libro.setAlta(Boolean.TRUE);
                        System.out.println("El libro *" + libro.getTitulo() + "* se dio de alta");
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Su opcion no se encontro en la lista");
                System.out.println("");
                bandera = 1;
            }

        } while (bandera != 0);

        //libro = em.find(Libro.class, seleccion);
        em.getTransaction().begin();
        //Persistimos el objeto
        em.merge(libro);
        //Terminamos la transacción con el método commit. Commit en programación significa confirmar un conjunto de cambios, en este caso persistir el objeto*/
        em.getTransaction().commit();

    }

    private Libro modificarLibroCargado(Libro libroRecibido) {
        Libro libroModificar = libroRecibido;
        //Creamos el EM para conectarnos a la libreria
        EntityManager em = Persistence.createEntityManagerFactory("JPA_LibreriaPU").createEntityManager();

        System.out.println("Desea cambiar el titulo? Y/N");
        String opcionTitulo = leer.next();
        if (opcionTitulo.equalsIgnoreCase("Y")) {
            try {
                System.out.println("Ingrese el nuevo titulo del libro");
                String titulo = leer.next();
                libroModificar.setTitulo(titulo);
            } catch (Exception e) {
                System.out.println("Error al cargar el titulo, intentelo nuevamente");
                modificarLibroCargado(libroRecibido);
            }
        }
        System.out.println("Desea mofificar el ISBN del libro? Y/N");
        String opcionISBN = leer.next();
        if (opcionISBN.equalsIgnoreCase("Y")) {
            try {
                System.out.println("Ingrese el nuevo ISBN del libro");
                String ISBN = leer.next();
                libroModificar.setIsbn(ISBN);
            } catch (Exception e) {
                System.out.println("Error al cargar el ISBN, intentelo nuevamente");
                modificarLibroCargado(libroRecibido);
            }
        }

        System.out.println("Desea mofificar el Autor del libro? Y/N");
        String opcionAutor = leer.next();
        if (opcionAutor.equalsIgnoreCase("Y")) {
            libroModificar.setAutor(modificarAutorLibro(libroModificar).getAutor()); ;            
        }

        System.out.println("Desea mofificar la Editorial del libro? Y/N");
        String opcionEditorial = leer.next();
        if (opcionEditorial.equalsIgnoreCase("Y")) {
            try {
                libroModificar.setEditorial(modificarEditorialLibro(libroModificar).getEditorial());
            } catch (Exception e) {
                System.out.println("Error al cargar la Editorial, intentelo nuevamente");
                modificarLibroCargado(libroRecibido);

            }
        }

        return libroModificar;
    }

    private Libro modificarAutorLibro(Libro libroModificar) {
        EntityManager em = Persistence.createEntityManagerFactory("JPA_LibreriaPU").createEntityManager();
        Libro libroModificado = new Libro();
        List<Autor> autores = new ArrayList();
        String nuevoAutor = null;

        try {
            System.out.println("Ingrese el nuevo Autor del libro");
            nuevoAutor = leer.next();
        } catch (Exception e) {
            System.out.println("Error al cargar el Autor, intentelo nuevamente");
            modificarAutorLibro(libroModificar);
        }
        autores = em.createQuery("SELECT a FROM Autor a").getResultList();
        int banderita = 0;
        for (Autor aux : autores) {

            if (aux.getNombre().equalsIgnoreCase(nuevoAutor)) {
                libroModificado.setAutor(aux);
                banderita = 1;
            }
        }
        if (banderita == 0) {
            System.out.println("Su autor no se encontro en la lista, vamos a cargarlo");
            libroModificado.setAutor(aS.crearAutor());
        }

        return libroModificado;
    }
    
    private Libro modificarEditorialLibro(Libro libroModificar) {
        EntityManager em = Persistence.createEntityManagerFactory("JPA_LibreriaPU").createEntityManager();
        Libro libroModificado = new Libro();
        List<Editorial> editoriales = new ArrayList();
        String nuevaEditorial = null;

        try {
            System.out.println("Ingrese la nueva Editorial del libro");
            nuevaEditorial = leer.next();
        } catch (Exception e) {
            System.out.println("Error al cargar la Editorial, intentelo nuevamente");
            modificarEditorialLibro(libroModificar);
        }
        editoriales = em.createQuery("SELECT a FROM Editorial a").getResultList();
        int banderita = 0;
        for (Editorial aux : editoriales) {

            if (aux.getNombre().equalsIgnoreCase(nuevaEditorial)) {
                libroModificado.setEditorial(aux);
                banderita = 1;
            }
        }
        if (banderita == 0) {
            System.out.println("Su editorial no se encontro en la lista, vamos a cargarla");
            libroModificado.setEditorial(eS.crearEditorial());
        }

        return libroModificado;
    }

    public void buscarPorISBN() {

        try {
            System.out.println("Ingrese el ISBN del libro a buscar");
            String isbnBuscado = leer.next();
            Query query = em.createQuery("SELECT e FROM Libro e WHERE e.isbn = :isbn");
            query.setParameter("isbn", isbnBuscado);
            Libro result = (Libro) query.getSingleResult();
            System.out.println("El libro con el ISBN *" + result.getIsbn() + "* se encontro en la lista");
        } catch (Exception e) {
            System.out.println("El ISBN no corresponde a un libro de nuestra base de datos");
            buscarPorISBN();
        }

    }

    public Libro buscarPorTitulo() {
        Libro libroEncontrado = null;
        try {
            System.out.println("Ingrese el Nombre del libro a buscar");
            String nombreBuscado = leer.next();
            Query query = em.createQuery("SELECT e FROM Libro e WHERE e.nombre = :nombre");
            query.setParameter("nombre", nombreBuscado);
            libroEncontrado = (Libro) query.getSingleResult();
            System.out.println("El libro * " + libroEncontrado.getTitulo() + " * se encontro en la lista");
        } catch (Exception e) {
            System.out.println("El Nombre ingresado no corresponde a un libro de nuestra base de datos");
            buscarPorTitulo();
        }

        return libroEncontrado;
    }

    public void buscarLibroPorAutor() {
        List<Libro> libros = new ArrayList<>();
        AutorServicio aS = new AutorServicio();

        try {
            System.out.println("Ingrese el Nombre del Autor a buscar");
            String nombreBuscado = leer.next();
            Query query = em.createQuery("SELECT a FROM Libro a WHERE a.autor.nombre = :nombre");
            query.setParameter("nombre", nombreBuscado);
            libros = query.getResultList();
            System.out.println("Los libros del autor son:");
            int numeroLibro = 0;
            for (Libro auxiliarLibro : libros) {
                numeroLibro++;
                System.out.println("# " + numeroLibro + " * " + auxiliarLibro.getTitulo() + " *");
            }

        } catch (Exception e) {
            System.out.println("El Nombre ingresado no corresponde a un autor de nuestra base de datos");
            buscarPorTitulo();
        }
    }

    public void buscarLibroPorEditorial() {
        List<Libro> libros = new ArrayList<>();
        EditorialServicio eS = new EditorialServicio();

        try {
            System.out.println("Ingrese el Nombre de la editorial a buscar");
            String nombreBuscado = leer.next();
            Query query = em.createQuery("SELECT a FROM Libro a WHERE a.editorial.nombre = :nombre");
            query.setParameter("nombre", nombreBuscado);
            libros = query.getResultList();
            System.out.println("Los libros de la editorial son:");
            int numeroLibro = 0;
            for (Libro auxiliarLibro : libros) {
                numeroLibro++;
                System.out.println("# " + numeroLibro + " * " + auxiliarLibro.getTitulo() + " *");
            }

        } catch (Exception e) {
            System.out.println("El Nombre ingresado no corresponde a una editorial de nuestra base de datos");
            buscarPorTitulo();
        }
    }

}
