package com.example.gestionetratte.repository.Airbus;

import com.example.gestionetratte.model.Airbus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AirbusRepository extends JpaRepository<Airbus, Long> {
    @Query("select distinct a from Airbus a left join fetch a.tratte")
    List<Airbus> findAllEager();

    @Query("select a from Airbus a left join fetch a.tratte where a.id = :id")
    Airbus findSingleAirbusEager(@Param("id") Long id);

    List<Airbus> findByCodiceContainingIgnoreCase(String codice);

    List<Airbus> findByNumeroPasseggeriGreaterThan(Integer min);
}
