package Database;

import Entities.Korisnik;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KorisnikController {
    public static Connection connection;

    public static void dodajKorisnika(Korisnik korisnik) {
        try {
            connection = DBConnector.openConnection();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO korisnik " +
                    "(ime_korisnika, prezime_korisnika, sifra, email) VALUES (?, ?, ?, ?)");
            stmt.setString(1, korisnik.getIme());
            stmt.setString(2, korisnik.getPrezime());
            stmt.setString(3, korisnik.getSifra());
            stmt.setString(4, korisnik.getEmail());
            stmt.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Korisnik> citajKorisnike() {
        List<Korisnik> korisnici = new ArrayList<>();
        try {
            connection = DBConnector.openConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM korisnik");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Korisnik korisnik = new Korisnik();
                korisnik.setId(rs.getInt("id"));
                korisnik.setIme(rs.getString("ime_korisnika"));
                korisnik.setPrezime(rs.getString("prezime_korisnika"));
                korisnik.setSifra(rs.getString("sifra"));
                korisnik.setEmail(rs.getString("email"));
                korisnici.add(korisnik);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return korisnici;
    }

    public static void updejtujKorisnika(Korisnik korisnik) {
        try {
            connection = DBConnector.openConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE korisnik SET ime_korisnika = ?, prezime_korisnika = ?, email = ?, sifra = ? WHERE id = ?");
            stmt.setString(1, korisnik.getIme());
            stmt.setString(2, korisnik.getPrezime());
            stmt.setString(3, korisnik.getEmail());
            stmt.setString(4, korisnik.getSifra());
            stmt.setInt(5, korisnik.getId());
            stmt.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
