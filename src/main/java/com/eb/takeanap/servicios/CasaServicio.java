/*
// Curso Egg FullStack
 */
package com.eb.takeanap.servicios;

import com.eb.takeanap.entidades.Casa;
import com.eb.takeanap.repositorios.CasaRepositorio;
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
public class CasaServicio {

    @Autowired
    CasaRepositorio casaRepositorio;

    /*--------------------------- CREAR CASA ---------------------------*/
    @Transactional
    public void crearCasa(String calle, String ciudad, String codPostal,
            Date fechaDesde, Date fechaHasta, int minDias, int maxDias,
            int numero, String pais, Double precio, String tipoVivienda) {

        Casa casa = new Casa();

        casa.setCalle(calle);
        casa.setCiudad(ciudad);
        casa.setCodPostal(codPostal);
        casa.setFechaDesde(fechaDesde);
        casa.setFechaHasta(fechaHasta);
        casa.setMinDias(minDias);
        casa.setMaxDias(maxDias);
        casa.setNumero(numero);
        casa.setPais(pais);
        casa.setPrecio(precio);
        casa.setTipoVivienda(tipoVivienda);

        casaRepositorio.save(casa);
    }

    /*--------------------------- LISTAR CASA ---------------------------*/
    public List<Casa> listarTodasCasas() {

        List<Casa> casa = new ArrayList();

        casa = casaRepositorio.findAll();

        return casa;
    }

    public List<Casa> buscarCasaPorCiudad(String ciudad) {

        List<Casa> casa = new ArrayList();

        casa = casaRepositorio.buscarPorCiudad(ciudad);

        return casa;

    }

    public List<Casa> buscarCasaPorPais(String pais) {

        List<Casa> casa = new ArrayList();

        casa = casaRepositorio.buscarPorPais(pais);

        return casa;

    }

    public List<Casa> buscarCasaPorPrecio(Double precioMenor, Double precioMayor) {

        List<Casa> casa = new ArrayList();

        casa = casaRepositorio.buscarPorPrecio(precioMenor, precioMayor);

        return casa;

    }

    public List<Casa> buscarCasaPorTipoVivienda(String tipoVivienda) {

        List<Casa> casa = new ArrayList();

        casa = casaRepositorio.buscarPorTipoVivienda(tipoVivienda);

        return casa;

    }

    /*--------------------------- EDITAR CASA ---------------------------*/
    @Transactional
    public void modificarCasa(String id, String calle, String ciudad,
            String codPostal, Date fechaDesde, Date fechaHasta, int minDias,
            int maxDias, int numero, String pais, Double precio, String tipoVivienda) {

        Optional<Casa> respuesta = casaRepositorio.findById(id);

        if (respuesta.isPresent()) {

            Casa casa = respuesta.get();

            casa.setCalle(calle);
            casa.setCiudad(ciudad);
            casa.setCodPostal(codPostal);
            casa.setFechaDesde(fechaDesde);
            casa.setFechaHasta(fechaHasta);
            casa.setMinDias(minDias);
            casa.setMaxDias(maxDias);
            casa.setNumero(numero);
            casa.setPais(pais);
            casa.setPrecio(precio);
            casa.setTipoVivienda(tipoVivienda);

            casaRepositorio.save(casa);
        }

    }

}
