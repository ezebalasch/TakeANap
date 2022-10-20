/*
// Curso Egg FullStack
 */
package com.eb.takeanap.repositorios;

import com.eb.takeanap.entidades.Cliente;
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
public interface ClienteRepositorio extends JpaRepository<Cliente, String> {

    @Query("SELECT c FROM Cliente c WHERE c.nombre = :nombre")
    List<Cliente> buscarPorNombre(@Param("nombre") String nombre);

    @Query("SELECT c FROM Cliente c WHERE c.email = :email")
    Cliente buscarPorEmail(@Param("email") String email);

}
