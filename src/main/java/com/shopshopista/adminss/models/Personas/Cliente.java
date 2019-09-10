
package com.shopshopista.adminss.models.Personas;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.shopshopista.adminss.models.Admins.ClientesBloqueados;
import com.shopshopista.adminss.models.Admins.HistorialProductosVisitas;
import com.shopshopista.adminss.models.Admins.HistorialRutasVisitas;
import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name="\"Clientes\"")
@PrimaryKeyJoinColumn(name = "id_cliente", foreignKey=@ForeignKey(name = "fk_cliente_usuario") )
public class Cliente extends Usuario implements Serializable {
 
    private static final long serialVersionUID = 1L;
		
	@Column(name = "cli_fecha_nacimiento" , nullable = false)
	private LocalDate cli_fecha_nacimiento;
        
        @JsonManagedReference
        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "id_cliente")
        private List<ClientesBloqueados> clientesBloqueados;
        
        @JsonManagedReference
        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "id_cliente")
        private List<HistorialProductosVisitas> historialProductosVisitas;
        
        @JsonManagedReference
        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "id_cliente")
        private List<HistorialRutasVisitas> historialRutasVisitas;

    public Cliente() {
    }

    public Cliente(LocalDate cli_fecha_nacimiento) {
        this.cli_fecha_nacimiento = cli_fecha_nacimiento;
    }

    public Cliente(LocalDate cli_fecha_nacimiento, Long id_usuario, Persona id_persona, String user_nick, Byte[] user_pass) {
        super(id_usuario, id_persona, user_nick, user_pass);
        this.cli_fecha_nacimiento = cli_fecha_nacimiento;
    }

    public LocalDate getCli_fecha_nacimiento() {
        return cli_fecha_nacimiento;
    }

    public void setCli_fecha_nacimiento(LocalDate cli_fecha_nacimiento) {
        this.cli_fecha_nacimiento = cli_fecha_nacimiento;
    }
        
        
}
