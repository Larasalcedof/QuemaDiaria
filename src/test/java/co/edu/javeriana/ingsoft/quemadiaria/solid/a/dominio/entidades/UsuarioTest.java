package co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    Usuario usuario;
    Credenciales credenciales;

    @BeforeEach
    void setUp() {
        credenciales = new Credenciales("testUser", "encryptedPassword", 1);
        usuario = new Usuario("123456789", "test@example.com", credenciales);
    }

    @Test
    void getNumeroDocumento() {
        assertEquals("123456789", usuario.getNumeroDocumento());
    }

    @Test
    void getNombre() {
        assertNull(usuario.getNombre());
        usuario.setNombre("John");
        assertEquals("John", usuario.getNombre());
    }

    @Test
    void getApellido() {
        assertNull(usuario.getApellido());
        usuario.setApellido("Doe");
        assertEquals("Doe", usuario.getApellido());
    }

    @Test
    void getCorreo() {
        assertEquals("test@example.com", usuario.getCorreo());
    }

    @Test
    void getCredenciales() {
        assertEquals(credenciales, usuario.getCredenciales());
    }

    @Test
    void setNombre() {
        assertNull(usuario.getNombre());
        usuario.setNombre("John");
        assertEquals("John", usuario.getNombre());
    }

    @Test
    void setApellido() {
        assertNull(usuario.getApellido());
        usuario.setApellido("Doe");
        assertEquals("Doe", usuario.getApellido());
    }

    @Test
    void testToString() {
        assertEquals("Usuario {numeroDocumento=123456789, nombre=null, apellido=null, correo=test@example.com, credenciales=" + credenciales.toString() + "}", usuario.toString());
    }
}
