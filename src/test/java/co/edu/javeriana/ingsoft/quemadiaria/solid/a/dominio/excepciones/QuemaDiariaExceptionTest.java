package co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.excepciones;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuemaDiariaExceptionTest {

    QuemaDiariaException exception;

    @BeforeEach
    void setUp() {
        exception = new QuemaDiariaException(QuemaDiariaException.ERROR_USUARIO_YA_EXISTE, "El usuario ya existe");
    }

    @Test
    void getCodigo() {
        assertEquals(QuemaDiariaException.ERROR_USUARIO_YA_EXISTE, exception.getCodigo());
    }

    @Test
    void getMessage() {
        assertEquals("El usuario ya existe", exception.getMessage());
    }
}
