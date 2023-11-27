package co.edu.javeriana.ingsoft.quemadiaria.solid.d.infraestructure.persistencia.basedatos;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Ejercicio;
import co.edu.javeriana.ingsoft.quemadiaria.solid.b.usecases.persistencia.EjercicioRepositorio;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BaseDeDatosRepositorioEjercicio implements EjercicioRepositorio {
    @Override
    public void guardarEjercicio(Ejercicio ejercicio) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String ejercicioQuery = "INSERT INTO ejercicio (nombre, repeticiones, musculo, descripcion) VALUES (?, ?, ?, ?)";
            PreparedStatement ejercicioStatement = connection.prepareStatement(ejercicioQuery, Statement.RETURN_GENERATED_KEYS);
            ejercicioStatement.setString(1, ejercicio.getNombre());
            ejercicioStatement.setInt(2, ejercicio.getRepeticiones());
            ejercicioStatement.setString(3, ejercicio.getMusculo());
            ejercicioStatement.setString(4, ejercicio.getDescripcion());
            ejercicioStatement.executeUpdate();

            // Retrieve the generated keys
            ResultSet generatedKeys = ejercicioStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int ejercicioId = generatedKeys.getInt(1);
                // Almacenar el ID generado en el objeto Ejercicio si es necesario.
                ejercicio.setId(ejercicioId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al guardar ejercicio en la base de datos", e);
        }
    }

    @Override
    public List<Ejercicio> consultarListaEjercicios() {
        List<Ejercicio> ejercicios = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM ejercicio")) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                int repeticiones = resultSet.getInt("repeticiones");
                String musculo = resultSet.getString("musculo");
                String descripcion = resultSet.getString("descripcion");
                Ejercicio ejercicio = new Ejercicio(nombre, repeticiones, musculo, descripcion);
                ejercicio.setId(id);
                ejercicios.add(ejercicio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al consultar la lista de ejercicios en la base de datos", e);
        }
        return ejercicios;
    }

    @Override
    public void eliminarEjercicio(Ejercicio ejercicio) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Eliminar las referencias en la tabla rutina_ejercicio
            String eliminarReferenciasQuery = "DELETE FROM rutina_ejercicio WHERE ejercicio_id = ?";
            try (PreparedStatement referenciasStatement = connection.prepareStatement(eliminarReferenciasQuery)) {
                referenciasStatement.setInt(1, ejercicio.getId());
                referenciasStatement.executeUpdate();
            }

            // Eliminar el ejercicio
            String eliminarEjercicioQuery = "DELETE FROM ejercicio WHERE id = ?";
            try (PreparedStatement ejercicioStatement = connection.prepareStatement(eliminarEjercicioQuery)) {
                ejercicioStatement.setInt(1, ejercicio.getId());
                ejercicioStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar ejercicio en la base de datos", e);
        }
    }

    @Override
    public Ejercicio consultarEjercicioPorNombre(String nombre) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ejercicio WHERE nombre = ?")) {
            preparedStatement.setString(1, nombre);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                int repeticiones = resultSet.getInt("repeticiones");
                String musculo = resultSet.getString("musculo");
                String descripcion = resultSet.getString("descripcion");
                Ejercicio ejercicio = new Ejercicio(nombre, repeticiones, musculo, descripcion);
                ejercicio.setId(id);
                return ejercicio;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al consultar ejercicio por nombre en la base de datos", e);
        }
        throw new RuntimeException("Ejercicio no encontrado: " + nombre);
    }

}
