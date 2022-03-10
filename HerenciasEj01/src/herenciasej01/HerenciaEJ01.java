package herenciasej01;

public class HerenciaEJ01 {

   public static void main(String[] args) {   
       
                 
       Animal perro = new Perro ("Ummo","Animalitos",15,"Ovejero");
       perro.Alimentarse();
       
       Perro perro1 = new Perro ("Nala","Alimento Blanceado",10,"Ovejero");
       perro1.Alimentarse();
       
       Animal gato = new Gato ("Michi","Galletas",15,"Siames");
       gato.Alimentarse();
       
       Animal caballo = new Caballo ("Pony","Pasto",25,"Fino");
       caballo.Alimentarse();
       
       
       
       
    }
    
}
