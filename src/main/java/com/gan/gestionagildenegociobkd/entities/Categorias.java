package com.gan.gestionagildenegociobkd.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gan.gestionagildenegociobkd.entities.base.GenericEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "categorias")
@Data
public class Categorias extends GenericEntity {

    @Id
    @Column(name = "categoria_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoriaId;

    @Column(name = "nombre", length = 20)
    private String nombre;

    @OneToMany(mappedBy = "categorias")
    @JsonManagedReference
    private List<Items> items;
}
