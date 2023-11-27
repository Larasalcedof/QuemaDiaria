package co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facade;


import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.RegistroUsuarioDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.ResponseDTO;

public interface ConsultarExistenciaFacade {

    ResponseDTO<String> consultarExistencia(RegistroUsuarioDTO registroUsuarioDTO);

}
