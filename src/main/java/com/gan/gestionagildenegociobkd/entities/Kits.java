package com.gan.gestionagildenegociobkd.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gan.gestionagildenegociobkd.entities.base.GenericEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "kits")
@Data
public class Kits extends GenericEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kit_id")
    private Long kitId;

    @Column(name = "nombre",length = 30)
    private String nombre;
    @Column(name = "cantidad")
    private double cantidad;

    //llave foranea
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    @ManyToOne()
    @JsonBackReference
    private Items item;


}
