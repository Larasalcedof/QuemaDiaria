package co.edu.javeriana.ingsoft.quemadiaria.solid.e.interfaces.main.controllers;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Ejercicio;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.EjercicioDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facadeRegistros.EliminarEjercicio;
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

public class EliminarEjercicioController {

    @FXML
    private ListView<Ejercicio> ejercicioListView;

    private final EliminarEjercicio ejercicioRepositorio = new FacadeRegistros();


    @FXML
    public void initialize() {
        cargarEjercicios();
    }

    private void cargarEjercicios() {
        ObservableList<Ejercicio> ejercicios = FXCollections.observableArrayList(ejercicioRepositorio.consultarListaEjercicios());
        ejercicioListView.setItems(ejercicios);
    }

    @FXML
    private void eliminarEjercicio() {
        Ejercicio ejercicioSeleccionado = ejercicioListView.getSelectionModel().getSelectedItem();

        if (ejercicioSeleccionado != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmar Eliminación");
            alert.setHeaderText("¿Estás seguro de eliminar el ejercicio?");
            alert.setContentText("Esta acción no se puede deshacer.");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                Ejercicio nuevoEjercicio = new Ejercicio(ejercicioSeleccionado.getNombre(),ejercicioSeleccionado.getRepeticiones(),ejercicioSeleccionado.getMusculo(),ejercicioSeleccionado.getDescripcion(),ejercicioSeleccionado.getId());
                ejercicioRepositorio.eliminarrEjercicio(nuevoEjercicio);
                cargarEjercicios();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText("Selecciona un ejercicio");
            alert.setContentText("Por favor, selecciona un ejercicio antes de intentar eliminarlo.");
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
        Stage stage = (Stage) ejercicioListView.getScene().getWindow();
        stage.close();
    }
}