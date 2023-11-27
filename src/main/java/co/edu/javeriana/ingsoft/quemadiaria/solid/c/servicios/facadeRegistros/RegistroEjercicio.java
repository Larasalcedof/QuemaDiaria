package co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facadeRegistros;

import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.EjercicioDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.ResponseDTO;

public interface RegistroEjercicio {
    public ResponseDTO<String> guardarEjercicio(EjercicioDTO ejerciciodto);
}
