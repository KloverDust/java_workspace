package it.prova.model;

public class Operaio extends Lavoratore{
    private int salario;

    public String percepisco(){
        return ("Io percepisco " + salario);
    }

    public String ilMioHobbyE(){
        return ("In quanto operaio non ho tempo per i hobby");
    }

}
