
package herenciasej02;

import Subclases.Lavadora;
import Subclases.Televisor;
import Superclase.Electrodomesticos;

public class HerenciasEj02 {

    public static void main(String[] args) {
       
        Lavadora Lava1 = new Lavadora ();
        Televisor Tele1 = new Televisor();
        
        Lava1.crearLavadora();
        Lava1.mostrarLavadora();
        Tele1.crearTelevisor();
        Tele1.mostrarTele();
        
        
        
    }
    
}
