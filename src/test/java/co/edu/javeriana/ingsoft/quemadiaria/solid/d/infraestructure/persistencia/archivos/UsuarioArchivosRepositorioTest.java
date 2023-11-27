package co.edu.javeriana.ingsoft.quemadiaria.solid.d.infraestructure.persistencia.archivos;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioArchivosRepositorioTest {

    UsuarioArchivosRepositorio usuarioArchivosRepositorio;
    @BeforeEach
    void setUp() {
        usuarioArchivosRepositorio = new UsuarioArchivosRepositorio();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void guardarUsuario() {
        // Arrange

        Credenciales credenciales = new Credenciales("a.barrera", "123456789", 1);
        Usuario usuario = new Usuario("123456789", "a.barrera@javeriana.edu.co", credenciales);
        usuario.setNombre("Andres");
        usuario.setApellido("Barrera");

        // Act - Assert
        usuarioArchivosRepositorio.guardarUsuario(usuario);
    }

    @Test
    void consultarListaUsuarios() {
        // Arrange
        List<Usuario> listaUsuarios = new ArrayList<>();
        // Act
        listaUsuarios = usuarioArchivosRepositorio.consultarListaUsuarios();
        // Assert
        assertTrue(listaUsuarios.size() > 3);
    }
}