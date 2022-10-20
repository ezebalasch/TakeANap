/*
// Curso Egg FullStack
 */
package com.eb.takeanap.servicios;

import com.eb.takeanap.entidades.Cliente;
import com.eb.takeanap.entidades.Usuario;
import com.eb.takeanap.repositorios.ClienteRepositorio;
import com.eb.takeanap.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ezequiel Balasch
 */
@Service
public class ClienteServicio {

    @Autowired
    ClienteRepositorio clienteRepositorio;
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    public void crearCliente(String calle, String ciudad, String codPostal, String email,
            String nombre, int numero, String pais, String idUsuario) {

        Usuario usuario = usuarioRepositorio.findById(idUsuario).get();
        Cliente cliente = new Cliente();

        cliente.setCalle(calle);
        cliente.setCiudad(ciudad);
        cliente.setCodPostal(codPostal);
        cliente.setEmail(email);
        cliente.setNombre(nombre);
        cliente.setNumero(numero);
        cliente.setPais(pais);
        cliente.setUsuario(usuario);

        clienteRepositorio.save(cliente);
    }

}
