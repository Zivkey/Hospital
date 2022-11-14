package Scenes.Korisnik;

import Database.KorisnikController;
import Entities.Korisnik;
import Scenes.Login;
import Util.EmailUtil;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Izmena extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public Label naslovLabel = new Label("Promenite vase podatke");
    private Label emailLabel = new Label("Promenite email");
    private Label sifraLabel = new Label("Promenite sifru");
    private Label sifraDvaLabel = new Label("Ukucajte sifru ponovo");
    private Label messageLabel = new Label();

    private TextField emailField = new TextField();
    private PasswordField sifraField = new PasswordField();
    private PasswordField ponoviSifruField = new PasswordField();

    private Button promeniButton = new Button("Promeni");
    private Button nazadButton = new Button("Nazad");

    @Override
    public void start(Stage stage) {
        HBox buttonBox = new HBox(nazadButton, promeniButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(20);
        emailField.setText(Login.getCurrentKorisnik().getEmail());
        VBox root = new VBox(naslovLabel, emailLabel, emailField, sifraLabel, sifraField, sifraDvaLabel, ponoviSifruField, messageLabel, buttonBox);
        emailField.setMaxWidth(150);
        sifraField.setMaxWidth(150);
        ponoviSifruField.setMaxWidth(150);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        root.setPadding(new Insets(20));
        Scene scene = new Scene(root, 400, 500);
        stage.setTitle("Korisnik meni");
        stage.setScene(scene);
        stage.show();

        promeniButton.setOnAction(actionEvent -> {
            if (!sifraField.getText().equals(ponoviSifruField.getText())) {
                messageLabel.setText("Nije dobra sifra");
                messageLabel.setTextFill(Color.RED);

            } else if (!emailField.getText().contains("@gmail.com") || !EmailUtil.proveriMail(emailField.getText())) {
                messageLabel.setText("Nije dobar email");
                messageLabel.setTextFill(Color.RED);
            } else {
                messageLabel.setText("Uspeno ste promenili podatke!");
                messageLabel.setTextFill(Color.GREEN);
                Korisnik k1 = Login.getCurrentKorisnik();
                k1.setEmail(emailField.getText());
                if (sifraField.getText().length() != 0) {
                    k1.setSifra(sifraField.getText());
                }
                KorisnikController.updejtujKorisnika(k1);
            }
        });

        nazadButton.setOnAction(actionEvent -> {
            stage.close();
            try {
                new KorisnikMeni().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
