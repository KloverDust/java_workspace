package it.prova.dao.televisore;

import it.prova.dao.AbstractMySQLDAO;
import it.prova.model.Televisore;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TelevisoreDAOImpl extends AbstractMySQLDAO implements TelevisoreDAO {


    @Override
    public List<Televisore> list() throws Exception {

        if (isNotActive())
            throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

        ArrayList<Televisore> result = new ArrayList<Televisore>();

        try (Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery("select * from televisore")) {

            while (rs.next()) {
                Televisore televisoreTemp = new Televisore();
                televisoreTemp.setMarca(rs.getString("marca"));
                televisoreTemp.setModello(rs.getString("modello"));
                televisoreTemp.setPollici(rs.getInt("pollici"));
                televisoreTemp.setDataproduzione(rs.getDate("dataproduzione") != null ? rs.getDate("dataproduzione").toLocalDate() : null);
                televisoreTemp.setId(rs.getLong("id"));
                result.add(televisoreTemp);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    @Override
    public int insert(Televisore televisoreInput) throws Exception {

        if (isNotActive())
            throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

        if (televisoreInput == null)
            throw new Exception("Valore di input non ammesso.");

        int result = 0;
        try (PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO televisore (marca, modello, pollici, dataproduzione) VALUES (?, ?, ?, ?);")) {
            ps.setString(1, televisoreInput.getMarca());
            ps.setString(2, televisoreInput.getModello());

            if (televisoreInput.getPollici() != null) {
                ps.setInt(3, televisoreInput.getPollici());
            } else {
                ps.setNull(3, java.sql.Types.INTEGER);
            }

            if (televisoreInput.getDataproduzione() != null) {
                ps.setDate(4, java.sql.Date.valueOf(televisoreInput.getDataproduzione()));
            } else {
                ps.setDate(4, java.sql.Date.valueOf("1980-01-01"));
            }

            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    @Override
    public Televisore get(Long idInput) throws Exception {

        if (isNotActive())
            throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

        if (idInput == null || idInput < 1)
            throw new Exception("Valore di input non ammesso.");

        Televisore result = null;
        try (PreparedStatement ps = connection.prepareStatement("select * from televisore where id=?")) {
            ps.setLong(1, idInput);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    result = new Televisore();
                    result.setMarca(rs.getString("marca"));
                    result.setModello(rs.getString("modello"));
                    result.setPollici(rs.getInt("pollici"));
                    result.setDataproduzione(rs.getDate("dataproduzione") != null ? rs.getDate("dataproduzione").toLocalDate() : null);
                    result.setId(rs.getLong("id"));
                } else {
                    result = null;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    @Override
    public int update(Televisore televisoreInput) throws Exception {
        if (isNotActive())
            throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

        if (televisoreInput == null)
            throw new Exception("Valore di input non ammesso.");

        int result = 0;
        try (PreparedStatement ps = connection.prepareStatement(
                "UPDATE televisore SET marca = ?, modello = ?, pollici = ?, dataproduzione = ? WHERE id = ?")) {

            ps.setString(1, televisoreInput.getMarca());
            ps.setString(2, televisoreInput.getModello());

            if (televisoreInput.getPollici() != null) {
                ps.setInt(3, televisoreInput.getPollici());
            } else {
                ps.setNull(3, java.sql.Types.INTEGER);
            }

            if (televisoreInput.getDataproduzione() != null) {
                ps.setDate(4, java.sql.Date.valueOf(televisoreInput.getDataproduzione()));
            } else {
                ps.setDate(4, java.sql.Date.valueOf("1980-01-01"));
            }

            ps.setLong(5, televisoreInput.getId());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    @Override
    public int delete(Long idDaRimuovere) throws Exception {
        if (isNotActive())
            throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

        if (idDaRimuovere == null || idDaRimuovere < 1)
            throw new Exception("ID non valido per la rimozione.");

        int result = 0;
        try (PreparedStatement ps = connection.prepareStatement(
                "DELETE FROM televisore WHERE id = ?")) {

            ps.setLong(1, idDaRimuovere);
            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }


    @Override
    public List<Televisore> findByExample(Televisore input) throws Exception {
        return List.of();
    }

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Televisore findTelevisorePiuGrande() throws Exception {
        if (isNotActive())
            throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

        Televisore result = new Televisore();

        try (Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery("SELECT * " +
                "FROM televisore " +
                "WHERE pollici = (SELECT MAX(pollici) FROM televisore)" +
                "LIMIT 1; ")) {

            if (rs.next()) {
                result.setMarca(rs.getString("marca"));
                result.setModello(rs.getString("modello"));
                result.setPollici(rs.getInt("pollici"));
                result.setDataproduzione(rs.getDate("dataproduzione") != null ? rs.getDate("dataproduzione").toLocalDate() : null);
                result.setId(rs.getLong("id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    @Override
    public List<Televisore> findProdottiInIntervallo(LocalDate inizio, LocalDate fine) throws Exception {
        if (isNotActive())
            throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

        if (inizio == null || fine == null)
            throw new Exception("Le date di inizio e fine non possono essere null.");

        List<Televisore> result = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(
                "SELECT * FROM televisore WHERE dataproduzione BETWEEN ? AND ?")) {

            ps.setDate(1, java.sql.Date.valueOf(inizio));
            ps.setDate(2, java.sql.Date.valueOf(fine));

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Televisore tv = new Televisore();
                    tv.setId(rs.getLong("id"));
                    tv.setMarca(rs.getString("marca"));
                    tv.setModello(rs.getString("modello"));
                    tv.setPollici(rs.getInt("pollici"));
                    tv.setDataproduzione(rs.getDate("dataproduzione") != null ? rs.getDate("dataproduzione").toLocalDate() : null);
                    result.add(tv);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    @Override
    public List<Televisore> showDistintaMarcheUltimi6Mesi(LocalDate giorno) throws Exception {
        if (isNotActive())
            throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

        if (giorno == null)
            throw new Exception("La data di riferimento non può essere null.");

        List<Televisore> result = new ArrayList<>();

        LocalDate seiMesiPrima = giorno.minusMonths(6);

        String query = "SELECT DISTINCT marca, modello, pollici, dataproduzione, id FROM televisore WHERE dataproduzione BETWEEN ? AND ? ORDER BY marca; ";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setDate(1, java.sql.Date.valueOf(seiMesiPrima));
            ps.setDate(2, java.sql.Date.valueOf(giorno));

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Televisore tv = new Televisore();
                    tv.setId(rs.getLong("id"));
                    tv.setMarca(rs.getString("marca"));
                    tv.setModello(rs.getString("modello"));
                    tv.setPollici(rs.getInt("pollici"));
                    tv.setDataproduzione(rs.getDate("dataproduzione") != null ? rs.getDate("dataproduzione").toLocalDate() : null);
                    result.add(tv);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return result;
    }



}
