package it.prova.gestioneedifici;

import it.prova.gestioneedifici.service.BatteriaTestEdificio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestioneedificiApplication implements CommandLineRunner {

	@Autowired
	BatteriaTestEdificio batteriaTestEdificio;
	public static void main(String[] args) {
		SpringApplication.run(GestioneedificiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			System.out.println("################ START   #################");
			System.out.println("################ eseguo i test  #################");

			batteriaTestEdificio.testInserisciEdificioConControlli();

			System.out.println("################ FINE - PASSED  #################");
		} catch (Exception e) {
			System.out.println("Errore durante l'esecuzione: " + e.getMessage());
		}
	}
}
