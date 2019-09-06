
package com.shopshopista.adminss.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HistorialProductosVisitas")
public class HistorialProductosVisitas {
    
    @Id
    private Long id_historial_producto_visita;
    @Column(name = "hprv_fecha_ingreso", nullable = false)
    private Date hprv_fecha_ingreso;
    @Column(name = "cobl_activo", nullable = false)
    private boolean cobl_activo;

    public HistorialProductosVisitas() {
    }

    public HistorialProductosVisitas(Long id_historial_producto_visita, Date hprv_fecha_ingreso, boolean cobl_activo) {
        this.id_historial_producto_visita = id_historial_producto_visita;
        this.hprv_fecha_ingreso = hprv_fecha_ingreso;
        this.cobl_activo = cobl_activo;
    }
    
    
    
}
