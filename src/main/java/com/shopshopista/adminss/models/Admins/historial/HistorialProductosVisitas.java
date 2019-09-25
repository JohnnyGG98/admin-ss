package com.shopshopista.adminss.models.Admins.historial;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Where;

@Where(clause = "hprv_activo = true")
@Entity(
        name = "HistorialProductosVisitas"
)
@Table(
        name = "\"HistorialProductosVisitas\"",
        schema = "admin"
)
public class HistorialProductosVisitas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_historial_producto_visita;
    @Column(name = "id_cliente", nullable = false)
    private Long id_cliente;
    @Column(name = "id_producto", nullable = false)
    private Long id_producto;
    @Column(name = "hprv_fecha_ingreso", nullable = false)
    private LocalDateTime hprv_fecha_ingreso = ZonedDateTime.now(ZoneId.of("America/Guayaquil")).toLocalDateTime();
    @Column(name = "hprv_activo", nullable = false)
    private boolean hprv_activo;

    public HistorialProductosVisitas() {
    }

    public Long getId_historial_producto_visita() {
        return id_historial_producto_visita;
    }

    public void setId_historial_producto_visita(Long id_historial_producto_visita) {
        this.id_historial_producto_visita = id_historial_producto_visita;
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

    public LocalDateTime getHprv_fecha_ingreso() {
        return hprv_fecha_ingreso;
    }

    public void setHprv_fecha_ingreso(LocalDateTime hprv_fecha_ingreso) {
        this.hprv_fecha_ingreso = hprv_fecha_ingreso;
    }

}
