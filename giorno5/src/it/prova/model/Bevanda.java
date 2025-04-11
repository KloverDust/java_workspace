package it.prova.model;

public class Bevanda {
    protected String nome;
    protected String[] ingredienti;
    protected int quantita;

    public Bevanda(String nome) {
        this.nome = nome;
    }

    public Bevanda(String nome, int quantita){
        this.nome= nome;
        this.quantita = quantita;
    }

    public Bevanda(String nome, int quantita, String[] ingredienti ){
        this.nome = nome;
        this.quantita = quantita;
        this.ingredienti = ingredienti;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String[] getIngredienti() {
        return ingredienti;
    }

    public void setIngredienti(String[] ingredienti) {
        this.ingredienti = ingredienti;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public static int quantiPadri(Bevanda[] bevande) {
        int instanziatiTramiteSuperclasse = 0;
        for (Bevanda bevanda: bevande) {
            if (bevanda instanceof Bevanda)
                instanziatiTramiteSuperclasse++;
        }
        return instanziatiTramiteSuperclasse;
    }
}
