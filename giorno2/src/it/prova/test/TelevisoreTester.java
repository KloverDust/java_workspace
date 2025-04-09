package it.prova.test;

import it.prova.model.Televisore;

public class TelevisoreTester {
    public static void main (String[] args) {

        Televisore samsungHD32 = new Televisore();
        samsungHD32.setMarca("samsung");
        samsungHD32.setPrezzo(499);
        samsungHD32.setPollici(32);
        samsungHD32.setModello("HD");

        Televisore lgUltraHD40 = new Televisore();
        lgUltraHD40.setMarca("LG");
        lgUltraHD40.setPrezzo(599);
        lgUltraHD40.setPollici(40);
        lgUltraHD40.setModello("UltraHD");

        boolean costaMenoDelSecondo = samsungHD32.costaMenoDelBudgetDisponibile(500);
        boolean marcheCoincidenti = samsungHD32.stessaMarcaDi(lgUltraHD40);

        System.out.println("Il televisore " + samsungHD32.getMarca() + " costa meno del budget previsto? " + costaMenoDelSecondo);
        System.out.println("Il televisore " + samsungHD32.getMarca() + " è della stessa marca del " + lgUltraHD40.getMarca() + " ? " + marcheCoincidenti);

    }

}
