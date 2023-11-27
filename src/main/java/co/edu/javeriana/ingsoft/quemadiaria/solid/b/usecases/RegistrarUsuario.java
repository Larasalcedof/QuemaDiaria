package co.edu.javeriana.ingsoft.quemadiaria.solid.b.usecases;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.solid.b.usecases.persistencia.UsuarioRepositorio;


public class RegistrarUsuario {
    private UsuarioRepositorio usuarioRepositorio;

    public RegistrarUsuario(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }
    public void registrarUsuario(Usuario usuario) {
        usuarioRepositorio.guardarUsuario(usuario);
    }
}
