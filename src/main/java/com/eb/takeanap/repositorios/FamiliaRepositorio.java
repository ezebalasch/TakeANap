/*
// Curso Egg FullStack
 */
package com.eb.takeanap.repositorios;

import com.eb.takeanap.entidades.Familia;
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
public interface FamiliaRepositorio extends JpaRepository<Familia, String> {

    @Query("SELECT f FROM Familia f WHERE f.email = :email")
    Familia buscarPorEmail(@Param("email") String email);

    @Query("SELECT f FROM Familia f WHERE f.casa_id = :casa_id")
    Familia buscarPorCasa(@Param("casa_id") String casa_id);

    @Query("SELECT f FROM Familia f WHERE f.nombre = :nombre")
    List<Familia> buscarPorNombre(@Param("nombre") String nombre);

}
