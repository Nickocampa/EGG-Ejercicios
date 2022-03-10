package herenciasej01;

public class Gato extends Animal{

    public Gato(String nombre, String alimento, Integer edad, String raza) {
        super(nombre, alimento, edad, raza);
    }

     @Override
    public void Alimentarse() {
        
        System.out.println("El gato " + nombre + " se alimenta de " + alimento);
    }
    
    
    
}
