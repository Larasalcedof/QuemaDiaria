package co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.services;


import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.RegistroUsuarioDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.d.infraestructure.persistencia.basedatos.BaseDatosRepositorioUsuario;

public class ConsultarExistenciaService {

    BaseDatosRepositorioUsuario baseDatosRepositorioUsuario = new BaseDatosRepositorioUsuario();

    public boolean consultarExistencia(RegistroUsuarioDTO registroUsuarioDTO) {
        // Lógica para registrar el usuario
        System.out.println(registroUsuarioDTO.getLogin().getPassword());
        Usuario nuevoUsuario = new Usuario(registroUsuarioDTO.getNumeroDocumento(), registroUsuarioDTO.getCorreo(), new Credenciales(registroUsuarioDTO.getLogin().getUsername(), registroUsuarioDTO.getLogin().getPassword(), registroUsuarioDTO.getLogin().getTipo()));
        nuevoUsuario.setNombre(registroUsuarioDTO.getNombre());
        nuevoUsuario.setApellido(registroUsuarioDTO.getApellido());
        // Guardar el usuario en la base de datos o en otro sistema de persistencia
        // Puedes utilizar el servicio o repositorio correspondiente
        // Ejemplo:
        
    
        // Devolver una respuesta adecuada
        return baseDatosRepositorioUsuario.consultarExistencia(nuevoUsuario);
}
}
