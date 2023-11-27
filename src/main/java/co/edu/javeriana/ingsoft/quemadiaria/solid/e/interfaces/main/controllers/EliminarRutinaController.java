package co.edu.javeriana.ingsoft.quemadiaria.solid.e.interfaces.main.controllers;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Rutina;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facadeRegistros.EliminarRutina;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facadeRegistros.FacadeRegistros;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class EliminarRutinaController {

    @FXML
    private ListView<Rutina> rutinaListView;

    private final EliminarRutina rutinaRepositorio = new FacadeRegistros();


    @FXML
    public void initialize() {
        cargarRutinas();
    }

    private void cargarRutinas() {
        ObservableList<Rutina> rutinas = FXCollections.observableArrayList(rutinaRepositorio.consultarListaRutinas());
        rutinaListView.setItems(rutinas);
    }

    @FXML
    private void eliminarRutina() {
        Rutina rutinaSeleccionada = rutinaListView.getSelectionModel().getSelectedItem();

        if (rutinaSeleccionada != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmar Eliminación");
            alert.setHeaderText("¿Estás seguro de eliminar esta rutina?");
            alert.setContentText("Esta acción no se puede deshacer.");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                Rutina nuevaRutina = new Rutina(rutinaSeleccionada.getNombre(), rutinaSeleccionada.getDescripcion(), rutinaSeleccionada.getEjercicios(), rutinaSeleccionada.getId());
                rutinaRepositorio.eliminarRutina(nuevaRutina);
                cargarRutinas();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText("Selecciona un ejercicio");
            alert.setContentText("Por favor, selecciona una rutina antes de intentar eliminarla.");
            alert.showAndWait();
        }
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
        Stage stage = (Stage) rutinaListView.getScene().getWindow();
        stage.close();
    }
}