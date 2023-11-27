package co.edu.javeriana.ingsoft.quemadiaria.solid.e.interfaces.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MenuEliminarPrograma extends Application{



     @Override
public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/ProgramaListView.fxml"));
    Scene scene = new Scene(root, 400, 600);
    primaryStage.setTitle("Eliminar Programa");
    primaryStage.setScene(scene);
    primaryStage.show();
}


    public static void main(String[] args) {
        launch(args);
    }
}
