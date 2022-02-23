
import Alumno.Alumno;
import Services.AlumnoService;
import java.util.ArrayList;



public class ColeEj003 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //CREO aS1 para acceder a los metodos del AlumnoService//       
        AlumnoService aS1 = new AlumnoService();
        
        aS1.crearAlumno();
               
        aS1.mostrarLista();
        
        aS1.buscarAlumno();
        
    }
    
}
