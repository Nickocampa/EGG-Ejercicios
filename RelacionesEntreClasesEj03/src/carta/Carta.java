package carta;

import Enums.numeros;
import Enums.palos;

public class Carta {
    
    private numeros numero;
    private palos palo;

    public numeros getNumero() {
        return numero;
    }

    public void setNumero(numeros numero) {
        this.numero = numero;
    }

    public palos getPalo() {
        return palo;
    }

    public void setPalo(palos palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        return numero + " de " + palo +"\n";
    }
    
    
}
