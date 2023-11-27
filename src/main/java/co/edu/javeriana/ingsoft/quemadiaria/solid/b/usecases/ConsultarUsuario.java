package co.edu.javeriana.ingsoft.quemadiaria.solid.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.solid.b.usecases.persistencia.UsuarioRepositorio;

public class ConsultarUsuario {
    UsuarioRepositorio usuarioRepositorio;

    public ConsultarUsuario(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public boolean consultarExistencia(Usuario usuario) {
        return usuarioRepositorio.consultarExistencia(usuario);
    }
}
