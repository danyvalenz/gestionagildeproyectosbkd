package com.gan.gestionagildenegociobkd.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gan.gestionagildenegociobkd.entities.base.GenericEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "existencias")
@Data
public class Existencias extends GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "existencia_id")
    private Long existenciaId;

    @Column(name = "existencia")
    private float existencia;
    @Column(name = "apartado")
    private float apartado;
    @Column(name = "costo_promedio")
    private float costoPromedio;

    @JoinColumn(name = "almacen_id", referencedColumnName = "almancenId")
    @ManyToOne()
    @JsonBackReference
    private Almacen almacen;

    @JoinColumn(name = "item_id",referencedColumnName = "item_id")
    @ManyToOne()
    @JsonBackReference
    private Items items;

}
