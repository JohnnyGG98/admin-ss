
package com.shopshopista.adminss.models.Admins;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.shopshopista.adminss.models.Personas.Cliente;
import com.shopshopista.adminss.models.Productos.Productos;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HistorialProductosVisitas")
public class HistorialProductosVisitas {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id_historial_producto_visita;
    @Column(name = "hprv_fecha_ingreso", nullable = false)
    private Date hprv_fecha_ingreso;
    @Column(name = "hprv_activo", nullable = false)
    private boolean hprv_activo;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto")
    @JsonBackReference
    private Productos productos;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente")
    @JsonBackReference(value = "cliente-hist-produ-visitas")
    private Cliente id_cliente;
    
    //Falta la relación con el Cliente

    public HistorialProductosVisitas() {
    }

    public HistorialProductosVisitas(Long id_historial_producto_visita, Date hprv_fecha_ingreso, boolean cobl_activo, Productos producto) {
        this.id_historial_producto_visita = id_historial_producto_visita;
        this.hprv_fecha_ingreso = hprv_fecha_ingreso;
        this.hprv_activo = cobl_activo;
        this.productos = producto;
    }

    public Long getId_historial_producto_visita() {
        return id_historial_producto_visita;
    }

    public void setId_historial_producto_visita(Long id_historial_producto_visita) {
        this.id_historial_producto_visita = id_historial_producto_visita;
    }

    public Date getHprv_fecha_ingreso() {
        return hprv_fecha_ingreso;
    }

    public void setHprv_fecha_ingreso(Date hprv_fecha_ingreso) {
        this.hprv_fecha_ingreso = hprv_fecha_ingreso;
    }

    public boolean isCobl_activo() {
        return hprv_activo;
    }

    public void setCobl_activo(boolean cobl_activo) {
        this.hprv_activo = cobl_activo;
    }

    public Productos getProducto() {
        return productos;
    }

    public void setProducto(Productos producto) {
        this.productos = producto;
    }
    
    
    
}
