package com.example.gestionesatelliti.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
@Table(name = "satellite")
public class Satellite {
    //Satellite(id, denominazione*, codice*, dataLancio, dataRientro, stato [IN_MOVIMENTO, FISSO, DISATTIVATO])

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "{satellite.denominazione.notblank}")
    @Column(name = "denominazione")
    private String denominazione;

    @NotBlank(message = "{satellite.codice.notblank}")
    @Column(name = "codice")
    private String codice;

    @Column(name = "dataLancio")
    private LocalDate dataLancio;

    @Column(name = "dataRientro")
    private LocalDate dataRientro;

    @Enumerated(EnumType.STRING)
    private StatoSatellite stato;

    public Satellite() {
    }

    public Satellite(String denominazione, String codice) {
        this.denominazione = denominazione;
        this.codice = codice;
    }

    public Satellite(String denominazione, String codice, StatoSatellite stato) {
        this.denominazione = denominazione;
        this.codice = codice;
        this.stato = stato;
    }

    public Satellite(String denominazione, String codice, LocalDate dataLancio, StatoSatellite stato) {
        this.denominazione = denominazione;
        this.codice = codice;
        this.dataLancio = dataLancio;
        this.stato = stato;
    }

    public Satellite(String denominazione, String codice, LocalDate dataLancio, LocalDate dataRientro, StatoSatellite stato) {
        this.denominazione = denominazione;
        this.codice = codice;
        this.dataLancio = dataLancio;
        this.dataRientro = dataRientro;
        this.stato = stato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public LocalDate getDataLancio() {
        return dataLancio;
    }

    public void setDataLancio(LocalDate dataLancio) {
        this.dataLancio = dataLancio;
    }

    public LocalDate getDataRientro() {
        return dataRientro;
    }

    public void setDataRientro(LocalDate dataRientro) {
        this.dataRientro = dataRientro;
    }

    public StatoSatellite getStato() {
        return stato;
    }

    public void setStato(StatoSatellite stato) {
        this.stato = stato;
    }
}
