package it.prova.model;

public class Volontario extends Lavoratore {
    private String nomeAssociazione;

    public String percepisco(){
        return (this.nomeAssociazione + " E' no profit");
    }

    public String ilMioHobbyE(){
        return ("In quanto volontario il mio hobby è aiutare gli animali");
    }
}
