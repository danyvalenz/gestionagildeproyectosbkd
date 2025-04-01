package com.gan.gestionagildenegociobkd.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gan.gestionagildenegociobkd.entities.base.GenericEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cajas_movimientos")
@Data
public class CajasMovimientos extends GenericEntity {

    @Id
    @Column(name = "movto_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movtoId;

    @Column(name = "saldo_incial")
    private double saldoInicial;

    @Column(name = "deposito")
    private double deposito;

    @Column(name = "retiro")
    private double retiro;

    @Column(name = "saldo_final")
    private double saldoFinal;

    //llave foranea
    @JoinColumn(name = "caja_id", referencedColumnName = "caja_id")
    @ManyToOne()
    @JsonBackReference
    private Cajas caja;

    //llave foranea
    @JoinColumn(name = "caja_tipo_mov_id", referencedColumnName = "caja_tipo_mov_id")
    @ManyToOne()
    @JsonBackReference
    private CajasTipoMov cajasTipoMov;
}
