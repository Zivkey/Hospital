package Scenes;

import Database.DoktorController;
import Database.KorisnikController;
import Entities.Doktor;
import Entities.Korisnik;
import Enums.Struka;
import Util.EmailUtil;
import Util.FxUtil;
import Util.ProveraUtil;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class Register extends Application {
    private Label titleLabel = new Label("Registrujte se");
    private Label imeLabel = new Label("Unesite korisnicko ime:");
    private Label sifraLabel = new Label("Unesite sifru:");
    private Label prezimeLabel = new Label("Unesite prezime:");
    private Label emailLabel = new Label("Unesite email:");
    private Label messageLabel = new Label(" ");

    private TextField imeField = new TextField();
    private PasswordField sifraField = new PasswordField();
    private TextField prezimeField = new TextField();
    private TextField emailField = new TextField();

    private Button loginDugme = new Button("Uloguj se");
    private Button registerDugme = new Button("Registruj se");

    private ToggleGroup dugmiciGrupa = new ToggleGroup();
    private RadioButton doktorDugme = new RadioButton("Doktor");
    private RadioButton korisnikDugme = new RadioButton("Korisnik");
    @Override
    public void start(Stage stage) throws Exception {
        imeField.setMaxWidth(150);
        sifraField.setMaxWidth(150);
        prezimeField.setMaxWidth(150);
        emailField.setMaxWidth(150);
        doktorDugme.setToggleGroup(dugmiciGrupa);
        korisnikDugme.setToggleGroup(dugmiciGrupa);
        korisnikDugme.setSelected(true);
        List<Button> dugmici = Arrays.asList(loginDugme, registerDugme);
        HBox dugmiciBox = FxUtil.dugmeBox(dugmici);
        HBox doktorKorisnik = new HBox(korisnikDugme, doktorDugme);
        VBox root = new VBox(titleLabel, imeLabel, imeField, prezimeLabel, prezimeField, emailLabel, emailField, sifraLabel, sifraField, doktorKorisnik, messageLabel, dugmiciBox);
        root.setSpacing(20);
        doktorKorisnik.setSpacing(20);
        root.setPadding(new Insets(20));
        doktorKorisnik.setPadding(new Insets(20));
        doktorKorisnik.setAlignment(Pos.CENTER);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 350, 550);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        imeField.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                prezimeField.requestFocus();
            }
        });

        prezimeField.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                emailField.requestFocus();
            }
        });

        emailField.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                sifraField.requestFocus();
            }
        });

        sifraField.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                registerDugme.fire();
            }
        });

        registerDugme.setOnAction(actionEvent -> {
            if (ProveraUtil.proveraRec(imeField.getText()) && ProveraUtil.proveraRec(prezimeField.getText()) && sifraField.getText().length() > 4 &&
                    emailField.getText().contains("@gmail.com") && EmailUtil.proveriMail(emailField.getText())) {
                if (korisnikDugme.isSelected()) {
                    Korisnik k1 = new Korisnik(imeField.getText(), prezimeField.getText(), sifraField.getText(), emailField.getText());
                    KorisnikController.dodajKorisnika(k1);
                    imeField.setText("");
                    prezimeField.setText("");
                    sifraField.setText("");
                    messageLabel.setText("Uspesno ste dodali korisnika");
                    messageLabel.setTextFill(Color.GREEN);
                } else {
                    Doktor d1 = new Doktor(imeField.getText(), prezimeField.getText(), emailField.getText(), Struka.NEMA, sifraField.getText());
                    DoktorController.dodajDoktora(d1);
                    imeField.setText("");
                    prezimeField.setText("");
                    sifraField.setText("");
                    messageLabel.setText("Uspesno ste dodali doktora");
                    messageLabel.setTextFill(Color.GREEN);
                }
            } else {
                messageLabel.setText("Niste lepo uneli podatke");
                messageLabel.setTextFill(Color.RED);
            }
        });

        loginDugme.setOnAction(actionEvent -> {
            stage.close();
            try {
                new Login().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }


}
