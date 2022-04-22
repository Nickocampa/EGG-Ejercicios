
package Principal.persistencia;


import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public abstract class DAO {
    
    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;
    
    
    
}
 