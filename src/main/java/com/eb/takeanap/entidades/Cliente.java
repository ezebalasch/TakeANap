/*
// Curso Egg FullStack
 */
package com.eb.takeanap.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Ezequiel Balasch
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "Cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")    
    private String id;
    
    private String nombre;
    
    private String calle;
    
    private int numero;
    
    private String codPostal;
    
    private String ciudad;
    
    private String pais;
    
    private String email;
    
    @OneToOne
    private Usuario usuario;
    
}
