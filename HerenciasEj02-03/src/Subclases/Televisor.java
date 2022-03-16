package Subclases;

import Superclase.Electrodomesticos;
import java.util.Scanner;

public class Televisor extends Electrodomesticos {

    Scanner leer = new Scanner(System.in);

    private Integer resolucion;
    private boolean sintonizador;

    public Televisor() {
        
    }

    public Televisor(Integer resolucion, boolean sintonizador, Double precio, String color, char consumo, Integer peso) {
        super(precio, color, consumo, peso);
        this.resolucion = resolucion;
        this.sintonizador = sintonizador;
    }

    public Integer getResolucion() {
        return resolucion;
    }

    public void setResolucion(Integer resolucion) {
        this.resolucion = resolucion;
    }

    public boolean isSintonizador() {
        return sintonizador;
    }

    public void setSintonizador(boolean sintonizador) {
        this.sintonizador = sintonizador;
    }

    public void crearTelevisor() {
        
        System.out.println("Ingrese las pulgadas del TV");
        resolucion = leer.nextInt();
        System.out.println("Posee un sintonizador? Y/N");
        String respuesta = leer.next().toUpperCase().substring(0);
        sintonizador = respuesta.equals("Y");
        
        super.crearElectrodomestico();

    }

    @Override
    public void precioFinal() {
        super.precioFinal();
        if (sintonizador) {
            precio = precio + 500.0;
        }
        if (resolucion > 40) {
            precio = precio * 1.30;
        }

    }
    
    public void mostrarTele(){
         
        System.out.println("El precio del televisor es igual a $" + precio);

}

}
