package it.prova.gestionesocieta.repository;

import it.prova.gestionesocieta.model.Dipendente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DipendenteRepository extends CrudRepository<Dipendente, Long>, QueryByExampleExecutor<Dipendente> {
    List<Dipendente> findByNome(String nome);
    List<Dipendente> findByCognome(String cognome);
    List<Dipendente> findBySocieta_id(Long id);

    // Trovate il dipendente più anziano, lavorativamente parlando, delle società fondate prima del 1990 e che lavora su progetto che dura almeno 6 mesi.
    @Query("SELECT DISTINCT d FROM Dipendente d JOIN d.societa s JOIN d.progetti p WHERE s.dataFondazione < :dataLimite AND p.durataInMesi >= 6 ORDER BY d.dataAssunzione ASC")
    Optional<Dipendente> findOldestEmployerWithProjectsOlderThan6MonthsAndCompanies(@Param("dataLimite") LocalDate dataLimite);

}
