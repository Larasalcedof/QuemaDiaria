package co.edu.javeriana.ingsoft.quemadiaria.solid.b.usecases.persistencia;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Rutina;

import java.util.List;

public interface RutinaRepositorio {
    List<Rutina> consultarListaRutina();

    Rutina consultarRutinaPorID(int id);

    void guardarRutina(Rutina rutina);

    public void eliminarRutina(Rutina rutina);
}
