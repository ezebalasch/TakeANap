/*
// Curso Egg FullStack
 */
package com.eb.takeanap.repositorios;

import com.eb.takeanap.entidades.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ezequiel Balasch
 */
@Repository
public interface ComentarioRepositorio extends JpaRepository<Comentario, String>{
    @Query("SELECT c FROM Comentario c WHERE c.casa_id = :casa_id")
    Comentario buscarPorCasa(@Param("casa_id") String casa_id);
}
