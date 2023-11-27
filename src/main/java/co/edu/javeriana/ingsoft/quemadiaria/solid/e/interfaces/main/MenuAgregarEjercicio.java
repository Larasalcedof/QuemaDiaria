package co.edu.javeriana.ingsoft.quemadiaria.solid.e.interfaces.main;

import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MenuAgregarEjercicio extends Application{

     @Override
public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/Ejercicio.fxml"));
    Scene scene = new Scene(root, 400, 325);
    primaryStage.setTitle("Ejercicio");
    primaryStage.setScene(scene);
    primaryStage.show();
}


    public static void main(String[] args) {
        launch(args);
    }
}
