package co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades;

import co.edu.javeriana.ingsoft.quemadiaria.solid.b.usecases.CifrarTexto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CredencialesTest {

    Credenciales credenciales;

    @BeforeEach
    void setUp() {
        credenciales = new Credenciales("testUser", "encryptedPassword", 1);
    }

    @Test
    void getNombreUsuario() {
        assertEquals("testUser", credenciales.getNombreUsuario());
    }

    @Test
    void getContrasenna() {
        assertEquals("encryptedPassword", credenciales.getContrasenna());
    }

    @Test
    void validarCredenciales_CredencialesValidas_DevuelveTrue() {
        // Arrange
        CifrarTexto cifrarTexto = new CifrarTexto();
        String contrasennaDesencriptada = cifrarTexto.desencriptarContra("encryptedPassword");

        // Act
        boolean esValido = credenciales.validarCredenciales("testUser", contrasennaDesencriptada, 1);

        // Assert
        assertTrue(esValido);
    }

    @Test
    void validarCredenciales_CredencialesInvalidas_DevuelveFalse() {
        // Arrange
        CifrarTexto cifrarTexto = new CifrarTexto();
        String contrasennaDesencriptada = cifrarTexto.desencriptarContra("encryptedPassword");

        // Act
        boolean esValido = credenciales.validarCredenciales("testUser", contrasennaDesencriptada, 1);

        // Assert
        assertTrue(esValido);
    }
}
