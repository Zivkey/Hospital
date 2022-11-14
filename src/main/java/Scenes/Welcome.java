package Scenes;

import Util.JsoupUtil;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.List;

public class Welcome extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private Label naslovLabel = new Label("Novosti o medicini:");

    private Button loginButton = new Button("Ulogujte se");

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(naslovLabel);
        Rectangle r1 = new Rectangle(500, 3);
        root.getChildren().add(r1);
        List<String> naslovi = JsoupUtil.citajNaslove();
        for (String s : naslovi) {
            Label naslovLabel = new Label("* " + s);
            root.getChildren().add(naslovLabel);
            Rectangle r2 = new Rectangle(500, 3);
            root.getChildren().add(r2);
        }
        root.getChildren().add(loginButton);
        root.setSpacing(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("Dobro dosli");
        stage.setScene(scene);
        stage.show();

        loginButton.setOnAction(actionEvent -> {
            stage.close();
            try {
                new Login().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
