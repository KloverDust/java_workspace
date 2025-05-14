package com.example.gestionetratte.repository.Tratta;

import com.example.gestionetratte.model.Airbus;
import com.example.gestionetratte.model.StatoTratta;
import com.example.gestionetratte.model.Tratta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TrattaRepository  extends JpaRepository<Tratta, Long> {
    @Query("select distinct t from Tratta t left join fetch t.airbus")
    List<Tratta> findAllEager();

    @Query("select t from Tratta t left join fetch t.airbus where t.id = :id")
    Tratta findSingleTrattaEager(@Param("id") Long id);

    List<Tratta> findByCodiceContainingIgnoreCase(String codice);

    List<Tratta> findByStato(StatoTratta stato);

    List<Tratta> findByAirbus(Airbus airbus);

    List<Tratta> findByData(LocalDate data);
}
