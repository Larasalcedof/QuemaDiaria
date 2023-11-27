package co.edu.javeriana.ingsoft.quemadiaria.solid.d.infraestructure.persistencia.basedatos;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Ejercicio;
import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Programa;
import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Rutina;
import co.edu.javeriana.ingsoft.quemadiaria.solid.b.usecases.persistencia.ProgramaRepositorio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDeDatosRepositorioPrograma implements ProgramaRepositorio {

    BaseDeDatosRepositorioRutina rutina = new BaseDeDatosRepositorioRutina();

    @Override
    public void guardarPrograma(Programa programa) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Insertar programa
            String programaQuery = "INSERT INTO programa (nombre, descripcion) VALUES (?, ?)";
            PreparedStatement programaStatement = connection.prepareStatement(programaQuery, Statement.RETURN_GENERATED_KEYS);
            programaStatement.setString(1, programa.getNombre());
            programaStatement.setString(2, programa.getDescripcion());
            programaStatement.executeUpdate();

            // Retrieve the generated keys
            ResultSet generatedKeys = programaStatement.getGeneratedKeys();
            int programaId = -1;
            if (generatedKeys.next()) {
                programaId = generatedKeys.getInt(1);
            }

            // Recorre la lista de rutinas en el programa y guarda la relación en la tabla "programa_rutina".

            for (Rutina rutina : programa.getRutinas()) {
                String relacionQuery = "INSERT INTO programa_rutina (programa_id, rutina_id) VALUES (?, ?)";
                PreparedStatement relacionStatement = connection.prepareStatement(relacionQuery);
                relacionStatement.setInt(1, programaId);
                relacionStatement.setInt(2, rutina.getId());
                relacionStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al guardar programa en la base de datos", e);
        }
    }

    @Override
    public List<Programa> consultarListaPrograma() {
        List<Programa> programas = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM programa")) {

            while (resultSet.next()) {
                int programaId = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");

                // Consulta para obtener las rutinas asociadas al programa
                String rutinasQuery = "SELECT rutina.* " +
                        "FROM rutina " +
                        "INNER JOIN programa_rutina ON rutina.id = programa_rutina.rutina_id " +
                        "WHERE programa_rutina.programa_id = ?";
                PreparedStatement rutinasStatement = connection.prepareStatement(rutinasQuery);
                rutinasStatement.setInt(1, programaId);
                ResultSet rutinasResultSet = rutinasStatement.executeQuery();

                List<Rutina> rutinas = new ArrayList<>();
                while (rutinasResultSet.next()) {
                    rutinas.add(rutina.consultarRutinaPorID(rutinasResultSet.getInt("id")));
                }

                // Crear una instancia de Programa con la información recopilada
                Programa programa = new Programa(nombre, descripcion, rutinas);
                programa.setId(programaId);

                // Agregar la rutina a la lista de rutinas
                programas.add(programa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al consultar la lista de programas en la base de datos", e);
        }

        return programas;
    }

    public void eliminarPrograma(Programa programa) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Eliminar las referencias en la tabla programa_rutina
            String eliminarReferenciasQuery = "DELETE FROM programa_rutina WHERE programa_id = ?";
            try (PreparedStatement referenciasStatement = connection.prepareStatement(eliminarReferenciasQuery)) {
                referenciasStatement.setInt(1, programa.getId());
                referenciasStatement.executeUpdate();
            }

            // Eliminar el programa
            String eliminarProgramaQuery = "DELETE FROM programa WHERE id = ?";
            try (PreparedStatement programaStatement = connection.prepareStatement(eliminarProgramaQuery)) {
                programaStatement.setInt(1, programa.getId());
                programaStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar programa en la base de datos", e);
        }
    }

}
