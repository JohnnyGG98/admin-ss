
package com.shopshopista.adminss.models.Admins;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "\"HistorialRutasVisitas\"")
public class HistorialRutasVisitas {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id_historial_ruta_visitas;
    @Column(name = "id_cliente", nullable = false)
    private Long id_cliente;
    @Column(name = "hruv_ruta", nullable = false)
    private String hruv_ruta;
    @Column(name = "hruv_fecha_ingreso", nullable = false)
    private Date hruv_fecha_ingreso;
    @Column(name = "hruv_activo", nullable = false)
    private boolean hruv_activo;

    public HistorialRutasVisitas() {
    }

    public HistorialRutasVisitas(Long id_historial_ruta_visitas, Long id_cliente, String hruv_ruta, Date hruv_fecha_ingreso, boolean hruv_activo) {
        this.id_historial_ruta_visitas = id_historial_ruta_visitas;
        this.id_cliente = id_cliente;
        this.hruv_ruta = hruv_ruta;
        this.hruv_fecha_ingreso = hruv_fecha_ingreso;
        this.hruv_activo = hruv_activo;
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

    public Date getHruv_fecha_ingreso() {
        return hruv_fecha_ingreso;
    }

    public void setHruv_fecha_ingreso(Date hruv_fecha_ingreso) {
        this.hruv_fecha_ingreso = hruv_fecha_ingreso;
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
    
}
