package herenciasej01extra;

import Service.BarcosService;
import Subclases.Barcos;
import Superclase.alquilerBarco.AlquilerBarco;
import java.util.ArrayList;

public class HerenciasEj01Extra {

    public static void main(String[] args) {

        BarcosService bS = new BarcosService();
        AlquilerBarco aB = new AlquilerBarco();

        bS.crearBarcos();

        bS.mostrarBarcos();

        aB.alquilarBarco(bS.seleccionarBarco());
        
        aB.mostrarPrecio(bS.sacarDatos());

    }

}
