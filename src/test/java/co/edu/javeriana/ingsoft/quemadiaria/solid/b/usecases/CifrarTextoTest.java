package co.edu.javeriana.ingsoft.quemadiaria.solid.b.usecases;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CifrarTextoTest {

    @Test
    public void testEncriptarContra() {
        CifrarTexto cifrarTexto = new CifrarTexto();
        String contrasenna = "contrasenna123";
        String contrasennaEncriptada = cifrarTexto.encriptarContra(contrasenna);
        assertEquals(contrasenna, contrasennaEncriptada);
    }

    @Test
    public void testDesencriptarContra() {
        CifrarTexto cifrarTexto = new CifrarTexto();
        String contrasenna = "contrasenna123";
        String contrasennaEncriptada = cifrarTexto.encriptarContra(contrasenna);
        String contrasennaDesencriptada = cifrarTexto.desencriptarContra(contrasennaEncriptada);
        assertEquals(contrasenna, contrasennaDesencriptada);
    }
}

