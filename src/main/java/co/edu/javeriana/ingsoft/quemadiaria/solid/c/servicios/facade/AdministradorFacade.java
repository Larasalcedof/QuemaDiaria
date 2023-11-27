package co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facade;

import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.RegistroUsuarioDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.ResponseDTO;

public interface AdministradorFacade {

    ResponseDTO<String> login(LoginDTO loginDTO);
    ResponseDTO<String> cambiarContrasenna(String usuario, String antiguaContrasenna, String nuevaContrasenna);

    ResponseDTO<String> registrarUsuario(RegistroUsuarioDTO registroUsuarioDTO);

    public ResponseDTO<String> cancelarRegistro(String email, String motivo);
}
