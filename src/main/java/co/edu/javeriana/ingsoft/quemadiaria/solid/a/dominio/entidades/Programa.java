package co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Programa implements Serializable {

    private String nombre;
    private String descripcion;
    private List<Rutina> rutinas;
    private int id;

    public Programa() {
    }

    public Programa(String nombre, String descripcion, List<Rutina> rutinas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rutinas = rutinas;
    }

    public Programa(String nombre, String descripcion, List<Rutina> rutinas, int id) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rutinas = rutinas;
        this.id = id;
    }
}