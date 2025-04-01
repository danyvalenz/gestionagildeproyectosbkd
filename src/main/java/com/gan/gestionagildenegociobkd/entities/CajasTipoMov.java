package com.gan.gestionagildenegociobkd.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gan.gestionagildenegociobkd.entities.base.GenericEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "cajas_tipo_mov")
@Data
public class CajasTipoMov extends GenericEntity {
    @Id
    @Column(name = "caja_tipo_mov_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cajaTipoMovId;

    @Column(name = "nombre",length = 50)
    private String nombre;

    @Column(name = "tipo")
    private double tipo;

    @OneToMany(mappedBy = "cajasTipoMov")
    @JsonManagedReference
    private List<CajasMovimientos> cajasMovimientos;

    @OneToMany(mappedBy = "cajasTipoMov")
    @JsonManagedReference
    private List<CajasTipoMovtoHist> cajasTipoMovtoHists;
}
