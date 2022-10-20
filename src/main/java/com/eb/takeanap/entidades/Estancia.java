/*
// Curso Egg FullStack
 */
package com.eb.takeanap.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Entity
@ToString
@NoArgsConstructor
@Table(name = "Estancia")
public class Estancia {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String huesped;
    
    @Temporal(TemporalType.DATE)
    private Date fechaDesde;

    @Temporal(TemporalType.DATE)
    private Date fechaHasta;

    @OneToOne
    private Casa casa;

    @OneToOne
    private Cliente cliente;

}
