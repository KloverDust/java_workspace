package it.prova.gestionesocieta;

import it.prova.gestionesocieta.service.BatteriaTestDipendente;
import it.prova.gestionesocieta.service.BatteriaTestProgetto;
import it.prova.gestionesocieta.service.BatteriaTestSocieta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionesocietaApplication implements CommandLineRunner {

	@Autowired
	private BatteriaTestSocieta batteriaTestSocieta;

	@Autowired
	private BatteriaTestProgetto batteriaTestProgetto;

	@Autowired
	private BatteriaTestDipendente batteriaTestDipendente;

	public static void main(String[] args) {
		SpringApplication.run(GestionesocietaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("################ START   #################");
		System.out.println("################ eseguo i test  #################");

		//batteriaTestSocieta.testInserisciNuovaSocieta();
		//batteriaTestSocieta.testCercaPerExample();
		//batteriaTestSocieta.testRimuoviSocieta();
		//batteriaTestSocieta.testInserimentoDipendenteInSocieta();
		//batteriaTestProgetto.testInserisciNuovoProgetto();
		//batteriaTestProgetto.testCollegaDipendenteAPiuProgetti();
		//batteriaTestDipendente.testCollegaProgettoADipendenti();
		//batteriaTestProgetto.testListaClientiProgettoPerSocieta();
		//batteriaTestProgetto.testListaNomiSocietaConProgettiDiDurataSuperioreA12Mesi();
		//batteriaTestProgetto.testListaProgettiConDipendentiConRALSopra29999();
		//batteriaTestDipendente.testTrovaDipendentePiuVecchioConSocietaEProgettiVecchi();
		//batteriaTestProgetto.testTrovaProgettiAnomali();

		System.out.println("################ FINE - PASSED  #################");
	}
}
