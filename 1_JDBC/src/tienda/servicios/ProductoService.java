package tienda.servicios;

import java.util.Collection;
import java.util.Scanner;
import tienda.entidades.Producto;
import tienda.persistencia.DAO;
import tienda.persistencia.ProductoDAO;

public class ProductoService extends DAO {

    Scanner leer = new Scanner(System.in);

    public void mostrarProductos() throws Exception {
        ProductoDAO p1 = new ProductoDAO();
        for (Producto producto : p1.listarNombreProductos()) {

            System.out.println("Producto N# " + producto.getCodigo() + " - " + producto.getNombre());

        }
    }

    public void mostrarPrecioNombre() throws Exception {
        ProductoDAO p1 = new ProductoDAO();
        for (Producto producto : p1.listarNombrePrecioProductos()) {

            System.out.println("Producto N# " + producto.getCodigo() + " - " + producto.getNombre() + " Precio-$" + producto.getPrecio());

        }

    }

    public void mostrarPrecioEntre120202() throws Exception {
        ProductoDAO p1 = new ProductoDAO();
        for (Producto producto : p1.listarPrecioEntre120202()) {

            System.out.println("Producto N# " + producto.getCodigo() + " - " + producto.getNombre() + " Precio-$" + producto.getPrecio());

        }

    }

    public void buscarPortatil() throws Exception {
        ProductoDAO p1 = new ProductoDAO();
        for (Producto producto : p1.listarPortatil()) {

            System.out.println("Producto N# " + producto.getCodigo() + " - " + producto.getNombre());

        }
    }

    public void productoBarato() throws Exception {
        ProductoDAO p1 = new ProductoDAO();
        for (Producto producto : p1.productoMasBarato()) {

            System.out.println("Producto N# " + producto.getCodigo() + " - " + producto.getNombre() + " PRECIO - $ " + producto.getPrecio());

        }
    }

    public void insertarNuevoProducto() throws Exception {
        ProductoDAO p1 = new ProductoDAO();
        p1.insertarProducto();

    }

    public void modificarProducto() throws Exception {
        ProductoDAO p1 = new ProductoDAO();
        Collection<Producto> productos = p1.listarNombreProductos();
        try {

            System.out.println("Seleccione el ID del producto a modificar");
            int idProductoElegido = leer.nextInt();
            System.out.println("Ingrese el nombre del nuevo producto");
            String nuevoNombreProducto = leer.next();
            // Enviamos el comando a MySQL como un String //
            String comandoParaMySQL = "update producto set nombre = '" + nuevoNombreProducto + "' where codigo = " + idProductoElegido + ";";
            // Metodo para modificar base de dato con comando enviado //
            insertarModificarEliminar(comandoParaMySQL);
            desconectarBase();

        } catch (Exception e) {
            desconectarBase();
            throw e;

        }
    }

}
