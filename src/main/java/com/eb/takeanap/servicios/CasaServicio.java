/*
// Curso Egg FullStack
 */
package com.eb.takeanap.servicios;

import com.eb.takeanap.entidades.Casa;
import com.eb.takeanap.repositorios.CasaRepositorio;
import java.util.Date;
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

}
