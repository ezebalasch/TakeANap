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
import java.util.Date;
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

}
