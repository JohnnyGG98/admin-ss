package com.shopshopista.adminss.models.Admins.bloqueos;

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

@Where(clause = "clbl_activo = true")
@Entity(
        name = "ClientesBloqueados"
)
@Table(
        name = "\"ClientesBloqueados\"",
        schema = "admin"
)
public class ClientesBloqueados implements Serializable {

    //Falta foránea
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente_bloqueado;
    @Column(name = "id_cliente", nullable = false)
    private Long id_cliente;
    @Column(name = "clbl_fecha_bloqueo", nullable = false)
    private LocalDateTime clbl_fecha_bloqueo = ZonedDateTime.now(ZoneId.of("America/Guayaquil")).toLocalDateTime();
    @Column(name = "clbl_motivo_bloqueo", nullable = false)
    private String clbl_motivo_bloqueo;
    @Column(name = "clbl_activo")
    private boolean clbl_activo = true;

    public ClientesBloqueados() {
    }

    public Long getId_cliente_bloqueado() {
        return id_cliente_bloqueado;
    }

    public void setId_cliente_bloqueado(Long id_cliente_bloqueado) {
        this.id_cliente_bloqueado = id_cliente_bloqueado;
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

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public LocalDateTime getClbl_fecha_bloqueo() {
        return clbl_fecha_bloqueo;
    }

    public void setClbl_fecha_bloqueo(LocalDateTime clbl_fecha_bloqueo) {
        this.clbl_fecha_bloqueo = clbl_fecha_bloqueo;
    }

}
