package it.prova.model;

public class Rivista extends MaterialeBiblioteca {
    private int numeroEdizione;
    private int annoPubblicazione;

    public Rivista(int numeroEdizione, int annoPubblicazione, String titolo, String autore, String codiceIdentificativo, boolean disponibile) {
        super(titolo, autore, codiceIdentificativo, disponibile);
        this.numeroEdizione = numeroEdizione;
        this.annoPubblicazione = annoPubblicazione;
    }

    public Rivista(){
        super();
        //this.numeroEdizione = 0; posso anche ometterli, java li assegnerebbe in automatico
        //this.annoPubblicazione = 0;
    }

    public int getNumeroEdizione() {
        return numeroEdizione;
    }

    public void setNumeroEdizione(int numeroEdizione) {
        this.numeroEdizione = numeroEdizione;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    @Override
    public int calcolaTempoPrestitoMassimo() {
        return 14;
    }
}
