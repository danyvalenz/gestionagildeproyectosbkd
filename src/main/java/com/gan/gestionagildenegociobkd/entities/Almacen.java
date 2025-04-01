package com.gan.gestionagildenegociobkd.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gan.gestionagildenegociobkd.entities.base.GenericEntity;
import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "almacen")
public class Almacen extends GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long almancenId;

    @Column(name = "nombre", length = 20)
    private String nombre;

    @OneToMany(mappedBy = "almacen")
    @JsonManagedReference
    private List<Existencias> existencias;

    public Long getAlmancenId() {
        return almancenId;
    }

    public void setAlmancenId(Long almancenId) {
        this.almancenId = almancenId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Existencias> getExistencias() {
        return existencias;
    }

    public void setExistencias(List<Existencias> existencias) {
        this.existencias = existencias;
    }
}
