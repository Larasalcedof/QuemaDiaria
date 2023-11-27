package co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ResponseDTO<T> {

    public static final Integer OK = 200;
    private final Integer codigo;
    private final String mensaje;
    private final T datos;

    public ResponseDTO(Integer codigo, String mensaje, T datos) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.datos = datos;
    }

    public boolean isExitoso() {
        // Define tu lógica para determinar si la respuesta es exitosa.
        // Por ejemplo, si el código es 200 (OK), podrías considerarla exitosa.
        return OK.equals(codigo);
    }
}

