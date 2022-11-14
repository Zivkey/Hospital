package Scenes.Korisnik;

import Entities.Pregled;
import Scenes.Login;
import Util.PregledUtil;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class Status extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Label naslovLabel = new Label("Statusi vasih pregleda");

    private Button backButton = new Button("Nazad");

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        root.setSpacing(30);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 300, 100);
        stage.setTitle("Korisnik meni");
        stage.setScene(scene);
        List<Pregled> pregledi = PregledUtil.listaPregleda(Login.getCurrentKorisnik());
        for (Pregled x : pregledi) {
            VBox pregledBox = new VBox();
            pregledBox.setSpacing(10);
            pregledBox.setAlignment(Pos.CENTER);
            Label doktorLabel = new Label("Pregled kod Dr." + x.getDoktor().getIme() + " " + x.getDoktor().getPrezime());
            Label opisLabel = new Label(x.getOpis());
            CheckBox odobrenBox = new CheckBox("Odobren:");
            odobrenBox.setDisable(true);
            if (x.isOdobren()) {
                odobrenBox.setSelected(true);
            } else {
                odobrenBox.setSelected(false);
            }
            stage.setHeight(stage.getHeight() + 35);
            pregledBox.getChildren().addAll(doktorLabel, opisLabel, odobrenBox);
            root.getChildren().add(pregledBox);
        }
        root.getChildren().add(backButton);


        stage.show();

        backButton.setOnAction(actionEvent -> {
            stage.close();
            try {
                new KorisnikMeni().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
