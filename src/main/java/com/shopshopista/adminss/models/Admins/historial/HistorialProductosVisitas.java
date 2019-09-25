
package com.shopshopista.adminss.models.Admins.historial;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(
        name = "\"HistorialProductosVisitas\"",
        schema = "admin"
)
public class HistorialProductosVisitas {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id_historial_producto_visita;
    @Column(name = "id_cliente", nullable = false)
    private Long id_cliente;
    @Column(name = "id_producto", nullable = false)
    private Long id_producto;
    @Column(name = "hprv_fecha_ingreso", nullable = false)
    private Date hprv_fecha_ingreso;
    @Column(name = "hprv_activo", nullable = false)
    private boolean hprv_activo;

    public HistorialProductosVisitas() {
    }

    public HistorialProductosVisitas(Long id_historial_producto_visita, Long id_cliente, Long id_producto, Date hprv_fecha_ingreso, boolean hprv_activo) {
        this.id_historial_producto_visita = id_historial_producto_visita;
        this.id_cliente = id_cliente;
        this.id_producto = id_producto;
        this.hprv_fecha_ingreso = hprv_fecha_ingreso;
        this.hprv_activo = hprv_activo;
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

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public boolean isHprv_activo() {
        return hprv_activo;
    }

    public void setHprv_activo(boolean hprv_activo) {
        this.hprv_activo = hprv_activo;
    }
    
    
    
}
