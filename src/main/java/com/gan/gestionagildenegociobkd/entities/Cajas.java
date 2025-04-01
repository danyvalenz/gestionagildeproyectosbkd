package com.gan.gestionagildenegociobkd.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gan.gestionagildenegociobkd.entities.base.GenericEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "cajas")
@Data
public class Cajas extends GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "caja_id")
    private Long cajaId;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "abierta")
    private boolean abierta;
    @Column(name = "importe")
    private Double importe;

    @OneToMany(mappedBy = "caja")
    @JsonManagedReference
    private List<CajasHist> cajasHists;

    @OneToMany(mappedBy = "caja")
    @JsonManagedReference
    private List<CajasMovimientos> cajasMovimientos;


    public Long getCajaId() {
        return cajaId;
    }

    public void setCajaId(Long cajaId) {
        this.cajaId = cajaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAbierta() {
        return abierta;
    }

    public void setAbierta(boolean abierta) {
        this.abierta = abierta;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public List<CajasHist> getCajasHists() {
        return cajasHists;
    }

    public void setCajasHists(List<CajasHist> cajasHists) {
        this.cajasHists = cajasHists;
    }

    public List<CajasMovimientos> getCajasMovimientos() {
        return cajasMovimientos;
    }

    public void setCajasMovimientos(List<CajasMovimientos> cajasMovimientos) {
        this.cajasMovimientos = cajasMovimientos;
    }
}
