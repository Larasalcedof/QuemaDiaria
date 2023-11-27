package co.edu.javeriana.ingsoft.quemadiaria.solid.e.interfaces.main;

import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.ResponseDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facade.AutenticacionFacade;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facade.SeguridadFacade;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MenuLogin extends Application{

    AutenticacionFacade seguridadFacade = new SeguridadFacade();

    public void login() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUsername("a.barrera");
        loginDTO.setPassword("123456789");

        ResponseDTO<String> respuesta = seguridadFacade.login(loginDTO);
        //seguridadFacade.
        System.out.println(respuesta.getCodigo()==ResponseDTO.OK?"Login exitoso":"Login fallido");

        //seguridadFacade
    }

     @Override
public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/LoginFXML.fxml"));
    Scene scene = new Scene(root, 400, 600);
    primaryStage.setTitle("Login");
    primaryStage.setScene(scene);
    primaryStage.show();
}


    public static void main(String[] args) {
        launch(args);
    }
}
