module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.jsoup;


    opens Scenes to javafx.fxml;
    exports Scenes;
    opens Scenes.Doktor to javafx.fxml;
    exports Scenes.Doktor;
    opens Entities to javafx.fxml;
    exports Entities;
    opens Scenes.Korisnik to javafx.fxml;
    exports Scenes.Korisnik;
}