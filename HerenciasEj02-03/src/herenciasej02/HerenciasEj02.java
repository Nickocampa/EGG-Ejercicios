
package herenciasej02;

import Service.ElectrodomesticosService;
import Subclases.Lavadora;
import Subclases.Televisor;
import Superclase.Electrodomesticos;
import java.util.ArrayList;

public class HerenciasEj02 {

    public static void main(String[] args) {
        
        ArrayList <Electrodomesticos> electros  = new ArrayList();
        
        ElectrodomesticosService eService = new ElectrodomesticosService();
        
        electros=eService.menu();
        
       
        
        
        
        
    }
    
}
