package it.prova.model;

public class Lavoratore {
    protected String nome;
    protected String cognome;
    protected String hobby;

    public Lavoratore(){

    }

    public Lavoratore(String nome, String cognome){
        this.nome = nome;
        this.cognome = cognome;
    }

    public Lavoratore(String nome, String cognome, String hobby){
        this.nome = nome;
        this.cognome = cognome;
        this.hobby = hobby;
    }

    public String percepisco() {
        return "Not defined";
    }

    public String ilMioHobbyE(){
        return this.hobby;
    }

    public String vivo(){
        return ("In quanto lavoratore sono un essere vivente");
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

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
