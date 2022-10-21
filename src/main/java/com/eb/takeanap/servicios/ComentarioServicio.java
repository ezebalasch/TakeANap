/*
// Curso Egg FullStack
 */
package com.eb.takeanap.servicios;

import com.eb.takeanap.entidades.Casa;
import com.eb.takeanap.entidades.Comentario;
import com.eb.takeanap.repositorios.CasaRepositorio;
import com.eb.takeanap.repositorios.ComentarioRepositorio;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ezequiel Balasch
 */
@Service
public class ComentarioServicio {
    @Autowired
    ComentarioRepositorio comentarioRepositorio;
    @Autowired
    CasaRepositorio casaRepositorio;
    
    /*--------------------------- CREAR COMENTARIO ---------------------------*/
    @Transactional
    public void crearComentario(String descripcion, String idCasa){
        
        Casa casa = casaRepositorio.findById(idCasa).get();
        
        Comentario comentario = new Comentario();
        
        comentario.setDescripcion(descripcion);
        comentario.setCasa(casa);
        
        comentarioRepositorio.save(comentario);
        
    }
    
    /*--------------------------- LISTAR COMENTARIO ---------------------------*/
    public List<Comentario> listarTodosComentarios(){
        
        List<Comentario> comentario = new ArrayList();
        
        comentario = comentarioRepositorio.findAll();
        
        return comentario;
        
    }
    
    public Comentario listarComentarioPorCasa(String id_casa){
        
        Comentario comentario = comentarioRepositorio.buscarPorCasa(id_casa);
        
        return comentario;
        
    }
    
}
