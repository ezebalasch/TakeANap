/*
// Curso Egg FullStack
 */
package com.eb.takeanap.repositorios;

import com.eb.takeanap.entidades.Usuario;
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
public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {

    @Query("SELECT u FROM Usuario u WHERE u.fecha_alta != 0")
    List<Usuario> todosUsuarios();

    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    Usuario buscarPorEmail(@Param("email") String email);

    @Query("SELECT u FROM Usuario u WHERE u.aliaz = :aliaz")
    List<Usuario> buscarPorAlias(@Param("aliaz") String aliaz);

}
