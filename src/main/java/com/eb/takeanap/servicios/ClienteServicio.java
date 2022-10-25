/*
// Curso Egg FullStack
 */
package com.eb.takeanap.servicios;

import com.eb.takeanap.entidades.Cliente;
import com.eb.takeanap.entidades.Usuario;
import com.eb.takeanap.repositorios.ClienteRepositorio;
import com.eb.takeanap.repositorios.UsuarioRepositorio;
import java.util.ArrayList;
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
public class ClienteServicio {

    @Autowired
    ClienteRepositorio clienteRepositorio;
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    /*--------------------------- CREAR CLIENTE ---------------------------*/
    @Transactional
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

    /*--------------------------- LISTAR CLIENTE ---------------------------*/
    public List<Cliente> buscarTodosClientes() {

        List<Cliente> cliente = new ArrayList();

        cliente = clienteRepositorio.findAll();

        return cliente;

    }

    public List<Cliente> buscarPorNombre(String nombre) {

        List<Cliente> cliente = new ArrayList();

        cliente = clienteRepositorio.buscarPorNombre(nombre);

        return cliente;

    }

    public Cliente buscarPorEmail(String email) {

        Cliente cliente = clienteRepositorio.buscarPorEmail(email);

        return cliente;

    }

    /*--------------------------- EDITAR CLIENTE ---------------------------*/
    @Transactional
    public void modificarCliente(String id, String calle, String ciudad, String codPostal,
            String email, String nombre, int numero, String pais) {

        Optional<Cliente> respuesta = clienteRepositorio.findById(id);

        if (respuesta.isPresent()) {

            Cliente cliente = respuesta.get();

            cliente.setCalle(calle);
            cliente.setCiudad(ciudad);
            cliente.setCodPostal(codPostal);
            cliente.setEmail(email);
            cliente.setNombre(nombre);
            cliente.setNumero(numero);
            cliente.setPais(pais);

            clienteRepositorio.save(cliente);
        }

    }
}
