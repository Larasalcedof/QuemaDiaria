package co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.services;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.excepciones.QuemaDiariaException;
import co.edu.javeriana.ingsoft.quemadiaria.solid.b.usecases.RealizarLogin;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.ResponseDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.d.infraestructure.persistencia.basedatos.BaseDatosRepositorioUsuario;

public class AutenticacionService {


    RealizarLogin realizarLogin;

    public AutenticacionService() {
        this.realizarLogin = new RealizarLogin(new BaseDatosRepositorioUsuario());
    }
    public ResponseDTO<String> autenticarUsuario(LoginDTO loginDTO) {
        try {
            realizarLogin.login(loginDTO.getUsername(), loginDTO.getPassword(), loginDTO.getTipo());
            return new ResponseDTO<>(ResponseDTO.OK, "Login exitoso", "Login exitoso");
        }
        catch (QuemaDiariaException e) {
            return new ResponseDTO<>(e.getCodigo(), e.getMessage(), "Error al hacer el login");
        }

    }
}
