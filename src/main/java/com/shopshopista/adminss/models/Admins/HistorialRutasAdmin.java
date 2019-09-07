
package com.shopshopista.adminss.models.Admins;

import com.shopshopista.adminss.models.Admins.Admin;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "HistorialRutasAdmin")
public class HistorialRutasAdmin {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id_historial_ruta_admin;
    @Column(name = "hiru_ruta", nullable = false)
    private String hiru_ruta;
    @Column(name = "hiru_activo")
    private boolean hiru_activo;
    
    @JsonBackReference
    @JoinColumn(name = "id_admin",referencedColumnName = "id_admin")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Admin admin;

    public HistorialRutasAdmin() {
        
    }

    public HistorialRutasAdmin(Long id_historial_ruta_admin, String hiru_ruta, boolean hiru_activo, Admin admin) {
        this.id_historial_ruta_admin = id_historial_ruta_admin;
        this.hiru_ruta = hiru_ruta;
        this.hiru_activo = hiru_activo;
        this.admin = admin;
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
