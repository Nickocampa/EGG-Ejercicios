package Subclases;

import java.util.Date;

public class Yate extends Motor {

    private Integer camarotes;

    public Yate(String matricula, Integer eslora, Date fechaFabricacion, Integer potencia, Integer camarotes) {
        super(matricula, eslora, fechaFabricacion, potencia);
        this.camarotes = camarotes;
    }

    public Integer getCamarotes() {
        return camarotes;
    }

    public void setCamarotes(Integer camarotes) {
        this.camarotes = camarotes;
    }

    @Override
    public String toString() {
        return "Yate de " + camarotes + " camarotes " + super.toString();
    }

    
}
