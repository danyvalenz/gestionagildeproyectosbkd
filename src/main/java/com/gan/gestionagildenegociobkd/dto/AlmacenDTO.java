package com.gan.gestionagildenegociobkd.dto;

import com.gan.gestionagildenegociobkd.entities.base.GenericEntity;
import jakarta.persistence.Column;
import lombok.Data;


@Data
public class AlmacenDTO  {

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
