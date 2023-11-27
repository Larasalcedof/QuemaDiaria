package co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.services;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Programa;
import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Rutina;
import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.excepciones.QuemaDiariaException;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.ProgramaDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.ResponseDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.d.infraestructure.persistencia.basedatos.BaseDeDatosRepositorioPrograma;

import java.util.List;

public class ServiciosPrograma {
    BaseDeDatosRepositorioPrograma programa = new BaseDeDatosRepositorioPrograma();

    public ResponseDTO<String> guardarPrograma(ProgramaDTO programaDTO){
        try {
            Programa nuevoPrograma = new Programa(programaDTO.getNombre(), programaDTO.getDescripcion(), programaDTO.getRutinas());

            programa.guardarPrograma(nuevoPrograma);
            return new ResponseDTO<>(ResponseDTO.OK, "Guardado exitoso", "Guardado exitoso");
        }
        catch (QuemaDiariaException e) {
            return new ResponseDTO<>(e.getCodigo(), e.getMessage(), "Error al guardar el programa");
        }
    }
    public List<Programa> consultarListaProgramas(){
        List<Programa> programas = programa.consultarListaPrograma();
        return programas;
    }

    public ResponseDTO<String> eliminarPrograma(Programa programadata) {
        try {
            programa.eliminarPrograma(programadata);
            return new ResponseDTO<>(ResponseDTO.OK, "Guardado exitoso", "Guardado exitoso");
        }
        catch (QuemaDiariaException e) {
            return new ResponseDTO<>(e.getCodigo(), e.getMessage(), "Error al eliminar el programa");
        }
    }
}
