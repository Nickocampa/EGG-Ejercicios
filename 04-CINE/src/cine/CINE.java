package cine;

import PeliculaService.PeliculaService;

public class CINE {

    public static void main(String[] args) {
        
       PeliculaService pService = new PeliculaService();
       
       pService.crearLista();
       pService.mostrarPeliculas();
       pService.mostrarDuracionMay();
       pService.ordenarMayMen();
       pService.ordenarMenMAy();
       pService.ordenarAZnombre();
       pService.ordenarAZdirector();
       
    }
    
}
