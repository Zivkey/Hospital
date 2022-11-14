package Util;

import Entities.Korisnik;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class TableUtil {

    public static TableView<Korisnik> prikaziPacijente(List<Korisnik> listKorisnika) {
        TableView<Korisnik> pacijenti = new TableView<>();

        TableColumn<Korisnik, String> imeColumn = new TableColumn<>("Ime:");
        TableColumn<Korisnik, String> prezimeColumn = new TableColumn<>("Prezime:");
        TableColumn<Korisnik, String> sifraColumn = new TableColumn<>("Sifra:");
        TableColumn<Korisnik, String> emailColumn = new TableColumn<>("Email:");

        imeColumn.setCellValueFactory(new PropertyValueFactory<>("ime"));
        prezimeColumn.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        sifraColumn.setCellValueFactory(new PropertyValueFactory<>("sifra"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        pacijenti.getColumns().add(imeColumn);
        pacijenti.getColumns().add(prezimeColumn);
        pacijenti.getColumns().add(sifraColumn);
        pacijenti.getColumns().add(emailColumn);

        imeColumn.setMinWidth(70);
        prezimeColumn.setMinWidth(70);
        sifraColumn.setMinWidth(70);
        emailColumn.setMinWidth(180);


        for (Korisnik x : listKorisnika) {
            pacijenti.getItems().add(x);
        }

        return pacijenti;

    }
}
