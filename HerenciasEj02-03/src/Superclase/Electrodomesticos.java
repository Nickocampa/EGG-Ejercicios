package Superclase;

import java.util.Scanner;

public abstract class Electrodomesticos {

    Scanner leer = new Scanner(System.in);
    Double precioConsumo = 0.0;
    Double precioPeso = 0.0;

//    Crear una superclase llamada Electrodoméstico con los siguientes atributos:
//precio, color, consumo energético (letras entre A y F) y peso.
    protected Double precio;
    protected String color;
    protected char consumo;
    protected Integer peso;

    public Electrodomesticos() {
    }

    public Electrodomesticos(Double precio, String color, char consumo, Integer peso) {
        this.precio = precio;
        this.color = color;
        this.consumo = consumo;
        this.peso = peso;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getConsumo() {
        return consumo;
    }

    public void setConsumo(char consumo) {
        this.consumo = consumo;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public void comprobarConsumoEnergetico(char letra) {

        
        switch (consumo) {
            case 'A':
                precioConsumo = 1000.0;
                break;
            case 'B':
                precioConsumo = 800.0;
                break;
            case 'C':
                precioConsumo = 600.0;
                break;
            case 'D':
                precioConsumo = 500.0;
                break;
            case 'E':
                precioConsumo = 300.0;
                break;
            default:
                precioConsumo = 100.0;

        }
    }

    public void comprobarColor(String color) {
        //blanco, negro, rojo, azul y gris.
        if (!color.equals("NEGRO") && !color.equals("ROJO") && !color.equals("AZUL") && !color.equals("GRIS")) {
            color.equals("BLANCO");
        }
    }

    public void crearElectrodomestico() {

        System.out.println("Ingrese el consumo de su electrodomestico");
        consumo = leer.next().toUpperCase().charAt(0);
        comprobarConsumoEnergetico(consumo);
        System.out.println("Ingrese el peso de su electrodomestico");
        peso = leer.nextInt();
        calculoPrecioPeso();
        System.out.println("Ingrese el color de la electrodomestico");
        color = leer.next().toUpperCase();
        comprobarColor(color);
        precioFinal();
    }

    public void calculoPrecioPeso() {

        if (peso > 0 && peso < 19) {
            precioPeso = 100.0;
        } else if (peso >= 20 && peso < 49) {
            precioPeso = 500.0;
        } else if (peso >= 50 && peso < 79) {
            precioPeso = 800.0;
        } else {
            precioPeso = 1000.0;
        }

    }

    public void precioFinal() {

        precio = precioConsumo + precioPeso + 1000.0;
    }
}
