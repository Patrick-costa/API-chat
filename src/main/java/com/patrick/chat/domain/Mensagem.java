package com.patrick.chat.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Mensagem implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private LocalDateTime dataEnvio = LocalDateTime.now();
	
	private String mensagem;
	
	private Integer usuario;
	
	private Integer idRemetente;
	
	private Boolean status;
	
	private Integer idDestinatario;

	public Mensagem(Integer id, String mensagem, Integer idRemetente,
			Integer idDestinatario) {
		super();
		this.id = id;
		this.mensagem = mensagem;
		this.idRemetente = idRemetente;
		this.idDestinatario = idDestinatario;
		this.status = false;
	}

	public Mensagem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalDateTime dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Integer getIdRemetente() {
		return idRemetente;
	}


	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Integer getIdDestinatario() {
		return idDestinatario;
	}

	public void setIdDestinatario(Integer idDestinatario) {
		this.idDestinatario = idDestinatario;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public void setIdRemetente(Integer idRemetente) {
		this.idRemetente = idRemetente;
	}

	
	
	
}
