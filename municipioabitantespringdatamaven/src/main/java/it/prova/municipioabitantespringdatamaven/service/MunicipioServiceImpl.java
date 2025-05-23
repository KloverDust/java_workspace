package it.prova.municipioabitantespringdatamaven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.municipioabitantespringdatamaven.model.Municipio;
import it.prova.municipioabitantespringdatamaven.repository.MunicipioRepository;

@Service
@Transactional(readOnly = true)
public class MunicipioServiceImpl implements MunicipioService {

	@Autowired
	private MunicipioRepository municipioRepository;

	public List<Municipio> listAllMunicipi() {
		return (List<Municipio>) municipioRepository.findAll();
	}

	public Municipio caricaSingoloMunicipio(Long id) {
		return municipioRepository.findById(id).orElse(null);
	}

	@Transactional
	public void aggiorna(Municipio municipioInstance) {
		municipioRepository.save(municipioInstance);
	}

	@Transactional
	public void inserisciNuovo(Municipio municipioInstance) {
		municipioRepository.save(municipioInstance);
	}

	@Transactional
	public void rimuovi(Long idMunicipio) {
		municipioRepository.deleteById(idMunicipio);
	}

	public List<Municipio> findByExample(Municipio municipioExample) {
		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING); // Match string
																										// containing
																										// pattern
		// .withIgnoreCase();
		return (List<Municipio>) municipioRepository.findAll(Example.of(municipioExample, matcher));
	}

	public List<Municipio> cercaByDescrizioneILike(String term) {
		return municipioRepository.findAllByDescrizioneContaining(term);
	}

	@Transactional
	public void removeConEccezione(Municipio municipioInstance) {
		municipioRepository.delete(municipioInstance);
		throw new RuntimeException("Eccezione di prova transazione");

	}

	public List<Municipio> cercaTuttiIMunicipiConAbitantiConEtaMaggioreDi(int etaInput) {
		return municipioRepository.findAllDistinctByAbitanti_EtaGreaterThan(etaInput);
	}

	public Municipio cercaPerCodice(String codice) {
		return municipioRepository.findByCodice(codice);
	}

}
