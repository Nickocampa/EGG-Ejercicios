package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;

public class FabricanteDAO extends DAO {

    public Collection<Fabricante> listarNombreFabricante() throws Exception {
        try {
            // Enviamos el comando a MySQL como un String //
            String comandoParaMySQL = "SELECT codigo,nombre FROM Fabricante ";
            // Metodo para consulta base de dato con comando enviado //
            consultarBase(comandoParaMySQL);
            // Instancio producto nulo //
            Fabricante fabricante = null;
            // Creamos la coleccion de productos //
            Collection<Fabricante> fabricantes = new ArrayList();
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
                fabricantes.add(fabricante);

            }
            desconectarBase();
            return fabricantes;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    //g) Ingresar un fabricante a la base de datos//
    public void insertarFabricante() throws Exception {
        Collection<Fabricante> fabricantes = listarNombreFabricante();
        try {

            // Enviamos el comando a MySQL como un String //
            System.out.println("Ingrese el nombre del fabricante");
            String fabricanteElegido = leer.next();
            String comandoParaMySQL = "INSERT into fabricante VALUES("+(fabricantes.size() + 1) + ",'" + fabricanteElegido+"')";
            // Metodo para consulta base de dato con comando enviado //
            insertarModificarEliminar(comandoParaMySQL);
            desconectarBase();

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

}
