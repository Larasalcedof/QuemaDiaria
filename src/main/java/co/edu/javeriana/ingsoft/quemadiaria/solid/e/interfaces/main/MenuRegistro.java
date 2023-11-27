package co.edu.javeriana.ingsoft.quemadiaria.solid.e.interfaces.main;

import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facade.RegistroFacade;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facade.SeguridadFacade;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuRegistro extends Application {

    RegistroFacade seguridadFacade = new SeguridadFacade();


    @Override
public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/MiAppFXML.fxml"));
    Scene scene = new Scene(root, 400, 600);
    primaryStage.setTitle("Registro!");
    primaryStage.setScene(scene);
    primaryStage.show();
}


    public static void main(String[] args) {
        launch(args);
    }
}

