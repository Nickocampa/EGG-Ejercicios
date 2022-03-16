package Subclases;

import Superclase.Electrodomesticos;
import java.util.Scanner;

public class Lavadora extends Electrodomesticos {

    Scanner leer = new Scanner(System.in);
    public Integer carga;

    public Lavadora() {
        
    }

    public Lavadora(Integer carga, Double precio, String color, char consumo, Integer peso) {
        super(precio, color, consumo, peso);
        this.carga = carga;
    }
   
    public Integer getCarga() {
        return carga;
    }

    public void setCarga(Integer carga) {
        this.carga = carga;
    }

    public void crearLavadora() {
        super.crearElectrodomestico();
    }
    
    @Override
    public void precioFinal() {
        super.precioFinal();
        System.out.println("Cual es el valor de la carga de la lavadora?");
        carga=leer.nextInt();
        if (carga>30) {
            precio=precio + 500;
            
        }
        
        
    }
    
    public void mostrarLavadora(){
         
        System.out.println("El precio del lavaropas es igual a $" + precio);

}

}
