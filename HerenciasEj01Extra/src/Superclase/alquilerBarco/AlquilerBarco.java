package Superclase.alquilerBarco;

import Service.BarcosService;
import Subclases.Barcos;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AlquilerBarco {

    Scanner leer = new Scanner(System.in);

    private Date comienzoAlquiler;
    private Date finalAlquiler;
    private Barcos barcoAlquilado;
    private String nombre;
    private String dni;
    private Integer posicionAmarre;

    public AlquilerBarco() {
    }

    public AlquilerBarco(Date comienzoAlquiler, Date finalAlquiler, Barcos barcoAlquilado, String nombre, String dni, Integer posicionAmarre) {
        this.comienzoAlquiler = comienzoAlquiler;
        this.finalAlquiler = finalAlquiler;
        this.barcoAlquilado = barcoAlquilado;
        this.nombre = nombre;
        this.dni = dni;
        this.posicionAmarre = posicionAmarre;
    }

    public Date getComienzoAlquiler() {
        return comienzoAlquiler;
    }

    public void setComienzoAlquiler(Date comienzoAlquiler) {
        this.comienzoAlquiler = comienzoAlquiler;
    }

    public Date getFinalAlquiler() {
        return finalAlquiler;
    }

    public void setFinalAlquiler(Date finalAlquiler) {
        this.finalAlquiler = finalAlquiler;
    }

    public Barcos getBarcoAlquilado() {
        return barcoAlquilado;
    }

    public void setBarcoAlquilado(Barcos barcoAlquilado) {
        this.barcoAlquilado = barcoAlquilado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getPosicionAmarre() {
        return posicionAmarre;
    }

    public void setPosicionAmarre(Integer posicionAmarre) {
        this.posicionAmarre = posicionAmarre;
    }

    public void alquilarBarco(Barcos barcoSeleccionado) {

        System.out.println("Ingrese su nombre");
        nombre = leer.next();
        System.out.println("Ingrese su DNI");
        dni = leer.next();
        barcoAlquilado = barcoSeleccionado;
        System.out.println("Ingrese la fecha de alquiler DD/MM/AAAA");
        int dia = leer.nextInt();
        int mes = leer.nextInt();
        int anio = leer.nextInt();
        comienzoAlquiler = new Date(anio - 1900, mes - 1, dia);
        System.out.println(comienzoAlquiler);

    }

    public void mostrarPrecio(ArrayList<Integer> datosBarcos) {

        int moduloBase = barcoAlquilado.getEslora() * 10;
        System.out.println("Ingrese la fecha de devolucion DD/MM/AAAA");
        int dia = leer.nextInt();
        int mes = leer.nextInt();
        int anio = leer.nextInt();
        finalAlquiler = new Date(anio - 1900, mes - 1, dia);
        long dias = (finalAlquiler.getTime() - comienzoAlquiler.getTime()) / 86400000;
        int opcion = datosBarcos.get(8);
        int moduloTotal = 0;
        switch (opcion) {
            case 0:
                moduloTotal = moduloBase + datosBarcos.get(0);
                break;
            case 1:
                moduloTotal = moduloBase + datosBarcos.get(1);
                break;
            case 2:
                moduloTotal = moduloBase + datosBarcos.get(2);
                break;
            case 3:
                moduloTotal = moduloBase + datosBarcos.get(3);
                break;
            case 4:
                moduloTotal = moduloBase + datosBarcos.get(4) + datosBarcos.get(5);
                break;
            case 5:
                moduloTotal = moduloBase + datosBarcos.get(6) + datosBarcos.get(7);
                break;
            default:
        }
        
        long precioTotal = moduloTotal * dias;
        
        System.out.println("El precio total del alquiler es $" + precioTotal);
    }

}
