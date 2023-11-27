package co.edu.javeriana.ingsoft.quemadiaria.solid.d.infraestructure.persistencia.basedatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCDemo {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM usuario";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    // Recupera los valores de las columnas de la tabla 'usuario'
                    int id = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    String numeroDocumento = resultSet.getString("numeroDocumento");
                    String correo = resultSet.getString("correo");
                    int credencialesId = resultSet.getInt("credenciales_id");

                    // Imprime los valores de los usuarios
                    System.out.println("ID: " + id);
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Apellido: " + apellido);
                    System.out.println("Número de Documento: " + numeroDocumento);
                    System.out.println("Correo: " + correo);
                    System.out.println("ID de Credenciales: " + credencialesId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

