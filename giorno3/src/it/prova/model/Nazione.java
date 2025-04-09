package it.prova.model;

public class Nazione {
    private String denominazione;
    private double superficieKmQ;
    private int abitanti;

    @Override
    public String toString() {
        return "Nazione: " + denominazione + ", Abitanti: " + abitanti + ", Superficie: " + superficieKmQ + " km quadrati";
    }


    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public double getSuperficieKmQ() {
        return superficieKmQ;
    }

    public void setSuperficieKmQ(double superficieKmQ) {
        this.superficieKmQ = superficieKmQ;
    }

    public int getAbitanti() {
        return abitanti;
    }

    public void setAbitanti(int abitanti) {
        this.abitanti = abitanti;
    }
}
