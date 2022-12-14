/*
// Curso Egg FullStack
 */
package com.eb.takeanap.servicios;

import com.eb.takeanap.entidades.Usuario;
import com.eb.takeanap.excepciones.MiExcepcion;
import com.eb.takeanap.repositorios.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ezequiel Balasch
 */
@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    /*--------------------------- CREAR USUARIO ---------------------------*/
    @Transactional
    public void crearUsuario(String aliaz, String clave, String email) throws MiExcepcion {

        validar(aliaz, clave, email);
        
        Usuario usuario = new Usuario();

        usuario.setAliaz(aliaz);
        usuario.setClave(clave);
        usuario.setEmail(clave);
        usuario.setFechaAlta(new Date());

        usuarioRepositorio.save(usuario);
    }

    /*--------------------------- LISTAR USUARIO ---------------------------*/
    public List<Usuario> listarUsuariosAlta() {

        List<Usuario> usuarios = new ArrayList();

        usuarios = usuarioRepositorio.todosUsuarios();

        return usuarios;
    }

    public List<Usuario> listarUsuariosAliaz(String aliaz) {

        List<Usuario> usuarios = new ArrayList();

        usuarios = usuarioRepositorio.buscarPorAlias(aliaz);

        return usuarios;

    }

    public Usuario listarUsuarioPorEmail(String email) {

        Usuario usuario = usuarioRepositorio.buscarPorEmail(email);

        return usuario;

    }

    /*--------------------------- LISTAR USUARIO ---------------------------*/
    @Transactional
    public void modificarUsuario(String id, String aliaz, String clave,
            String email) throws MiExcepcion {

        validar(aliaz, clave, email);
        
        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);

        if (respuesta.isPresent()) {

            Usuario usuario = respuesta.get();

            usuario.setAliaz(aliaz);
            usuario.setClave(clave);
            usuario.setEmail(email);

            usuarioRepositorio.save(usuario);

        }

    }

    /*--------------------------- VALIDACION USUARIO ---------------------------*/
    private void validar(String aliaz, String clave, String email) throws MiExcepcion {

        if (aliaz.isEmpty() || aliaz == null) {
            throw new MiExcepcion("El alias no puede estar vac??o");
        }

        if (clave.isEmpty() || clave == null) {
            throw new MiExcepcion("La clave no puede estar vac??a");
        }
        
        if (email.isEmpty() || email == null) {
            throw new MiExcepcion("El email no puede estar vac??o");
        }        
        
    }

}
