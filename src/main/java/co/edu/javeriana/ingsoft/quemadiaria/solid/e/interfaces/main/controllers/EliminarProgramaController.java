package co.edu.javeriana.ingsoft.quemadiaria.solid.e.interfaces.main.controllers;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Programa;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facadeRegistros.EliminarPrograma;
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

public class EliminarProgramaController {

    @FXML
    private ListView<Programa> programaListView;

    private final EliminarPrograma programaRepositorio = new FacadeRegistros();


    @FXML
    public void initialize() {
        cargarProgramas();
    }

    private void cargarProgramas() {
        ObservableList<Programa> programas = FXCollections.observableArrayList(programaRepositorio.consultarListaProgramas());
        programaListView.setItems(programas);
    }

    @FXML
    private void eliminarPrograma() {
        Programa programaSeleccionado = programaListView.getSelectionModel().getSelectedItem();

        if (programaSeleccionado != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmar Eliminación");
            alert.setHeaderText("¿Estás seguro de eliminar el programa?");
            alert.setContentText("Esta acción no se puede deshacer.");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                Programa nuevoPrograma = new Programa(programaSeleccionado.getNombre(), programaSeleccionado.getDescripcion(), programaSeleccionado.getRutinas(), programaSeleccionado.getId());
                programaRepositorio.eliminarPrograma(nuevoPrograma);
                cargarProgramas();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText("Selecciona un programa");
            alert.setContentText("Por favor, selecciona un programa antes de intentar eliminarlo.");
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
        Stage stage = (Stage) programaListView.getScene().getWindow();
        stage.close();
    }
}