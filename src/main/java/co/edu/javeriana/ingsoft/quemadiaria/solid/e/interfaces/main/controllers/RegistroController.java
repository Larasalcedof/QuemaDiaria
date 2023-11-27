package co.edu.javeriana.ingsoft.quemadiaria.solid.e.interfaces.main.controllers;

import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facade.ConsultarExistenciaFacade;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facade.RegistroFacade;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facade.SeguridadFacade;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.RegistroUsuarioDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.LoginDTO;


import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistroController {

    RegistroFacade seguridadFacade = new SeguridadFacade();
    ConsultarExistenciaFacade consultarFacade = new SeguridadFacade();


    @FXML
    private TextField nombreTextField;

    @FXML
    private TextField apellidoTextField;

    @FXML
    private TextField nombreUsuarioTextField;

    @FXML
    private PasswordField contrasennaPasswordField;

    @FXML
    private TextField correoUsuarioTextField;
    
    @FXML
    private TextField documentoUsuarioTextField;

    @FXML
    private Button registrarButton;

    @FXML
    private Label errorLabel;

    @FXML
    private Label errorLabel2;

    @FXML
private void registrarUsuario() {
    RegistroUsuarioDTO registroUsuarioDTO = new RegistroUsuarioDTO();
    LoginDTO loginDTO = new LoginDTO();
    String correo = correoUsuarioTextField.getText();
    String documento = documentoUsuarioTextField.getText();
    String nombreUsuario = nombreUsuarioTextField.getText();
    String contrasenna = contrasennaPasswordField.getText();
    String nombre = nombreTextField.getText();
    String apellido = apellidoTextField.getText();
    
    loginDTO.setPassword(contrasenna);
    loginDTO.setUsername(nombreUsuario);
    loginDTO.setTipo(1);

    registroUsuarioDTO.setApellido(apellido);
    registroUsuarioDTO.setCorreo(correo);
    registroUsuarioDTO.setLogin(loginDTO);
    registroUsuarioDTO.setNombre(nombre);
    registroUsuarioDTO.setNumeroDocumento(documento);

    if (nombre.isEmpty() || apellido.isEmpty() || nombreUsuario.isEmpty() || contrasenna.isEmpty() || correo.isEmpty() || documento.isEmpty()) {
        errorLabel.setVisible(true);
    }else if(!consultarFacade.consultarExistencia(registroUsuarioDTO).isExitoso()){
        errorLabel2.setVisible(true);
        errorLabel.setVisible(false);
    }else {
        errorLabel.setVisible(false);
        errorLabel2.setVisible(false);
    

    

    seguridadFacade.registrarUsuario(registroUsuarioDTO);

    abrirVentanaRegistroExitoso();

    cerrarVentanaActual();

    }

}

    @FXML
private void registrarEntrenador() {
    RegistroUsuarioDTO registroUsuarioDTO = new RegistroUsuarioDTO();
    LoginDTO loginDTO = new LoginDTO();
    String correo = correoUsuarioTextField.getText();
    String documento = documentoUsuarioTextField.getText();
    String nombreUsuario = nombreUsuarioTextField.getText();
    String contrasenna = contrasennaPasswordField.getText();
    String nombre = nombreTextField.getText();
    String apellido = apellidoTextField.getText();
    
    loginDTO.setPassword(contrasenna);
    loginDTO.setUsername(nombreUsuario);
    loginDTO.setTipo(0);

    registroUsuarioDTO.setApellido(apellido);
    registroUsuarioDTO.setCorreo(correo);
    registroUsuarioDTO.setLogin(loginDTO);
    registroUsuarioDTO.setNombre(nombre);
    registroUsuarioDTO.setNumeroDocumento(documento);

    if (nombre.isEmpty() || apellido.isEmpty() || nombreUsuario.isEmpty() || contrasenna.isEmpty() || correo.isEmpty() || documento.isEmpty()) {
        errorLabel.setVisible(true);
    }else if(!consultarFacade.consultarExistencia(registroUsuarioDTO).isExitoso()){
        errorLabel2.setVisible(true);
        errorLabel.setVisible(false);
    }else {
        errorLabel.setVisible(false);
        errorLabel2.setVisible(false);
    

    

    seguridadFacade.registrarUsuario(registroUsuarioDTO);

    abrirVentanaRegistroExitoso();

    cerrarVentanaActual();

    }

}

private void abrirVentanaRegistroExitoso() {
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
    Stage stage = (Stage) nombreUsuarioTextField.getScene().getWindow();
    stage.close();
}
}
