package it.prova.model;

public class DVD extends MaterialeBiblioteca {
    private int durata; // in minuti

    public DVD(int durata, String titolo, String autore, String codiceIdentificativo, boolean disponibile) {
        super(titolo, autore, codiceIdentificativo, disponibile);
        this.durata = durata;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    @Override
    public int calcolaTempoPrestitoMassimo() {
        return 7; // Prestito più breve per DVD
    }
}
