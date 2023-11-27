package co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Rutina implements Serializable {

    private String nombre;
    private String descripcion;
    private List<Ejercicio> ejercicios;
    private int id;

    public Rutina() {
    }

    public Rutina(String nombre, String descripcion, List<Ejercicio> ejercicios) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ejercicios = ejercicios;
    }

    public Rutina(String nombre, String descripcion, List<Ejercicio> ejercicios, int id) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ejercicios = ejercicios;
        this.id = id;
    }

}