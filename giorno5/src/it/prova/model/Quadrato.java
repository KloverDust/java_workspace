package it.prova.model;

public class Quadrato extends FiguraGeometrica{

    public Quadrato(int base, int altezza){
        super(base, altezza);
    }

    @Override
    public float calcolaArea() {
        return (float )(this.base * this.altezza);
    }

    @Override
    public float calcolaPerimetro() {
        return (float )(this.base * 4);
    }
}
