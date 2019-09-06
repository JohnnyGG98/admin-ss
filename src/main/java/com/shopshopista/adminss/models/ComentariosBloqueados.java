
package com.shopshopista.adminss.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ComentariosBloqueados")
public class ComentariosBloqueados {
    
    //Falta foránea
    @Id
    private Long id_comentario_bloqueado;
    @Column(name = "cobl_fecha_bloqueo", nullable = false)
    private Date cobl_fecha_bloqueo;
    @Column(name = "cobl_motivo_bloqueo", nullable = false)
    private String cobl_motivo_bloqueo;
    @Column(name = "cobl_activo")
    private boolean cobl_activo;

    public ComentariosBloqueados() {
    }

    public ComentariosBloqueados(Long id_comentario_bloqueado, Date cobl_fecha_bloqueo, String cobl_motivo_bloqueo, boolean cobl_activo) {
        this.id_comentario_bloqueado = id_comentario_bloqueado;
        this.cobl_fecha_bloqueo = cobl_fecha_bloqueo;
        this.cobl_motivo_bloqueo = cobl_motivo_bloqueo;
        this.cobl_activo = cobl_activo;
    }
    
    
    
}
