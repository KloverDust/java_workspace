package it.prova.model;

public class MaterialeBiblioteca {
    protected String titolo;
    protected String autore;
    protected String codiceIdentificativo;
    protected boolean disponibile;

    public MaterialeBiblioteca(String titolo, String autore, String codiceIdentificativo, boolean disponibile){
        this.titolo = titolo;
        this.autore = autore;
        this.codiceIdentificativo = codiceIdentificativo;
        this.disponibile = disponibile;
    }

    public  MaterialeBiblioteca() {

    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getCodiceIdentificativo() {
        return codiceIdentificativo;
    }

    public void setCodiceIdentificativo(String codiceIdentificativo) {
        this.codiceIdentificativo = codiceIdentificativo;
    }

    public boolean isDisponibile() {
        return disponibile;
    }

    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }

    public void prestito(){
        setDisponibile(false);
        //oppure this.disponibile = false;
    }

    public void restituzione(){
        setDisponibile(true);
        //oppure this.disponibile = true;
    }

    public int calcolaTempoPrestitoMassimo() {
        return 14;
    }
}
