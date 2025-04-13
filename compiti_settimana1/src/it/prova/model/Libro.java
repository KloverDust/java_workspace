package it.prova.model;

public class Libro extends MaterialeBiblioteca{
    private int numeroPagine;
    private String genere;

    public Libro(int numeroPagine, String genere, String titolo, String autore, String codiceIdentificativo, boolean disponibile){
        super(titolo, autore, codiceIdentificativo, disponibile);
        this.numeroPagine = numeroPagine;
        this.genere = genere;
    }

    public Libro() {
        super();
        this.numeroPagine = 0;
        this.genere = null;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public int calcolaTempoPrestitoMassimo(){
        if(genere.equals("horror"))
            return 21;
        if(genere.equals("giallo") || genere.equals("romanzo"))
            return 28;
        if(genere.equals("fantasy") || genere.equals("fantascienza"))
            return 14;
        if(genere.equals("scienza"))
            return 7;

        return super.calcolaTempoPrestitoMassimo();
    }
}
