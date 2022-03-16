package Subclases;

import java.util.Date;

public abstract class Barcos {

    protected String matricula;
    protected Integer eslora;
    protected Date fechaFabricacion = new Date();

    public Barcos() {

    }

    public Barcos(String matricula, Integer eslora, Date fechaFabricacion) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.fechaFabricacion = fechaFabricacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getEslora() {
        return eslora;
    }

    public void setEslora(Integer eslora) {
        this.eslora = eslora;
    }

    public Date getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(Date fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    @Override
    public String toString() {
        return "matricula=" + matricula + ", eslora=" + eslora + ", fechaFabricacion=" + (fechaFabricacion.getYear() + 1900);
    }

}
