package co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.services;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Ejercicio;
import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.excepciones.QuemaDiariaException;
import co.edu.javeriana.ingsoft.quemadiaria.solid.b.usecases.persistencia.EjercicioRepositorio;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.EjercicioDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.ResponseDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.d.infraestructure.persistencia.basedatos.BaseDeDatosRepositorioEjercicio;

import java.util.List;

public class ServiciosEjercicio{
    BaseDeDatosRepositorioEjercicio ejercicio = new BaseDeDatosRepositorioEjercicio();

    public ResponseDTO<String> guardarEjercicio(EjercicioDTO ejerciciodto){
        try {
            Ejercicio nuevoEjercicio = new Ejercicio(ejerciciodto.getNombre(), ejerciciodto.getRepeticiones(), ejerciciodto.getMusculo(), ejerciciodto.getDescripcion());

            ejercicio.guardarEjercicio(nuevoEjercicio);
            return new ResponseDTO<>(ResponseDTO.OK, "Guardado exitoso", "Guardado exitoso");
        }
        catch (QuemaDiariaException e) {
            return new ResponseDTO<>(e.getCodigo(), e.getMessage(), "Error al guardar el ejercicio");
        }
    }
    public List<Ejercicio> consultarListaEjercicios(){
        List<Ejercicio> ejercicios = ejercicio.consultarListaEjercicios();
        return ejercicios;
    }
    public Ejercicio consultarEjercicioPorNombre(String nombre){
        Ejercicio ejercicio1 = ejercicio.consultarEjercicioPorNombre(nombre);
        return ejercicio1;
    }
    public ResponseDTO<String> eliminarEjercicio(Ejercicio ejerciciodto) {
        try {
            ejercicio.eliminarEjercicio(ejerciciodto);
            return new ResponseDTO<>(ResponseDTO.OK, "Guardado exitoso", "Guardado exitoso");
        }
        catch (QuemaDiariaException e) {
            return new ResponseDTO<>(e.getCodigo(), e.getMessage(), "Error al eliminar el ejercicio");
        }
    }
}
