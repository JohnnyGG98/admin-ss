
package com.shopshopista.adminss.models.Admins.admin;

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
import org.hibernate.annotations.Where;

@Where(clause = "rut_activo = true")
@Entity(
        name = "Rutas"
)
@Table(
        name = "\"Rutas\"",
        schema = "admin"
)
public class Rutas {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_ruta;
    @Column(name = "rut_url", nullable = false)
    private String rut_url;
    @Column(name = "rut_activo")
    private boolean rut_activo = true;
    
    @OneToMany(mappedBy = "rutas", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Permisos> permisos;
    
    @JsonManagedReference(value = "roles-rutas")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rutas")
    private List<RolesRutas> rolesRutas;

    public Rutas() {
    }

    public Rutas(Long id_ruta, String rut_url, boolean rut_activo) {
        this.id_ruta = id_ruta;
        this.rut_url = rut_url;
        this.rut_activo = rut_activo;
    }

    public Long getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(Long id_ruta) {
        this.id_ruta = id_ruta;
    }

    public String getRut_url() {
        return rut_url;
    }

    public void setRut_url(String rut_url) {
        this.rut_url = rut_url;
    }

    public boolean isRut_activo() {
        return rut_activo;
    }

    public void setRut_activo(boolean rut_activo) {
        this.rut_activo = rut_activo;
    }

    public List<Permisos> getPermiso() {
        return permisos;
    }

    public void setPermiso(List<Permisos> permiso) {
        this.permisos = permiso;
    }
    
    
}
