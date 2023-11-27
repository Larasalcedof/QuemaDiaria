package co.edu.javeriana.ingsoft.quemadiaria.solid.d.infraestructure.basedatos;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.solid.d.infraestructure.persistencia.basedatos.BaseDatosRepositorioUsuario;
import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BaseDatosRepositorioUsuarioTest {

    BaseDatosRepositorioUsuario baseDatosRepositorioUsuario;

    @BeforeEach
    void setUp() {
        baseDatosRepositorioUsuario = new BaseDatosRepositorioUsuario();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void consultarExistencia_UsuarioExistente_DevuelveTrue() {
        // Arrange
        Credenciales credenciales = new Credenciales("a.barrera", "123456789", 1);

        Usuario usuario = new Usuario("123456789", "test@example.com", credenciales);

        // Act
        boolean existe = baseDatosRepositorioUsuario.consultarExistencia(usuario);

        // Assert
        assertTrue(existe);
    }

   @Test
    void guardarUsuarioTest() {
        Credenciales credenciales = new Credenciales("a.barreraa", "123456789", 1);

        Usuario usuario = new Usuario("12345678910", "test@example.com", credenciales);

        // Act
        baseDatosRepositorioUsuario.guardarUsuario(usuario);
    }

    @Test
    void consultarListaUsuariosTest() {

        assertNull(baseDatosRepositorioUsuario.consultarListaUsuarios());
    }

    @Test
    void consultarUsuarioPorUserName() {
        String username = "a.barrera";

        assertNull(baseDatosRepositorioUsuario.consultarUsuarioPorUserName(username));;
    }
}
