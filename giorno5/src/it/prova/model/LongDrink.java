package it.prova.model;

public class LongDrink extends Bevanda{
    private float contenutoAlcolico;
    public LongDrink(String nome, int quantita, float contenutoAlcolico) {
        super(nome, quantita);
        this.contenutoAlcolico = contenutoAlcolico;
    }

    public float getContenutoAlcolico() {
        return contenutoAlcolico;
    }

    public void setContenutoAlcolico(float contenutoAlcolico) {
        this.contenutoAlcolico = contenutoAlcolico;
    }
}
