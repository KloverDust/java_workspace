package it.prova.model;

public class FiguraGeometrica {
    protected int base;
    protected int altezza;

    public FiguraGeometrica (){

    }

    public FiguraGeometrica(int base, int altezza){
        this.base = base;
        this.altezza = altezza;
    }

    // Non ha senso passare un oggetto FiguraGeometrica come parametro qui,
    // perché il metodo dovrebbe lavorare sui dati dell'istanza corrente.
    // Se lo avessi fatto, avrebbe avuto più senso rendere il metodo statico.
    // Ma i metodi statici non possono usare 'this' o 'super', quindi non avrei
    // potuto accedere ai campi della classe o sovrascrivere il comportamento.

    //    public float calcolaPerimetro(FiguraGeometrica figuraGeometrica){
    //        return -1;
    //    }

    //    public float calcolaArea(FiguraGeometrica figuraGeometrica){
    //        return -1;
    //    }

    public float calcolaPerimetro(){
        return -1;
    }

    public float calcolaArea(){
        return -1;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltezza() {
        return altezza;
    }

    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }
}
