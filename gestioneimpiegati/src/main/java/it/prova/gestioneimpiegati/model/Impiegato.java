package it.prova.gestioneimpiegati.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "impiegato")
public class Impiegato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotBlank(message = "{impiegato.nome.notblank}")
	@Column(name = "nome")
	private String nome;

	@NotBlank(message = "{impiegato.cognome.notblank}")
	@Column(name = "cognome")
	private String cognome;

	@NotBlank(message = "{impiegato.matricola.notblank}")
	@Column(name = "matricola")
	private String matricola;

	@NotNull(message = "{impiegato.dataDiNascita.notnull}")
	@Column(name = "datadinascita")
	private LocalDate dataDiNascita;

	@NotNull(message = "{impiegato.stato.notblank}")
	@Column(name = "stato")
	@Enumerated(EnumType.STRING)
	private StatoImpiegato stato;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public StatoImpiegato getStato() {
		return stato;
	}

	public void setStato(StatoImpiegato stato) {
		this.stato = stato;
	}

}
