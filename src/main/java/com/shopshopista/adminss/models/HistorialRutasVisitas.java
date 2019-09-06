
package com.shopshopista.adminss.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HistorialRutasVisitas")
public class HistorialRutasVisitas {
    
    @Id
    private Long id_historial_ruta_visitas;
    @Column(name = "hruv_ruta", nullable = false)
    private String hruv_ruta;
    @Column(name = "hruv_fecha_ingreso", nullable = false)
    private Date hruv_fecha_ingreso;
    @Column(name = "hruv_activo", nullable = false)
    private boolean hruv_activo;

   
    
    
    
}
