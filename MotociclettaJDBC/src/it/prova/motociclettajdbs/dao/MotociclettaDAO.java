package it.prova.motociclettajdbs.dao;

import it.prova.motociclettajdbs.model.Motocicletta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MotociclettaDAO {

    public Motocicletta findById(Long idInput) {
        if (idInput == null || idInput < 1) {
            return null;
        }

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Motocicletta result = null;

        try {
            connection = it.prova.lavoratorejdbc.connection.MyConnection.getConnection();
            ps = connection.prepareStatement("select * from Motocicletta where Motocicletta.id=?;");
            ps.setLong(1, idInput);
            rs = ps.executeQuery();

            if (rs.next()) {
                result = new Motocicletta();
                result.setId(rs.getLong("id"));
                result.setMarca(rs.getString("marca"));
                result.setModello(rs.getString("modello"));
                result.setCilindrata(rs.getInt("cilindrata"));
                result.setDataImmatricolazione(rs.getDate("dataImmatricolazione"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public List<Motocicletta> findAll(){

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Motocicletta temp = null;
        List<Motocicletta> result = new ArrayList<>();

        try {
            connection = it.prova.lavoratorejdbc.connection.MyConnection.getConnection();
            ps = connection.prepareStatement("select * from Motocicletta ;");
            rs = ps.executeQuery();

            while (rs.next()) {
                temp = new Motocicletta();
                temp.setId(rs.getLong("id"));
                temp.setMarca(rs.getString("marca"));
                temp.setModello(rs.getString("modello"));
                temp.setCilindrata(rs.getInt("cilindrata"));
                temp.setDataImmatricolazione(rs.getDate("dataImmatricolazione"));
                result.add(temp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    public int insert(Motocicletta motoDaInserire) {
        Connection connection = null;
        PreparedStatement ps = null;
        int result = 0;

        try {
            connection = it.prova.lavoratorejdbc.connection.MyConnection.getConnection();
            ps = connection.prepareStatement(
                    "INSERT INTO Motocicletta (marca, modello, cilindrata, dataImmatricolazione) " + "VALUES (?, ?, ?,?) ");
            ps.setString(1, motoDaInserire.getMarca());
            ps.setString(2, motoDaInserire.getModello());
            ps.setInt(3, motoDaInserire.getCilindrata());
            ps.setDate(4, new java.sql.Date(motoDaInserire.getDataImmatricolazione().getTime()));

            result = ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {
                ps.close();
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public int update(Motocicletta motoInput) {
        if (motoInput == null || motoInput.getId() < 1) {
            return 0;
        }

        Connection connection = null;
        PreparedStatement ps = null;
        int result = 0;

        try {

            connection = it.prova.lavoratorejdbc.connection.MyConnection.getConnection();
            ps = connection.prepareStatement("UPDATE Motocicletta SET marca=?, modello=?, cilindrata=?, dataImmatricolazione=? where id=?;");
            ps.setString(1, motoInput.getMarca());
            ps.setString(2, motoInput.getModello());
            ps.setInt(3, motoInput.getCilindrata());
            ps.setDate(4, new java.sql.Date(motoInput.getDataImmatricolazione().getTime()));
            ps.setLong(5, motoInput.getId());

            result = ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {
                ps.close();
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public int delete(Long idDaEliminate) {
        Connection connection = null;
        PreparedStatement ps = null;
        int result = 0;

        try {
            connection = it.prova.lavoratorejdbc.connection.MyConnection.getConnection();
            ps = connection.prepareStatement("DELETE FROM Motocicletta where id=? ;");
            ps.setLong(1, idDaEliminate);
            result = ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {
                ps.close();
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
