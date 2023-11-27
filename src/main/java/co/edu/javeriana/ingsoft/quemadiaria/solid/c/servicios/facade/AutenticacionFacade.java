package co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facade;

import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.ResponseDTO;

public interface AutenticacionFacade {

    ResponseDTO<String> login(LoginDTO loginDTO);
    ResponseDTO<String> cambiarContrasenna(String usuario, String antiguaContrasenna, String nuevaContrasenna);
}
