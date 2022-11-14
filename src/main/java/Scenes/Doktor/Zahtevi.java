package Scenes.Doktor;

import Database.PregledController;
import Entities.Pregled;
import Scenes.Login;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Zahtevi extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Label naslovLabel = new Label("Zahtevi za pregled");
    private Button odobriDugme = new Button("Odobri");
    private Button nazadDugme = new Button("Nazad");
    private Label messageLabel = new Label("Uspesno ste updejtovali preglede!");

    @Override
    public void start(Stage stage) {
        messageLabel.setVisible(false);
        messageLabel.setTextFill(Color.GREEN);
        VBox root = new VBox();
        root.getChildren().add(naslovLabel);
        List<Pregled> pregledi = PregledController.citajPreglede();
        List<Pregled> noviPregledi = new ArrayList<>();
        for (Pregled p : pregledi) {
            if (p.getDoktor().getId() == Login.getCurrentDoktor().getId()) {
                noviPregledi.add(p);
            }
        }
        List<Pregled> preglediList = new ArrayList<>();
        List<CheckBox> dugmici = new ArrayList<>();
        VBox preglediBox = new VBox();
        for (Pregled p : noviPregledi) {
            preglediList.add(p);
            HBox hBox = new HBox();
            Label pacijent = new Label(p.getPacijent().getIme());
            Label opis = new Label(p.getOpis());
            CheckBox checker = new CheckBox();
            dugmici.add(checker);
            if (p.isOdobren()) {
                checker.setSelected(true);
            }
            hBox.getChildren().addAll(pacijent, opis, checker);
            hBox.setSpacing(20);
            hBox.setAlignment(Pos.CENTER);
            hBox.setPadding(new Insets(10));
            preglediBox.getChildren().add(hBox);
        }

        preglediBox.setSpacing(20);
        preglediBox.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(preglediBox);
        root.getChildren().add(messageLabel);
        root.getChildren().add(odobriDugme);
        root.getChildren().add(nazadDugme);
        root.setPadding(new Insets(20));
        Scene scene = new Scene(root, 320, 400);
        stage.setTitle("Odobravanje pregleda");
        stage.setScene(scene);
        stage.show();

        odobriDugme.setOnAction(actionEvent -> {
            for (int i = 0; i < dugmici.size(); i++) {
                if (dugmici.get(i).isSelected()) {
                    pregledi.get(i).setOdobren(true);
                    PregledController.updejtujPregled(pregledi.get(i));
                } else {
                    pregledi.get(i).setOdobren(false);
                    PregledController.updejtujPregled(pregledi.get(i));
                }
            }
            messageLabel.setVisible(true);
        });

        nazadDugme.setOnAction(actionEvent -> {
            stage.close();
            try {
                new DoktorMeni().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
