package MainEJ02Juego;

import Entidades.Jugador;
import Entidades.RevolverAgua;
import RuletaService.RevolverAguaService;
import java.util.ArrayList;

public class Juego {

    public static void main(String[] args) {

        ArrayList<Jugador> jugadores = new ArrayList();
        RevolverAguaService revolverServ = new RevolverAguaService();
        Jugador player = new Jugador();
        int i = 0;

        //Cargo un ARRAYLIST con los jugadores que se crean.
        //Cargar Jugadores me devuelve un INT  con el nro de jugadores //
        //Paso el numero a cargar jugador para que ejecute el numero de jugadores//
        jugadores = player.cargarJugador(player.cargarJugadores());
        System.out.println("Cantidad de Jugadores cargados: " + player.getNumJugadores());
        for (Jugador aux : jugadores) {
            System.out.println(aux);
        }
        System.out.println("");
        System.out.println("---COMENZAMOS EL JUEGO---");
        System.out.println("-------------------------");
        
        //Disparo llena el revolver , usa metodo mojar para cagar el revolver y devuelve rev1.
        RevolverAgua rev1 = player.disparo();
        
        //Con rev1 devuelto chequeo el juego.Paso rev1 con las posiciones.
        //Chequear Juego me trae un booleano y lo guardo en player 1.                        
        revolverServ.mojar(jugadores, rev1);
        revolverServ.imprimir();
       

    }

}
