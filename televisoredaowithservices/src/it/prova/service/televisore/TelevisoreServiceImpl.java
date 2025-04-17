package it.prova.service.televisore;

import it.prova.connection.MyConnection;
import it.prova.dao.Constants;
import it.prova.dao.televisore.TelevisoreDAO;
import it.prova.model.Televisore;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TelevisoreServiceImpl implements TelevisoreService{
    private TelevisoreDAO televisoreDAO;

    @Override
    public void setTelevisoreDao(TelevisoreDAO televisoreDAO) {
        this.televisoreDAO = televisoreDAO;
    }

    @Override
    public List<Televisore> listAll() throws Exception {
        List<Televisore> result = new ArrayList<>();
        try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {
            televisoreDAO.setConnection(connection);
            result = televisoreDAO.list();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    @Override
    public Televisore findById(Long idInput) throws Exception {
        Televisore result = new Televisore();
        try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {
            televisoreDAO.setConnection(connection);
            result = televisoreDAO.get(idInput);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    @Override
    public int aggiorna(Televisore input) throws Exception {
        int result = 0;
        try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {
            televisoreDAO.setConnection(connection);
            result = televisoreDAO.update(input);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    @Override
    public int inserisciNuovo(Televisore input) throws Exception {
        if (input == null)
            throw new Exception("Valore di input non ammesso.");

        int result = 0;
        try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

            televisoreDAO.setConnection(connection);

            result = televisoreDAO.insert(input);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    @Override
    public int rimuovi(Long idDaRimuovere) throws Exception {
        if (idDaRimuovere == null)
            throw new Exception("Valore di input non ammesso.");

        int result = 0;
        try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {
            televisoreDAO.setConnection(connection);
            result = televisoreDAO.delete(idDaRimuovere);

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
    public Televisore trovaIlPiuGrande() throws Exception {
        Televisore result = new Televisore();
        try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {
            televisoreDAO.setConnection(connection);
            result = televisoreDAO.findTelevisorePiuGrande();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    @Override
    public List<Televisore> trovaProdottiInIntervallo(LocalDate inizio, LocalDate fine) throws Exception {
        List<Televisore> result;
        try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {
            televisoreDAO.setConnection(connection);
            result = televisoreDAO.findProdottiInIntervallo(inizio, fine);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    @Override
    public List<Televisore> listaDistintaMarcheUltimi6Mesi(LocalDate giorno) throws Exception {
        List<Televisore> result;
        try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {
            televisoreDAO.setConnection(connection);
            result = televisoreDAO.showDistintaMarcheUltimi6Mesi(giorno);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }


}
