package it.prova.model;

public class Pet {
    private String animale;
    private String nomeAnimale;
    private String razza;
    private String nomeProprietario;
    private String cognomeProprietario;
    private String telefonoProprietario;
    private int eta;
    private boolean eSano;
    private PetSitter petSitter;


    public Pet(){

    }
    public Pet (String animale, String nomeAnimale, String nomeProprietario, String cognomeProprietario) {
        this.animale = animale;
        this.nomeAnimale = nomeAnimale;
        this.nomeProprietario = nomeProprietario;
        this.cognomeProprietario = cognomeProprietario;
    }

    public Pet (String animale, String nomeAnimale, String nomeProprietario, String cognomeProprietario, String telefonoProprietario) {
        this.animale = animale;
        this.nomeAnimale = nomeAnimale;
        this.nomeProprietario = nomeProprietario;
        this.cognomeProprietario = cognomeProprietario;
        this.telefonoProprietario = telefonoProprietario;
    }

    public String getAnimale() {
        return animale;
    }

    public void setAnimale(String animale) {
        this.animale = animale;
    }

    public String getNomeAnimale() {
        return nomeAnimale;
    }

    public void setNomeAnimale(String nomeAnimale) {
        this.nomeAnimale = nomeAnimale;
    }

    public String getRazza() {
        return razza;
    }

    public void setRazza(String razza) {
        this.razza = razza;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public String getCognomeProprietario() {
        return cognomeProprietario;
    }

    public void setCognomeProprietario(String cognomeProprietario) {
        this.cognomeProprietario = cognomeProprietario;
    }

    public String getTelefonoProprietario() {
        return telefonoProprietario;
    }

    public void setTelefonoProprietario(String telefonoProprietario) {
        this.telefonoProprietario = telefonoProprietario;
    }

    public boolean iseSano() {
        return eSano;
    }

    public void seteSano(boolean eSano) {
        this.eSano = eSano;
    }

    public PetSitter getPetSitter() {
        return petSitter;
    }

    public void setPetSitter(PetSitter petSitter) {
        this.petSitter = petSitter;
    }

    public int minutiPasseggiati
}
