package it.prova.test;
import it.prova.model.Televisore;

public class TelevisoreTester {
    public static void main (String[] args) {

        Televisore samsungHD32 = new Televisore();
        samsungHD32.setMarca("Samsung");
        samsungHD32.setPrezzo(499);
        samsungHD32.setPollici(32);
        samsungHD32.setModello("HD");

        Televisore lgUltraHD40 = new Televisore();
        lgUltraHD40.setMarca("LG");
        lgUltraHD40.setPrezzo(999);
        lgUltraHD40.setPollici(40);
        lgUltraHD40.setModello("UltraHD");

        boolean costaMenoDelSecondo = samsungHD32.costaMenoDelBudgetDisponibile(500);
        System.out.println("Test costaMenoDelBudgetDisponibile");
        System.out.println("Start.....");
        System.out.println("Il televisore " + samsungHD32.getMarca() + " costa meno del budget previsto? " + costaMenoDelSecondo);
        System.out.println("End.......");
        System.out.println(".......... \n");

        boolean marcheCoincidenti = samsungHD32.stessaMarcaDi(lgUltraHD40);
        System.out.println("Test stessaMarcaDi");
        System.out.println("Start.....");
        System.out.println("Il televisore " + samsungHD32.getMarca() + " è della stessa marca del " + lgUltraHD40.getMarca() + " ? " + marcheCoincidenti);
        System.out.println("End.......");
        System.out.println(".......... \n");

        boolean piuGrandeDi = samsungHD32.piuGrandeDi(lgUltraHD40);
        System.out.println("Test piuGrandeDi");
        System.out.println("Start.....");
        System.out.println("Il televisore " + samsungHD32.getPollici() + " è più grande di " + lgUltraHD40.getPollici() + " ? " + piuGrandeDi);
        System.out.println("End.......");
        System.out.println(".......... \n");

        boolean miglioreQualitaPrezzo = samsungHD32.miglioreQualitaPrezzoDi(lgUltraHD40);
        System.out.println("Test miglioreQualitaPrezzoDi");
        System.out.println("Start.....");
        System.out.println("Il televisore " + samsungHD32.getMarca() + " è migliore per qualita-prezzo di " + lgUltraHD40.getMarca() + " ? " + miglioreQualitaPrezzo);
        System.out.println("End.......");
        System.out.println(".......... \n");

        Televisore tv1 = new Televisore("Siemens", 299, "4K", 21);
        Televisore tv2= new Televisore("Panasonic", 799, "8K", 55);
        Televisore tv3 = new Televisore("Samsung", 599, "Full HD", 43);
        Televisore tv4 = new Televisore("LG", 999, "OLED", 65);
        Televisore tv5 = new Televisore("Sony", 1200, "4K HDR", 75);
        Televisore [] listaTelevisori = new Televisore[] {tv1, tv2, tv3, tv4, tv5};


        boolean esisteUnTVEconomico = samsungHD32.esisteAlmenoUnoPiuEconomico(listaTelevisori);
        System.out.println("Test esisteUnTVEconomico");
        System.out.println("Start.....");
        System.out.println("Esiste un televisore piu economico nel catalogo di " + samsungHD32.getMarca() + " ? " + esisteUnTVEconomico);
        System.out.println("End.......");
        System.out.println(".......... \n");

        int televisoriPiuGrandi = samsungHD32.quantiSonoPiuGrandi(listaTelevisori);
        System.out.println("Test quantiSonoPiuGrandi");
        System.out.println("Start.....");
        System.out.println("Esistono n televisori piu grandi nel catalogo rispetto a " + samsungHD32.getMarca() + " : " + televisoriPiuGrandi);
        System.out.println("End.......");
        System.out.println(".......... \n");

        int televisoriPiuCariStessaMarca = samsungHD32.quantiSonoPiuCariAvendoStessaMarca(listaTelevisori);
        System.out.println("Test televisoriPiuCariStessaMarca");
        System.out.println("Start.....");
        System.out.println("Esistono n televisori piu cari della stessa marca nel catalogo rispetto a " + samsungHD32.getMarca() + " : " + televisoriPiuCariStessaMarca);
        System.out.println("End.......");
        System.out.println(".......... \n");

        boolean televisorePiuCaroDellaMedia = lgUltraHD40.ePiuCaroDellaMedia(listaTelevisori);
        System.out.println("Test televisorePiuCaroDellaMedia");
        System.out.println("Start.....");
        System.out.println("Il televisore è piu caro della media nel catalogo ? " + televisorePiuCaroDellaMedia);
        System.out.println("End.......");
        System.out.println(".......... \n");
    }

}
