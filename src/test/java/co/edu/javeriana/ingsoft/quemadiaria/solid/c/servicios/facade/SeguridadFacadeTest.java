package co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.RegistroUsuarioDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.ResponseDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.services.AutenticacionService;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.services.RegistroUsuarioService;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.services.ConsultarExistenciaService;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facade.SeguridadFacade;

public class SeguridadFacadeTest {

    private SeguridadFacade seguridadFacade;

    @BeforeEach
    public void setUp() {
        seguridadFacade = new SeguridadFacade();
    }

    @Test
    public void testConsultarExistencia() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setPassword("123456789");
        loginDTO.setUsername("a.barrera");
        RegistroUsuarioDTO registroUsuarioDTO = new RegistroUsuarioDTO();
        registroUsuarioDTO.setApellido("Barrera");
        registroUsuarioDTO.setCorreo("a.barrera@javeriana.edu.co");
        registroUsuarioDTO.setNombre("Andres");
        registroUsuarioDTO.setLogin(loginDTO);
        registroUsuarioDTO.setNumeroDocumento("123456789");


        ResponseDTO<String> response = seguridadFacade.consultarExistencia(registroUsuarioDTO);
        assertEquals(200, response.getCodigo());
        assertEquals("El usuario existe", response.getMensaje());
        assertEquals("", response.getDatos());
    }

    @Test
    public void testLoginExitoso() {

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setPassword("123456789");
        loginDTO.setUsername("a.barrera");
        ResponseDTO<String> response = seguridadFacade.login(loginDTO);
        assertEquals(200, response.getCodigo());
        assertEquals("Login exitoso", response.getMensaje());
        assertEquals("Login exitoso", response.getDatos());
    }

    @Test
    public void testLoginErroneo() {

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setPassword("12345678");
        loginDTO.setUsername("a.barrer");
        ResponseDTO<String> response = seguridadFacade.login(loginDTO);
        assertEquals(400, response.getCodigo());
        assertEquals("Usuario no encontrado: a.barrer", response.getMensaje());
        assertEquals("Error al hacer el login", response.getDatos());
    }

    @Test
    public void testRegistrarUsuario() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setPassword("nuevacontra");
        loginDTO.setUsername("nuevoTest");
        RegistroUsuarioDTO registroUsuarioDTO = new RegistroUsuarioDTO();
        registroUsuarioDTO.setApellido("Test");
        registroUsuarioDTO.setCorreo("nuevoTest@javeriana.edu.co");
        registroUsuarioDTO.setNombre("Nuesvo");
        registroUsuarioDTO.setLogin(loginDTO);
        registroUsuarioDTO.setNumeroDocumento("documentoEjemplo");
        

        ResponseDTO<String> response = seguridadFacade.registrarUsuario(registroUsuarioDTO);
        assertEquals(200, response.getCodigo());
        assertEquals("Registro exitoso", response.getMensaje());
        assertEquals("Registro exitoso", response.getDatos());
    }
}
