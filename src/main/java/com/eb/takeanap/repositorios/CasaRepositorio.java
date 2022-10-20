/*
// Curso Egg FullStack
 */
package com.eb.takeanap.repositorios;

import com.eb.takeanap.entidades.Casa;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ezequiel Balasch
 */
@Repository
public interface CasaRepositorio extends JpaRepository<Casa, String> {

    @Query("SELECT c FROM Casa c WHERE c.ciudad = :ciudad")
    List<Casa> buscarPorCiudad(@Param("ciudad") String ciudad);

    @Query("SELECT c FROM Casa c WHERE c.pais = :pais")
    List<Casa> buscarPorPais(@Param("pais") String pais);

    @Query("SELECT c FROM Casa c WHERE c.tipo_vivienda = :tipo_vivienda")
    List<Casa> buscarPorTipoVivienda(@Param("tipo_vivienda") String tipo_vivienda);

    @Query("SELECT c FROM Casa c WHERE c.precio = :precio")
    List<Casa> buscarPorPrecio(@Param("precio") Double precio);

}
