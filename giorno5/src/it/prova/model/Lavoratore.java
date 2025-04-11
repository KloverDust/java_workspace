package it.prova.model;

public class Lavoratore {
    protected String nome;
    protected String cognome;
    protected String hobby;

    public String percepisco() {
        return "Not defined";
    }

    public String ilMioHobbyE(){
        return this.hobby;
    }

    public String vivo(){
        return ("In quanto lavoratore sono un essere vivente");
    }

}
