package it.prova.model;

public class Persona {
    private String nome;
    private String cognome;
    private int eta;
    private Indirizzo indirizzo;


    public Persona(String nome, String cognome, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }


    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo( Indirizzo indirizzo) {
         this.indirizzo = indirizzo;
    }

    public Persona () {

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

    public boolean abitaA(String cittaInput){
       String cittaAbitazione = this.getIndirizzo().getCitta();
       return (cittaAbitazione.equals(cittaInput));
    }

    public boolean haAlmenoUnConcittadino(Persona[] elenco) {
        String cittaPersona = this.getIndirizzo().getCitta();
        for (int i=0; i< elenco.length; i++) {
            if (cittaPersona.equals(elenco[i].getIndirizzo().getCitta()))
                return true;
        }
        return false;

    }

    
}
