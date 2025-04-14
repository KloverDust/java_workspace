package it.prova.model.CentroCommerciale;

public abstract class Lavoratore {
    protected String nome;
    protected String cognome;
    protected Negozio negozioAppartenenza;

    public Lavoratore(String nome, String cognome){
        this.nome = nome;
        this.cognome = cognome;
    }

    public Lavoratore() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Negozio getNegozioAppartenenza() {
        return negozioAppartenenza;
    }

    public void setNegozioAppartenenza(Negozio negozioAppartenenza) {
        this.negozioAppartenenza = negozioAppartenenza;
    }

    public abstract boolean handleItemAdd(Item item);

    public abstract boolean handleItemRemove(Item item);
}
