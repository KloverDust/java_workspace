package it.prova.model;

import java.time.LocalDate;

public class Destinatario {
    private String nome;
    private String cognome;
    private int eta;
    private String indirizzo;
    private boolean possessoreDiContoCorrente;
    private PostaDiPaese postaDiPaese = new PostaDiPaese("Posta in città", "Roma 6 (RM)", LocalDate.of(2023, 1, 1));

    public Destinatario() {
    }


    public Destinatario(String nome, String cognome, String indirizzo) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
    }

    public Destinatario(String nome, String cognome, String indirizzo, int eta, boolean possessoreDiContoCorrente) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.eta = eta;
        this.possessoreDiContoCorrente = possessoreDiContoCorrente;
    }

    public Destinatario(String nome, String cognome, String indirizzo, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.eta = eta;
    }

    public Destinatario(String nome, String cognome, int eta, String indirizzo, boolean possessoreDiContoCorrente, PostaDiPaese postaDiPaese) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.indirizzo = indirizzo;
        this.possessoreDiContoCorrente = possessoreDiContoCorrente;
        this.postaDiPaese = postaDiPaese;
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

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public boolean isPossessoreDiContoCorrente() {
        return possessoreDiContoCorrente;
    }

    public void setPossessoreDiContoCorrente(boolean possessoreDiContoCorrente) {
        this.possessoreDiContoCorrente = possessoreDiContoCorrente;
    }

    public PostaDiPaese getPostaDiPaese() {
        return postaDiPaese;
    }

    public void setPostaDiPaese(PostaDiPaese postaDiPaese) {
        this.postaDiPaese = postaDiPaese;
    }
}
