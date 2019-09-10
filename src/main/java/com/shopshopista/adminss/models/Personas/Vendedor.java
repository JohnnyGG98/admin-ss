package com.shopshopista.adminss.models.Personas;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.shopshopista.adminss.models.Admins.VendedoresBloqueados;

@Entity
@Table(name = "\"Vendedores\"")
@PrimaryKeyJoinColumn(name = "id_vendedor", foreignKey=@ForeignKey(name = "fk_vendedor_usuario"))
public class Vendedor extends Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	 
	@Column(name = "vend_max_productos",  nullable =false)	
	private Integer vend_max_productos;
        
        @JsonManagedReference(value = "vendedor-bloq")
        @OneToMany(mappedBy = "id_vendedor", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<VendedoresBloqueados> vendedoresBLoqueados;
	
//	@JsonManagedReference
//	@OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Local> localesVendedor;


	public Vendedor() {
		super();
	}
	

	public Vendedor(Long id_usuario, Persona persona, String user_nick, String user_pass, Integer vend_max_productos) {
		super(id_usuario, persona, user_nick, user_pass);
		this.vend_max_productos = vend_max_productos;
        }
        
}

