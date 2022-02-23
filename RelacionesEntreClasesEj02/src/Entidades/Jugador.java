package Entidades;

import RuletaService.RevolverAguaService;
import java.util.ArrayList;
import java.util.Scanner;

public class Jugador {

    Scanner leer = new Scanner(System.in);

    private Integer iD;
    private String nombrePlayer;
    private boolean mojado;
    int numJugadores = 0;
    private RevolverAgua rev1 = new RevolverAgua();
    RevolverAguaService rAS1 = new RevolverAguaService();

    public Jugador() {
      
    }

    public Integer getiD() {
        return iD;
    }

    public void setiD(Integer iD) {
        this.iD = iD;
    }

    public String getNombrePlayer() {
        return nombrePlayer;
    }

    public void setNombrePlayer(String nombrePlayer) {
        this.nombrePlayer = nombrePlayer;
    }

    public boolean isMojado() {
        return mojado;
    }

    public void setMojado(boolean mojado) {
        this.mojado = mojado;
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }

    public RevolverAgua getRev1() {
        return rev1;
    }

    public void setRev1(RevolverAgua rev1) {
        this.rev1 = rev1;
    }

    public RevolverAguaService getrAS1() {
        return rAS1;
    }

    public void setrAS1(RevolverAguaService rAS1) {
        this.rAS1 = rAS1;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombrePlayer=" + nombrePlayer + ", mojado=" + mojado + '}';
    }
    
    public int cargarJugadores() {

        System.out.println("Ingrese el numero de jugadores * de 1 a 6 *");
        numJugadores = leer.nextInt();
        if (numJugadores < 1 || numJugadores > 6) {
            numJugadores = 6;
            cargarJugador(numJugadores);
        } else {
            cargarJugador(numJugadores);
        }

        return numJugadores;

    }

    public ArrayList cargarJugador(int numJugadores) {

        ArrayList aux = new ArrayList();

        for (int i = 0; i < numJugadores; i++) {
            Jugador jugadorx = new Jugador();
            String nombreJugador = "Jugador";
            jugadorx.setiD(i);
            jugadorx.setNombrePlayer(nombreJugador + " N# 0" + (i+1));
            aux.add(jugadorx);

        }
        
        //devuelvo el arraylist aux con los jugadores.
        return aux;
    }

    public RevolverAgua disparo() {

        //llenar revolver - ajusta posicion de agua
        //posicionActual - ajusta la posicion actual del tambor
        //revulvo rev1 con las posiciones.
        rev1 = rAS1.llenarRevolver();
        rAS1.posicionActual(rev1);

        return rev1;
    }
    
   
}
