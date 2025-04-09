package it.prova.model;

public class Nazione {
    private String denominazione;
    private double superficieKmQ;
    private int abitanti;

    public Nazione () {

    }

    public Nazione(String denominazione, double superficieKmQ, int abitanti) {
        this.denominazione = denominazione;
        this.superficieKmQ = superficieKmQ;
        this.abitanti = abitanti;
    }

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

    public boolean piuEstesaDi(Nazione input) {
        return (this.superficieKmQ > input.getSuperficieKmQ());
    }

    public boolean piuPopolosaDi(Nazione input) {
        return (this.abitanti > input.getAbitanti());
    }

    public boolean esisteAlmenoUnaPiuEstesa(Nazione[] nazioni) {
        for(int i=0; i< nazioni.length; i++) {
            if(this.superficieKmQ< nazioni[i].getSuperficieKmQ())
                return true;
        }
        return false;
    }

    public int dimmiQuanteSonoPiuPopolose(Nazione[] nazioni) {
        int counter = 0;
        for(int i=0; i<nazioni.length; i++) {
            if(this.abitanti < nazioni[i].getAbitanti())
                counter++;
        }
        return counter;
    }

    public boolean haPiuAbitantiDiTutteLeAltre(Nazione[] nazioni) {
        int popolazioneMax = this.abitanti;
        for (int i=0; i<nazioni.length; i++) {
            if (popolazioneMax< nazioni[i].getAbitanti()){
                return false;
            }
        }
        return true;
    }

}
