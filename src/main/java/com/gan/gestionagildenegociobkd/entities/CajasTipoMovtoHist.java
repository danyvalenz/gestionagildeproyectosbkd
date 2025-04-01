package com.gan.gestionagildenegociobkd.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gan.gestionagildenegociobkd.entities.base.GenericEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cajas_tipo_mov_hist")
@Data
public class CajasTipoMovtoHist extends GenericEntity {
    @Id
    @Column(name = "movto_hist_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movtoHistId;

    @Column(name = "tipo_mov")
    private String tipoMov;

    @Column(name = "nombre",length = 50)
    private String nombre;

    @Column(name = "tipo",length = 10)
    private String tipo;

    //llave foranea
    @JoinColumn(name = "caja_tipo_mov_id", referencedColumnName = "caja_tipo_mov_id")
    @ManyToOne()
    @JsonBackReference
    private CajasTipoMov cajasTipoMov;
}
