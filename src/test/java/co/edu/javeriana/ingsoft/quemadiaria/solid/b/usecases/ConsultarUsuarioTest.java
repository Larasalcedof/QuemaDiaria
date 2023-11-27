package co.edu.javeriana.ingsoft.quemadiaria.solid.b.usecases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.solid.d.infraestructure.persistencia.archivos.UsuarioArchivosRepositorio;


public class ConsultarUsuarioTest {

    private ConsultarUsuario consultarUsuario;



    @BeforeEach
    public void setUp() {
        consultarUsuario = new ConsultarUsuario(new UsuarioArchivosRepositorio());
    }

    @Test
    public void testConsultarTrue() {
   
        Credenciales credenciales = new Credenciales("a.barrera", "123456789", 1);
        Usuario usuario = new Usuario("123456789", "a.barrera@javeriana.edu.co", credenciales);

        assertFalse(consultarUsuario.consultarExistencia(usuario));
    }

    @Test
    public void testConsultarFalse() {

        Credenciales credenciales = new Credenciales("a.noexiste", "987654321", 1);
        Usuario usuario = new Usuario("3322234123", "a.noexiste@javeriana.edu.co", credenciales);

        assertTrue(consultarUsuario.consultarExistencia(usuario));
    }
}
