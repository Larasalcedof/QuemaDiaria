package co.edu.javeriana.ingsoft.quemadiaria.solid.e.interfaces.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MenuAgregarRutina extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Rutina.fxml"));
        Scene scene = new Scene(root, 643, 551);
        primaryStage.setTitle("Rutina");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

