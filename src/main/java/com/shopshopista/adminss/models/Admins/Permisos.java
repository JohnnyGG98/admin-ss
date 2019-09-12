
package com.shopshopista.adminss.models.Admins;

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
@Table(name = "\"Permisos\"")
public class Permisos {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id_permiso;
    @Column(name = "prem_activo")
    private boolean prem_activo;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_admin")
    @JsonBackReference(value = "admin-permiso")
    private Admin admin;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_ruta")
    @JsonBackReference
    private Rutas rutas;

    public Permisos() {
    }
    

    public Permisos(Long id_permiso, boolean prem_activo, Admin admin, Rutas rutas) {
        this.id_permiso = id_permiso;
        this.prem_activo = prem_activo;
        this.admin = admin;
        this.rutas = rutas;
    }

    public Long getId_permiso() {
        return id_permiso;
    }

    public void setId_permiso(Long id_permiso) {
        this.id_permiso = id_permiso;
    }

    public boolean isPrem_activo() {
        return prem_activo;
    }

    public void setPrem_activo(boolean prem_activo) {
        this.prem_activo = prem_activo;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Rutas getRutas() {
        return rutas;
    }

    public void setRutas(Rutas rutas) {
        this.rutas = rutas;
    }
    
    
    
}
