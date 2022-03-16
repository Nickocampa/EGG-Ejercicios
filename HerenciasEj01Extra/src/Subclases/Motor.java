package Subclases;

import java.util.Date;

public class Motor extends Barcos {

    private Integer potencia;

    public Motor(String matricula, Integer eslora, Date fechaFabricacion, Integer potencia) {
        super(matricula, eslora, fechaFabricacion);
        this.potencia = potencia;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        
        return "Motor de " + potencia +  " CV de potencia " +" " + super.toString();
    }
    
    

}
