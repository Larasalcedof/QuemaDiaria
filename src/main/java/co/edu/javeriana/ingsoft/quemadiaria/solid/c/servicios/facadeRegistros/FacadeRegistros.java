package co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facadeRegistros;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Ejercicio;
import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Programa;
import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Rutina;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.EjercicioDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.ProgramaDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.ResponseDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.RutinaDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.services.ServiciosEjercicio;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.services.ServiciosPrograma;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.services.ServiciosRutina;

import java.util.List;

public class FacadeRegistros implements RegistroEjercicio, RegistroRutina, RegistroPrograma, ListarPrograma, EliminarEjercicio, EliminarRutina, EliminarPrograma {
    private ServiciosEjercicio serviciosEjercios = new ServiciosEjercicio();
    private ServiciosRutina serviciosRutina = new ServiciosRutina();
    private ServiciosPrograma serviciosPrograma = new ServiciosPrograma();


    @Override
    public ResponseDTO<String> guardarEjercicio(EjercicioDTO ejerciciodto) {
        return serviciosEjercios.guardarEjercicio(ejerciciodto);
    }

    @Override
    public List<Ejercicio> consultarListaEjercicios(){
        return serviciosEjercios.consultarListaEjercicios();
    }

    public Ejercicio consultarEjercicioPorNombre(String nombre){
        return serviciosEjercios.consultarEjercicioPorNombre(nombre);
    }

    @Override
    public ResponseDTO<String> eliminarrEjercicio(Ejercicio ejerciciodto) {
        return serviciosEjercios.eliminarEjercicio(ejerciciodto);
    }

    @Override
    public ResponseDTO<String> guardarRutina(RutinaDTO rutinadto) {
        return serviciosRutina.guardarRutina(rutinadto);
    }

    @Override
    public List<Rutina> consultarListaRutinas(){
        return serviciosRutina.consultarListaRutinas();
    }

    @Override
    public ResponseDTO<String> eliminarRutina(Rutina rutina) {
        return serviciosRutina.eliminarRutina(rutina);
    }

    @Override
    public ResponseDTO<String> guardarPrograma(ProgramaDTO programadto) {
        return serviciosPrograma.guardarPrograma(programadto);
    }

    @Override
    public List<Programa> consultarListaProgramas(){
        return serviciosPrograma.consultarListaProgramas();
    }

    @Override
    public ResponseDTO<String> eliminarPrograma(Programa programa) {
        return serviciosPrograma.eliminarPrograma(programa);
    }


}
