package com.shopshopista.adminss.models.Admins.admin;

import com.shopshopista.adminss.models.Admins.historial.HistorialRutasAdmin;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(
        name = "\"Admins\"",
        schema = "admin"
)
public class Admin {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id_admin;
    
    @Column(name = "adm_user", nullable = false)
    private String adm_user;
    @Column(name = "adm_pass", nullable = false)
    private String adm_pass;
    @Column(name = "adm_activo", nullable = false)
    private boolean adm_activo;

    @JsonManagedReference(value = "admin-hr")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "admin")
    private List<HistorialRutasAdmin> histRutasAdmin;

    @JsonManagedReference(value = "admin-permiso")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "admin")
    private List<Permisos> permiso;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_ruta")
    @JsonBackReference(value = "roles-admin")
    private RolesAdmin rolesAdmin;

    public Admin() {
    }

    public Admin(long id_admin, String adm_user, String adm_pass, boolean adm_activo) {
        this.id_admin = id_admin;
        this.adm_user = adm_user;
        this.adm_pass = adm_pass;
        this.adm_activo = adm_activo;
    }

    public Long getId_admin() {
        return id_admin;
    }

    public void setId_admin(Long id_admin) {
        this.id_admin = id_admin;
    }

    public String getAdm_user() {
        return adm_user;
    }

    public void setAdm_user(String adm_user) {
        this.adm_user = adm_user;
    }

    public String getAdm_pass() {
        return adm_pass;
    }

    public void setAdm_pass(String adm_pass) {
        this.adm_pass = adm_pass;
    }

    public boolean isAdm_activo() {
        return adm_activo;
    }

    public void setAdm_activo(boolean adm_activo) {
        this.adm_activo = adm_activo;
    }

    public List<HistorialRutasAdmin> getHistRutasAdmin() {
        return histRutasAdmin;
    }

    public void setHistRutasAdmin(List<HistorialRutasAdmin> histRutasAdmin) {
        this.histRutasAdmin = histRutasAdmin;
    }

    public List<Permisos> getPermiso() {
        return permiso;
    }

    public void setPermiso(List<Permisos> permiso) {
        this.permiso = permiso;
    }

    

}
