package co.edu.javeriana.ingsoft.quemadiaria.solid.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.solid.d.infraestructure.persistencia.archivos.UsuarioArchivosRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class RegistrarUsuarioTest {

    private RegistrarUsuario registrarUsuario;

    @BeforeEach
    void setUp() {
        registrarUsuario = new RegistrarUsuario(new UsuarioArchivosRepositorio());
    }


    @Test
    void registrarUsuario() throws IOException {
        // Arrange

        Credenciales credenciales = new Credenciales("a.barrera", "123456789", 1);
        Usuario usuario = new Usuario("123456789", "a.barrera@javeriana.edu.co", credenciales);
        usuario.setNombre("Andres");
        usuario.setApellido("Barrera");

        Usuario otroUsuario = new Usuario("987654321", "c.barrera@javeriana.edu.co", credenciales);
        otroUsuario.setNombre("Camilo");
        otroUsuario.setApellido("Barrera");


        // Act - Assert
        registrarUsuario.registrarUsuario(usuario);
        registrarUsuario.registrarUsuario(otroUsuario);
    }
}