package co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facadeRegistros;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Ejercicio;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.EjercicioDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.ResponseDTO;

import java.util.List;

public interface EliminarEjercicio {
    public ResponseDTO<String> eliminarrEjercicio(Ejercicio ejerciciodto);

    public List<Ejercicio> consultarListaEjercicios();
}
