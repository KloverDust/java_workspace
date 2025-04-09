package it.prova.model;

public class Persona {
    private String nome;
    private String cognome;
    private int eta;

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

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public boolean ePiuAnziano(Persona personaDiConfronto){
        if (this.eta > personaDiConfronto.getEta()) {
            //System.out.println(this.getNome() + " è più grande di " + personaDiConfronto.getNome() );
            return true;
        }
        return false;
    }
}
