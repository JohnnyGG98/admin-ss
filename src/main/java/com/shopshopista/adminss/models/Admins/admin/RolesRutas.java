
package com.shopshopista.adminss.models.Admins.admin;

import com.shopshopista.adminss.models.Admins.admin.RolesAdmin;
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
@Table(
        name = "\"Rolesrutas\"",
        schema = "admin"
)
public class RolesRutas {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id_rol_ruta;
    @Column(name = "roru_activo")
    private boolean roru_activo;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_rol_admin")
    @JsonBackReference(value = "roles-admin-rutas")
    private RolesAdmin rolesAdmin;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_ruta")
    @JsonBackReference(value = "roles-rutas")
    private Rutas rutas;
}
