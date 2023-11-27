package co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.services;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Ejercicio;
import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Rutina;
import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.excepciones.QuemaDiariaException;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.ResponseDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.RutinaDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.d.infraestructure.persistencia.basedatos.BaseDeDatosRepositorioRutina;

import java.util.List;

public class ServiciosRutina {
    BaseDeDatosRepositorioRutina rutina = new BaseDeDatosRepositorioRutina();

    public ResponseDTO<String> guardarRutina(RutinaDTO rutinaDTO){
        try {
            Rutina nuevaRutina = new Rutina(rutinaDTO.getNombre(), rutinaDTO.getDescripcion(), rutinaDTO.getEjercicios());

            rutina.guardarRutina(nuevaRutina);
            return new ResponseDTO<>(ResponseDTO.OK, "Guardado exitoso", "Guardado exitoso");
        }
        catch (QuemaDiariaException e) {
            return new ResponseDTO<>(e.getCodigo(), e.getMessage(), "Error al guardar la rutina");
        }
    }
    public List<Rutina> consultarListaRutinas(){
        List<Rutina> rutinas = rutina.consultarListaRutina();
        return rutinas;
    }
    public Rutina consultarRutinaPorNombre(int id){
        Rutina rutina1 = rutina.consultarRutinaPorID(id);
        return rutina1;
    }

    public ResponseDTO<String> eliminarRutina(Rutina rutinadata) {
        try {
            rutina.eliminarRutina(rutinadata);
            return new ResponseDTO<>(ResponseDTO.OK, "Guardado exitoso", "Guardado exitoso");
        }
        catch (QuemaDiariaException e) {
            return new ResponseDTO<>(e.getCodigo(), e.getMessage(), "Error al eliminar el rutina");
        }
    }
}
