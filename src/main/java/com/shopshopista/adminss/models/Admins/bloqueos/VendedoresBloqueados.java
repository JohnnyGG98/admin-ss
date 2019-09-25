
package com.shopshopista.adminss.models.Admins.bloqueos;

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
@Table(
        name = "\"VendedoresBloqueados\"",
         schema = "admin"
)
public class VendedoresBloqueados {
    
    //Falta foránea
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id_vendedor_bloqueado;
    @Column(name = "id_vendedor", nullable = false)
    private Long id_vendedor;
    @Column(name = "vebl_fecha_bloqueo", nullable = false)
    private Date vebl_fecha_bloqueo;
    @Column(name = "vebl_motivo_bloqueo", nullable = false)
    private String vebl_motivo_bloqueo;
    @Column(name = "vebl_activo")
    private boolean vebl_activo;

    public VendedoresBloqueados() {
    }

    public VendedoresBloqueados(Long id_vendedor_bloqueado, Long id_vendedor, Date vebl_fecha_bloqueo, String vebl_motivo_bloqueo, boolean vebl_activo) {
        this.id_vendedor_bloqueado = id_vendedor_bloqueado;
        this.id_vendedor = id_vendedor;
        this.vebl_fecha_bloqueo = vebl_fecha_bloqueo;
        this.vebl_motivo_bloqueo = vebl_motivo_bloqueo;
        this.vebl_activo = vebl_activo;
    }

    public Long getId_vendedor_bloqueado() {
        return id_vendedor_bloqueado;
    }

    public void setId_vendedor_bloqueado(Long id_vendedor_bloqueado) {
        this.id_vendedor_bloqueado = id_vendedor_bloqueado;
    }

    public Date getVebl_fecha_bloqueo() {
        return vebl_fecha_bloqueo;
    }

    public void setVebl_fecha_bloqueo(Date vebl_fecha_bloqueo) {
        this.vebl_fecha_bloqueo = vebl_fecha_bloqueo;
    }

    public String getVebl_motivo_bloqueo() {
        return vebl_motivo_bloqueo;
    }

    public void setVebl_motivo_bloqueo(String vebl_motivo_bloqueo) {
        this.vebl_motivo_bloqueo = vebl_motivo_bloqueo;
    }

    public boolean isVebl_activo() {
        return vebl_activo;
    }

    public void setVebl_activo(boolean vebl_activo) {
        this.vebl_activo = vebl_activo;
    }

    public Long getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(Long id_vendedor) {
        this.id_vendedor = id_vendedor;
    }
    
    
    
}