package it.prova.gestioneordiniarticolicategorie.test;

import it.prova.gestioneordiniarticolicategorie.dao.EntityManagerUtil;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;
import it.prova.gestioneordiniarticolicategorie.model.Ordine;
import it.prova.gestioneordiniarticolicategorie.service.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class TestArticoloCategorie {
    public static void main(String[] args) {

        ArticoloService articoloServiceInstance = MyServiceFactory.getArticoloServiceInstance();
        CategoriaService categoriaServiceInstance = MyServiceFactory.getCategoriaServiceInstance();
        OrdineService ordineServiceInstance = MyServiceFactory.getOrdineServiceInstance();

        try {
            System.out.println("**************************** inizio batteria di test ********************************************");
            System.out.println("*************************************************************************************************");

            //testInserimentoNuovoOrdine(ordineServiceInstance);
            //testAggiornaOrdineEsistente(ordineServiceInstance);
            //testInserimentoNuovoArticolo(articoloServiceInstance, ordineServiceInstance);
            //testAggiornaArticolo(articoloServiceInstance, ordineServiceInstance);
            //testRimuoviArticoloDaOrdine(articoloServiceInstance, ordineServiceInstance);
            //testInserimentoNuovaCategoria(categoriaServiceInstance);
            //testAggiornaCategoriaEsistente(categoriaServiceInstance);
            //testAggiungiArticoloACategoria(articoloServiceInstance, categoriaServiceInstance, ordineServiceInstance);
            //testRimuoviArticoloEScollegaCategorie(articoloServiceInstance, categoriaServiceInstance);
            //testRimuoviCategoriaEScollegaArticoli(articoloServiceInstance, categoriaServiceInstance);
            //testRimuoviOrdineConArticoli(ordineServiceInstance, articoloServiceInstance);
            //testSommaPrezziArticoliPerCategoria(articoloServiceInstance, categoriaServiceInstance, ordineServiceInstance);
            //testOrdinePiuRecentePerCategoria(ordineServiceInstance, articoloServiceInstance, categoriaServiceInstance);
            //testSommaPrezziArticoliPerDestinatario(articoloServiceInstance, ordineServiceInstance);
            //testListaIndirizziPerSerialeArticolo(ordineServiceInstance, articoloServiceInstance);
            //testArticoliSpeditiOltreScadenza(articoloServiceInstance, ordineServiceInstance);

            System.out.println("****************************** fine batteria di test ********************************************");
            System.out.println("*************************************************************************************************");

        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            EntityManagerUtil.shutdown();
        }

    }

    private static void testArticoliSpeditiOltreScadenza(ArticoloService artServ, OrdineService ordServ) throws Exception {
        // ordine regolare
        Ordine normale = new Ordine("Normale", "Via Normale");
        normale.setDataScadenza(LocalDate.of(2025, 4, 1));
        normale.setDataSpedizione(LocalDate.of(2025, 3, 30));
        ordServ.inserisciNuovoOrdine(normale);
        Articolo aNorm = new Articolo("Norm", "NORM1", 5.0, LocalDate.now());
        aNorm.setOrdine(normale);
        artServ.inserisciNuovoArticolo(aNorm);

        //ordine in ritardo
        Ordine inRitardo = new Ordine("Ritardo", "Via Ritardo");
        inRitardo.setDataScadenza(LocalDate.of(2025, 4, 1));
        inRitardo.setDataSpedizione(LocalDate.of(2025, 4, 5));
        ordServ.inserisciNuovoOrdine(inRitardo);
        Articolo aRit = new Articolo("Rit", "RIT1", 7.0, LocalDate.now());
        aRit.setOrdine(inRitardo);
        artServ.inserisciNuovoArticolo(aRit);

        List<Articolo> risultati = artServ.listArticoliSpeditiOltreScadenza();

        // verifico che ci sia esattamente 1 risultato
        if (risultati.size() != 1) {
            throw new RuntimeException("Fallito: attesi 1 articolo ma trovati " + risultati.size());
        }

        Articolo trovato = risultati.get(0);
        if (!trovato.getId().equals(aRit.getId())) {
            throw new RuntimeException("Fallito: atteso articolo id="
                    + aRit.getId() + " ma ottenuto id=" + trovato.getId());
        }

        System.out.println("testArticoliSpeditiOltreScadenza: PASSED");
    }

    private static void testListaIndirizziPerSerialeArticolo(OrdineService ordineService, ArticoloService articoloService) throws Exception {
        Ordine o1 = new Ordine("Dest1", "Via delle Palme 10");
        ordineService.inserisciNuovoOrdine(o1);
        Ordine o2 = new Ordine("Dest2", "Corso dei Lecci 5");
        ordineService.inserisciNuovoOrdine(o2);
        Ordine o3 = new Ordine("Dest3", "Via dei Pini 7");
        ordineService.inserisciNuovoOrdine(o3);

        Articolo a1 = new Articolo("A1", "ABCXYZ01");
        a1.setOrdine(o1);
        articoloService.inserisciNuovoArticolo(a1);

        Articolo a2 = new Articolo("A2", "XYZ123");
        a2.setOrdine(o2);
        articoloService.inserisciNuovoArticolo(a2);

        Articolo a3 = new Articolo("A3", "NOPE");
        a3.setOrdine(o3);
        articoloService.inserisciNuovoArticolo(a3);

        List<String> indirizzi = ordineService.listaIndirizziPerSerialeArticolo("XYZ");

        Set<String> attesi = Set.of("Via delle Palme 10", "Corso dei Lecci 5");
        if (indirizzi.size() != 2 || !attesi.containsAll(indirizzi)) {
            throw new RuntimeException(
                    "testListaIndirizziPerSerialeArticolo FALLITO: attesi "
                            + attesi + " ma ottenuti " + indirizzi);
        }

        System.out.println("testListaIndirizziPerSerialeArticolo: PASSED");
    }

    private static void testSommaPrezziArticoliPerDestinatario(ArticoloService artServ, OrdineService ordServ) throws Exception {
        Ordine ord1 = new Ordine("Ermanno Mostantini", "Via A");
        ordServ.inserisciNuovoOrdine(ord1);
        Ordine ord2 = new Ordine("Emanuele Vichi", "Via B");
        ordServ.inserisciNuovoOrdine(ord2);

        Articolo a1 = new Articolo("X1", "SN1", 12.5, LocalDate.now());
        a1.setOrdine(ord1);
        artServ.inserisciNuovoArticolo(a1);

        Articolo a2 = new Articolo("X2", "SN2", 7.5, LocalDate.now());
        a2.setOrdine(ord1);
        artServ.inserisciNuovoArticolo(a2);

        Articolo a3 = new Articolo("X3", "SN3", 20.0, LocalDate.now());
        a3.setOrdine(ord2);
        artServ.inserisciNuovoArticolo(a3);

        Double sum = artServ.sommaPrezziArticoliPerDestinatario("Ermanno Mostantini");
        if (sum == null || sum != 20.0) {
            throw new RuntimeException(
                    "testSommaPrezziArticoliPerDestinatario FALLITO: " +
                            "atteso 20.0 ma ottenuto " + sum);
        }
        System.out.println("testSommaPrezziArticoliPerDestinatario: PASSED");
    }

    private static void testOrdinePiuRecentePerCategoria(OrdineService ordServ, ArticoloService artServ, CategoriaService catServ) throws Exception {
        Categoria cat = new Categoria("CatLatest", "CL01");
        catServ.inserisciNuovaCategoria(cat);

        Ordine o1 = new Ordine("A", "Via A");
        o1.setDataSpedizione(LocalDate.of(2025, 1, 1));
        ordServ.inserisciNuovoOrdine(o1);

        Ordine o2 = new Ordine("B", "Via B");
        o2.setDataSpedizione(LocalDate.of(2025, 3, 1));
        ordServ.inserisciNuovoOrdine(o2);

        Articolo a1 = new Articolo("ArtA", "SA1", 5.0, LocalDate.now());
        a1.setOrdine(o1);
        artServ.inserisciNuovoArticolo(a1);
        artServ.aggiungiArticoloACategoria(cat.getId(), a1.getId());

        Articolo a2 = new Articolo("ArtB", "SB2", 7.0, LocalDate.now());
        a2.setOrdine(o2);
        artServ.inserisciNuovoArticolo(a2);
        artServ.aggiungiArticoloACategoria(cat.getId(), a2.getId());

        Ordine latest = ordServ.caricaOrdinePiuRecentePerCategoria(cat.getId());
        if (latest == null || !latest.getId().equals(o2.getId())) {
            throw new RuntimeException(
                    "testOrdinePiuRecentePerCategoria FALLITO: atteso id="
                            + o2.getId() + " ma ottenuto "
                            + (latest==null?"null":latest.getId()));
        }
        System.out.println("testOrdinePiuRecentePerCategoria: PASSED");
    }


    private static void testSommaPrezziArticoliPerCategoria(ArticoloService artServ, CategoriaService catServ, OrdineService ordServ) throws Exception {
        Categoria cat = new Categoria("Somma Test", "SUM01");
        catServ.inserisciNuovaCategoria(cat);

        Ordine o = new Ordine("Carlo Conti", "Via delle Somme 71");
        ordServ.inserisciNuovoOrdine(o);

        Articolo a1 = new Articolo("Art1", "S1", 10.0, LocalDate.now());
        a1.setOrdine(o);
        artServ.inserisciNuovoArticolo(a1);

        Articolo a2 = new Articolo("Art2", "S2", 20.0, LocalDate.now());
        a2.setOrdine(o);
        artServ.inserisciNuovoArticolo(a2);

        artServ.aggiungiArticoloACategoria(cat.getId(), a1.getId());
        artServ.aggiungiArticoloACategoria(cat.getId(), a2.getId());

        Double sum = artServ.sommaPrezziArticoliPerCategoria(cat.getId());
        if (sum == null || sum != 30.0) {
            throw new RuntimeException(
                    "testSommaPrezziArticoliPerCategoria FALLITO: atteso 30.0 ma ottenuto " + sum
            );
        }

        System.out.println("testSommaPrezziArticoliPerCategoria: PASSED");
    }


    private static void testRimuoviOrdineConArticoli(OrdineService ordServ, ArticoloService artServ) throws Exception {
        Ordine o = new Ordine("Nome3", "Via 3");
        ordServ.inserisciNuovoOrdine(o);

        Articolo a = new Articolo("D", "SN");
        a.setOrdine(o);
        artServ.inserisciNuovoArticolo(a);

        try {
            ordServ.rimuoviOrdine(o.getId());
            throw new RuntimeException(
                    "Fallito: doveva lanciare OrderHasArticlesException");
        } catch (RuntimeException e) {
            System.out.println("testRimuoviOrdineConArticoli: PASSED");
        }
    }

    private static void testRimuoviCategoriaEScollegaArticoli(ArticoloService artServ, CategoriaService catServ) throws Exception {
        Articolo art = new Articolo("Descr2", "SER456");
        artServ.inserisciNuovoArticolo(art);

        Categoria cat = new Categoria("Desc2", "CODY");
        catServ.inserisciNuovaCategoria(cat);

        catServ.aggiungiArticoloACategoria(cat.getId(), art.getId());

        catServ.rimuoviCategoriaEScollegaArticoli(cat.getId());

        Categoria check = catServ.caricaSingolaCategoria(cat.getId());
        if (check != null) throw new RuntimeException("Fallito: categoria non eliminata");

        Articolo artReload = artServ.caricaSingoloArticolo(art.getId());
        if (!artReload.getCategorie().isEmpty())
            throw new RuntimeException("Fallito: articolo ancora collegato alla categoria");
        System.out.println("testRimuoviCategoriaEScollegaArticoli: PASSED");
    }

    private static void testRimuoviArticoloEScollegaCategorie(ArticoloService artServ, CategoriaService catServ) throws Exception {
        Categoria cat = new Categoria("Desc", "CODX");
        catServ.inserisciNuovaCategoria(cat);

        Articolo art = new Articolo("Descr", "SER123");
        artServ.inserisciNuovoArticolo(art);

        artServ.aggiungiArticoloACategoria(cat.getId(), art.getId());

        artServ.rimuoviArticoloEScollegaCategorie(art.getId());

        Articolo check = artServ.caricaSingoloArticolo(art.getId());
        if (check != null) throw new RuntimeException("Fallito: articolo non eliminato");

        Categoria catReload = catServ.caricaSingolaCategoria(cat.getId());
        if (!catReload.getArticoli().isEmpty())
            throw new RuntimeException("Fallito: categoria ancora collegata all'articolo");
        System.out.println("testRimuoviArticoloEScollegaCategorie: PASSED");
    }

    private static void testAggiungiArticoloACategoria(ArticoloService articoloServiceInstance, CategoriaService categoriaServiceInstance, OrdineService ordineServiceInstance) throws Exception {
        System.out.println(".......testAggiungiArticoloACategoria inizio.............");

        Categoria categoriaInstance = new Categoria("XXXXXX", "CAT101");
        categoriaServiceInstance.inserisciNuovaCategoria(categoriaInstance);

        if (categoriaInstance.getId() == null)
            throw new RuntimeException("testAggiungiArticoloACategoria fallito: categoria non inserita");

        Ordine ordineInstance = new Ordine("Eleonora Anselmi", "Via Cappuccino ballerino 1");
        ordineServiceInstance.inserisciNuovoOrdine(ordineInstance);

        if (ordineInstance.getId() == null)
            throw new RuntimeException("testAggiungiArticoloACategoria fallito: ordine non inserito");


        Articolo articoloInstance = new Articolo("Articolo Test", "ART001");
        articoloInstance.setOrdine(ordineInstance);

        articoloServiceInstance.inserisciNuovoArticolo(articoloInstance);

        if (articoloInstance.getId() == null)
            throw new RuntimeException("testAggiungiArticoloACategoria fallito: articolo non inserito");

        categoriaServiceInstance.aggiungiArticoloACategoria(categoriaInstance.getId(), articoloInstance.getId());

        Categoria categoriaAggiornata = categoriaServiceInstance.caricaSingolaCategoria(categoriaInstance.getId());
        if (categoriaAggiornata.getArticoli().isEmpty())
            throw new RuntimeException("testAggiungiArticoloACategoria fallito: categoria non aggiornata");


        System.out.println(".......testAggiungiArticoloACategoria fine: PASSED.............");
    }

    private static void testAggiornaCategoriaEsistente(CategoriaService categoriaService) throws Exception {
        System.out.println(".......testAggiornaCategoriaEsistente inizio.............");

        Categoria categoriaInstance = new Categoria("CategoriaAggiornamtno", "10");
        categoriaService.inserisciNuovaCategoria(categoriaInstance);

        if (categoriaInstance.getId() == null)
            throw new RuntimeException("testAggiornaCategoriaEsistente fallito: categoria non inserita");

        categoriaInstance.setDescrizione("Categoria Aggiornata");
        categoriaService.aggiornaCategoria(categoriaInstance);

        Categoria categoriaAggiornata = categoriaService.caricaSingolaCategoria(categoriaInstance.getId());
        if (!"Categoria Aggiornata".equals(categoriaAggiornata.getDescrizione()))
            throw new RuntimeException("testAggiornaCategoriaEsistente fallito: descrizione non aggiornata");

        System.out.println(".......testAggiornaCategoriaEsistente fine: PASSED.............");
    }

    private static void testInserimentoNuovaCategoria(CategoriaService categoriaService) throws Exception {
        System.out.println(".......testInserimentoNuovaCategoria inizio.............");

        Categoria categoriaInstance = new Categoria("Categoria Test", "12");
        categoriaService.inserisciNuovaCategoria(categoriaInstance);

        if (categoriaInstance.getId() == null)
            throw new RuntimeException("testInserimentoNuovaCategoria fallito ");

        System.out.println(".......testInserimentoNuovaCategoria fine: PASSED.............");
    }

    private static void testRimuoviArticoloDaOrdine(ArticoloService articoloService, OrdineService ordineService) throws Exception {
        System.out.println(".......testRimuoviArticoloDaOrdine inizio.............");

        Ordine ordineInstance = new Ordine("Eleonora Mattei", "Via Mosca 1");
        ordineService.inserisciNuovoOrdine(ordineInstance);

        if (ordineInstance.getId() == null)
            throw new RuntimeException("testRimuoviArticoloDaOrdine fallito: ordine non inserito");

        Articolo articoloInstance = new Articolo("ArticoloDaScollegare", "CODICE123");
        articoloInstance.setOrdine(ordineInstance);
        articoloService.inserisciNuovoArticolo(articoloInstance);

        if (articoloInstance.getId() == null)
            throw new RuntimeException("testRimuoviArticoloDaOrdine fallito: articolo non inserito");

        articoloService.rimuoviArticoloDaOrdine(ordineInstance.getId(), articoloInstance.getId());

        Articolo articoloTrovato = articoloService.caricaSingoloArticolo(articoloInstance.getId());
        if (articoloTrovato != null)
            throw new RuntimeException("testRimuoviArticoloDaOrdine fallito: articolo non rimosso");

        System.out.println(".......testRimuoviArticoloDaOrdine fine: PASSED.............");
    }

    private static void testAggiornaArticolo(ArticoloService articoloService, OrdineService ordineService) throws Exception {
        System.out.println(".......testAggiornaArticolo inizio.............");

        Ordine ordineInstance = new Ordine("Geronimo Gatti", "Via delle Magnolie 15");
        ordineService.inserisciNuovoOrdine(ordineInstance);

        if (ordineInstance.getId() == null)
            throw new RuntimeException("testAggiornaArticolo fallito: ordine non inserito");

        Articolo articoloInstance = new Articolo("Articolo Test", "CODICE789");
        articoloInstance.setOrdine(ordineInstance);
        articoloService.inserisciNuovoArticolo(articoloInstance);

        if (articoloInstance.getId() == null)
            throw new RuntimeException("testAggiornaArticolo fallito: articolo non inserito");

        articoloInstance.setDescrizione("Articolo Aggiornato");
        articoloService.aggiornaArticolo(articoloInstance);

        Articolo articoloAggiornato = articoloService.caricaSingoloArticolo(articoloInstance.getId());
        if (!"Articolo Aggiornato".equals(articoloAggiornato.getDescrizione()))
            throw new RuntimeException("testAggiornaArticolo fallito: descrizione non aggiornata");

        System.out.println(".......testAggiornaArticolo fine: PASSED.............");
    }

    private static void testAggiornaOrdineEsistente(OrdineService ordineServiceInstance) throws Exception {
        System.out.println(".......testAggiornaOrdineEsistente inizio.............");

        Ordine ordineInstance = new Ordine("Emanuele Bianchi", "Via dei Cianuri 5");
        ordineServiceInstance.inserisciNuovoOrdine(ordineInstance);

        if (ordineInstance.getId() == null)
            throw new RuntimeException("testInserimentoNuovoOrdine fallito ");

        ordineInstance.setDataScadenza(LocalDate.now());
        ordineServiceInstance.aggiornaOrdine(ordineInstance);

        if (ordineInstance.getDataScadenza() == null)
            throw new RuntimeException("testAggiornaOrdineEsistente fallito ");

        System.out.println(".......testAggiornaOrdineEsistente fine: PASSED.............");
    }

    private static void testInserimentoNuovoOrdine(OrdineService ordineServiceInstance) throws Exception {
        System.out.println(".......testInserimentoNuovoOrdine inizio.............");

        Ordine ordineInstance = new Ordine("Michela Giovacchini", "Via dei Monti 5");
        ordineServiceInstance.inserisciNuovoOrdine(ordineInstance);

        if (ordineInstance.getId() == null)
            throw new RuntimeException("testInserimentoNuovoOrdine fallito ");

        System.out.println(".......testInserimentoNuovoOrdine fine: PASSED.............");
    }

    private static void testInserimentoNuovoArticolo(ArticoloService articoloServiceInstance, OrdineService ordineServiceInstance ) throws Exception {
        System.out.println(".......testInserimentoNuovoArticolo inizio.............");

        Ordine ordineInstance = new Ordine("Giammarco Rossi", "Via dei Cianuri 5");
        Articolo articoloInstance = new Articolo("Articolo 1", "AGIORNALE1");
        ordineServiceInstance.inserisciNuovoOrdine(ordineInstance);

      if(ordineInstance.getId() == null)
           throw new RuntimeException("testInserimentoNuovoOrdine fallito ");

        articoloInstance.setOrdine(ordineInstance);
        articoloServiceInstance.inserisciNuovoArticolo(articoloInstance);

        if (articoloInstance.getId() == null)
            throw new RuntimeException("testInserimentoNuovoArticolo fallito ");

        System.out.println(".......testInserimentoNuovoArticolo fine: PASSED.............");
    }



}
