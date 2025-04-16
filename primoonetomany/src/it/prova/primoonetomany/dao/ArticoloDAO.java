package it.prova.primoonetomany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.primoonetomany.connection.MyConnection;
import it.prova.primoonetomany.model.Articolo;
import it.prova.primoonetomany.model.Negozio;

public class ArticoloDAO {

	public List<Articolo> list() {

		List<Articolo> result = new ArrayList<Articolo>();

		try (Connection c = MyConnection.getConnection();
				Statement s = c.createStatement();
				// STRATEGIA EAGER FETCHING
				ResultSet rs = s.executeQuery("select * from articolo a inner join negozio n on n.id=a.negozio_id")) {

			while (rs.next()) {
				Articolo articoloTemp = new Articolo();
				articoloTemp.setNome(rs.getString("a.NOME"));
				articoloTemp.setMatricola(rs.getString("matricola"));
				articoloTemp.setId(rs.getLong("a.id"));

				Negozio negozioTemp = new Negozio();
				negozioTemp.setId(rs.getLong("n.id"));
				negozioTemp.setNome(rs.getString("n.nome"));
				negozioTemp.setIndirizzo(rs.getString("indirizzo"));
				negozioTemp.setDataApertura(
						rs.getDate("dataapertura") != null ? rs.getDate("dataapertura").toLocalDate() : null);


				articoloTemp.setNegozio(negozioTemp);
				result.add(articoloTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// rilancio in modo tale da avvertire il chiamante
			throw new RuntimeException(e);
		}
		return result;
	}

	public Articolo findById(Long idArticoloInput) {

		if (idArticoloInput == null || idArticoloInput < 1)
			throw new RuntimeException("Impossibile recuperare Articolo: id mancante!");

		Articolo result = null;
		try (Connection c = MyConnection.getConnection();
				PreparedStatement ps = c.prepareStatement("select * from articolo a where a.id=?")) {

			ps.setLong(1, idArticoloInput);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					result = new Articolo();
					result.setNome(rs.getString("NOME"));
					result.setMatricola(rs.getString("matricola"));
					result.setId(rs.getLong("id"));
				} else {
					result = null;
				}
			} // niente catch qui

		} catch (Exception e) {
			e.printStackTrace();
			// rilancio in modo tale da avvertire il chiamante
			throw new RuntimeException(e);
		}
		return result;
	}

	public int insert(Articolo articoloInput) {

		if (articoloInput.getNegozio() == null || articoloInput.getNegozio().getId() < 1)
			throw new RuntimeException("Impossibile inserire Articolo: Negozio mancante!");

		int result = 0;
		try (Connection c = MyConnection.getConnection();
				PreparedStatement ps = c
						.prepareStatement("INSERT INTO articolo (nome, matricola,negozio_id) VALUES (?, ?, ?)")) {

			ps.setString(1, articoloInput.getNome());
			ps.setString(2, articoloInput.getMatricola());
			ps.setLong(3, articoloInput.getNegozio().getId());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// rilancio in modo tale da avvertire il chiamante
			throw new RuntimeException(e);
		}
		return result;
	}

	// TODO

