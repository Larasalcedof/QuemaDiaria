package co.edu.javeriana.ingsoft.quemadiaria.solid.e.interfaces.main.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private Button crearEjercicioButton;
    
    @FXML
    private Button crearRutinaButton;

    @FXML
    private Button crearProgramaButton;

    @FXML
    private Button eliminarEjercicioButton;

    @FXML
    private void crearEjercicio(ActionEvent event) {
        // Lógica para crear un ejercicio
        System.out.println("Crear Ejercicio pulsado");

        cerrarVentanaActual();

        crearEjercicioAction();
    }

    @FXML
    private void crearRutina(ActionEvent event) {
        // Lógica para crear una rutina
        System.out.println("Crear Rutina pulsado");

        cerrarVentanaActual();

        crearRutinaAction();
    }

    @FXML
    private void crearPrograma(ActionEvent event) {
        // Lógica para crear un programa
        System.out.println("Crear Programa pulsado");

        cerrarVentanaActual();

        crearProgramaAction();
    }

    @FXML
    private void eliminarEjercicio(ActionEvent event) {
        // Lógica para crear una rutina
        System.out.println("Eliminar Ejercicio pulsado");

        cerrarVentanaActual();

        eliminarEjercicioAction();
    }

    @FXML
    private void eliminarRutina(ActionEvent event) {
        // Lógica para crear una rutina
        System.out.println("Eliminar Rutina pulsado");

        cerrarVentanaActual();

        eliminarRutinaAction();
    }

    @FXML
    private void eliminarPrograma(ActionEvent event) {
        // Lógica para crear una rutina
        System.out.println("Eliminar Programa pulsado");

        cerrarVentanaActual();

        eliminarProgramaAction();
    }

    private void crearEjercicioAction() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Ejercicio.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            
            Scene scene = new Scene(root);
            
            // Ajusta la altura de la ventana
            stage.setHeight(400);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void eliminarEjercicioAction() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/EjercicioListView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            
            Scene scene = new Scene(root);
            
            // Ajusta la altura de la ventana
            stage.setHeight(400);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void eliminarRutinaAction() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/RutinaListView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();

            Scene scene = new Scene(root);

            // Ajusta la altura de la ventana
            stage.setHeight(400);

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void eliminarProgramaAction() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProgramaListView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();

            Scene scene = new Scene(root);

            // Ajusta la altura de la ventana
            stage.setHeight(400);

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void crearRutinaAction() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Rutina.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            
            Scene scene = new Scene(root);
            
            // Ajusta la altura de la ventana
            stage.setHeight(600);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void crearProgramaAction() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Programa.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();

            Scene scene = new Scene(root);

            // Ajusta la altura de la ventana
            stage.setHeight(600);

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cerrarVentanaActual() {
        Stage stage = (Stage) crearEjercicioButton.getScene().getWindow();
        stage.close();
    }
}
