package tienda;

import tienda.servicios.TiendaService;
import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;
import tienda.servicios.FabricanteService;
import tienda.servicios.ProductoService;

public class Tienda_Main {

    public static void main(String[] args) throws Exception {
        // Instanciar objetos para usar servicios //
        TiendaService tS = new TiendaService();
        tS.menu();
    }

}
