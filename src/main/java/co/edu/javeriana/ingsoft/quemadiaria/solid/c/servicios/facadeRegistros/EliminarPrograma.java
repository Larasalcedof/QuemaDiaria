package co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facadeRegistros;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Programa;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.ResponseDTO;

import java.util.List;

public interface EliminarPrograma {
    public ResponseDTO<String> eliminarPrograma(Programa programa);

    public List<Programa> consultarListaProgramas();
}
