package model.remanencia.bd;

import model.remanencia.bd.tablas.Futbolista;
import model.remanencia.persistencia;

import java.sql.*;
import java.util.ArrayList;

public class FutbolistaBD implements persistencia<Futbolista> {
    ArrayList<Futbolista> lista = new ArrayList<>();

    @Override
    public Futbolista find(String who) {
        return null;
    }

    @Override
    public void update(int id, Futbolista dato) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public boolean add(Futbolista dato) {
        return false;
    }

    @Override
    public void saveAll(ArrayList<Futbolista> lista) {

    }

    @Override
    public ArrayList<Futbolista> loadAll() {
        ArrayList<Futbolista> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM futbolista");

            // loop through the result set
            while (rs.next()) {
                list.add(new Futbolista(
                rs.getInt("idFutbolista"),
                rs.getInt("anioNacimiento"),
                rs.getString("apellido"),
                rs.getInt("dorsal"),
                rs.getFloat("idEquipo"),
                rs.getString("mote"),
                rs.getString("nombre")
                ));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection(conn);
        }
        return list;
    }

    private void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection connect() {
        try {
            Connection connect = DriverManager.getConnection("jdbc:sqlite:futbolistas.db");
            if (connect != null) {
                System.out.println("Conectado");
            }
            return connect;
        } catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
            return null;
        }
    }

}
