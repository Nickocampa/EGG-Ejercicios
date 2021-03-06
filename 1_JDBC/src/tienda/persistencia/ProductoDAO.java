package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;

public class ProductoDAO extends DAO {

    //a) Lista el nombre de todos los productos que hay en la tabla producto.//
    public Collection<Producto> listarNombreProductos() throws Exception {
        try {
            // Enviamos el comando a MySQL como un String //
            String comandoParaMySQL = "SELECT codigo,nombre,codigo_fabricante, precio FROM Producto ";
            // Metodo para consulta base de dato con comando enviado //
            consultarBase(comandoParaMySQL);
            // Instancio producto nulo //
            Producto producto = null;
            // Creamos la coleccion de productos //
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setCodigoFabricante(resultado.getInt(3));
                producto.setPrecio(resultado.getInt(4));
                productos.add(producto);

            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    //b) Lista los nombres y los precios de todos los productos de la tabla producto.//
    public Collection<Producto> listarNombrePrecioProductos() throws Exception {
        try {
            // Enviamos el comando a MySQL como un String //
            String comandoParaMySQL = "SELECT codigo,nombre,precio FROM Producto ";
            // Metodo para consulta base de dato con comando enviado //
            consultarBase(comandoParaMySQL);
            // Instancio producto nulo //
            Producto producto = null;
            // Creamos la coleccion de productos //
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getInt(3));
                productos.add(producto);

            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    //c) Listar aquellos productos que su precio est?? entre 120 y 202.//
    public Collection<Producto> listarPrecioEntre120202() throws Exception {
        try {
            // Enviamos el comando a MySQL como un String //
            String comandoParaMySQL = "SELECT codigo,nombre,precio FROM Producto where PRECIO between 120 and 202";
            // Metodo para consulta base de dato con comando enviado //
            consultarBase(comandoParaMySQL);
            // Instancio producto nulo //
            Producto producto = null;
            // Creamos la coleccion de productos //
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getInt(3));
                productos.add(producto);

            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    //d)Buscar y listar todos los Port??tiles de la tabla producto//
    public Collection<Producto> listarPortatil() throws Exception {
        try {
            // Enviamos el comando a MySQL como un String //
            String comandoParaMySQL = "SELECT codigo,nombre,precio FROM Producto where nombre like  '%portatil%'";
            // Metodo para consulta base de dato con comando enviado //
            consultarBase(comandoParaMySQL);
            // Instancio producto nulo //
            Producto producto = null;
            // Creamos la coleccion de productos //
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getInt(3));
                productos.add(producto);

            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    //e) Listar el nombre y el precio del producto m??s barato.
    public Collection<Producto> productoMasBarato() throws Exception {
        try {
            // Enviamos el comando a MySQL como un String //
            String comandoParaMySQL = "SELECT codigo,nombre,precio FROM Producto order by precio asc limit 1;";
            // Metodo para consulta base de dato con comando enviado //
            consultarBase(comandoParaMySQL);
            // Instancio producto nulo //
            Producto producto = null;
            // Creamos la coleccion de productos //
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getInt(3));
                productos.add(producto);

            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    //f) Ingresar un producto a la base de datos.//
    public void insertarProducto() throws Exception {
        Collection<Producto> productos = listarNombrePrecioProductos();
        FabricanteDAO fD = new FabricanteDAO();
        Collection<Fabricante> fabricantes = fD.listarNombreFabricante();

        try {

            // Enviamos el comando a MySQL como un String //
            System.out.println("Ingrese el producto para agregar");
            String productoElegido = leer.nextLine();
            for (Fabricante fabricante : fabricantes) {
                System.out.println("Codigo N# " + fabricante.getCodigo() + "- Nombre: " + fabricante.getNombre());
            }

            Integer fabricanteElegido = 0;

            do {
                System.out.println("Seleccione el codigo del fabricante");
                fabricanteElegido = leer.nextInt();

            } while (fabricanteElegido < 0 || fabricanteElegido > fabricantes.size());
            
            int precioElegido=-1;
            
            do {
                try {System.out.println("Ingrese el precio del producto");
            precioElegido = leer.nextInt();
            } catch (Exception e) {
            precioElegido=-1;
            //limpia el nextInt buffer.
            leer.next();
        }
            } while (precioElegido==-1);
            
            
            String comandoParaMySQL = "INSERT into producto VALUES(" + (productos.size() + 1) + ",'" + productoElegido + "'," + precioElegido + ", " + fabricanteElegido + ")";
            // Metodo para consulta base de dato con comando enviado //
            insertarModificarEliminar(comandoParaMySQL);
            desconectarBase();

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

}
