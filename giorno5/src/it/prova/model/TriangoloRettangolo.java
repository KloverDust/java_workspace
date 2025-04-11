package it.prova.model;

public class TriangoloRettangolo extends FiguraGeometrica{
    private int ipotenusa;

    public TriangoloRettangolo(int base, int altezza, int ipotenusa){
        super(base, altezza);
        this.ipotenusa = ipotenusa;
    }

    public int getIpotenusa() {
        return ipotenusa;
    }

    public void setIpotenusa(int ipotenusa) {
        this.ipotenusa = ipotenusa;
    }

    @Override
    public float calcolaArea() {
        return ((float) (base * altezza) / 2);
    }

    @Override
    public float calcolaPerimetro() {
        return (float) (base + altezza + ipotenusa);
    }
}
