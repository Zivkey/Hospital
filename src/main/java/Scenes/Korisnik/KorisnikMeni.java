package Scenes.Korisnik;

import Scenes.Login;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class KorisnikMeni extends Application {

    private Label naslovLabel = new Label();
    private Button zakazivanjeButton = new Button("Zakazi pregled");
    private Button izmeniButton = new Button("Izmeni podatke");
    private Button zakazaniButton = new Button("Status pregleda");
    private Button nazadButton = new Button("Izloguj se");

    @Override
    public void start(Stage stage) throws Exception {
        String naslov = "Dobro dosli " + Login.getCurrentKorisnik().getIme() + " " + Login.getCurrentKorisnik().getPrezime();
        naslovLabel.setText(naslov);
        VBox root = new VBox(naslovLabel, zakazivanjeButton, zakazaniButton, izmeniButton, nazadButton);
        root.setSpacing(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        zakazivanjeButton.setMaxWidth(150);
        zakazaniButton.setMaxWidth(150);
        nazadButton.setMaxWidth(150);
        izmeniButton.setMaxWidth(150);
        Scene scene = new Scene(root, 320, 400);
        stage.setTitle("Korisnik meni");
        stage.setScene(scene);
        stage.show();

        nazadButton.setOnAction(actionEvent -> {
            stage.close();
            try {
                new Login().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        izmeniButton.setOnAction(actionEvent -> {
            stage.close();
            try {
                new Izmena().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        zakazaniButton.setOnAction(actionEvent -> {
            stage.close();
            try {
                new Status().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        zakazivanjeButton.setOnAction(actionEvent -> {
            stage.close();
            try {
                new Zakazivanje().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
