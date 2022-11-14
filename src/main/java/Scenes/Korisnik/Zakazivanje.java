package Scenes.Korisnik;

import Database.DoktorController;
import Database.PregledController;
import Entities.Doktor;
import Entities.Pregled;
import Scenes.Login;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Zakazivanje extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Label naslovLabel = new Label("Zakazite pregled");
    private Label unosLabel = new Label("Opisite vase simptome");
    private Label messageLabel = new Label("");

    private TextArea opsisField = new TextArea();

    private ComboBox doktorCombo = new ComboBox();

    private Button nazadButton = new Button("Nazad");
    private Button posaljiButton = new Button("Zakazi");

    @Override
    public void start(Stage stage) {
        doktorCombo.getItems().addAll(DoktorController.citajDoktore());
        doktorCombo.getSelectionModel().selectFirst();
        HBox buttonBox = new HBox(nazadButton, posaljiButton);
        buttonBox.setSpacing(20);
        buttonBox.setPadding(new Insets(20));
        buttonBox.setAlignment(Pos.CENTER);
        nazadButton.setMinWidth(100);
        posaljiButton.setMinWidth(100);
        VBox root = new VBox(naslovLabel, unosLabel, opsisField, doktorCombo, messageLabel, buttonBox);
        root.setSpacing(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        opsisField.setMaxWidth(200);
        opsisField.setMaxHeight(200);
        opsisField.setWrapText(true);
        doktorCombo.setMaxWidth(150);
        Scene scene = new Scene(root, 400, 500);
        stage.setTitle("Korisnik meni");
        stage.setScene(scene);
        stage.show();

        nazadButton.setOnAction(actionEvent -> {
            stage.close();
            try {
                new KorisnikMeni().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        posaljiButton.setOnAction(actionEvent -> {
            if (opsisField.getText().equals("")) {
                messageLabel.setText("Opis problema je prazan!");
                messageLabel.setTextFill(Color.RED);
            } else {
                Pregled p1 = new Pregled();
                p1.setOpis(opsisField.getText());
                p1.setPacijent(Login.getCurrentKorisnik());
                p1.setDoktor((Doktor) doktorCombo.getSelectionModel().getSelectedItem());
                PregledController.dodajPregled(p1);
                messageLabel.setText("Uspesno ste poslali zahtev za pregled!");
                messageLabel.setTextFill(Color.GREEN);
            }
        });
    }
}
