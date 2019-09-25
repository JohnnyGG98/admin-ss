
package com.shopshopista.adminss.models.Admins.admin;

import com.shopshopista.adminss.models.Admins.admin.Admin;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(
        name = "\"Rolesadmin\"",
        schema = "admin"
)
public class RolesAdmin {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id_rol_admin;
    @Column(name = "rlad_nombre", nullable = false)
    private String rlad_nombre;
    @Column(name = "rlad_activo", nullable = false)
    private boolean rlad_activo;
    
    @JsonManagedReference(value = "roles-admin")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rolesAdmin")
    private List<Admin> admin;
    
    @JsonManagedReference(value = "roles-admin-rutas")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rolesAdmin")
    private List<RolesRutas> rolesRutas;

    public RolesAdmin() {
    }

    public RolesAdmin(Long id_rol_admin, String rlad_nombre, boolean rlad_activo, List<Admin> admin) {
        this.id_rol_admin = id_rol_admin;
        this.rlad_nombre = rlad_nombre;
        this.rlad_activo = rlad_activo;
        this.admin = admin;
    }

    public Long getId_rol_admin() {
        return id_rol_admin;
    }

    public void setId_rol_admin(Long id_rol_admin) {
        this.id_rol_admin = id_rol_admin;
    }

    public String getRlad_nombre() {
        return rlad_nombre;
    }

    public void setRlad_nombre(String rlad_nombre) {
        this.rlad_nombre = rlad_nombre;
    }

    public boolean isRlad_activo() {
        return rlad_activo;
    }

    public void setRlad_activo(boolean rlad_activo) {
        this.rlad_activo = rlad_activo;
    }

    public List<Admin> getAdmin() {
        return admin;
    }

    public void setAdmin(List<Admin> admin) {
        this.admin = admin;
    }
    
    
}
