
package com.shopshopista.adminss.models.Personas;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="\"Usuarios\"")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable{
    
    private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id_usuario;
	
	@JsonBackReference
	@JoinColumn(name="id_persona")
	@ManyToOne(fetch = FetchType.LAZY)
	private Persona id_persona;
	
	@Column(name = "user_nick", length = 50, nullable = false ,columnDefinition="character varying(50) UNIQUE")
	private String user_nick;
	
	@Column(name = "user_pass", nullable = false)
	private Byte[] user_pass;

    public Usuario() {
    }

    public Usuario(Long id_usuario, Persona id_persona, String user_nick, Byte[] user_pass) {
        this.id_usuario = id_usuario;
        this.id_persona = id_persona;
        this.user_nick = user_nick;
        this.user_pass = user_pass;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Persona getId_persona() {
        return id_persona;
    }

    public void setId_persona(Persona id_persona) {
        this.id_persona = id_persona;
    }

    public String getUser_nick() {
        return user_nick;
    }

    public void setUser_nick(String user_nick) {
        this.user_nick = user_nick;
    }

    public Byte[] getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(Byte[] user_pass) {
        this.user_pass = user_pass;
    }
        
        
}
