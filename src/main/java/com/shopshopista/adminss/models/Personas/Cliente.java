package com.shopshopista.adminss.models.Personas;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.shopshopista.adminss.models.Admins.ClientesBloqueados;
import com.shopshopista.adminss.models.Admins.HistorialProductosVisitas;
import com.shopshopista.adminss.models.Admins.HistorialRutasVisitas;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "\"Clientes\"")
@PrimaryKeyJoinColumn(name = "id_cliente", foreignKey = @ForeignKey(name = "fk_cliente_usuario"))
public class Cliente extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "cli_fecha_nacimiento", nullable = false)
    private LocalDate cli_fecha_nacimiento;

    @JsonManagedReference(value = "cliente-bloq")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "id_cliente")
    private List<ClientesBloqueados> clientesBloqueados;
    
    @JsonManagedReference(value = "cliente-hist-produ-visitas")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "id_cliente")
    private List<HistorialProductosVisitas> historialProductosVisitas;
    
    @JsonManagedReference(value = "cliente-hist-rutas-visitas")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "id_cliente")
    private List<HistorialRutasVisitas> historialRutasVisitas;

    public Cliente() {
        super();
    }

    public Cliente(Long id_usuario, Persona persona, String user_nick, String user_pass,
            LocalDate cli_fecha_nacimiento) {
        super(id_usuario, persona, user_nick, user_pass);
        this.cli_fecha_nacimiento = cli_fecha_nacimiento;
    }

    public LocalDate getCli_fecha_nacimiento() {
        return cli_fecha_nacimiento;
    }

    public void setCli_fecha_nacimiento(LocalDate cli_fecha_nacimiento) {
        this.cli_fecha_nacimiento = cli_fecha_nacimiento;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Cliente [cli_fecha_nacimiento=" + cli_fecha_nacimiento + ", toString()=" + super.toString() + "]";
    }

}
