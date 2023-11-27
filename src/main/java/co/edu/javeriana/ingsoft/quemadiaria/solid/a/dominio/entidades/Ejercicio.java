package co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades;

import java.io.Serializable;

public class Ejercicio implements Serializable{
    
    private String nombre;
    private int repeticiones;
    private String musculo;
    private String descripcion;
    private int Id;

    public Ejercicio(String nombre, int repeticiones, String musculo, String descripcion, int id) {
        this.nombre = nombre;
        this.repeticiones = repeticiones;
        this.musculo = musculo;
        this.descripcion = descripcion;
        Id = id;
    }

    public Ejercicio(String nombre, int repeticiones, String musculo, String descripcion){
        this.nombre = nombre;
        this.repeticiones = repeticiones;
        this.musculo = musculo;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public String getMusculo() {
        return musculo;
    }

    public void setMusculo(String musculo) {
        this.musculo = musculo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Ejercicio [id="+Id+", nombre=" + nombre + ", repeticiones=" + repeticiones + ", musculo=" + musculo + ", descripcion ejercicio = " +descripcion+ "]";
    }

}
