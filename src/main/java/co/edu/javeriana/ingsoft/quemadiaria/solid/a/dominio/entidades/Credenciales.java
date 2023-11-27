package co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades;

import java.io.Serializable;
import co.edu.javeriana.ingsoft.quemadiaria.solid.b.usecases.CifrarTexto;

public class Credenciales implements Serializable {

    private final String nombreUsuario;

    private final String contrasenna;

    private final Integer tipo;


    public Credenciales(String nombreUsuario, String contrasenna, Integer tipo) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenna = contrasenna;
        this.tipo = tipo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public Integer getTipo(){
        return tipo;
    }

    public boolean validarCredenciales(String nombreUsuario, String contrasenna, Integer tipo) {
        CifrarTexto cifrarTexto = new CifrarTexto();
        String desncriptada = cifrarTexto.desencriptarContra(this.contrasenna);
        return desncriptada.equals(contrasenna) && this.nombreUsuario.equals(nombreUsuario) && this.tipo.equals(tipo);
    }

    @Override
    public String toString() {
        return "Credenciales {" + "nombreUsuario=" + nombreUsuario + ", contrasenna=" + contrasenna + '}';
    }
}
