package co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto;

import lombok.Data;

@Data
public class EjercicioDTO {
    private String nombre;
    private int repeticiones;
    private String musculo;
    private String descripcion;

    public EjercicioDTO(String nombre, int repeticiones, String musculo, String descripcion) {
        this.nombre = nombre;
        this.repeticiones = repeticiones;
        this.musculo = musculo;
        this.descripcion = descripcion;
    }
}
