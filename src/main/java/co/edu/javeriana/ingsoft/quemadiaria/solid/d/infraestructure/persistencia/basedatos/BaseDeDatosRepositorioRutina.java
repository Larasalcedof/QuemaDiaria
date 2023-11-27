package co.edu.javeriana.ingsoft.quemadiaria.solid.d.infraestructure.persistencia.basedatos;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Ejercicio;
import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Rutina;
import co.edu.javeriana.ingsoft.quemadiaria.solid.b.usecases.persistencia.RutinaRepositorio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDeDatosRepositorioRutina implements RutinaRepositorio {
    @Override
    public void guardarRutina(Rutina rutina) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Insertar rutina
            String rutinaQuery = "INSERT INTO rutina (nombre, descripcion) VALUES (?, ?)";
            PreparedStatement rutinaStatement = connection.prepareStatement(rutinaQuery, Statement.RETURN_GENERATED_KEYS);
            rutinaStatement.setString(1, rutina.getNombre());
            rutinaStatement.setString(2, rutina.getDescripcion());
            rutinaStatement.executeUpdate();

            // Retrieve the generated keys
            ResultSet generatedKeys = rutinaStatement.getGeneratedKeys();
            int rutinaId = -1;
            if (generatedKeys.next()) {
                rutinaId = generatedKeys.getInt(1);
            }

            // Asociar los ejercicios con la rutina y almacenar esta relación en la tabla "rutina_ejercicio".
            // Recorre la lista de ejercicios en la rutina y guarda la relación en la tabla "rutina_ejercicio".

            for (Ejercicio ejercicio : rutina.getEjercicios()) {
                String relacionQuery = "INSERT INTO rutina_ejercicio (rutina_id, ejercicio_id) VALUES (?, ?)";
                PreparedStatement relacionStatement = connection.prepareStatement(relacionQuery);
                relacionStatement.setInt(1, rutinaId);
                relacionStatement.setInt(2, ejercicio.getId());
                relacionStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al guardar rutina en la base de datos", e);
        }
    }


    @Override
    public List<Rutina> consultarListaRutina() {
        List<Rutina> rutinas = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM rutina")) {

            while (resultSet.next()) {
                int rutinaId = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");

                // Consulta para obtener los ejercicios asociados a la rutina
                String ejerciciosQuery = "SELECT ejercicio.* " +
                        "FROM ejercicio " +
                        "INNER JOIN rutina_ejercicio ON ejercicio.id = rutina_ejercicio.ejercicio_id " +
                        "WHERE rutina_ejercicio.rutina_id = ?";
                PreparedStatement ejerciciosStatement = connection.prepareStatement(ejerciciosQuery);
                ejerciciosStatement.setInt(1, rutinaId);
                ResultSet ejerciciosResultSet = ejerciciosStatement.executeQuery();

                List<Ejercicio> ejercicios = new ArrayList<>();
                while (ejerciciosResultSet.next()) {
                    int ejercicioId = ejerciciosResultSet.getInt("id");
                    String ejercicioNombre = ejerciciosResultSet.getString("nombre");
                    int repeticiones = ejerciciosResultSet.getInt("repeticiones");
                    String musculo = ejerciciosResultSet.getString("musculo");
                    String ejercicioDescripcion = ejerciciosResultSet.getString("descripcion");

                    Ejercicio ejercicio = new Ejercicio(ejercicioNombre, repeticiones, musculo, ejercicioDescripcion);
                    ejercicio.setId(ejercicioId);
                    ejercicios.add(ejercicio);
                }

                // Crear una instancia de Rutina con la información recopilada
                Rutina rutina = new Rutina(nombre, descripcion, ejercicios);
                rutina.setId(rutinaId);

                // Agregar la rutina a la lista de rutinas
                rutinas.add(rutina);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al consultar la lista de rutinas en la base de datos", e);
        }

        return rutinas;
    }


    @Override
    public Rutina consultarRutinaPorID(int id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Consulta para obtener la rutina por nombre
            String query = "SELECT * FROM rutina WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");

                // Consulta para obtener los ejercicios asociados a la rutina
                String ejerciciosQuery = "SELECT ejercicio.* " +
                        "FROM ejercicio " +
                        "INNER JOIN rutina_ejercicio ON ejercicio.id = rutina_ejercicio.ejercicio_id " +
                        "WHERE rutina_ejercicio.rutina_id = ?";
                PreparedStatement ejerciciosStatement = connection.prepareStatement(ejerciciosQuery);
                ejerciciosStatement.setInt(1, id);
                ResultSet ejerciciosResultSet = ejerciciosStatement.executeQuery();

                List<Ejercicio> ejercicios = new ArrayList<>();
                while (ejerciciosResultSet.next()) {
                    int ejercicioId = ejerciciosResultSet.getInt("id");
                    String ejercicioNombre = ejerciciosResultSet.getString("nombre");
                    int repeticiones = ejerciciosResultSet.getInt("repeticiones");
                    String musculo = ejerciciosResultSet.getString("musculo");
                    String ejercicioDescripcion = ejerciciosResultSet.getString("descripcion");

                    Ejercicio ejercicio = new Ejercicio(ejercicioNombre, repeticiones, musculo, ejercicioDescripcion);
                    ejercicio.setId(ejercicioId);
                    ejercicios.add(ejercicio);
                }

                // Crear y retornar la rutina con la información recopilada
                Rutina rutina = new Rutina(nombre, descripcion, ejercicios);
                rutina.setId(id);
                return rutina;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al consultar rutina por nombre en la base de datos", e);
        }
        throw new RuntimeException("Rutina no encontrada ");
    }

    @Override
    public void eliminarRutina(Rutina rutina) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Eliminar las referencias en la tabla rutina_ejercicio
            String eliminarReferenciasQuery = "DELETE FROM rutina_ejercicio WHERE rutina_id = ?";
            try (PreparedStatement referenciasStatement = connection.prepareStatement(eliminarReferenciasQuery)) {
                referenciasStatement.setInt(1, rutina.getId());
                referenciasStatement.executeUpdate();
            }

            // Eliminar las referencias en la tabla programa_rutina
            String eliminarProgramaRutinaQuery = "DELETE FROM programa_rutina WHERE rutina_id = ?";
            try (PreparedStatement programaRutinaStatement = connection.prepareStatement(eliminarProgramaRutinaQuery)) {
                programaRutinaStatement.setInt(1, rutina.getId());
                programaRutinaStatement.executeUpdate();
            }

            // Eliminar la rutina
            String eliminarRutinaQuery = "DELETE FROM rutina WHERE id = ?";
            try (PreparedStatement rutinaStatement = connection.prepareStatement(eliminarRutinaQuery)) {
                rutinaStatement.setInt(1, rutina.getId());
                rutinaStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar rutina en la base de datos", e);
        }
    }


}
