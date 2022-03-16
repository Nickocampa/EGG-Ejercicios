package herenciasej04;

import herenciasej04.Subclases.Circulo;
import herenciasej04.Subclases.Rectangulo;
import herenciasej04.Superclase.calculoFormas;
import java.util.Scanner;

public class HerenciasEj04 {

    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        
                
        System.out.println("Ingrese la base y la altura del rectangulo");
        Rectangulo rectangulo_1 = new Rectangulo(leer.nextDouble(), leer.nextDouble());
        
        System.out.println("Ingrese el radio del circulo");
        Circulo circulo_1 = new Circulo(leer.nextDouble());
        
        circulo_1.area();
        circulo_1.perimetro();
        
        rectangulo_1.area();
        rectangulo_1.perimetro();
        
        
    }
    
}
