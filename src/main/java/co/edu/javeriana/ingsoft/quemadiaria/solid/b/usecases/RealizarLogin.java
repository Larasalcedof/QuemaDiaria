package co.edu.javeriana.ingsoft.quemadiaria.solid.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.excepciones.QuemaDiariaException;
import co.edu.javeriana.ingsoft.quemadiaria.solid.b.usecases.persistencia.UsuarioRepositorio;

public class RealizarLogin {

    private UsuarioRepositorio usuarioRepositorio;

    public RealizarLogin(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }
    public void login(String nombreUsuario, String contrasenna, Integer tipo) {

        Usuario usuario = usuarioRepositorio.consultarUsuarioPorUserName(nombreUsuario);
        if(!usuario.getCredenciales().validarCredenciales(nombreUsuario, contrasenna, tipo))
            throw new QuemaDiariaException(QuemaDiariaException.ERROR_CREDENCIALES_INVALIDAS, "Credenciales invalidas");
    }
}
