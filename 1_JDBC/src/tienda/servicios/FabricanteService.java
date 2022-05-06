package tienda.servicios;

import tienda.persistencia.FabricanteDAO;
import tienda.persistencia.ProductoDAO;

public class FabricanteService {

    //g) Ingresar un fabricante a la base de datos//
    public void insertarNuevoFabricante() throws Exception {
        FabricanteDAO p1 = new FabricanteDAO();
        p1.insertarFabricante();
    }
}
