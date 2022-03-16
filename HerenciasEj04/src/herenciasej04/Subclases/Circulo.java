package herenciasej04.Subclases;

import herenciasej04.Superclase.calculoFormas;

public class Circulo implements calculoFormas {

    private Double radio;

    public Circulo() {
    }

    public Circulo(Double radio) {
        this.radio = radio;
    }

    public Double getRadio() {
        return radio;
    }

    public void setRadio(Double radio) {
        this.radio = radio;
    }

    @Override
    public void area() {

        Double areaCirculo = PII * radio * radio;
        System.out.println("El area del circulo es " + areaCirculo);

    }

    @Override
    public void perimetro() {

        Double perimetroCirculo = PII * radio * 2;
        System.out.println("El perimetro del circulo es " + perimetroCirculo);

    }

}
