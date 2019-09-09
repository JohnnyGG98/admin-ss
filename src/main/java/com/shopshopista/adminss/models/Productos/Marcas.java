package com.shopshopista.adminss.models.Productos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Marcas")
public class Marcas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_marca", nullable = false)
    private Long id_marca;
    @Column(name = "marc_nombre", nullable = false)
    private String marc_nombre;
    @Column(name = "marc_codigo", nullable = false)
    private String marc_codigo;
    @Column(name = "marc_activo", nullable = false)
    private boolean marc_activo;
    
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "marcas")
    private List<Productos> productos;

    public Marcas() {
    }

    public Marcas(Long id_marca, String marc_nombre, String marc_codigo, boolean marc_activo) {
        this.id_marca = id_marca;
        this.marc_nombre = marc_nombre;
        this.marc_codigo = marc_codigo;
        this.marc_activo = marc_activo;
    }

    public Long getId_marca() {
        return id_marca;
    }

    public void setId_marca(Long id_marca) {
        this.id_marca = id_marca;
    }

    public String getMarc_nombre() {
        return marc_nombre;
    }

    public void setMarc_nombre(String marc_nombre) {
        this.marc_nombre = marc_nombre;
    }

    public String getMarc_codigo() {
        return marc_codigo;
    }

    public void setMarc_codigo(String marc_codigo) {
        this.marc_codigo = marc_codigo;
    }

    public boolean isMarc_activo() {
        return marc_activo;
    }

    public void setMarc_activo(boolean marc_activo) {
        this.marc_activo = marc_activo;
    }

    public List<Productos> getProductos() {
        return productos;
    }

    public void setProductos(List<Productos> productos) {
        this.productos = productos;
    }
    
    
}