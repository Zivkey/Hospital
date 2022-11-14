package Scenes.Doktor;

import Database.KorisnikController;
import Entities.Korisnik;
import Util.TableUtil;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListaPacijenata extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Label naslovLabel = new Label("Lista pacijenata");
    private TableView<Korisnik> pacijentiTable = new TableView<>();
    private Button nazadDugme = new Button("Nazad");

    @Override
    public void start(Stage stage) {

        pacijentiTable = TableUtil.prikaziPacijente(KorisnikController.citajKorisnike());
        VBox root = new VBox(naslovLabel, pacijentiTable, nazadDugme);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        root.setPadding(new Insets(20));
        Scene scene = new Scene(root, 400, 500);
        stage.setTitle("Korisnik meni");
        stage.setScene(scene);
        stage.show();

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
