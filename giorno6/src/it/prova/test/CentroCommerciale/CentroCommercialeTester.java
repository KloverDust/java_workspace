package it.prova.test.CentroCommerciale;

import it.prova.model.CentroCommerciale.*;

import java.util.ArrayList;
import java.util.List;

public class CentroCommercialeTester {

    public static void main (String[] args){
        CentroCommerciale whiteLotusCC = new CentroCommerciale("WhiteLotus SPA", "Via Londra 11");
        Negozio bvlgari = new Negozio("BVLGARI GIOIELLI", "BV01");
        Negozio stroili = new Negozio("Stroili gioielli", "STR01");
        List<Negozio> negoziWhiteLotus= new ArrayList<>();
        negoziWhiteLotus.add(bvlgari);
        negoziWhiteLotus.add(stroili);
        bvlgari.setCentroDiAppartenenza(whiteLotusCC);
        stroili.setCentroDiAppartenenza(whiteLotusCC);

        List<Item> listaBvlgari = new ArrayList<>();
        Item orologio1 = new Item("001", "Orologio in oro", 10000);
        Item orologio2 = new Item("001", "Orologio in argento", 1000);
        Item orologio3 = new Item("001", "Orologio in oro", 10000);
        listaBvlgari.add(orologio1);
        listaBvlgari.add(orologio2);
        listaBvlgari.add(orologio3);
        bvlgari.setItemsInNegozio(listaBvlgari);
        orologio1.setNegozioAppartenza(bvlgari);
        orologio2.setNegozioAppartenza(bvlgari);
        orologio3.setNegozioAppartenza(bvlgari);

        List<Lavoratore> lavoratoriBvlgari = new ArrayList<>();
        Lavoratore marcoCommesso = new Commesso("Marco", "Rossi");
        Lavoratore giulioCommesso = new Commesso("Giulio", "Neri");
        Lavoratore stefanoCommesso = new Commesso("Stefano", "Verdi");
        Lavoratore micheleAmministratore = new Amministratore("Michele", "Santini");
        Lavoratore mauroBoss = new Boss("Mauro", "Pulzone");
        lavoratoriBvlgari.add(marcoCommesso);
        lavoratoriBvlgari.add(giulioCommesso);
        lavoratoriBvlgari.add(stefanoCommesso);
        lavoratoriBvlgari.add(micheleAmministratore);
        lavoratoriBvlgari.add(mauroBoss);
        marcoCommesso.setNegozioAppartenenza(bvlgari);
        giulioCommesso.setNegozioAppartenenza(bvlgari);
        stefanoCommesso.setNegozioAppartenenza(bvlgari);
        micheleAmministratore.setNegozioAppartenenza(bvlgari);
        mauroBoss.setNegozioAppartenenza(bvlgari);


        System.out.println(bvlgari.addToItems(marcoCommesso, orologio1));
        System.out.println(bvlgari.removeFromItems(micheleAmministratore, orologio1));







    }
}
