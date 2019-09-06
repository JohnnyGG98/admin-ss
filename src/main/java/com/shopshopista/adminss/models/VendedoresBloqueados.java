
package com.shopshopista.adminss.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VendedoresBloqueados")
public class VendedoresBloqueados {
    
    //Falta foránea
    @Id
    private Long id_vendedor_bloqueado;
    @Column(name = "vebl_fecha_bloqueo", nullable = false)
    private Date vebl_fecha_bloqueo;
    @Column(name = "vebl_motivo_bloqueo", nullable = false)
    private String vebl_motivo_bloqueo;
    @Column(name = "vebl_activo")
    private boolean vebl_activo;

    public VendedoresBloqueados() {
    }

    public VendedoresBloqueados(Long id_vendedor_bloqueado, Date vebl_fecha_bloqueo, String vebl_motivo_bloqueo, boolean vebl_activo) {
        this.id_vendedor_bloqueado = id_vendedor_bloqueado;
        this.vebl_fecha_bloqueo = vebl_fecha_bloqueo;
        this.vebl_motivo_bloqueo = vebl_motivo_bloqueo;
        this.vebl_activo = vebl_activo;
    }
    
    
    
}
