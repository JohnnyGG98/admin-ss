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

@Where(clause = "hruv_activo = true")
@Entity(
        name = "HistorialRutasVisitas"
)
@Table(
        name = "\"HistorialRutasVisitas\"",
        schema = "admin"
)
public class HistorialRutasVisitas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_historial_ruta_visitas;
    @Column(name = "id_cliente", nullable = false)
    private Long id_cliente;
    @Column(name = "hruv_ruta", nullable = false)
    private String hruv_ruta;
    @Column(name = "hruv_fecha_ingreso", nullable = false)
    private LocalDateTime hruv_fecha_ingreso = ZonedDateTime.now(ZoneId.of("America/Guayaquil")).toLocalDateTime();
    @Column(name = "hruv_activo", nullable = false)
    private boolean hruv_activo = true;

    public HistorialRutasVisitas() {
    }

    public Long getId_historial_ruta_visitas() {
        return id_historial_ruta_visitas;
    }

    public void setId_historial_ruta_visitas(Long id_historial_ruta_visitas) {
        this.id_historial_ruta_visitas = id_historial_ruta_visitas;
    }

    public String getHruv_ruta() {
        return hruv_ruta;
    }

    public void setHruv_ruta(String hruv_ruta) {
        this.hruv_ruta = hruv_ruta;
    }

    public boolean isHruv_activo() {
        return hruv_activo;
    }

    public void setHruv_activo(boolean hruv_activo) {
        this.hruv_activo = hruv_activo;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public LocalDateTime getHruv_fecha_ingreso() {
        return hruv_fecha_ingreso;
    }

    public void setHruv_fecha_ingreso(LocalDateTime hruv_fecha_ingreso) {
        this.hruv_fecha_ingreso = hruv_fecha_ingreso;
    }

}
