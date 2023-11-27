package co.edu.javeriana.ingsoft.quemadiaria.solid.d.infraestructure.persistencia.basedatos;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.solid.b.usecases.persistencia.UsuarioRepositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.List;

public class BaseDatosRepositorioUsuario implements UsuarioRepositorio {

    @Override
public boolean consultarExistencia(Usuario usuario) {
    try (Connection connection = DatabaseConnection.getConnection()) {
        String query = "SELECT * FROM credenciales WHERE nombreUsuario = ? OR contrasenna = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, usuario.getCredenciales().getNombreUsuario());
        preparedStatement.setString(2, usuario.getCredenciales().getContrasenna());
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Error al consultar existencia de usuario en la base de datos", e);
    }
}

@Override
public void guardarUsuario(Usuario usuario) {
    try (Connection connection = DatabaseConnection.getConnection()) {
        // Insertar credenciales
        String credencialesQuery = "INSERT INTO credenciales (nombreUsuario, contrasenna, tipo) VALUES (?, ?, ?)";
        PreparedStatement credencialesStatement = connection.prepareStatement(credencialesQuery, Statement.RETURN_GENERATED_KEYS);
        credencialesStatement.setString(1, usuario.getCredenciales().getNombreUsuario());
        credencialesStatement.setString(2, usuario.getCredenciales().getContrasenna());
        credencialesStatement.setInt(3, usuario.getCredenciales().getTipo());
        credencialesStatement.executeUpdate();

        // Retrieve the generated keys
        ResultSet generatedKeys = credencialesStatement.getGeneratedKeys();
        int credencialesId = -1;
        if (generatedKeys.next()) {
            credencialesId = generatedKeys.getInt(1);
        }

        // Insertar usuario
        String usuarioQuery = "INSERT INTO usuario (nombre, apellido, numeroDocumento, correo, credenciales_id) " +
                "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement usuarioStatement = connection.prepareStatement(usuarioQuery);
        usuarioStatement.setString(1, usuario.getNombre());
        usuarioStatement.setString(2, usuario.getApellido());
        usuarioStatement.setString(3, usuario.getNumeroDocumento());
        usuarioStatement.setString(4, usuario.getCorreo());
        usuarioStatement.setInt(5, credencialesId);
        usuarioStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Error al guardar usuario en la base de datos", e);
    }
}

@Override
public Usuario consultarUsuarioPorUserName(String username) {
    try (Connection connection = DatabaseConnection.getConnection()) {
        String query = "SELECT usuario.id, usuario.nombre, usuario.apellido, usuario.numeroDocumento, " +
                "usuario.correo, credenciales.nombreUsuario, credenciales.contrasenna, credenciales.tipo " +
                "FROM usuario " +
                "INNER JOIN credenciales ON usuario.credenciales_id = credenciales.id " +
                "WHERE credenciales.nombreUsuario = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String nombreUsuario = resultSet.getString("nombreUsuario");
            String contrasenna = resultSet.getString("contrasenna");
            int tipo = resultSet.getInt("tipo");
            Credenciales credenciales = new Credenciales(nombreUsuario, contrasenna, tipo);
            String nombre = resultSet.getString("nombre");
            String apellido = resultSet.getString("apellido");
            String numeroDocumento = resultSet.getString("numeroDocumento");
            String correo = resultSet.getString("correo");
            Usuario usuario = new Usuario(numeroDocumento, correo, credenciales);
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            return usuario;
        } else {
            throw new RuntimeException("Usuario no encontrado: " + username);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Error al consultar usuario por nombre de usuario en la base de datos", e);
    }
}

@Override
public List<Usuario> consultarListaUsuarios() {
    List<Usuario> usuarios = new ArrayList<>();
    try (Connection connection = DatabaseConnection.getConnection()) {
        String query = "SELECT usuario.id, usuario.nombre, usuario.apellido, usuario.numeroDocumento, " +
                "usuario.correo, credenciales.nombreUsuario, credenciales.contrasenna, credenciales.tipo " +
                "FROM usuario " +
                "INNER JOIN credenciales ON usuario.credenciales_id = credenciales.id";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String nombreUsuario = resultSet.getString("nombreUsuario");
            String contrasenna = resultSet.getString("contrasenna");
            int tipo = resultSet.getInt("tipo");
            Credenciales credenciales = new Credenciales(nombreUsuario, contrasenna, tipo);
            String nombre = resultSet.getString("nombre");
            String apellido = resultSet.getString("apellido");
            String numeroDocumento = resultSet.getString("numeroDocumento");
            String correo = resultSet.getString("correo");
            Usuario usuario = new Usuario(numeroDocumento, correo, credenciales);
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuarios.add(usuario);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Error al consultar lista de usuarios en la base de datos", e);
    }
    return usuarios;
}
}
