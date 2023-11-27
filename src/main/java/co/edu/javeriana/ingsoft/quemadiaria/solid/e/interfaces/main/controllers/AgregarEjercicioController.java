package co.edu.javeriana.ingsoft.quemadiaria.solid.e.interfaces.main.controllers;

import java.io.IOException;

import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.EjercicioDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facadeRegistros.FacadeRegistros;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facadeRegistros.RegistroEjercicio;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AgregarEjercicioController {

    RegistroEjercicio facade = new FacadeRegistros();

    @FXML
    private TextField nombreTextField;

    @FXML
    private TextField repeticionesTextField;

    @FXML
    private TextField musculoTextField;

    @FXML
    private TextArea descripcionTextArea;

    @FXML
    public void agregarEjercicio() {
        String nombre = nombreTextField.getText();
        int repeticiones = Integer.parseInt(repeticionesTextField.getText());
        String musculo = musculoTextField.getText();
        String descripcion = descripcionTextArea.getText();
        EjercicioDTO ejercicio = new EjercicioDTO(nombre, repeticiones, musculo, descripcion);
        facade.guardarEjercicio(ejercicio);
        abrirVentanaEjercicioExitoso();
        cerrarVentanaActual();
    }

    private void abrirVentanaEjercicioExitoso() {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Main.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    private void cerrarVentanaActual() {
        // Obtiene la escena actual desde cualquier nodo dentro de la escena.
        Stage stage = (Stage) nombreTextField.getScene().getWindow();
        stage.close();
    }
}


