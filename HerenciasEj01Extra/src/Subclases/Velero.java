package Subclases;

import java.util.Date;

public class Velero extends Barcos {

    private Integer mastiles;

    public Velero(String matricula, Integer eslora, Date fechaFabricacion, Integer mastiles) {
        super(matricula, eslora, fechaFabricacion);
        this.mastiles = mastiles;
    }

    public Integer getMastiles() {
        return mastiles;
    }

    public void setMastiles(Integer mastiles) {
        this.mastiles = mastiles;
    }

    @Override
    public String toString() {
        return "Velero de " + mastiles + " mastiles "  + super.toString();
    }

    

    

}
