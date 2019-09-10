
package com.shopshopista.adminss.models.Admins;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.shopshopista.adminss.models.Personas.Cliente;
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
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente")
    @JsonBackReference
    private Cliente id_cliente;

    public ClientesBloqueados() {
    }

    public ClientesBloqueados(Long id_cliente_bloqueado, Date clbl_fecha_bloqueo, String clbl_motivo_bloqueo, boolean clbl_activo) {
        this.id_cliente_bloqueado = id_cliente_bloqueado;
        this.clbl_fecha_bloqueo = clbl_fecha_bloqueo;
        this.clbl_motivo_bloqueo = clbl_motivo_bloqueo;
        this.clbl_activo = clbl_activo;
    }

    public Long getId_cliente_bloqueado() {
        return id_cliente_bloqueado;
    }

    public void setId_cliente_bloqueado(Long id_cliente_bloqueado) {
        this.id_cliente_bloqueado = id_cliente_bloqueado;
    }

    public Date getClbl_fecha_bloqueo() {
        return clbl_fecha_bloqueo;
    }

    public void setClbl_fecha_bloqueo(Date clbl_fecha_bloqueo) {
        this.clbl_fecha_bloqueo = clbl_fecha_bloqueo;
    }

    public String getClbl_motivo_bloqueo() {
        return clbl_motivo_bloqueo;
    }

    public void setClbl_motivo_bloqueo(String clbl_motivo_bloqueo) {
        this.clbl_motivo_bloqueo = clbl_motivo_bloqueo;
    }

    public boolean isClbl_activo() {
        return clbl_activo;
    }

    public void setClbl_activo(boolean clbl_activo) {
        this.clbl_activo = clbl_activo;
    }
    
    
}
