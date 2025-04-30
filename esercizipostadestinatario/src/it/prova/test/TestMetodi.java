package it.prova.test;

import it.prova.model.Destinatario;
import it.prova.model.PostaDiPaese;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestMetodi {

    public static void main(String[] args) throws Exception {
        System.out.println("------------------ INIZIO TEST METODI ------------------");
        List<Destinatario> listaDestinatari = MockData.DESTINATARI_LIST;
        List<PostaDiPaese> listaPoste = MockData.POSTE_LIST;
        //testListPosteConPVInIndirizzo(listaPoste);
        //testListPosteAperteDopoData(listaPoste);
        //testListaIndirizziPosteConDipendentiSuperioreA20(listaPoste);
        //testListaIndirizziDestinatariConPosteConAlmeno10Dipendenti(listaDestinatari, listaPoste);
        //testListaClientiDiPosteConDipendentiTra50e100(listaDestinatari, listaPoste);
        //testListaEtaDestinatariConPosteCheConteganoCentraleAperteDal1Anno2000(listaDestinatari);
        //testSommaDipendentiTuttePoste(listaPoste);
        //testListaCognomiDeiDestinatariDiTutteLePoste(listaPoste);
        //testTrovaDestinatariPiuVecchiDi60DiTutteLePoste(listaPoste);
        //testCalcolaNumeroPosteConClientiSenzaCC(listaPoste);
        testCreazioneMapUtil(listaPoste);

        System.out.println("------------------ FINE TEST METODI ------------------");

    }

    private static void testCreazioneMapUtil(List<PostaDiPaese> listaPoste) throws Exception{
        System.out.println("testCreazioneMapUtil");
        Map<Integer, List<PostaDiPaese>> postePerDipendenti = listaPoste.stream().collect(Collectors.groupingBy(PostaDiPaese::getNumeroDipendenti));

        if(postePerDipendenti.isEmpty()) {
            throw new RuntimeException("Nessuna Posta di Paese trovata");
        } else {
            System.out.println("Poste di Paese raggruppate per numero di dipendenti:");
            for (Map.Entry<Integer, List<PostaDiPaese>> entry : postePerDipendenti.entrySet()) {
                System.out.println("Numero dipendenti: " + entry.getKey());
                for (PostaDiPaese posta : entry.getValue()) {
                    System.out.println(" - " + posta.getDenominazione() + " - " + posta.getIndirizzoSede());
                }
            }
        }
    }

    private static void testCalcolaNumeroPosteConClientiSenzaCC(List<PostaDiPaese> listaPoste) throws Exception{
        System.out.println("testCalcolaNumeroPosteConClientiSenzaCC");
        long numeroPoste = listaPoste.stream().filter(p -> p.getDestinatari().stream().anyMatch(d -> !d.isPossessoreDiContoCorrente())).count();
        if(numeroPoste != 0) {
            throw new RuntimeException("Nessuna Posta di Paese trovata con clienti senza conto corrente");
        } else {
            System.out.println("Poste di Paese trovate con clienti senza conto corrente:");
        }
    }

    private static void testTrovaDestinatariPiuVecchiDi60DiTutteLePoste(List<PostaDiPaese> listaPoste) throws Exception{
        System.out.println();
        System.out.println("testTrovaDestinatariPiuVecchiDi60DiTutteLePoste");
        List<Destinatario> destinatari = listaPoste.stream().flatMap(p-> p.getDestinatari().stream()).filter(d-> d.getEta() >60).toList();
        if(destinatari.isEmpty()) {
            throw new RuntimeException("Nessun destinatario trovato con più di 60 anni");
        } else {
            System.out.println("Destinatari trovati con più di 60 anni:");
            for (Destinatario destinatario : destinatari) {
                System.out.println(destinatario.getNome() + " " + destinatario.getCognome() + " - " + destinatario.getEta() + " anni");
            }
        }
    }

    private static void testListaCognomiDeiDestinatariDiTutteLePoste(List<PostaDiPaese> listaPoste) throws Exception{
        System.out.println("testListaCognomiDeiDestinatariDiTutteLePoste");
        List<String> cognomiRicercati = listaPoste.stream().flatMap(p-> p.getDestinatari().stream()).map(Destinatario::getCognome).toList();
        if(cognomiRicercati.isEmpty()) {
            throw new RuntimeException("Nessun destinatario trovato");
        } else {
            System.out.println("Cognomi dei destinatari trovati:");
            for (String cognome : cognomiRicercati) {
                System.out.println(cognome + " - ");
            }
        }
    }

    private static void testSommaDipendentiTuttePoste(List<PostaDiPaese> listaPoste) throws Exception{
        System.out.println("testSommaDipendentiTuttePoste");
        int sommaDipendenti = listaPoste.stream().filter(postaDiPaese -> postaDiPaese.getNumeroDipendenti() != 0).mapToInt(posta -> posta.getNumeroDipendenti()).sum() ;
        if(sommaDipendenti == 0) {
            throw new RuntimeException("Nessuna Posta di Paese trovata");
        } else {
            System.out.println("Somma totale dei dipendenti delle Poste di Paese: " + sommaDipendenti);
        }
    }

    private static void testListaEtaDestinatariConPosteCheConteganoCentraleAperteDal1Anno2000(List<Destinatario> listaDestinatari) throws Exception{
        System.out.println("testListaEtaDestinatariConPosteCheConteganoCentraleAperteDal1Anno2000");
        List<Integer> etaRicercate = listaDestinatari.stream().
                map(Destinatario::getPostaDiPaese).
                filter(postaDiPaese -> postaDiPaese.getIndirizzoSede().contains("Centrale")).
                filter(postaDiPaese -> postaDiPaese.getDataApertura().isBefore(LocalDate.of(2000,1,1))).
                flatMap(p -> p.getDestinatari().stream()).
                map(Destinatario::getEta).toList();

        if(etaRicercate.isEmpty()) {
            throw new RuntimeException("Nessun destinatario trovato con posta di paese con denominazione Centrale e aperta dopo il 1 gennaio 2000");
        } else {
            System.out.println("Destinatari trovati con posta di paese con denominazione Centrale e aperta dopo il 1 gennaio 2000:");
            for (Integer eta : etaRicercate) {
                System.out.println(eta + " - ");
            }
        }
    }

    private static void testListaClientiDiPosteConDipendentiTra50e100(List<Destinatario> listaDestinatari, List<PostaDiPaese> listaPoste) throws Exception{
        System.out.println("testListaClientiDiPosteConDipendentiTra50e100");
        List<String> indirizziRicercati = listaDestinatari.stream().map(Destinatario::getPostaDiPaese).filter(postaDiPaese -> postaDiPaese.getNumeroDipendenti() > 50 && postaDiPaese.getNumeroDipendenti() < 100).map(PostaDiPaese::getIndirizzoSede).toList();

        if(indirizziRicercati.isEmpty()) {
            throw new RuntimeException("Nessun destinatario trovato con posta di paese con più di 50 e meno di 100 dipendenti");
        } else {
            System.out.println("Destinatari trovati con posta di paese con più di 50 e meno di 100 dipendenti:");
            for (String indirizzo : indirizziRicercati) {
                System.out.println(indirizzo + " - ");
            }
        }
    }

    private static void testListaIndirizziDestinatariConPosteConAlmeno10Dipendenti(List<Destinatario> listaDestinatari, List<PostaDiPaese> listaPoste) throws Exception{
        System.out.println("testListaIndirizziDestinatariConPosteConAlmeno10Dipendenti");
        List<String> indirizziRicercati = listaDestinatari.stream().map(Destinatario::getPostaDiPaese).filter(postaDiPaese -> postaDiPaese.getNumeroDipendenti() > 10).map(PostaDiPaese::getIndirizzoSede).toList();
        if(indirizziRicercati.isEmpty()) {
            throw new RuntimeException("Nessun destinatario trovato con posta di paese con più di 10 dipendenti");
        } else {
            System.out.println("Destinatari trovati con posta di paese con più di 10 dipendenti:");
            for (String indirizzo : indirizziRicercati) {
                System.out.println(indirizzo + " - ");
            }
        }
    }

    private static void testListaIndirizziPosteConDipendentiSuperioreA20(List<PostaDiPaese> listaPoste) throws Exception{
        System.out.println("testListaIndirizziPosteConDipendentiSuperioreA20");
        List<String> indirizziRicercati = listaPoste.stream().filter(posta -> posta.getNumeroDipendenti() > 20).map(PostaDiPaese::getIndirizzoSede).toList();
        if(indirizziRicercati.isEmpty()) {
            throw new RuntimeException("Nessuna Posta di Paese trovata con più di 20 dipendenti");
        } else {
            System.out.println("Poste di Paese trovate con più di 20 dipendenti:");
            for (String indirizzo : indirizziRicercati) {
                System.out.println(indirizzo + " - ");
            }
        }
    }

    private static void testListaClientiDiPosteConPiu100Dipendenti(List<Destinatario> listaDestinatari, List<PostaDiPaese> listaPoste) throws Exception{
        System.out.println("testListaClientiDiPosteConPiu100Dipendenti");

    }

    public static void testListPosteConPVInIndirizzo(List<PostaDiPaese> listaPoste) throws Exception{
        System.out.println("testListPosteConPVInIndirizzo");
        String stringaRicerca = "(MI)";
        List<PostaDiPaese> posteDiPaeseCiclato = listaPoste.stream().filter(posta -> posta.getIndirizzoSede().contains("(MI")).toList();
        if(posteDiPaeseCiclato.isEmpty()) {
            throw new RuntimeException("Nessuna Posta di Paese trovata con la stringa " + stringaRicerca);
        } else {
            System.out.println("Poste di Paese trovate con la stringa " + stringaRicerca + ":");
            for (PostaDiPaese posta : posteDiPaeseCiclato) {
                System.out.println(posta.getDenominazione() + " - " + posta.getIndirizzoSede());
            }
        }
    }

    private static void testListPosteAperteDopoData(List<PostaDiPaese> listaPoste) throws Exception{
        System.out.println("testListPosteAperteDopoData");
        LocalDate dataInteressata = LocalDate.of(2019,3,1);
        List<PostaDiPaese> posteDiPaeseCiclato = listaPoste.stream().filter(posta -> posta.getDataApertura() != null).filter(posta -> posta.getDataApertura().isAfter(dataInteressata)).toList();

        if(posteDiPaeseCiclato.isEmpty()) {
            throw new RuntimeException("Nessuna Posta di Paese trovata con la data " + dataInteressata);
        } else {
            System.out.println("Poste di Paese trovate con la data " + dataInteressata.toString() + ":");
            for (PostaDiPaese posta : posteDiPaeseCiclato) {
                System.out.println(posta.getDenominazione() + " - " + posta.getIndirizzoSede());
            }
        }
    }

}
