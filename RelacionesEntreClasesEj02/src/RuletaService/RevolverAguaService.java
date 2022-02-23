package RuletaService;

import Entidades.Jugador;
import Entidades.RevolverAgua;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class RevolverAguaService {

    ArrayList<Jugador> mojados = new ArrayList();
    Scanner leer = new Scanner(System.in);
    int t = 0;

    public RevolverAgua llenarRevolver() {

        System.out.println("");
        System.out.println("PRIMERO VAMOS A LLENAR EL REVOLVER");
        System.out.println("-----------------------------------");
        System.out.println("presione una tecla para continuar");
        String a = leer.next();

        int posicionAgua = (int) (Math.random() * (5 - 0)) + 0;

        RevolverAgua rev1 = new RevolverAgua(posicionAgua);

        return rev1;
    }

    public RevolverAgua posicionActual(RevolverAgua rev1) {

        System.out.println("");
        System.out.println("AHORA VAMOS A GIRAR EL TAMBOR ");
        System.out.println("------------------------------");
        System.out.println("presione una tecla para continuar");
        String a = leer.next();
        girarTambor();

        int posicionActual = (int) (Math.random() * (5 - 0)) + 0;
        rev1.setPosicionActual(posicionActual);

        return rev1;

    }

    public void girarTambor() {

        System.out.println(" ");
        System.out.println("------------");
        System.out.println("      *     ");
        System.out.println("  *       * ");
        System.out.println("            ");
        System.out.println("  *       * ");
        System.out.println("      *     ");
        System.out.println("------------");
    }

    public boolean chequearJuego(RevolverAgua rev1) {
        boolean mojadoSiNo = false;

        mojadoSiNo = rev1.getPosicionActual().equals(rev1.getPosicionAgua());
        return mojadoSiNo;

    }

    public RevolverAgua siguienteChorro(RevolverAgua rev1) {
        System.out.println("");
        System.out.println("VAMOS A LA PROXIMA CAMARA");
        System.out.println("--------------------------");

        if (rev1.getPosicionActual() < 5) {
            Integer newPosicion = rev1.getPosicionActual() + 1;
            rev1.setPosicionActual(newPosicion);
            chequearJuego(rev1);
        } else {
            rev1.setPosicionActual(0);
        }
        chequearJuego(rev1);
        return rev1;
    }

    public void mojar(ArrayList jugadores, RevolverAgua rev1) {

        System.out.println("presione una tecla para continuar");
        String a = leer.next();

        Jugador player = new Jugador();
        int contador = jugadores.size();
        int i = t;

        do {

            player = (Jugador) jugadores.get(i);

            player.setMojado(chequearJuego(rev1));

            if (player.isMojado()) {

                mojados.add(player);

            } else {
                System.out.println("--------------------------");
                System.out.println("-------JUGADOR # " + (i + 1) + "--------");
                System.out.println("¡¡¡¡¡¡¡TE SALVASTE!!!!!!!!");
                System.out.println("--------------------------");
                t++;
                RevolverAgua revaux = new RevolverAgua();
                revaux = siguienteChorro(rev1);
                mojar(jugadores, revaux);
            }

        } while (!player.isMojado());

    }

    public void imprimir() {
        
        System.out.println("--------------------------");
        System.out.println("----- " + (mojados.get(0).getNombrePlayer() + "--------"));
        System.out.println("¡¡¡¡¡¡¡TE MOJASTE!!!!!!!!!");
        System.out.println("--------------------------");
        System.out.println("*********GAME OVER********");
        System.out.println("--------------------------");
    }

}
