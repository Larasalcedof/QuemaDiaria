package co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.services;

import co.edu.javeriana.ingsoft.quemadiaria.solid.b.usecases.CifrarTexto;

import co.edu.javeriana.ingsoft.quemadiaria.solid.d.infraestructure.persistencia.basedatos.BaseDatosRepositorioUsuario;
import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.excepciones.QuemaDiariaException;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.RegistroUsuarioDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.ResponseDTO;

public class RegistroUsuarioService {


    BaseDatosRepositorioUsuario baseDatosRepositorioUsuario = new BaseDatosRepositorioUsuario();
    CifrarTexto cifrarTexto = new CifrarTexto();
    public ResponseDTO<String> registrarUsuario(RegistroUsuarioDTO registroUsuarioDTO) {
   
    

    try {
        String encriptada = cifrarTexto.encriptarContra(registroUsuarioDTO.getLogin().getPassword());
        Usuario nuevoUsuario = new Usuario(registroUsuarioDTO.getNumeroDocumento(), registroUsuarioDTO.getCorreo(), new Credenciales(registroUsuarioDTO.getLogin().getUsername(), encriptada, registroUsuarioDTO.getLogin().getTipo()));
        nuevoUsuario.setNombre(registroUsuarioDTO.getNombre());
        nuevoUsuario.setApellido(registroUsuarioDTO.getApellido());
    
    baseDatosRepositorioUsuario.guardarUsuario(nuevoUsuario);
            return new ResponseDTO<>(ResponseDTO.OK, "Registro exitoso", "Registro exitoso");
        }
        catch (QuemaDiariaException e) {
            return new ResponseDTO<>(e.getCodigo(), e.getMessage(), "Error al hacer el login");
        }
}

}
