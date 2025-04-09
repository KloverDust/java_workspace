package it.prova.model;

public class Studente {
    private String nome;
    private String cognome;
    private int eta;
    float mediaScolastica;

    public Studente() {

    }

    public Studente(String nome, String cognome, int eta, float mediaScolastica) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.mediaScolastica = mediaScolastica;
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

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public float getMediaScolastica() {
        return mediaScolastica;
    }

    public void setMediaScolastica(float mediaScolastica) {
        this.mediaScolastica = mediaScolastica;
    }

    public boolean sonoTuttiPiuGiovaniDiMe(Studente[] corso){
        int miaEta= this.eta;
        for (Studente matricola: corso) {
            if(miaEta<=matricola.getEta())
                return false;
        }
        return true;
    }
}
