/*
// Curso Egg FullStack
 */
package com.eb.takeanap.servicios;

import com.eb.takeanap.entidades.Casa;
import com.eb.takeanap.entidades.Cliente;
import com.eb.takeanap.entidades.Estancia;
import com.eb.takeanap.repositorios.CasaRepositorio;
import com.eb.takeanap.repositorios.ClienteRepositorio;
import com.eb.takeanap.repositorios.EstanciaRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
            Date fechaHasta, String huesped) {

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

}
