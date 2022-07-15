package com.patrick.chat.domain.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.patrick.chat.domain.Mensagem;
import com.patrick.chat.domain.Usuario;

public class MensagemDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	
	private LocalDateTime dataEnvio = LocalDateTime.now();
	
	private String mensagem;
	
	private Usuario usuario;
	
	private Integer idRemetente;
	
	private Boolean status;
	
	private Integer idDestinatario;

	public MensagemDTO(Mensagem obj) {
		super();
		this.id = obj.getId();
		this.dataEnvio = obj.getDataEnvio();
		this.mensagem = obj.getMensagem();
		this.idRemetente = obj.getIdRemetente();
		this.status = obj.getStatus();
		this.idDestinatario = obj.getIdDestinatario();
	}
	
	

	public MensagemDTO() {
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


	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public Integer getIdRemetente() {
		return idRemetente;
	}

	public void setIdRemetente(Integer idRemetente) {
		this.idRemetente = idRemetente;
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
	
	

}
