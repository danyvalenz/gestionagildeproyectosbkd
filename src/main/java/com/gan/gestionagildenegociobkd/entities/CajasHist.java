package com.gan.gestionagildenegociobkd.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gan.gestionagildenegociobkd.entities.base.GenericEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "cajas_hist")
@Data
public class CajasHist extends GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movto_id")
    private Long movtoId;

    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "tipo_mov",length = 10)
    private String tipoMov;
    @Column(name = "nombre",length = 50)
    private String nombre;
    @Column(name = "abierta")
    private boolean abierta;
    @Column(name = "importe")
    private Double importe;

    //llave foranea
    @JoinColumn(name = "caja_id", referencedColumnName = "caja_id")
    @ManyToOne()
    @JsonBackReference
    private Cajas caja;

}
