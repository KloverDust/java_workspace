package it.prova.catenadimontaggio;

import it.prova.catenadimontaggio.model.Automobile;
import it.prova.catenadimontaggio.model.SlotCatenaDiMontaggio;
import it.prova.catenadimontaggio.service.SlotCatenaDiMontaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatenadimontaggioApplication implements CommandLineRunner {

	@Autowired
	private SlotCatenaDiMontaggioService slotCatenaDiMontaggioService;

	public static void main(String[] args) {
		SpringApplication.run(CatenadimontaggioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SlotCatenaDiMontaggio slotCatenaDiMontaggio = new SlotCatenaDiMontaggio();
		Automobile automobile = new Automobile();
	}
}
