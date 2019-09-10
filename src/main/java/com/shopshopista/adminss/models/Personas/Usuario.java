package com.shopshopista.adminss.models.Personas;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.CascadeType;
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

import org.apache.tomcat.util.codec.binary.Base64;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="\"Usuarios\"")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id_usuario;
	
	@JsonBackReference
	@JoinColumn(name="id_persona", foreignKey = @ForeignKey(name="fk_usuario_persona", foreignKeyDefinition = "FOREIGN KEY (id_persona) REFERENCES \"Personas\" ON UPDATE CASCADE ON DELETE CASCADE"))
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Persona persona;
	
	@Column(name = "user_nick", length = 50, nullable = false ,columnDefinition="character varying(50) UNIQUE")
	private String user_nick;
	
	@Column(name = "user_pass", nullable = false)
	private byte[] user_pass;

	public Usuario() {
		
	}

	public Usuario(Long id_usuario, Persona persona, String user_nick, String user_pass) {
		this.id_usuario = id_usuario;
		this.persona = persona;
		this.user_nick = user_nick;
		this.user_pass = Base64.encodeBase64(user_pass.getBytes());
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getUser_nick() {
		return user_nick;
	}

	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}

	public byte[] getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = Base64.encodeBase64(user_pass.getBytes());
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", persona=" + persona + ", user_nick=" + user_nick
				+ ", user_pass=" + Arrays.toString(user_pass) + "]";
	}

	
	
	
	
	
	
	
	
	
	
}

