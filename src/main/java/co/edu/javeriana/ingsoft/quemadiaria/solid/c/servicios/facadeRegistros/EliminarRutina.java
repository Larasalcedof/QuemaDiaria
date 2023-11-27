package co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facadeRegistros;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Rutina;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.ResponseDTO;

import java.util.List;

public interface EliminarRutina {
    public ResponseDTO<String> eliminarRutina(Rutina rutina);

    public List<Rutina> consultarListaRutinas();
}
