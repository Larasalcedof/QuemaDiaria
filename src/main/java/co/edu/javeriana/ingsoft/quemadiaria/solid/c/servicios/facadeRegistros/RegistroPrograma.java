package co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facadeRegistros;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Programa;
import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Rutina;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.ProgramaDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.ResponseDTO;

import java.util.List;

public interface RegistroPrograma {
    public ResponseDTO<String> guardarPrograma(ProgramaDTO programadto);
    public List<Rutina> consultarListaRutinas();
}
