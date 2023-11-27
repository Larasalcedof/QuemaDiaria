package co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Rutina;
import lombok.Data;

import java.util.List;

@Data
public class ProgramaDTO {
    private String nombre;
    private String descripcion;
    private List<Rutina> rutinas;

    public ProgramaDTO(String nombre, String descripcion, List<Rutina> rutinas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rutinas = rutinas;
    }
}
