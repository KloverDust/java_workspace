package it.prova.model;

public class Studente {
    private String nome;
    private String cognome;
    private int eta;
    private float mediaScolastica; // E' stata aggiunto private perché altrimenti sarebbe stato di tipo deafult

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

    public boolean almenoUnoHaLaMediaMiglioreDellaMia(Studente[] corso) {
        for (Studente s : corso) {
            if (s.getMediaScolastica() > this.mediaScolastica) {
                return true;
            }
        }
        return false;
    }

    public int numeroOmonimiMinorenni(Studente[] studenti) {
        String mioNome = this.nome;
        int counterOmonimi =0;
        for (Studente s: studenti) {
            if (mioNome.equals(s.getNome()) && s.getEta() <18)
                counterOmonimi++;
        }
        return counterOmonimi;
    }

    public static int contaStudentiConMediaSufficiente(Studente[] studenti) {
        int counter = 0;
        for (Studente s : studenti) {
            if (s.getMediaScolastica() >= 18) {
                counter++;
            }
        }
        return counter;
    }


}