	public Articolo findByIdEager(Long idInput) {
		Articolo result;

		try (Connection c = MyConnection.getConnection();
			 PreparedStatement ps = c
					 .prepareStatement("select * from articolo a inner join negozio n on n.id=a.negozio_id WHERE a.id = ?")) {

			ps.setLong(1, idInput);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Articolo articoloTemp = new Articolo();
					articoloTemp.setNome(rs.getString("a.NOME"));
					articoloTemp.setMatricola(rs.getString("matricola"));
					articoloTemp.setId(rs.getLong("a.id"));

					Negozio negozioTemp = new Negozio();
					negozioTemp.setId(rs.getLong("n.id"));
					negozioTemp.setNome(rs.getString("n.nome"));
					negozioTemp.setIndirizzo(rs.getString("indirizzo"));
					negozioTemp.setDataApertura(rs.getDate("dataapertura") != null ? rs.getDate("dataapertura").toLocalDate() : null);

					articoloTemp.setNegozio(negozioTemp);
					result = articoloTemp;
				} else {
					result = null;
				}
			} // niente catch qui
		} catch (Exception e) {
			e.printStackTrace();
			// rilancio in modo tale da avvertire il chiamante
			throw new RuntimeException(e);
		}
		return result;
	}

	public int update(Articolo articoloInput) {
		if (articoloInput == null )
			throw new RuntimeException("Impossibile aggiornare Articolo: id mancante o non valido!");

		int result = 0;
		try (
				Connection c = MyConnection.getConnection();
			 	PreparedStatement ps = c.prepareStatement("UPDATE articolo SET nome=?, matricola=?, negozio_id=? WHERE id=?")) {

			ps.setString(1, articoloInput.getNome());
			ps.setString(2, articoloInput.getMatricola());
			ps.setLong(3, articoloInput.getNegozio().getId());
			if (articoloInput.getNegozio() != null) {
				ps.setLong(3, articoloInput.getNegozio().getId());
			} else {
				ps.setNull(3, java.sql.Types.BIGINT);
			}
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return result;
	}

	public int delete(Long idToDelete) {
		if (idToDelete == null || idToDelete < 1)
			throw new RuntimeException("Impossibile eliminare Articolo: id mancante o non valido!");

		int result = 0;
		try (Connection c = MyConnection.getConnection();
			 PreparedStatement ps = c.prepareStatement("DELETE FROM articolo WHERE id=?")) {
			ps.setLong(1, idToDelete);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return result;
	}

	// CARICAMENTO EAGER -> VADO A POPOLARE IL CAMPO NEGOZIO DI ARTICOLO
	public List<Articolo> findAllByNegozio(Negozio negozioInput) {
		if (negozioInput == null)
			throw new RuntimeException("Impossibile proseguire: negozioInput mancante!");

		List<Articolo> result = new ArrayList<>();


		try (Connection c = MyConnection.getConnection();
			 PreparedStatement ps = c.prepareStatement(
					 "SELECT a.*, n.* FROM articolo a, negozio n " +
							 "WHERE a.negozio_id = n.id " +
							 "AND n.id = ?")) {

			ps.setLong(1, negozioInput.getId());

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Articolo tempArticolo = new Articolo();
					tempArticolo.setNome(rs.getString("a.nome"));
					tempArticolo.setMatricola(rs.getString("a.matricola"));
					tempArticolo.setId(rs.getLong("a.id"));

					Negozio tempNegozio = new Negozio();
					tempNegozio.setNome(rs.getString("n.nome"));
					tempNegozio.setDataApertura(rs.getDate("n.dataapertura").toLocalDate());
					tempNegozio.setIndirizzo(rs.getString("n.indirizzo"));
					tempNegozio.setId(rs.getLong("n.id"));

					tempArticolo.setNegozio(tempNegozio);
					result.add(tempArticolo);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

			throw new RuntimeException(e);
		}
		return result;
	}

	// CARICAMENTO LAZY -> NON VADO A POPOLARE IL CAMPO NEGOZIO DI ARTICOLO
	public List<Articolo> findAllByMatricola(String matricolaInput) {
		if (matricolaInput == null)
			throw new RuntimeException("Impossibile proseguire: negozioInput mancante!");

		List<Articolo> result = new ArrayList<>();

		try (Connection c = MyConnection.getConnection();
			 PreparedStatement ps = c.prepareStatement(
					 "SELECT a.* FROM articolo a " +
							 "WHERE a.matricola = ? ")) {

			ps.setString(1, matricolaInput);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Articolo tempArticolo = new Articolo();
					tempArticolo.setNome(rs.getString("nome"));
					tempArticolo.setMatricola(rs.getString("matricola"));
					tempArticolo.setId(rs.getLong("id"));

					result.add(tempArticolo);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

			throw new RuntimeException(e);
		}
		return result;
	}

	// CARICAMENTO LAZY
	public List<Articolo> findAllByIndirizzoNegozio(String indirizzoNegozioInput) {
		if (indirizzoNegozioInput == null)
			throw new RuntimeException("Impossibile proseguire: indirizzoNegozioInput mancante!");

		List<Articolo> result = new ArrayList<>();

		try (Connection c = MyConnection.getConnection();
			 PreparedStatement ps = c.prepareStatement(
					 "SELECT a.* FROM articolo a, negozio n " +
							 "WHERE a.negozio_id = n.id " +
							 "AND n.indirizzo LIKE ? ")) {

			ps.setString(1, '%' + indirizzoNegozioInput +'%');

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Articolo tempArticolo = new Articolo();
					tempArticolo.setNome(rs.getString("nome"));
					tempArticolo.setMatricola(rs.getString("matricola"));
					tempArticolo.setId(rs.getLong("id"));

					result.add(tempArticolo);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

			throw new RuntimeException(e);
		}
		return result;
	}

}
