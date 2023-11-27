package co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Ejercicio;
import lombok.Data;

import java.util.List;
@Data
public class RutinaDTO {
    private String nombre;
    private String descripcion;
    private List<Ejercicio> ejercicios;

    public RutinaDTO(String nombre, String descripcion, List<Ejercicio> ejercicios) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ejercicios = ejercicios;
    }
}
