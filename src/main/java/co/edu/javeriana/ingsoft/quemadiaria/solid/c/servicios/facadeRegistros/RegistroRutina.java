package co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facadeRegistros;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Ejercicio;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.ResponseDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.RutinaDTO;

import java.util.List;

public interface RegistroRutina {
    public ResponseDTO<String> guardarRutina(RutinaDTO rutinadto);
    public List<Ejercicio> consultarListaEjercicios();
}
