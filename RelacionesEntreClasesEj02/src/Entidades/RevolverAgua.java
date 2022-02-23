package Entidades;

import java.util.ArrayList;

public class RevolverAgua {

    private Integer posicionAgua, posicionActual, cantPosiciones = 6;

    public RevolverAgua() {

    }

    public RevolverAgua(Integer posicionAgua) {
        this.posicionAgua = posicionAgua;
    }

    public Integer getPosicionAgua() {
        return posicionAgua;
    }

    public void setPosicionAgua(Integer posicionAgua) {
        this.posicionAgua = posicionAgua;
    }

    public Integer getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(Integer posicionActual) {
        this.posicionActual = posicionActual;
    }

    public Integer getCantPosiciones() {
        return cantPosiciones;
    }

    public void setCantPosiciones(Integer cantPosiciones) {
        this.cantPosiciones = cantPosiciones;
    }

    @Override
    public String toString() {
        return "RevolverAgua{" + "posicionAgua=" + posicionAgua + ", posicionActual=" + posicionActual + ", cantPosiciones=" + cantPosiciones + '}';
    }

}
