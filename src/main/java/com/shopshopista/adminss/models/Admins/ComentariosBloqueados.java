
package com.shopshopista.adminss.models.Admins;

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
@Table(name = "\"ComentariosBloqueados\"")
public class ComentariosBloqueados {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_comentario_bloqueado", nullable = false)
    private Long id_comentario_bloqueado;
    @Column(name = "id_comentario", nullable = false)
    private Long id_comentario;
    @Column(name = "cobl_fecha_bloqueo", nullable = false)
    private Date cobl_fecha_bloqueo;
    @Column(name = "cobl_motivo_bloqueo", nullable = false)
    private String cobl_motivo_bloqueo;
    @Column(name = "cobl_activo")
    private boolean cobl_activo;

    public ComentariosBloqueados() {
    }

    public ComentariosBloqueados(Long id_comentario_bloqueado, Long id_comentario, Date cobl_fecha_bloqueo, String cobl_motivo_bloqueo, boolean cobl_activo) {
        this.id_comentario_bloqueado = id_comentario_bloqueado;
        this.id_comentario = id_comentario;
        this.cobl_fecha_bloqueo = cobl_fecha_bloqueo;
        this.cobl_motivo_bloqueo = cobl_motivo_bloqueo;
        this.cobl_activo = cobl_activo;
    }
    
    public Long getId_comentario_bloqueado() {
        return id_comentario_bloqueado;
    }

    public void setId_comentario_bloqueado(Long id_comentario_bloqueado) {
        this.id_comentario_bloqueado = id_comentario_bloqueado;
    }

    public Date getCobl_fecha_bloqueo() {
        return cobl_fecha_bloqueo;
    }

    public void setCobl_fecha_bloqueo(Date cobl_fecha_bloqueo) {
        this.cobl_fecha_bloqueo = cobl_fecha_bloqueo;
    }

    public String getCobl_motivo_bloqueo() {
        return cobl_motivo_bloqueo;
    }

    public void setCobl_motivo_bloqueo(String cobl_motivo_bloqueo) {
        this.cobl_motivo_bloqueo = cobl_motivo_bloqueo;
    }

    public boolean isCobl_activo() {
        return cobl_activo;
    }

    public void setCobl_activo(boolean cobl_activo) {
        this.cobl_activo = cobl_activo;
    }

    public Long getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(Long id_comentario) {
        this.id_comentario = id_comentario;
    }

    
}
