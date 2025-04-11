package it.prova.model;

import static java.lang.Math.sqrt;

public class TriangoloEquilatero extends FiguraGeometrica{
    public TriangoloEquilatero(int base, int altezza){
        //super.base = base; /E' meglio utilizzare il metodo super
        //super.altezza = altezza;
        super(base, altezza);
    }

    @Override
    public float calcolaArea() {
        float altezza = (float) sqrt((this.base*this.base + this.altezza*this.altezza));
        return (this.base * altezza); // Potrei anche non usare this. ? Si potrei non usarlo
    }

    @Override
    public float calcolaPerimetro() {
        return (float) (this.base * 3);
    }
}
