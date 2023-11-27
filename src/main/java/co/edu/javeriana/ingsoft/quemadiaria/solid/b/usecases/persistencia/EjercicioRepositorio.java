package co.edu.javeriana.ingsoft.quemadiaria.solid.b.usecases.persistencia;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Ejercicio;

import java.util.List;

public interface EjercicioRepositorio {
    void guardarEjercicio(Ejercicio ejercicio);

    public Ejercicio consultarEjercicioPorNombre(String nombre);

    public List<Ejercicio> consultarListaEjercicios();

    void eliminarEjercicio(Ejercicio ejercicio);
}
