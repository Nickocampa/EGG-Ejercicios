/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Subclases.Barcos;
import Subclases.Motor;
import Subclases.Velero;
import Subclases.Yate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author NCampanella
 */
public class BarcosService {

    Scanner leer = new Scanner(System.in);

    ArrayList<Barcos> barcosDisponibles = new ArrayList();
    Velero barco1,barco2;
    Motor barco3,barco4;
    Yate barco5,barco6;
    int opcion=0;

    public ArrayList<Barcos> crearBarcos() {

        barco1 = new Velero("ABC123", 25, new Date(), 2);
        barcosDisponibles.add(barco1);
        barco2 = new Velero("XYZ123", 50, new Date(), 4);
        barcosDisponibles.add(barco2);
        barco3 = new Motor("BCD123", 26, new Date(), 100);
        barcosDisponibles.add(barco3);
        barco4 = new Motor("WXY123", 25, new Date(), 50);
        barcosDisponibles.add(barco4);
        barco5 = new Yate("CDE123", 50, new Date(), 50, 2);
        barcosDisponibles.add(barco5);
        barco6 = new Yate("WXY123", 75, new Date(), 75, 6);
        barcosDisponibles.add(barco6);
        
        return barcosDisponibles;

    }

    public void mostrarBarcos() {
        int i = 1;
        System.out.println("Estos barcos son los disponibles");
        for (Barcos auxiliarBarcosDisponibles : barcosDisponibles) {

            System.out.println("Barco # " + i + " - " + auxiliarBarcosDisponibles.toString());
            i++;
        }

    }

    public Barcos seleccionarBarco() {
        Barcos barcoSeleccionado = null;
        System.out.println(" ");
        System.out.println("Ingrese el numero del barco deseado");
        opcion = leer.nextInt() - 1;
        if (opcion >= 0 && opcion < 6) {
            barcoSeleccionado = barcosDisponibles.get(opcion);
            System.out.println(barcoSeleccionado.toString());
        } else {
            System.out.println("La opcion seleccionada no esta disponible");
            seleccionarBarco();
        }

        return barcoSeleccionado;

    }
     
    
    public ArrayList<Integer> sacarDatos(){
        
        ArrayList<Integer> listaDatos = new ArrayList();
        
        listaDatos.add(barco1.getMastiles());
        listaDatos.add(barco2.getMastiles());
        listaDatos.add(barco3.getPotencia());
        listaDatos.add(barco4.getPotencia());
        listaDatos.add(barco5.getPotencia());
        listaDatos.add(barco5.getCamarotes());
        listaDatos.add(barco6.getPotencia());
        listaDatos.add(barco6.getCamarotes());
        listaDatos.add(opcion);
        
        
        return listaDatos;
        
    }
    
}
