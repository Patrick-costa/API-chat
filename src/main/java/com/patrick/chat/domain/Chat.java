package com.patrick.chat.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.patrick.chat.domain.dtos.ChatDTO;

@Entity
public class Chat implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer idRemetente;
	private Integer idDestinatario;
	@ElementCollection(fetch = FetchType.EAGER) 
	private List<Mensagem> mensagem;
	
	public Chat(Integer id, Integer idRemetente, Integer idDestinatario) {
		super();
		this.id = id;
		this.idRemetente = idRemetente;
		this.idDestinatario = idDestinatario;
	}
	
	public Chat(ChatDTO obj) {
		super();
		this.id = obj.getId();
		this.idRemetente = obj.getIdRemetente();
		this.idDestinatario = obj.getIdDestinatario();
		this.mensagem = obj.getMensagem();
	}
	
	public Chat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdRemetente() {
		return idRemetente;
	}
	public void setIdRemetente(Integer idRemetente) {
		this.idRemetente = idRemetente;
	}
	public Integer getIdDestinatario() {
		return idDestinatario;
	}
	public void setIdDestinatario(Integer idDestinatario) {
		this.idDestinatario = idDestinatario;
	}
	public List<Mensagem> getMensagem() {
		return mensagem;
	}
	public void setMensagem(List<Mensagem> mensagem) {
		this.mensagem = mensagem;
	}
	
	

}
