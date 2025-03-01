package com.gan.gestionagildenegociobkd.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gan.gestionagildenegociobkd.entities.base.GenericEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.util.List;

@Entity
@Table(name = "items")
@Data
public class Items extends GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "nombre",length = 30)
    private String nombre;
    @Column(name = "tipo",length = 1)
    private String tipo;
    @Column(name = "EAN",length = 17)
    @Comment("código de fabricante")
    private String ean;
    @Column(name = "marca",length = 30)
    private String marca;
    @Column(name = "precio_lista")
    private float precioLista;
    @Column(name = "precio_descuento")
    private float precioDescuento;
    @Column(name = "precio_mayoreo")
    private float precioMayoreo;
    @Column(name = "precio_minimo")
    private float precioMinimo;
    @Column(name = "costo_promedio")
    private float costoPromedio;

    //llave foranea
    @JoinColumn(name = "categoria_id", referencedColumnName = "categoria_id")
    @ManyToOne()
    @JsonBackReference
    private Categorias categorias;

    @OneToMany(mappedBy = "items")
    @JsonManagedReference
    private List<Existencias> existencias;
}
