package herenciasej01;

public class Perro extends Animal{

    public Perro(String nombre, String alimento, Integer edad, String raza) {
        super(nombre, alimento, edad, raza);
    }

    @Override
    public void Alimentarse() {
        
        System.out.println("El perro " + nombre + " se alimenta de " + alimento);
        
    }

   
    
}
