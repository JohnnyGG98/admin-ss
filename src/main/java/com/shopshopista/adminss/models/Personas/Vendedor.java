package com.shopshopista.adminss.models.Personas;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.shopshopista.adminss.models.Admins.VendedoresBloqueados;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "\"Vendedores\"")
@PrimaryKeyJoinColumn(name = "id_vendedor", foreignKey = @ForeignKey(name = "fk_vendedor_usuario"))
public class Vendedor extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "vend_max_productos", nullable = false)
    private Integer vend_max_productos;
    
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "id_vendedor")
    private List<VendedoresBloqueados> vendedoresBloqueados;

    public Vendedor() {
    }

    public Vendedor(Integer vend_max_productos) {
        this.vend_max_productos = vend_max_productos;
    }

    public Vendedor(Integer vend_max_productos, Long id_usuario, Persona id_persona, String user_nick, Byte[] user_pass) {
        super(id_usuario, id_persona, user_nick, user_pass);
        this.vend_max_productos = vend_max_productos;
    }

    public Integer getVend_max_productos() {
        return vend_max_productos;
    }

    public void setVend_max_productos(Integer vend_max_productos) {
        this.vend_max_productos = vend_max_productos;
    }

}
