package Scenes.Doktor;

import Database.DoktorController;
import Entities.Doktor;
import Enums.Struka;
import Scenes.Login;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Odabir extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Label naslovLabel = new Label("Odaberite vasu struku!");
    private Label messageLabel = new Label("Uspesno ste odabrali struku");

    private ToggleGroup dugmici = new ToggleGroup();
    private RadioButton hirurgDugme = new RadioButton("Hirurg");
    private RadioButton opstaDugme = new RadioButton("Opsta Praska");
    private RadioButton psihijatarDugme = new RadioButton("Psihijatar");
    private RadioButton stomatologDugme = new RadioButton("Stomatolog");

    private Button promeniButton = new Button("Odaberite");
    private Button backButton = new Button("Nazad");

    @Override
    public void start(Stage stage) {
        hirurgDugme.setToggleGroup(dugmici);
        opstaDugme.setToggleGroup(dugmici);
        psihijatarDugme.setToggleGroup(dugmici);
        stomatologDugme.setToggleGroup(dugmici);
        messageLabel.setVisible(false);
        messageLabel.setTextFill(Color.GREEN);

        HBox buttonBox1 = new HBox(hirurgDugme, opstaDugme);
        HBox buttonBox2 = new HBox(psihijatarDugme, stomatologDugme);
        buttonBox1.setAlignment(Pos.CENTER);
        buttonBox2.setAlignment(Pos.CENTER);
        buttonBox1.setSpacing(10);
        buttonBox1.setPadding(new Insets(10));
        buttonBox2.setSpacing(10);
        buttonBox2.setPadding(new Insets(10));
        VBox root = new VBox(naslovLabel, buttonBox1, buttonBox2, messageLabel, promeniButton, backButton);
        root.setSpacing(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 320, 400);
        stage.setTitle("Korisnik meni");
        stage.setScene(scene);
        stage.show();

        if (Login.getCurrentDoktor().getStruka().equals(Struka.HIRURG)) {
            hirurgDugme.setSelected(true);
        } else if (Login.getCurrentDoktor().getStruka().equals(Struka.STOMATOLOG)) {
            stomatologDugme.setSelected(true);
        } else if (Login.getCurrentDoktor().getStruka().equals(Struka.PSIHIJATAR)) {
            psihijatarDugme.setSelected(true);
        } else if (Login.getCurrentDoktor().getStruka().equals(Struka.OPSTA_PRAKSA)) {
            opstaDugme.setSelected(true);
        }

        backButton.setOnAction(actionEvent -> {
            stage.close();
            try {
                new DoktorMeni().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        promeniButton.setOnAction(actionEvent -> {
            Doktor trenutniDoktor = Login.getCurrentDoktor();
            if (hirurgDugme.isSelected()) {
                trenutniDoktor.setStruka(Struka.HIRURG);
            } else if (psihijatarDugme.isSelected()) {
                trenutniDoktor.setStruka(Struka.PSIHIJATAR);
            } else if (opstaDugme.isSelected()) {
                trenutniDoktor.setStruka(Struka.OPSTA_PRAKSA);
            } else {
                trenutniDoktor.setStruka(Struka.STOMATOLOG);
            }
            DoktorController.UpdejtujDoktora(trenutniDoktor);
            Login.setCurrentDoktor(trenutniDoktor);
            messageLabel.setVisible(true);
        });
    }
}
