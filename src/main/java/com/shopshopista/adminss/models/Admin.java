
package com.shopshopista.adminss.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admins")
public class Admin {
    
    @Id
    private Long id_admin;
    @Column(name = "adm_user", nullable = false)
    private String adm_user;
    @Column(name = "adm_pass", nullable = false)
    private String adm_pass;
    @Column(name = "adm_activo", nullable = false)
    private boolean adm_activo;

    public Admin() {
    }

    public Admin(long id_admin, String adm_user, String adm_pass, boolean adm_activo) {
        this.id_admin = id_admin;
        this.adm_user = adm_user;
        this.adm_pass = adm_pass;
        this.adm_activo = adm_activo;
    }

    public long getId_admin() {
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
    
    
    
}
