package co.edu.javeriana.ingsoft.quemadiaria.solid.e.interfaces.main.controllers;

import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facade.AutenticacionFacade;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facade.SeguridadFacade;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.LoginDTO;

public class LoginController {

    AutenticacionFacade seguridadFacade = new SeguridadFacade();

    @FXML
    private TextField nombreUsuarioTextField;

    @FXML
    private PasswordField contrasennaPasswordField;

    @FXML
    private Button iniciarSesionButtonEntrenador;

    @FXML
    private Button iniciarSesionButtonUsuario;

    @FXML
    private Label errorLabel;

    @FXML
    private void iniciarSesionUsuario() {
        String nombreUsuario = nombreUsuarioTextField.getText();
        String contrasenna = contrasennaPasswordField.getText();

        if (nombreUsuario.isEmpty() || contrasenna.isEmpty()) {
            errorLabel.setText("Llene los dos recuadros");
            errorLabel.setVisible(true);
        } else {
            // Intenta iniciar sesión
            LoginDTO loginDTO = new LoginDTO();
            loginDTO.setPassword(contrasenna);
            loginDTO.setUsername(nombreUsuario);
            loginDTO.setTipo(1);
            seguridadFacade.login(loginDTO);

            if (seguridadFacade.login(loginDTO).isExitoso()) {
                // Si la sesión es exitosa, cierra la ventana actual
                abrirVentanaLoginExitoso();
                cerrarVentanaActual();
            } else {
                // Muestra un mensaje de error si la sesión falla
                errorLabel.setText("Error: Usuario o contraseña incorrectos");
                errorLabel.setVisible(true);
            }
        }
    }

    @FXML
    private void iniciarSesionEntrenador() {
        String nombreUsuario = nombreUsuarioTextField.getText();
        String contrasenna = contrasennaPasswordField.getText();

        if (nombreUsuario.isEmpty() || contrasenna.isEmpty()) {
            errorLabel.setText("Llene los dos recuadros");
            errorLabel.setVisible(true);
        } else {
            // Intenta iniciar sesión
            LoginDTO loginDTO = new LoginDTO();
            loginDTO.setPassword(contrasenna);
            loginDTO.setUsername(nombreUsuario);
            loginDTO.setTipo(0);
            seguridadFacade.login(loginDTO);

            if (seguridadFacade.login(loginDTO).isExitoso()) {
                // Si la sesión es exitosa, cierra la ventana actual
                abrirVentanaLoginExitoso();
                cerrarVentanaActual();
            } else {
                // Muestra un mensaje de error si la sesión falla
                errorLabel.setText("Error: Usuario o contraseña incorrectos");
                errorLabel.setVisible(true);
            }
        }
    }


    
private void abrirVentanaLoginExitoso() {
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
        Stage stage = (Stage) nombreUsuarioTextField.getScene().getWindow();
        stage.close();
    }
}
