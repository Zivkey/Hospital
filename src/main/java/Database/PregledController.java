package Database;

import Entities.Doktor;
import Entities.Korisnik;
import Entities.Pregled;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PregledController {
    public static Connection connection;

    public static void dodajPregled(Pregled pregled) {
        try {
            connection = DBConnector.openConnection();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO pregled " +
                    "(id_doktora, id_pacijenta, opis_problema, odobren) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, pregled.getDoktor().getId());
            stmt.setInt(2, pregled.getPacijent().getId());
            stmt.setString(3, pregled.getOpis());
            stmt.setBoolean(4, pregled.isOdobren());
            stmt.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updejtujPregled(Pregled pregled) {
        try {
            connection = DBConnector.openConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE pregled SET opis_problema = ?, odobren = ? WHERE id = ?");
            stmt.setString(1, pregled.getOpis());
            stmt.setBoolean(2, pregled.isOdobren());
            stmt.setInt(3, pregled.getId());
            stmt.execute();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Pregled> citajPreglede() {
        List<Pregled> pregledi = new ArrayList<>();
        try {
            connection = DBConnector.openConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM pregled");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Pregled pregled = new Pregled();
                pregled.setId(rs.getInt("id"));
                Doktor d1 = new Doktor();
                int idDoktora = rs.getInt("id_doktora");
                for (Doktor d : DoktorController.citajDoktore()) {
                    if (d.getId() == idDoktora) {
                        d1 = d;
                    }
                }
                Korisnik k1 = new Korisnik();
                int idKorisnika = rs.getInt("id_pacijenta");
                for (Korisnik k : KorisnikController.citajKorisnike()) {
                    if (k.getId() == idKorisnika) {
                        k1 = k;
                    }
                }
                pregled.setDoktor(d1);
                pregled.setPacijent(k1);
                pregled.setOdobren(rs.getBoolean("odobren"));
                pregled.setOpis(rs.getString("opis_problema"));
                pregledi.add(pregled);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pregledi;
    }
}

