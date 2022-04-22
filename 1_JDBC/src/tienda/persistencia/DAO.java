package tienda.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public abstract class DAO {

    protected Connection conexion;
    protected ResultSet resultado;
    protected Statement sentencia;
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "tienda";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    Scanner leer = new Scanner (System.in);

//    public void setDATABASE(String DATABASE) {
//        System.out.println("Ingrese el nombre de la base de datos");
//        this.DATABASE = leer.next();
//    }
//    
//    public String getDATABASE() {
//        return DATABASE;
//    }
    
    protected void conectarBase() throws Exception {
        try {
            Class.forName(DRIVER);
            //setDATABASE(DATABASE);
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
            conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }
    }

    protected void desconectarBase() throws Exception {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    protected void insertarModificarEliminar(String sql) throws Exception {
        try {
            conectarBase();
            sentencia = (Statement) conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            throw ex;
        } finally {
            desconectarBase();
        }
    }

    protected void consultarBase(String sql) throws Exception {
        try {
            conectarBase();
            sentencia = (Statement) conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (Exception ex) {
            throw ex;
        }
    }

}
