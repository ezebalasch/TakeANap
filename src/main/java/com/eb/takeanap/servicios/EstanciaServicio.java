/*
// Curso Egg FullStack
 */
package com.eb.takeanap.servicios;

import com.eb.takeanap.entidades.Casa;
import com.eb.takeanap.entidades.Cliente;
import com.eb.takeanap.entidades.Estancia;
import com.eb.takeanap.excepciones.MiExcepcion;
import com.eb.takeanap.repositorios.CasaRepositorio;
import com.eb.takeanap.repositorios.ClienteRepositorio;
import com.eb.takeanap.repositorios.EstanciaRepositorio;
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
public class EstanciaServicio {

    @Autowired
    EstanciaRepositorio estanciaRepositorio;
    @Autowired
    CasaRepositorio casaRepositorio;
    @Autowired
    ClienteRepositorio clienteRepositorio;

    /*--------------------------- CREAR ESTANCIA ---------------------------*/
    @Transactional
    public void crearEstancia(String idCasa, String idCliente, Date fechaDesde,
            Date fechaHasta, String huesped) throws MiExcepcion {

        validar(idCasa, idCliente, fechaDesde, fechaHasta, huesped);

        Casa casa = casaRepositorio.findById(idCasa).get();

        Cliente cliente = clienteRepositorio.findById(idCliente).get();

        Estancia estancia = new Estancia();

        estancia.setCasa(casa);
        estancia.setCliente(cliente);
        estancia.setFechaDesde(fechaDesde);
        estancia.setFechaHasta(fechaHasta);
        estancia.setHuesped(huesped);

        estanciaRepositorio.save(estancia);

    }

    /*--------------------------- LISTAR ESTANCIA ---------------------------*/
    public List<Estancia> listarTodasEstancias() {

        List<Estancia> estancia = new ArrayList();

        estancia = estanciaRepositorio.findAll();

        return estancia;

    }

    public Estancia listarEstanciaPorCasa(String id_casa) {

        Estancia estancia = estanciaRepositorio.buscarPorCasa(id_casa);

        return estancia;

    }

    public Estancia listarEstanciaPorCliente(String id_cliente) {

        Estancia estancia = estanciaRepositorio.buscarPorCliente(id_cliente);

        return estancia;

    }

    public Estancia listarEstanciaPorHuesped(String huesped) {

        Estancia estancia = estanciaRepositorio.buscarPorHuesped(huesped);

        return estancia;

    }

    /*--------------------------- EDITAR ESTANCIA ---------------------------*/
    @Transactional
    public void modificarEstancia(String idCasa, String idCliente, String id,
            Date fechaDesde, Date fechaHasta, String huesped) throws MiExcepcion {

        validar(idCasa, idCliente, fechaDesde, fechaHasta, huesped);

        Optional<Estancia> respuesta = estanciaRepositorio.findById(id);
        Optional<Casa> respuestaCasa = casaRepositorio.findById(idCasa);
        Optional<Cliente> respuestaCliente = clienteRepositorio.findById(idCliente);

        Casa casa = new Casa();
        Cliente cliente = new Cliente();

        if (respuestaCasa.isPresent()) {
            casa = respuestaCasa.get();
        }

        if (respuestaCliente.isPresent()) {
            cliente = respuestaCliente.get();
        }

        if (respuesta.isPresent()) {

            Estancia estancia = respuesta.get();
            
            estancia.setCasa(casa);
            estancia.setCliente(cliente);
            estancia.setFechaDesde(fechaDesde);
            estancia.setFechaHasta(fechaHasta);
            estancia.setHuesped(huesped);

            estanciaRepositorio.save(estancia);

        }

    }

    /*--------------------------- VALIDACION ESTANCIA ---------------------------*/
    private void validar(String idCasa, String idCliente, Date fechaDesde,
            Date fechaHasta, String huesped) throws MiExcepcion {

        if (idCasa.isEmpty() || idCasa == null) {
            throw new MiExcepcion("La casa no puede estar vacía");
        }

        if (idCliente.isEmpty() || idCliente == null) {
            throw new MiExcepcion("El cliente no puede estar vacío");
        }

        if (fechaHasta.before(fechaDesde)) {
            throw new MiExcepcion("Fecha errónea");
        }

        if (huesped.isEmpty() || huesped == null) {
            throw new MiExcepcion("El huésped no puede estar vacío");
        }
    }
}
