package relacionesentreclasesej03;

import cartasService.cartasService;

public class JuegoCartas03 {

    public static void main(String[] args) {
        
        cartasService cartasServ = new cartasService();
        
        cartasServ.crearCartas();
        
        cartasServ.mensajeInicial();  
        cartasServ.menu();
        
        
    }
    
}
