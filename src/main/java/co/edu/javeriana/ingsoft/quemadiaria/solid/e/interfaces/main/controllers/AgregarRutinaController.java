package co.edu.javeriana.ingsoft.quemadiaria.solid.e.interfaces.main.controllers;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Ejercicio;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.RutinaDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facadeRegistros.FacadeRegistros;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facadeRegistros.RegistroRutina;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AgregarRutinaController {
    RegistroRutina facade = new FacadeRegistros();
    @FXML
    private TextField nombreRutina;
    @FXML
    private TextArea descripcionRutina;
    @FXML
    private ListView<Ejercicio> elegidos;
    @FXML
    private ListView<Ejercicio> elegir;
    @FXML
    private TextField elegirEjercicio;
    private List<Ejercicio> ejerciciosRutina = new ArrayList<>();
    List<Ejercicio> elegirlist = facade.consultarListaEjercicios();

    @FXML
    public void initialize() {
        // Crear una lista observable para los ejercicios
        ObservableList<Ejercicio> elegirObservable = FXCollections.observableArrayList(elegirlist);
        ObservableList<Ejercicio> elegidosObservable = FXCollections.observableArrayList(ejerciciosRutina);


        // Asignar la listas observables al ListView
        elegir.setItems(elegirObservable);
        elegidos.setItems(elegidosObservable);
    }

    @FXML
    private void agregarEjercicio() {
        String ejercicioSeleccionado = elegirEjercicio.getText();
        boolean encontrado = false;

        for(Ejercicio ejercicio: elegirlist){
            if (ejercicio.getNombre().equalsIgnoreCase(ejercicioSeleccionado)){
                ejerciciosRutina.add(ejercicio);
                encontrado = true;
                break;
            }
        }

        if(!encontrado){System.out.println("No se encontro el ejercicio");}

        ObservableList<Ejercicio> elegidosObservable = FXCollections.observableArrayList(ejerciciosRutina);
        elegidos.setItems(elegidosObservable);

        for (Ejercicio ejercicio: ejerciciosRutina){
            System.out.println(ejercicio);
        }
        System.out.println();

        elegirEjercicio.clear();

    }

    @FXML
    private void crearRutina() {

        String nombre = nombreRutina.getText();
        String descripcion = descripcionRutina.getText();

        RutinaDTO rutina = new RutinaDTO(nombre, descripcion, ejerciciosRutina);
        facade.guardarRutina(rutina);

        // Limpia los campos y la lista después de guardar la rutina
        nombreRutina.clear();
        descripcionRutina.clear();
        ejerciciosRutina.clear();
        ObservableList<Ejercicio> elegidosObservable = FXCollections.observableArrayList(ejerciciosRutina);
        elegidos.setItems(elegidosObservable);

        abrirVentanaRutinaExitoso();
        cerrarVentanaActual();
    }

    private void abrirVentanaRutinaExitoso() {
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
        Stage stage = (Stage) nombreRutina.getScene().getWindow();
        stage.close();
    }
}

