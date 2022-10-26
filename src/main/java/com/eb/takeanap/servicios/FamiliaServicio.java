/*
// Curso Egg FullStack
 */
package com.eb.takeanap.servicios;

import com.eb.takeanap.entidades.Casa;
import com.eb.takeanap.entidades.Familia;
import com.eb.takeanap.entidades.Usuario;
import com.eb.takeanap.excepciones.MiExcepcion;
import com.eb.takeanap.repositorios.CasaRepositorio;
import com.eb.takeanap.repositorios.FamiliaRepositorio;
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
public class FamiliaServicio {

    @Autowired
    FamiliaRepositorio familiaRepositorio;
    @Autowired
    CasaRepositorio casaRepositorio;
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    /*--------------------------- LISTAR FAMILIA ---------------------------*/
    @Transactional
    public void crearFamilia(int edadMax, int edadMin, String email, String nombre,
            int numHijos, String idUsuario, String idCasa) throws MiExcepcion {

        validar(edadMax, edadMin, email, nombre, numHijos, idUsuario, idCasa);

        Usuario usuario = usuarioRepositorio.findById(idUsuario).get();

        Casa casa = casaRepositorio.findById(idCasa).get();

        Familia familia = new Familia();

        familia.setEdadMax(edadMax);
        familia.setEdadMin(edadMin);
        familia.setEmail(email);
        familia.setNombre(nombre);
        familia.setNumHijos(numHijos);
        familia.setUsuario(usuario);
        familia.setCasa(casa);

        familiaRepositorio.save(familia);

    }

    /*--------------------------- LISTAR FAMILIA ---------------------------*/
    public List<Familia> listarFamilias() {

        List<Familia> familia = new ArrayList();

        familia = familiaRepositorio.findAll();

        return familia;

    }

    public Familia listarFamiliaPorEmail(String email) {

        Familia familia = familiaRepositorio.buscarPorEmail(email);

        return familia;

    }

    public Familia listarFamiliaPorCasa(String id_casa) {

        Familia familia = familiaRepositorio.buscarPorCasa(id_casa);

        return familia;

    }

    public List<Familia> listarFamiliaPorNombre(String nombre) {

        List<Familia> familia = new ArrayList();

        familia = familiaRepositorio.buscarPorNombre(nombre);

        return familia;

    }

    /*--------------------------- EDITAR FAMILIA ---------------------------*/
    @Transactional
    public void modificarFamilia(String id, int edadMax, int edadMin, String email, String nombre,
            int numHijos, String idUsuario, String idCasa) throws MiExcepcion {

        validar(edadMax, edadMin, email, nombre, numHijos, email, id);

        Optional<Familia> respuesta = familiaRepositorio.findById(id);
        Optional<Casa> respuestaCasa = casaRepositorio.findById(idCasa);
        Optional<Usuario> respuestaUsuario = usuarioRepositorio.findById(idUsuario);

        Casa casa = new Casa();
        Usuario usuario = new Usuario();

        if (respuestaCasa.isPresent()) {
            casa = respuestaCasa.get();
        }

        if (respuestaUsuario.isPresent()) {
            usuario = respuestaUsuario.get();
        }

        if (respuesta.isPresent()) {

            Familia familia = respuesta.get();

            familia.setEdadMax(edadMax);
            familia.setEdadMin(edadMin);
            familia.setEmail(email);
            familia.setNombre(nombre);
            familia.setNumHijos(numHijos);
            familia.setUsuario(usuario);
            familia.setCasa(casa);
            
            familiaRepositorio.save(familia);

        }

    }

    /*--------------------------- VALIDACION FAMILIA ---------------------------*/
    private void validar(int edadMax, int edadMin, String email, String nombre,
            int numHijos, String idUsuario, String idCasa) throws MiExcepcion {

        if (edadMax < edadMin) {
            throw new MiExcepcion("La edad máxima no puede ser menor a la mínima");
        }

        if (email.isEmpty() || email == null) {
            throw new MiExcepcion("El email no puede estar vacío");
        }

        if (nombre.isEmpty() || nombre == null) {
            throw new MiExcepcion("El nombre no puede estar vacío");
        }

        if (numHijos < 0) {
            throw new MiExcepcion("El numero de hijos no puede ser menor a 0");
        }

        if (idCasa.isEmpty() || idCasa == null) {
            throw new MiExcepcion("La casa no puede estar vacía");
        }

        if (idUsuario.isEmpty() || idUsuario == null) {
            throw new MiExcepcion("El usuario no puede estar vacío");
        }
    }
}
