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
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Casa")
public class Casa {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String calle;

    private int numero;

    private String codPostal;

    private String ciudad;

    private String pais;

    @Temporal(TemporalType.DATE)
    private Date fechaDesde;
    
    @Temporal(TemporalType.DATE)
    private Date fechaHasta;

    private int minDias;

    private int maxDias;

    private Double precio;

    private String tipoVivienda;


}
