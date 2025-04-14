package it.prova.model.CentroCommerciale;

public class Item {
    private String codice;
    private String descrizione;
    private int prezzo;
    private Negozio negozioAppartenza;

    public Item(String codice, String descrizione, int prezzo) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }

    public Item(int prezzo, String codice) {
        this.prezzo = prezzo;
        this.codice = codice;
    }

    public Item() {
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public Negozio getNegozioAppartenza() {
        return negozioAppartenza;
    }

    public void setNegozioAppartenza(Negozio negozioAppartenza) {
        this.negozioAppartenza = negozioAppartenza;
    }
}
