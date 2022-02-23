package MascotAPPCollections;

import Services.ServiceCollections;


public class mascotAppCollection {


    public static void main(String[] args) {
        
        ServiceCollections servMasc = new ServiceCollections();
        
       servMasc.fabricaMascota(2);
       
       servMasc.mostrarMascotas();
       
       servMasc.actualizarMascota(0);
       
       servMasc.mostrarMascotas();
        
       servMasc.eliminarMascota(0);
       
       servMasc.mostrarMascotas();
       
    }
    
}
