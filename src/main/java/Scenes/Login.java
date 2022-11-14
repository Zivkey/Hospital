package Scenes;

import Database.DoktorController;
import Database.KorisnikController;
import Entities.Doktor;
import Entities.Korisnik;
import Scenes.Doktor.DoktorMeni;
import Scenes.Korisnik.KorisnikMeni;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;

public class Login extends Application {

    private static Doktor currentDoktor;
    private static Korisnik currentKorisnik;

    private Label titleLabel = new Label("Dobrodosli");
    private Label imeLabel = new Label("Unesite email:");
    private Label sifraLabel = new Label("Unesite sifru:");
    private Label porukaLabel = new Label("Niste lepo uneli ime ili sifru");

    private TextField imeField = new TextField();
    private PasswordField sifraField = new PasswordField();

    private Button loginDugme = new Button("Uloguj se");
    private Button registerDugme = new Button("Registruj se");

    @Override
    public void start(Stage stage) throws Exception {
        porukaLabel.setVisible(false);
        porukaLabel.setTextFill(Color.RED);
        List<Korisnik> korisnici = KorisnikController.citajKorisnike();
        List<Doktor> doktori = DoktorController.citajDoktore();
        imeField.setMaxWidth(150);
        sifraField.setMaxWidth(150);
        HBox dugmeBox = new HBox(loginDugme, registerDugme);
        dugmeBox.setSpacing(20);
        dugmeBox.setPadding(new Insets(20));
        VBox root = new VBox(titleLabel, imeLabel, imeField, sifraLabel, sifraField, porukaLabel, dugmeBox);
        root.setSpacing(30);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        dugmeBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 350, 400);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);

        sifraField.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                loginDugme.fire();
            }
        });

        imeField.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                sifraField.requestFocus();
            }
        });

        registerDugme.setOnAction(actionEvent -> {
            stage.close();
            try {
                new Register().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        loginDugme.setOnAction(actionEvent -> {
            String email = imeField.getText();
            String sifra = sifraField.getText();
            for (Korisnik k : korisnici) {
                if (k.getEmail().equalsIgnoreCase(email) && k.getSifra().equals(sifra)) {
                    setCurrentKorisnik(k);
                    stage.close();
                    try {
                        new KorisnikMeni().start(stage);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            for (Doktor d : doktori) {
                if (d.getEmail().equalsIgnoreCase(email) && d.getSifra().equals(sifra)) {
                    setCurrentDoktor(d);
                    stage.close();
                    try {
                        new DoktorMeni().start(stage);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            porukaLabel.setVisible(true);
        });


    }

    public static Doktor getCurrentDoktor() {
        return currentDoktor;
    }

    public static void setCurrentDoktor(Doktor currentDoktor) {
        Login.currentDoktor = currentDoktor;
    }

    public static Korisnik getCurrentKorisnik() {
        return currentKorisnik;
    }

    public static void setCurrentKorisnik(Korisnik currentKorisnik) {
        Login.currentKorisnik = currentKorisnik;
    }

    public static void main(String[] args) {
        launch();
    }
}
