package Scenes.Doktor;

import Scenes.Login;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DoktorMeni extends Application {

    private Label naslovlabel = new Label();
    private Button odabirButton = new Button("Odabir struke");
    private Button zahteviButton = new Button("Odobravanje pregleda");
    private Button listaButton = new Button("Lista pacijenata");
    private Button logoutButton = new Button("Izlogujte se");

    @Override
    public void start(Stage stage) throws Exception {
        String naslov = "Dobro dosli Dr." + Login.getCurrentDoktor().getPrezime();
        naslovlabel.setText(naslov);
        VBox root = new VBox(naslovlabel, odabirButton, zahteviButton, listaButton, logoutButton);
        root.setSpacing(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        odabirButton.setMaxWidth(150);
        zahteviButton.setMaxWidth(150);
        listaButton.setMaxWidth(150);
        logoutButton.setMaxWidth(150);

        Scene scene = new Scene(root, 320, 400);
        stage.setTitle("Doktor meni");
        stage.setScene(scene);
        stage.show();

        odabirButton.setOnAction(actionEvent -> {
            stage.close();
            try {
                new Odabir().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        zahteviButton.setOnAction(actionEvent -> {
            stage.close();
            try {
                new Zahtevi().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        listaButton.setOnAction(actionEvent -> {
            stage.close();
            try {
                new ListaPacijenata().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        logoutButton.setOnAction(actionEvent -> {
            stage.close();
            try {
                new Login().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

    }

}
