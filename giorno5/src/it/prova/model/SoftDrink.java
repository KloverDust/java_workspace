package it.prova.model;

public class SoftDrink extends Bevanda{
    private boolean frizzante;
    private boolean zuccheroArtificiale;

    public SoftDrink(String nome, int quantita, boolean frizzante, boolean zuccheroArtificiale) {
        super(nome);
        super.quantita = quantita;
        this.frizzante = frizzante;
        this.zuccheroArtificiale = zuccheroArtificiale;
    }

    public boolean isFrizzante() {
        return frizzante;
    }

    public void setFrizzante(boolean frizzante) {
        this.frizzante = frizzante;
    }

    public boolean isZuccheroArtificiale() {
        return zuccheroArtificiale;
    }

    public void setZuccheroArtificiale(boolean zuccheroArtificiale) {
        this.zuccheroArtificiale = zuccheroArtificiale;
    }
}
