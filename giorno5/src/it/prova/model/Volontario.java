package it.prova.model;

public class Volontario extends Lavoratore {
    private String nomeAssociazione;

    public Volontario(String nome, String cognome, String nomeAssociazione){
        this.nome = nome;
        this.cognome = cognome;
        this.nomeAssociazione = nomeAssociazione;
    }

    public String percepisco(){
        return (this.nomeAssociazione + " E' no profit");
    }

    public String ilMioHobbyE(){
        return ("In quanto volontario il mio hobby è aiutare gli animali");
    }

    public static int contaQuantiVolontari(Lavoratore[] input) {
        int figliCounter = 0;
        for(Lavoratore l: input) {
            if(l instanceof Operaio)
                figliCounter++;
        }
        return figliCounter;
    }
}
