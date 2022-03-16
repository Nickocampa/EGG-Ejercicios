package herenciasej04.Subclases;

import herenciasej04.Superclase.calculoFormas;

public class Rectangulo implements calculoFormas {

    private Double base, altura;

    public Rectangulo() {
    }

    public Rectangulo(Double base, Double altura) {
        this.base = base;
        this.altura = altura;
    }

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    @Override
    public void area() {

        Double areaRectangulo = base * altura;
        System.out.println("El area del rectangulo es " + areaRectangulo);

    }

    @Override
    public void perimetro() {

        Double perimetroRectangulo = (base * 2) + (altura * 2);
        System.out.println("El perimetro del rectangulo es " + perimetroRectangulo);

    }

}
