package co.edu.javeriana.ingsoft.quemadiaria.solid.e.interfaces.main.controllers;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Rutina;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.ProgramaDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facadeRegistros.FacadeRegistros;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facadeRegistros.RegistroPrograma;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AgregarProgramaController {
    RegistroPrograma facade = new FacadeRegistros();
    @FXML
    private TextField nombrePrograma;
    @FXML
    private TextArea descripcionPrograma;
    @FXML
    private ListView<Rutina> elegidos;
    @FXML
    private ListView<Rutina> elegir;
    @FXML
    private TextField elegirRutina;
    private List<Rutina> rutinasPrograma = new ArrayList<>();
    List<Rutina> elegirlist = facade.consultarListaRutinas();

    @FXML
    public void initialize() {
        // Crear una lista observable para los ejercicios
        ObservableList<Rutina> elegirObservable = FXCollections.observableArrayList(elegirlist);
        ObservableList<Rutina> elegidosObservable = FXCollections.observableArrayList(rutinasPrograma);


        // Asignar la listas observables al ListView
        elegir.setItems(elegirObservable);
        elegidos.setItems(elegidosObservable);
    }

    @FXML
    private void agregarRutina() {
        String rutinaSeleccionado = elegirRutina.getText();
        boolean encontrado = false;

        for(Rutina rutina: elegirlist){
            if (rutina.getNombre().equalsIgnoreCase(rutinaSeleccionado)){
                rutinasPrograma.add(rutina);
                encontrado = true;
                break;
            }
        }

        if(!encontrado){System.out.println("No se encontro la rutina");}

        ObservableList<Rutina> elegidosObservable = FXCollections.observableArrayList(rutinasPrograma);
        elegidos.setItems(elegidosObservable);

        for (Rutina rutina: rutinasPrograma){
            System.out.println(rutina);
        }
        System.out.println();

        elegirRutina.clear();

    }

    @FXML
    private void crearPrograma() {

        String nombre = nombrePrograma.getText();
        String descripcion = descripcionPrograma.getText();

        ProgramaDTO programa = new ProgramaDTO(nombre, descripcion, rutinasPrograma);
        facade.guardarPrograma(programa);

        // Limpia los campos y la lista después de guardar la rutina
        nombrePrograma.clear();
        descripcionPrograma.clear();
        rutinasPrograma.clear();
        ObservableList<Rutina> elegidosObservable = FXCollections.observableArrayList(rutinasPrograma);
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
        Stage stage = (Stage) nombrePrograma.getScene().getWindow();
        stage.close();
    }
}

