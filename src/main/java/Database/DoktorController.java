package Database;

import Entities.Doktor;
import Entities.Korisnik;
import Enums.Struka;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoktorController {
    public static Connection connection;

    public static void dodajDoktora(Doktor doktor) {
        try {
            connection = DBConnector.openConnection();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO doktor " +
                    "(ime_doktora, prezime_doktora, sifra, struka, email) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, doktor.getIme());
            stmt.setString(2, doktor.getPrezime());
            stmt.setString(3, doktor.getSifra());
            stmt.setString(4, String.valueOf(doktor.getStruka()));
            stmt.setString(5, doktor.getEmail());
            stmt.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void UpdejtujDoktora(Doktor doktor) {
        try {
            connection = DBConnector.openConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE doktor SET ime_doktora = ?, prezime_doktora = ?, struka = ?, sifra = ?, email = ? WHERE id = ?");
            stmt.setString(1, doktor.getIme());
            stmt.setString(2, doktor.getPrezime());
            stmt.setString(4, doktor.getSifra());
            stmt.setString(3, String.valueOf(doktor.getStruka()));
            stmt.setString(5, doktor.getEmail());
            stmt.setInt(6, doktor.getId());
            stmt.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Doktor> citajDoktore() {
        List<Doktor> doktori = new ArrayList<>();
        try {
            connection = DBConnector.openConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM doktor");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Doktor doktor = new Doktor();
                doktor.setId(rs.getInt("id"));
                doktor.setIme(rs.getString("ime_doktora"));
                doktor.setPrezime(rs.getString("prezime_doktora"));
                doktor.setSifra(rs.getString("sifra"));
                doktor.setEmail(rs.getString("email"));
                doktor.setStruka(Struka.valueOf(rs.getString("struka")));
                doktori.add(doktor);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return doktori;
    }
}

