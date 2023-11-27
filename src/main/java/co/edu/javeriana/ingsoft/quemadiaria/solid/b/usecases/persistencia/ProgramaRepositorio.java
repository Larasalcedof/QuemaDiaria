package co.edu.javeriana.ingsoft.quemadiaria.solid.b.usecases.persistencia;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Programa;

import java.util.List;

public interface ProgramaRepositorio {
    List<Programa> consultarListaPrograma();

    void guardarPrograma(Programa programa);
}
