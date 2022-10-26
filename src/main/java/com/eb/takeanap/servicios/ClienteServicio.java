/*
// Curso Egg FullStack
 */
package com.eb.takeanap.servicios;

import com.eb.takeanap.entidades.Cliente;
import com.eb.takeanap.entidades.Usuario;
import com.eb.takeanap.excepciones.MiExcepcion;
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
            String nombre, int numero, String pais, String idUsuario) throws MiExcepcion {

        validar(calle, ciudad, codPostal, email, nombre, numero, pais, idUsuario);

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
            String email, String nombre, int numero, String pais, String idUsuario) throws MiExcepcion {

        validar(calle, ciudad, codPostal, email, nombre, numero, pais, idUsuario);

        Optional<Cliente> respuesta = clienteRepositorio.findById(id);
        Optional<Usuario> respuestaUsuario = usuarioRepositorio.findById(idUsuario);

        Usuario usuario = new Usuario();

        if (respuestaUsuario.isPresent()) {
            usuario = respuestaUsuario.get();
        }

        if (respuesta.isPresent()) {

            Cliente cliente = respuesta.get();

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

    /*--------------------------- VALIDACIONES CLIENTE ---------------------------*/
    private void validar(String calle, String ciudad, String codPostal, String email,
            String nombre, int numero, String pais, String idUsuario) throws MiExcepcion {

        if (calle.isEmpty() || calle == null) {
            throw new MiExcepcion("La calle no puede estar vacía");
        }

        if (ciudad.isEmpty() || ciudad == null) {
            throw new MiExcepcion("La ciudad no puede estar vacía");
        }

        if (codPostal.isEmpty() || codPostal == null) {
            throw new MiExcepcion("El código postal no puede estar vacío");
        }

        if (email.isEmpty() || email == null) {
            throw new MiExcepcion("La dirección email no puede estar vacía");
        }

        if (nombre.isEmpty() || nombre == null) {
            throw new MiExcepcion("El nombre no puede estar vacío");
        }

        if (numero <= 0) {
            throw new MiExcepcion("El número debe ser mayor a 0");
        }

        if (pais.isEmpty() || pais == null) {
            throw new MiExcepcion("El país no puede estar vacío");
        }

        if (idUsuario.isEmpty() || idUsuario == null) {
            throw new MiExcepcion("El usuario no puede estar vacío");
        }
    }

}
