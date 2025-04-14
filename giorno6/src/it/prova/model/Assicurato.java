package it.prova.model;

import java.util.ArrayList;
import java.util.List;

public class Assicurato {
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private float rataPremioAssicurativo;
    //private ArrayList <Assicurato> assicurati;

    public Assicurato(String nome, String cognome, String cf, float rpa){
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = cf;
        this.rataPremioAssicurativo = rpa;
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

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public float getRataPremioAssicurativo() {
        return rataPremioAssicurativo;
    }

    public void setRataPremioAssicurativo(float rataPremioAssicurativo) {
        this.rataPremioAssicurativo = rataPremioAssicurativo;
    }

    public boolean presenteInElenco(ArrayList<Assicurato> assicurati){
        for(Assicurato ass: assicurati) {
            if(this.codiceFiscale.equals(ass.getCodiceFiscale()))
                return true;
        }
        return false;
    }

    public static int quantiConInizialeNelCognome(ArrayList<Assicurato> assicurati, char iniziale) {
        int cognomiStessaIniziale = 0;
        for (Assicurato assic: assicurati){
            if (assic.getCognome().charAt(0) == iniziale)
                cognomiStessaIniziale++;
        }
        return cognomiStessaIniziale;
    }

    public static ArrayList<String> estraiSoloICognomi(ArrayList<Assicurato> assicurati){
        ArrayList<String> listaCognomi = new ArrayList<String>();
        for (Assicurato assic: assicurati){
            listaCognomi.add(assic.getCognome());
        }
        return listaCognomi;
    }

    public static ArrayList<Assicurato> estraiQuelliConRataMaggioreDi(ArrayList<Assicurato> assicurati, int sogliaRata){
        ArrayList<Assicurato> assicuratiConRataMaggiore = new ArrayList<Assicurato>();
        for (Assicurato assic: assicurati){
            if (assic.getRataPremioAssicurativo() > sogliaRata){
                assicuratiConRataMaggiore.add(assic);
            }
        }
        return assicuratiConRataMaggiore;
    }

}
