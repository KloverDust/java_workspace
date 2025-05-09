package it.prova.gestionesocieta.repository;

import it.prova.gestionesocieta.model.Dipendente;
import it.prova.gestionesocieta.model.Societa;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface SocietaRepository extends CrudRepository<Societa, Long>, QueryByExampleExecutor<Societa> {
    List<Societa> findByRagioneSociale(String ragioneSociale);
    List<Societa> findByIndirizzo(String indirizzo);

    // Query costruita per usare JPQL
//    @Modifying
//    @Query("""
//      DELETE FROM Societa s
//      WHERE s.id = :id
//        AND s.dipendenti IS EMPTY
//      """)
//    int deleteIfNoDipendenti(@Param("id") Long id);
}
