package co.edu.javeriana.ingsoft.quemadiaria.solid.b.usecases.persistencia;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Usuario;

import java.util.List;

public interface UsuarioRepositorio {

    boolean consultarExistencia(Usuario usuario);

    void guardarUsuario(Usuario listaUsuarios);

    List<Usuario> consultarListaUsuarios();

    Usuario consultarUsuarioPorUserName(String username);
}
