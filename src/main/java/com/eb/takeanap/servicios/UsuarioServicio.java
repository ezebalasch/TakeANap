/*
// Curso Egg FullStack
 */
package com.eb.takeanap.servicios;

import com.eb.takeanap.entidades.Usuario;
import com.eb.takeanap.repositorios.UsuarioRepositorio;
import java.util.Date;
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

    public void crearUsuario(String aliaz, String clave, String email) {

        Usuario usuario = new Usuario();

        usuario.setAliaz(aliaz);
        usuario.setClave(clave);
        usuario.setEmail(clave);
        usuario.setFechaAlta(new Date());

        usuarioRepositorio.save(usuario);
    }

}
