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

    public static int contaQuantiPadri(Lavoratore[] input) {
        int padriCounter = 0;
        for(Lavoratore l: input) {
            if( l instanceof Lavoratore) {
                padriCounter++;
            }
        }
        return padriCounter;
    }

    // E' PIU GIUSTO METTERE QUESTI METODI NELLE CLASSI FIGLIE PERCHE' UN PADRE PUO ANCHE NON AVERE MAI FIGLI SU CUI INVOCARE TALE METODO
    public static int contaQuantiFigli(Lavoratore[] input) {
        int figliCounter = 0;
        for(Lavoratore l: input) {
            if(l instanceof Operaio || l instanceof Volontario)
                figliCounter++;
        }
        return figliCounter;
    }
    // NOTE: CHIEDERE SPIEGAZIONE MIGLIORATA



}
