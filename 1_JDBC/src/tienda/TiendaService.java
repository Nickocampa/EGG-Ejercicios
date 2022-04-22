/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import java.util.Scanner;
import tienda.servicios.FabricanteService;
import tienda.servicios.ProductoService;

/**
 *
 * @author ncampanella
 */
public class TiendaService {

    Scanner leer = new Scanner(System.in);
    ProductoService pS = new ProductoService();
    FabricanteService fS = new FabricanteService();

    /*update personajes set aparicion = 1938 where id_personaje = 7;*/
    public void menu() throws Exception {

        String opcionElegida = null;
        System.out.println("/*************************************************/");
        System.out.println("Seleccione una opcion");
        System.out.println("1) Lista el nombre de todos los productos que hay en la tabla producto.");
        System.out.println("2) Lista los nombres y los precios de todos los productos de la tabla producto.");
        System.out.println("3) Listar aquellos productos que su precio esté entre 120 y 202.");
        System.out.println("4) Buscar y listar todos los Portátiles de la tabla producto.");
        System.out.println("5) Listar el nombre y el precio del producto más barato.");
        System.out.println("6) Ingresar un producto a la base de datos.");
        System.out.println("7) Ingresar un fabricante a la base de datos");
        System.out.println("8) Editar un producto con datos a elección.*/");
        System.out.println("9) SALIR");
        opcionElegida = leer.next();
        try {
            int opcion = Integer.parseInt(opcionElegida);

            if (opcion < 1 || opcion > 9) {
                throw new Exception("Las opciones van de 1 a 9");
            }
        } catch (Exception e) {
            System.out.println("Las opciones van de 1 a 9");
            opcionElegida = null;
            menu();
        }

        switch (opcionElegida) {
            case "1":
                pS.mostrarProductos();
                menu();
                break;
            case "2":
                pS.mostrarPrecioNombre();
                menu();
                break;
            case "3":
                pS.mostrarPrecioEntre120202();
                menu();
                break;
            case "4":
                pS.buscarPortatil();
                menu();
                break;
            case "5":
                pS.productoBarato();
                menu();
                break;
            case "6":
                pS.insertarNuevoProducto();
                menu();
                break;
            case "7":
                fS.insertarNuevoFabricante();
                menu();
                break;
            case "8":
                pS.modificarProducto();
                menu();
                break;
            case "9":
                System.exit(0);
                break;

        }
    }

}
