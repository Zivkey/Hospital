package Util;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.List;

public class FxUtil {
    public static HBox dugmeBox(List<Button> dugmici) {
        HBox dugmeKutija = new HBox();
        for (Button x : dugmici) {
            dugmeKutija.getChildren().add(x);
        }
        dugmeKutija.setSpacing(20);
        dugmeKutija.setPadding(new Insets(20));
        dugmeKutija.setAlignment(Pos.CENTER);
        return dugmeKutija;
    }
}
