package it.prova.model;

public class Operaio extends Lavoratore{
    private int salario;

    public Operaio(){

    }

    public Operaio(String nome, String cognome){
        super.nome = nome;
        super.cognome = cognome;
    }

    public Operaio(String nome, String cognome, int salario){
        super.nome = nome;
        super.cognome = cognome;
        this.salario = salario;
    }

    public String percepisco(){
        return ("Io percepisco " + salario);
    }

    public String ilMioHobbyE(){
        return ("In quanto operaio non ho tempo per i hobby");
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
}
