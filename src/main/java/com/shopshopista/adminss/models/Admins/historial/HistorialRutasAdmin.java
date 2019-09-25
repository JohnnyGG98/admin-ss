
package com.shopshopista.adminss.models.Admins.historial;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.shopshopista.adminss.models.Admins.admin.Admin;
import java.io.Serializable;
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
import org.hibernate.annotations.Where;

@Where(clause = "hiru_activo= true")
@Entity(
        name = "HistorialRutasAdmin"
)
@Table(
        name = "\"HistorialRutasAdmin\"",
        schema = "admin"
)
public class HistorialRutasAdmin implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_historial_ruta_admin;
    @Column(name = "hiru_ruta", nullable = false)
    private String hiru_ruta;
    @Column(name = "hiru_activo")
    private boolean hiru_activo = true;
    
    @JsonBackReference(value = "admin-hr")
    @JoinColumn(name = "id_admin",referencedColumnName = "id_admin")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Admin admin;

    public HistorialRutasAdmin() {
        
    }

    public Long getId_historial_ruta_admin() {
        return id_historial_ruta_admin;
    }

    public void setId_historial_ruta_admin(Long id_historial_ruta_admin) {
        this.id_historial_ruta_admin = id_historial_ruta_admin;
    }

    public String getHiru_ruta() {
        return hiru_ruta;
    }

    public void setHiru_ruta(String hiru_ruta) {
        this.hiru_ruta = hiru_ruta;
    }

    public boolean isHiru_activo() {
        return hiru_activo;
    }

    public void setHiru_activo(boolean hiru_activo) {
        this.hiru_activo = hiru_activo;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    
    
}
