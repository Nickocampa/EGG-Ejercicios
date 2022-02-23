/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparadores;

import Pelicula.Pelicula;
import java.util.Comparator;

/**
 *
 * @author NCampanella
 */
public class Comparators {
    
    public static Comparator<Pelicula> duracionMayMen = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula t, Pelicula t1) {
            return t1.getDuracion().compareTo(t.getDuracion());
        }  
    };   
    
    public static Comparator<Pelicula> duracionMenMay = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula t, Pelicula t1) {
            return t.getDuracion().compareTo(t1.getDuracion());
        }  
    };
    
    public static Comparator<Pelicula> tituloAZ = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula t, Pelicula t1) {
            return t1.getTitulo().compareToIgnoreCase(t.getTitulo());
        }
    };
    
    public static Comparator<Pelicula> directorAZ = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula t, Pelicula t1) {
            return t1.getDirector().compareToIgnoreCase(t.getDirector());
        }
    };
    
}
