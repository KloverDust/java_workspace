package it.prova.model;

public class PetSitter {
    private String nomeUtente;
    private String numeroTelefono;
    private int score;
    private float pagaOraria;

    public PetSitter(String nomeUtente, String numeroTelefono, int score, float pagaOraria){
        this.nomeUtente = nomeUtente;
        this.numeroTelefono = numeroTelefono;
        this.score = score;
        this.pagaOraria = pagaOraria;
    }

    public PetSitter() {

    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public float getPagaOraria() {
        return pagaOraria;
    }

    public void setPagaOraria(float pagaOraria) {
        this.pagaOraria = pagaOraria;
    }

}
