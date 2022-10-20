/*
// Curso Egg FullStack
 */
package com.eb.takeanap.repositorios;

import com.eb.takeanap.entidades.Estancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ezequiel Balasch
 */
@Repository
public interface EstanciaRepositorio extends JpaRepository<Estancia, String> {

    @Query("SELECT e FROM Estancia e WHERE e.casa_id = :casa_id")
    Estancia buscarPorCasa(@Param("casa_id") String casa_id);

    @Query("SELECT e FROM Estancia e WHERE e.cliente_id = :cliente_id")
    Estancia buscarPorCliente(@Param("cliente_id") String cliente_id);

    @Query("SELECT e FROM Estancia e WHERE e.huesped = :huesped")
    Estancia buscarPorHuesped(@Param("huesped") String huesped);

}
