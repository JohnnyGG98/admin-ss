
package com.shopshopista.adminss.models.Admins;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ClientesBloqueados")
public class ClientesBloqueados {
    
    //Falta foránea
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id_cliente_bloqueado;
    @Column(name = "clbl_fecha_bloqueo", nullable = false)
    private Date clbl_fecha_bloqueo;
    @Column(name = "clbl_motivo_bloqueo", nullable = false)
    private String clbl_motivo_bloqueo;
    @Column(name = "clbl_activo")
    private boolean clbl_activo;

    public ClientesBloqueados() {
    }

    public ClientesBloqueados(Long id_cliente_bloqueado, Date clbl_fecha_bloqueo, String clbl_motivo_bloqueo, boolean clbl_activo) {
        this.id_cliente_bloqueado = id_cliente_bloqueado;
        this.clbl_fecha_bloqueo = clbl_fecha_bloqueo;
        this.clbl_motivo_bloqueo = clbl_motivo_bloqueo;
        this.clbl_activo = clbl_activo;
    }
    
    
}
