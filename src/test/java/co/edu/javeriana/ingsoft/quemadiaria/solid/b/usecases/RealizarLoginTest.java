package co.edu.javeriana.ingsoft.quemadiaria.solid.b.usecases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.excepciones.QuemaDiariaException;
import co.edu.javeriana.ingsoft.quemadiaria.solid.d.infraestructure.persistencia.archivos.UsuarioArchivosRepositorio;

public class RealizarLoginTest {

    private RealizarLogin realizarLogin;



    @BeforeEach
    public void setUp() {
        realizarLogin = new RealizarLogin(new UsuarioArchivosRepositorio());
    }

    @Test
    public void testLoginConCredencialesValidas() {

        Credenciales credenciales = new Credenciales("a.barrera", "123456789", 1);

 
        assertDoesNotThrow(() -> realizarLogin.login(credenciales.getNombreUsuario(), credenciales.getContrasenna(), credenciales.getTipo()));
    }

    @Test
    public void testLoginUsuarioNoEncontrado() {
 
        Credenciales credenciales = new Credenciales("a.erroneo", "123456789", 1);
        

       
        QuemaDiariaException excepcion = assertThrows(QuemaDiariaException.class, () -> realizarLogin.login(credenciales.getNombreUsuario(), credenciales.getContrasenna(), credenciales.getTipo()));

        assertEquals(400, excepcion.getCodigo());
        assertEquals("Usuario no encontrado: a.erroneo", excepcion.getMessage());
    }
}
