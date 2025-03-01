package com.gan.gestionagildenegociobkd.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gan.gestionagildenegociobkd.entities.base.GenericEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.util.List;

@Entity
@Table(name = "almacen")
@Data
public class Almacen extends GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long almancenId;

    @Column(name = "nombre", length = 20)
    private String nombre;

    @OneToMany(mappedBy = "almacen")
    @JsonManagedReference
    private List<Existencias> existencias;


}
