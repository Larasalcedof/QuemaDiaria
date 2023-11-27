package co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facade;

import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.*;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.services.*;




public class SeguridadFacade implements AutenticacionFacade, RegistroFacade, AdministradorFacade, ConsultarExistenciaFacade{

    private RegistroUsuarioService registroUsuarioService = new RegistroUsuarioService();
    private AutenticacionService autenticacionService = new AutenticacionService();
    private ConsultarExistenciaService consultarService = new ConsultarExistenciaService();

    @Override
public ResponseDTO<String> consultarExistencia(RegistroUsuarioDTO registroUsuarioDTO) {
    boolean existeUsuario = consultarService.consultarExistencia(registroUsuarioDTO);
    if (existeUsuario) {
        // Si el usuario existe, construye un ResponseDTO con un mensaje.
        return new ResponseDTO<>(100, "El usuario no existe", "");
    } else {
        // Si el usuario no existe, puedes devolver un ResponseDTO con un mensaje diferente o vacío.
        return new ResponseDTO<>(200, "El usuario existe", "");
    }
}


    @Override
    public ResponseDTO<String> login(LoginDTO loginDTO) {
        return autenticacionService.autenticarUsuario(loginDTO);
    }

    @Override
    public ResponseDTO<String> registrarUsuario(RegistroUsuarioDTO registroUsuarioDTO) {
        return registroUsuarioService.registrarUsuario(registroUsuarioDTO);
    }

    @Override
    public ResponseDTO<String> cambiarContrasenna(String usuario, String antiguaContrasenna, String nuevaContrasenna) {
        return null;//autenticacionService.cambiarContrasenna(usuario, contrasenna);
    }

    @Override
    public ResponseDTO<String> cancelarRegistro(String email, String motivo) {
        return null;//autenticacionService.recuperarContrasenna(usuario);
    }
}
