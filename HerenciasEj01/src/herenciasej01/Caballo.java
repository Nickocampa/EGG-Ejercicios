package herenciasej01;

public class Caballo extends Animal {

    public Caballo(String nombre, String alimento, Integer edad, String raza) {
        super(nombre, alimento, edad, raza);
    }

     @Override
    public void Alimentarse() {
     
        System.out.println("El caballo " + nombre + " se alimenta de " + alimento);
    }
    
}
