package co.edu.javeriana.ingsoft.quemadiaria.solid.e.interfaces.main.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AppController {

    @FXML
    private Button registrarseButton;
    
    @FXML
    private Button iniciarSesionButton;

    @FXML
    private void registrarse(ActionEvent event) {

        System.out.println("Registrarse pulsado");

        registroAction();

        cerrarVentanaActual();
    }

    @FXML
    private void iniciarSesion(ActionEvent event) {

        System.out.println("Iniciar sesion pulsado");

        loginAction();
        
        cerrarVentanaActual();
    }


    private void registroAction() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MiAppFXML.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            
            Scene scene = new Scene(root, 400, 600);
            
                        
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void loginAction() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/LoginFXML.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            
            Scene scene = new Scene(root, 400, 600);
            
            // Ajusta la altura de la ventana
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void cerrarVentanaActual() {
        Stage stage = (Stage) registrarseButton.getScene().getWindow();
        stage.close();
    }
}

