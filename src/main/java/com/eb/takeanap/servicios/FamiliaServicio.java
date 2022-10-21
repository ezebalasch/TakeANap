/*
// Curso Egg FullStack
 */
package com.eb.takeanap.servicios;

import com.eb.takeanap.entidades.Casa;
import com.eb.takeanap.entidades.Familia;
import com.eb.takeanap.entidades.Usuario;
import com.eb.takeanap.repositorios.CasaRepositorio;
import com.eb.takeanap.repositorios.FamiliaRepositorio;
import com.eb.takeanap.repositorios.UsuarioRepositorio;
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
public class FamiliaServicio {

    @Autowired
    FamiliaRepositorio familiaRepositorio;
    @Autowired
    CasaRepositorio casaRepositorio;
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    /*--------------------------- LISTAR FAMILIA ---------------------------*/
    @Transactional
    public void crearFamilia(int edadMax, int edadMin, String email, String nombre,
            int numHijos, String idUsuario, String idCasa) {

        Usuario usuario = usuarioRepositorio.findById(idUsuario).get();

        Casa casa = casaRepositorio.findById(idCasa).get();

        Familia familia = new Familia();

        familia.setEdadMax(edadMax);
        familia.setEdadMin(edadMin);
        familia.setEmail(email);
        familia.setNombre(nombre);
        familia.setNumHijos(numHijos);
        familia.setUsuario(usuario);
        familia.setCasa(casa);

        familiaRepositorio.save(familia);

    }

    /*--------------------------- LISTAR FAMILIA ---------------------------*/
    public List<Familia> listarFamilias() {

        List<Familia> familia = new ArrayList();

        familia = familiaRepositorio.findAll();
        
        return familia;

    }
    
    public Familia listarFamiliaPorEmail(String email){
        
        Familia familia = familiaRepositorio.buscarPorEmail(email);
        
        return familia;
        
    }
    
    public Familia listarFamiliaPorCasa(String id_casa){
        
        Familia familia = familiaRepositorio.buscarPorCasa(id_casa);
        
        return familia;
        
    } 
    
    public List<Familia> listarFamiliaPorNombre(String nombre) {

        List<Familia> familia = new ArrayList();

        familia = familiaRepositorio.buscarPorNombre(nombre);
        
        return familia;

    }    
}
