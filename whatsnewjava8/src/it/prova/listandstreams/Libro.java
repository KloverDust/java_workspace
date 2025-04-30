package it.prova.listandstreams;

public class Libro {

	private Long id;
	private String titolo;
	private String genere;
	private Integer pagine;
	private Autore autore;

	public Libro() {
	}

	public Libro(Long id, String titolo, String genere, Integer pagine, Autore autore) {
		this.id = id;
		this.titolo = titolo;
		this.genere = genere;
		this.pagine = pagine;
		this.autore = autore;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public Integer getPagine() {
		return pagine;
	}

	public void setPagine(Integer pagine) {
		this.pagine = pagine;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

}
