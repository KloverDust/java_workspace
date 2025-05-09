package it.prova.gestionesocieta.repository;

import it.prova.gestionesocieta.model.Dipendente;
import it.prova.gestionesocieta.model.Progetto;
import it.prova.gestionesocieta.model.Societa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface ProgettoRepository  extends CrudRepository<Progetto, Long>, QueryByExampleExecutor<Progetto> {
    List<Progetto> findByNome(String nome);

    @Query("SELECT DISTINCT p.cliente FROM Progetto p JOIN p.dipendenti d WHERE d.societa = :societaInput")
    List<String> findClientiBySocieta(@Param("societaInput") Societa societa);

    @Query("SELECT DISTINCT d.societa.ragioneSociale FROM Progetto p JOIN p.dipendenti d WHERE p.durataInMesi > 12")
    List<String> findCompaniesWithProjectsOlderThan12Months();

    //La lista di progetti  in cui lavora almeno un dipendente con una RAL a partire da 30000
    @Query("SELECT DISTINCT p FROM Progetto p JOIN p.dipendenti d WHERE d.redditoAnnuoLordo >= 30000")
    List<Progetto> findProjectsWithEmployersWithRALGreaterThan29999();

    //Lista di Progetti anomali cioè quelli in cui è presente almeno un dipendente in cui la società sia stata chiusa
    @Query("SELECT DISTINCT p FROM Progetto p JOIN p.dipendenti d WHERE d.societa.dataChiusura IS NOT NULL")
    List<Progetto> findAnomalousProjectsWithClosedCompanyEmployees();

    //List<Progetto> findDistinctByDipendentiSocietaDataChiusuraIsNotNull();
}
